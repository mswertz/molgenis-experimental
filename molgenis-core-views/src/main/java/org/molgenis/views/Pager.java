package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Pager extends View<Pager>
{
	List<Hyperlink> pages = new ArrayList<Hyperlink>();

	public Pager()
	{
		super(randomId());
	}

	public Pager add(String url, String label)
	{
		add(new Hyperlink().url(url).label(label));
		return this;
	}

	public Pager add(String url, String label, boolean disabled)
	{
		pages.add(new Hyperlink().url(url).label(label).disable(disabled));
		return this;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.println("<div class=\"pagination\"><ul>");
		for (Hyperlink h : pages)
		{
			out.println(String.format("<li><a href=\"%s\" %s>%s</a></li>", h.getUrl(),
					h.isDisabled() ? " class=\"disabled\"" : "", h.getLabel()
					));
		}
		out.println("</ul></div>");
	}
}
