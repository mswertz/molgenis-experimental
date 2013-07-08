package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Input for date values
 * 
 * Based on https://github.com/eternicode/bootstrap-datepicker
 */
public class DateInput extends HtmlInput<DateInput, Date>
{
	private String bootstrapFormat = "mm/dd/yyyy";
	private String javaFormat = "MM/dd/yyyy";

	public DateInput(String name)
	{
		super(name);
		this.placeholder(bootstrapFormat);
		this.add(new Css("/res/css/datepicker.css"));
		this.add(new Script("/res/js/bootstrap-datepicker.js"));
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		String date = "";
		if (this.getObject() != null)
		{
			date = new SimpleDateFormat(javaFormat).format(getObject());
		}
		String required = this.isRequired() ? " required" : "";
		out.println("<input id=\"" + getId() + "\" name=\""+getName()+"\" type=\"text\" placeholder=\"" + getPlaceholder()
				+ "\" class=\"span2 date"+required+"\" value=\"" + date
				+ "\" data-date-format=\""+bootstrapFormat+"\">");
		out.println("<script>$('#" + getId() + "').datepicker({autoclose: true});</script>");

	}
	
	public String getValue()
	{
		String date = "";
		if (this.getObject() != null)
		{
			date = new SimpleDateFormat(bootstrapFormat).format(getObject());
		}
		else if(isRequired())
		{
			date = new SimpleDateFormat(bootstrapFormat).format(new Date());
		}
		return date;
	}
}