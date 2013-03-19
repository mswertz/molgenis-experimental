package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;


public class Alert<E extends Alert<E>> extends GuiElement<E>
{
	public enum Type
	{
		ERROR, WARNING, SUCCESS, INFO
	};

	String message;

	Type type = Type.WARNING;

	public Alert(String message, Type type)
	{
		super(randomId());
		if (message == null) throw new NullPointerException("Cannot create new Alert(null)");
		this.message = message;
		this.type = type;
	}

	public Alert<E> setMessage(String message)
	{
		this.message = message;

		return this;
	}

	public String getMessage()
	{
		return message;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		String cssClass = "alert";

		if (type.equals(Type.ERROR))
		{
			cssClass += " alert-error";
		}
		else if (type.equals(Type.SUCCESS))
		{
			cssClass += " alert-success";
		}
		else if (type.equals(Type.INFO))
		{
			cssClass += " alert-info";
		}
		else
		{
			cssClass += " alert-warning";
		}

		out.println("<div id=\""+getId()+"\" class=\"" + cssClass + "\">");
		out.println("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">x</button>");
		out.println(this.getMessage());
		out.println("</div>");
	}

}
