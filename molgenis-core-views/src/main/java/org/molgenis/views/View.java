package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * View is a simple composable HTML view framework (i.e. Views can be nested).
 * View is responsible for
 * <ul>
 * <li>Making sure that all its sub views have unique IDs
 * <li>CSS/Javascript are includedin the main view
 * <li>title
 * <li>rendering of the page elements
 * </ul>
 * 
 * View implements a factory method so you can chain the setters.
 */
public class View<T extends View<T>> implements org.springframework.web.servlet.View
{
	/** String constant with the ID field name. Used for set(Record c)*/
	public static final String ID = "id";
	
	/** keep track of unique ids */
	public static int idCounter = 1;

	/** The id of current element */
	private String id;

	/** Css/javascript headers */
	private Set<HtmlHeader> allHeaders = new LinkedHashSet<HtmlHeader>();

	/** map of tree elements (ordered) */
	protected Map<String, View<?>> allChildren = new LinkedHashMap<String, View<?>>();

	/** parent.id (or null if root element). Allows for nesting views */
	protected String parentId;

	public View(View<?> ... elements)
	{
		this(randomId());
		this.add(elements);
	}
	
	public View(String id)
	{
		this.id = id;
		this.allChildren.put(id, this);

		add(new Css("/res/css/bootstrap.min.css"));
		add(new Script("/res/js/jquery-1.8.1.min.js"));
		add(new Script("/res/js/bootstrap.min.js"));
		add(new Script("/res/js/jquery.validate.js"));
	}

	public String getContentType()
	{
		return "text/html";
	}

	public int getContentLength()
	{
		return 0;
	}

	public Map<String, String> getHeaders()
	{
		return new LinkedHashMap<String, String>();
	}

	public void render(PrintWriter out) throws IOException
	{
		for (View<?> el : this.getChildren())
		{
			el.render(out);
		}
	}

	/** This is the bridge the Spring MVC View */
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\"><head>");

		for (HtmlHeader head : this.getHtmlHeaders())
		{
			out.println(head.toString());
		}

		out.println("</head><body><div class=\"container\">");

		this.render(out);

		out.println("</div></body></html>");		
	}

	/** This method is used if users don't want to specify ids themselves */
	protected static String randomId()
	{
		return "molgenis_ui_" + (idCounter++);
	}

	@SuppressWarnings("unchecked")
	public T add(View<?>... elements)
	{
		for (View<?> element : elements)
		{
			// check if id exists
			if (this.allChildren.containsKey(element.getId()))
			{
				throw new RuntimeException("Cannot add " + element.getClass().getSimpleName() + "(id="
						+ element.getId() + "): id is already in use");
			}

			this.allChildren.put(element.getId(), element);
			element.parentId = this.getId();

			// if the element has children, then allChildren should be merged
			this.allChildren.putAll(element.allChildren);
			for (View<?> child : this.allChildren.values())
			{
				child.allChildren = this.allChildren;
			}

			// if the element has headers, merge
			this.allHeaders.addAll(element.allHeaders);
			for (View<?> child : this.allChildren.values())
			{
				child.allHeaders = this.allHeaders;
			}
		}

		return (T) this;
	}

	public Set<HtmlHeader> getHtmlHeaders()
	{
		return this.allHeaders;
	}

	public View<T> add(HtmlHeader header)
	{
		this.allHeaders.add(header);

		return this;
	}

	public List<View<?>> getChildren()
	{
		Vector<View<?>> children = new Vector<View<?>>();
		for (View<?> sc : allChildren.values())
		{
			if (sc.getParent() != null && sc.getParent() == this)
			{
				children.add(sc);
			}
		}
		return children;
	}

	public final View<?> getParent()
	{
		if (parentId != null) return allChildren.get(parentId);
		else return null;
	}

	public String getId()
	{
		return this.id;
	}

	@SuppressWarnings("unchecked")
	protected T setId(String id)
	{
		this.id = id;
		return (T) this;
	}
	
	public void renderChildren(PrintWriter out) throws IOException
	{
		for(View<?> child: this.getChildren())
		{
			child.render(out);
		}
		
	}
}