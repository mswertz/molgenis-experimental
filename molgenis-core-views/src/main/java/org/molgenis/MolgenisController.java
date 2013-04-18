package org.molgenis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.molgenis.views.BoolInput;
import org.molgenis.views.Button;
import org.molgenis.views.Button.Method;
import org.molgenis.views.DateInput;
import org.molgenis.views.DatetimeInput;
import org.molgenis.views.DecimalInput;
import org.molgenis.views.Div;
import org.molgenis.views.EmailInput;
import org.molgenis.views.FileInput;
import org.molgenis.views.Form;
import org.molgenis.views.FreemarkerInput;
import org.molgenis.views.H1;
import org.molgenis.views.Help;
import org.molgenis.views.Html;
import org.molgenis.views.Hyperlink;
import org.molgenis.views.IntInput;
import org.molgenis.views.Legend;
import org.molgenis.views.MrefInput;
import org.molgenis.views.Pager;
import org.molgenis.views.PasswordInput;
import org.molgenis.views.RichtextInput;
import org.molgenis.views.SelectInput;
import org.molgenis.views.StringInput;
import org.molgenis.views.Table;
import org.molgenis.views.TextInput;
import org.molgenis.views.View;
import org.molgenis.views.XrefInput;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * MOLGENIS superclass that provides all kinds of helper methods to rapidly
 * create views.
 */
@Controller
public abstract class MolgenisController
{
	/**
	 * Create a single line String input
	 * 
	 * @param name
	 * @return
	 */
	public StringInput string(String name)
	{
		return new StringInput(name);
	}

	/** Create a text area */
	public TextInput text(String name)
	{
		return new TextInput(name);
	}
	
	/** Create a freemarker area */
	public FreemarkerInput freemarker(String name)
	{
		return new FreemarkerInput(name);
	}

	/**
	 * Create a rich text input, including bold, italic, underline, bullets,
	 * images, hyperlinks
	 */
	public RichtextInput richtext(String name)
	{
		return new RichtextInput(name);
	}

	/** Create a form container */
	public Form form(View<?>... elements)
	{
		Form f = new Form();

		f.add(elements);

		return f;
	}

	/** Creates a button that POSTs form contents to an url */
	public Button post(String name, String url)
	{
		Button b = new Button(name);
		b.setUrl(url);
		b.setMethod(Method.POST);
		return b;
	}

	/** Creates a button that GETs form contents to an url */
	public Button get(String name, String url)
	{
		Button b = new Button(name);
		b.setUrl(url);
		b.setMethod(Method.GET);
		return b;
	}

	/** Creates a yes/no inpute */
	public BoolInput bool(String name)
	{
		return new BoolInput(name);
	}

	/** Create an email input */
	public EmailInput email(String name)
	{
		return new EmailInput(name);
	}

	/** Create a password input */
	public PasswordInput password(String name)
	{
		return new PasswordInput(name);
	}

	/** Create a natural number input */
	public IntInput integer(String name)
	{
		return new IntInput(name);
	}

	/** Create a decimal number input */
	public DecimalInput decimal(String name)
	{
		return new DecimalInput(name);
	}

	/** Create a file upload */
	public FileInput file(String name)
	{
		return new FileInput(name);
	}

	
	/** Create a simple choice */
	public SelectInput select(String name)
	{
		return new SelectInput(name);
	}

	/** Create a table based on list of records */
	public Table table(List<Record> records)
	{
		return new Table().add(records);
	}
	
	/** Create a table based on list of records */
	public Pager pager()
	{
		return new Pager();
	}
	
	/**
	 * Create a standardize JSON choice. Uses REST service of form
	 * ../entity?q=filter
	 */
	public XrefInput xref(String name, String entity)
	{
		return new XrefInput(name, entity);
	}
	
	public MrefInput mref(String name, String entity)
	{
		return new MrefInput(name,entity);
	}

	/** Create a calendar choice */
	public DateInput date(String name)
	{
		DateInput d = new DateInput(name);
		return d;
	}

	/** Create a calender + time choice */
	public DatetimeInput datetime(String name)
	{
		DatetimeInput d = new DatetimeInput(name);
		return d;
	}

	/** internal method; takes care of the mapping of date values for date input */
	@InitBinder
	protected void dateBinder(WebDataBinder binder)
	{
		// The date format to parse or output your dates
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		// Create a new CustomDateEditor
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		// Register it as custom editor for the Date type
		binder.registerCustomEditor(Date.class, editor);
	}

	/**
	 * Create a container with 'legend' layout. Typically used after an input to
	 * explain what an input does
	 */
	public Legend legend(String content)
	{
		return new Legend(content);
	}

	/** Create a container with 'help' layout */
	public Help help(String content)
	{
		return new Help(content);
	}

	/** Create a hyperlink */
	public Hyperlink href(String name, String url)
	{
		return new Hyperlink(name, url);
	}

	/** Create a simple DIV container */
	public Div div(View<?>... elements)
	{
		Div d = new Div();
		d.add(elements);
		return d;
	}

	/** Create a newline */
	public Html br()
	{
		return new Html("<br/>");
	}

	/** Create a level 1 header */
	public H1 H1(String title)
	{
		return new H1(title);
	}
}