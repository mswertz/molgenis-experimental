package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

/**
 * Page is responsible for
 * <ul>
 * <li>Making sure that all its elements have unique IDs
 * <li>CSS/Javascript
 * <li>title
 * <li>rendering of the page elements
 * </ul>
 */
public class GuiView extends GuiElement<GuiView> implements View
{
	public GuiView()
	{
		super(randomId());
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
		return new LinkedHashMap<String,String>();
	}

	@Override
	public void render(Map<String, ?> arg0, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\"><head>");

		for (HtmlHeader head : this.getHtmlHeaders())
		{
			out.println(head.toString());
		}

		out.println("</head><body><div class=\"container\">");

		for (GuiElement<?> el : this.getChildren())
		{
			el.render(out);
		}

		out.println("</div></body></html>");
		
	}
}
