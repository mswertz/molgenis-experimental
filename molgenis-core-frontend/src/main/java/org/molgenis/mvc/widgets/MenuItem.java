package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;


public class MenuItem extends GuiElement<MenuItem>
{
	// href, defaults to #id
	String href;
	// label
	String label;

	public MenuItem(String id)
	{
		super(id);
	}
	
	public String getHref()
	{
		if(href == null) return "#"+this.getId();
		return href;
	}

	public MenuItem setHref(String href)
	{
		this.href = href;
		
		return this;
	}

	public String getLabel()
	{
		return label;
	}

	public MenuItem setLabel(String label)
	{
		this.label = label;
		
		return this;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		throw new RuntimeException("tab should only be used as part of TabMenu");

	}

	public MenuItem setContents(String string)
	{
		this.add(new Html(string));
		
		return this;
	}
	
	public String getContents() throws IOException
	{
		if(getChildren().size() == 0) return null;
		
		StringWriter sw = new StringWriter();
		for(GuiElement<?> el: getChildren())
		{
			el.render(new PrintWriter(sw));
		}
		return sw.toString();
	}
}
