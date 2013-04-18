package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;



public class PrevNext extends View<PrevNext>
{
	public enum Action
	{
		FIRST, PREV, NEXT, LAST
	};

	public PrevNext()
	{
		super(randomId());
	}

	Map<PrevNext.Action, String> actions = new HashMap<PrevNext.Action, String>();

	String message = "";

	public PrevNext next(String link)
	{
		this.actions.put(Action.NEXT, link);

		return this;
	}

	public PrevNext prev(String link)
	{
		this.actions.put(Action.PREV, link);

		return this;
	}

	public PrevNext last(String link)
	{
		this.actions.put(Action.LAST, link);

		return this;
	}

	public PrevNext first(String link)
	{
		this.actions.put(Action.FIRST, link);

		return this;
	}

	public PrevNext message(String message)
	{
		this.message = message;

		return this;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		String firstDisabled = actions.containsKey(Action.FIRST) ? "" : " disabled";
		String prevDisabled = actions.containsKey(Action.PREV) ? "" : " disabled";
		String nextDisabled = actions.containsKey(Action.NEXT) ? "" : " disabled";
		String lastDisabled = actions.containsKey(Action.LAST) ? "" : " disabled";

		String hrefFirst = actions.containsKey(Action.FIRST) ? actions.get(Action.FIRST) : "";
		String hrefPrev = actions.containsKey(Action.PREV) ? actions.get(Action.PREV) : "";
		String hrefNext = actions.containsKey(Action.NEXT) ? actions.get(Action.NEXT) : "";
		String hrefLast = actions.containsKey(Action.LAST) ? actions.get(Action.LAST) : "";

		// render
		out.println("<ul class=\"pager\">");

		out.println("<li class=\"" + firstDisabled + "\"><a href=\"" + hrefFirst + "\">&larr;&larr; First</a></li>");
		out.println("<li class=\"" + prevDisabled + "\"><a href=\"" + hrefPrev + "\">&larr; Previous</a></li>");
		out.println(message);
		out.println("<li class=\"" + nextDisabled + "\"><a href=\"" + hrefNext + "\">Next &rarr;</a></li>");
		out.println("<li class=\"" + lastDisabled + "\"><a href=\"" + hrefLast + "\">Last &rarr;&rarr;</a></li>");

		out.println("</ul>");
	}

}
