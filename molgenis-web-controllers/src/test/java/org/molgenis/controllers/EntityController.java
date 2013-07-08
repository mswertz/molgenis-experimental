package org.molgenis.controllers;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.log4j.Logger;
import org.molgenis.Entity;
import org.molgenis.data.Query;
import org.molgenis.views.Button;
import org.molgenis.views.ButtonGroup;
import org.molgenis.views.Danger;
import org.molgenis.views.Div;
import org.molgenis.views.Form;
import org.molgenis.views.H1;
import org.molgenis.views.Html;
import org.molgenis.views.Show;
import org.molgenis.views.Success;
import org.molgenis.views.Table;
import org.molgenis.views.View;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

public abstract class EntityController<E extends Entity>
{
	Logger logger = Logger.getLogger(getClass());

	public abstract EntityService<E> getService();

	public abstract String getLabel();

	public abstract String getBase();

	@RequestMapping("")
	public View<?> list(@RequestParam(required=false)
	Integer page)
	{
		if(page == null) page = 1;
		
		// counts
		Integer limit = 3;
		Integer count = (int) getService().count();
		Integer maxPage = (int) Math.floor(count / limit);
		if (maxPage * limit < count) maxPage++;

		// header
		Div div = new Div();
		div.add(new H1(getLabel()));

		// buttongroup with actions and paging
		ButtonGroup bg = new ButtonGroup();
		div.add(bg);

		bg.add(new Button("New").get(getBase() + "/new?back=" + getPath()));

		if (page == 1)
		{
			bg.add(new Button("<<").get(getBase()).disable());
			bg.add(new Button("<").get(getBase()).disable());
		}
		else
		{
			bg.add(new Button("<<").get(getBase()));
			bg.add(new Button("<").get(getBase() + "/?page=" + (page - 1)));
		}

		if (page >= maxPage)
		{
			bg.add(new Button(">>").get(getBase() + "/?page=" + maxPage).disable());
			bg.add(new Button(">>").get(getBase() + "/?page=" + maxPage).disable());
		}
		else
		{
			bg.add(new Button(">").get(getBase() + "/?page=" + (page + 1)));
			bg.add(new Button(">>").get(getBase() + "/?page=" + maxPage));
		}

		// status
		div.add(new Html("items " + ((page - 1) * limit + 1) + " to " + Math.min(page * limit, count) + " of " + count));

		// data
		Table table = new Table(getService().find(new Query().limit(limit).page(page)));
		// change rendering of first column to be hyperlink
		table.template("Id", "<a href=\"" + getBase() + "/${Id}?back=" + getPath() + "\">${Id}</a>");
		div.add(table);

		return div;
	}

	@RequestMapping("{id}")
	public View<?> show(@PathVariable("id")
	Integer id, @RequestParam(required = false)
	String back)
	{
		if (back == null) back = getBase();

		E e = getService().getById(id);
		if (e == null) return new Div().add(new H1("NOT FOUND"));

		Div d = new Div().add(new H1(e.getMetaData().getLabel()));
		ButtonGroup bg = new ButtonGroup();
		d.add(bg);

		// get prev
		List<E> aList = getService().list(new Query().lt(e.getIdField(), e.getIdValue()).limit(1));
		if (aList.size() == 1) bg.add(new Button("<").get(getBase() + "/" + aList.get(0).getIdValue().toString()
				+ "?back=" + back));
		else bg.add(new Button("<").get("").disable());

		// get next
		aList = getService().list(new Query().gt(e.getIdField(), e.getIdValue()).limit(1));
		if (aList.size() == 1) bg.add(new Button(">").get(getBase() + "/" + aList.get(0).getIdValue().toString()
				+ "?back=" + back));
		else bg.add(new Button(">").get("").disable());

		// add edit and back to list
		bg.add(new Button("Edit").get(getBase() + "/" + id + "/edit?back=" + back).primary());
		bg.add(new Button("Remove").get(getBase() + "/" + id + "/remove?back=" + back).danger());
		bg.add(new Button("Back").get(back));

		// show the entity contents
		d.add(new Show(e));
		return d;
	}

	@RequestMapping("{id}/edit")
	public View<?> edit(@PathVariable("id")
	Integer id, @RequestParam(required = false)
	String back)
	{
		if (back == null) back = getBase();

		E e = getService().getById(id);
		if (e != null)
		{
			Div d = new Div();
			d.add(new H1(e.getMetaData().getLabel()));

			Form f = new Form(e);
			f.add(new Button("Save").post(getBase() + "/save").primary());
			f.add(new Button("Back").get(back));

			d.add(f);
			return d;
		}
		else return new Div(new H1("NOT FOUND"));
	}

	@RequestMapping("{id}/remove")
	public View<?> remove(@PathVariable("id")
	Integer id, @RequestParam(required = false)
	String back)
	{
		if (back == null) back = getBase();
		try
		{
			getService().remove(id);
		}
		catch (Exception e)
		{
			Div div = new Div();
			div.add(new Danger("Remove failed: " + convert(e)));
			div.add(new Button("Back").get(back));
			return div;
		}

		Div div = new Div();
		div.add(new Success("Removed succesfully"));
		div.add(new Button("Back").get(back));
		return div;
	}

	@RequestMapping("{id}/save")
	public View<?> save(E entity, @RequestParam(required = false)
	String back)
	{
		if (back == null) back = getBase();

		logger.info(entity);

		try
		{
			getService().update(entity);
		}
		catch (RuntimeException e)
		{
			Div div = new Div();
			div.add(new Danger("Save failed: " + convert(e)));
			Form f = new Form(entity);
			f.add(new Button("Save").post(getBase() + "save?back=" + back).primary());
			f.add(new Button("Cancel").get(back));
			return div.add(f);
		}

		Div div = new Div();
		div.add(new Success("Saved succesfully"));
		Form f = new Form(entity);
		f.add(new Button("Save").post(getBase() + "/save?back=" + back).primary());
		f.add(new Button("Back").get(back));
		return div.add(f);
	}

	@RequestMapping("new")
	public View<?> create(@RequestParam(required = false)
	String back)
	{
		if (back == null) back = getBase();

		Form f = new Form(getService().create());
		f.add(new Button("Add").post(getBase() + "/add?back=" + back).primary());
		f.add(new Button("Cancel").get(back));
		return f;
	}

	@RequestMapping("add")
	public View<?> add(E entity, @RequestParam(required = false)
	String back)
	{
		if (back == null) back = getBase();

		logger.info(entity);
		try
		{
			getService().add(entity);
		}
		catch (RuntimeException e)
		{
			Div div = new Div();
			div.add(new Danger("Add failed: " + convert(e)));
			Form f = new Form(entity);
			f.add(new Button("Add again").post("add?back=" + back).primary());
			f.add(new Button("Cancel").get(back));
			return div.add(f);
		}

		Div div = new Div();
		div.add(new Success("Added succesfully"));
		div.add(new Show(entity));
		div.add(new Button("Edit").get(getBase() + "/" + entity.getIdValue() + "/edit?back=" + back));
		div.add(new Button("Add another").get(getBase() + "/new?back=" + back));
		div.add(new Button("Back").get(back));
		return div;
	}

	/** internal method; takes care of the mapping of date values for date input */
	@InitBinder
	protected void dateBinder(WebDataBinder binder)
	{
		// The date format to parse or output your dates
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// Create a new CustomDateEditor
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		// Register it as custom editor for the Date type
		binder.registerCustomEditor(Date.class, editor);

		// the paging settings
		QueryEditor settingsEditor = new QueryEditor();
		binder.registerCustomEditor(Query.class, settingsEditor);
	}

	public String convert(Exception e)
	{
		String error = "";
		if (e instanceof javax.validation.ConstraintViolationException)
		{
			for (ConstraintViolation<?> v : ((ConstraintViolationException) e).getConstraintViolations())
			{
				error += v.getPropertyPath() + " " + v.getMessage() + ".<br/>";
			}
		}
		else
		{
			error += e.getCause().getMessage();
		}
		return error;
	}

	public class QueryEditor extends PropertyEditorSupport
	{
		public QueryEditor()
		{
		}

		public void setAsText(String text)
		{
			MultiValueMap<String, String> map = WebUtils.parseMatrixVariables(text);

			Query q = new Query();
			q.setPage(Integer.parseInt(map.getFirst("page")));
			Logger.getLogger("test").info("done");
			setValue(q);
		}

		public String getAsText()
		{
			Query q = (Query) getValue();
			return "page=" + q.getPage();
		}
	}

	public String getPath()
	{
		HttpServletRequest curRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		return curRequest.getRequestURI();
	}
}
