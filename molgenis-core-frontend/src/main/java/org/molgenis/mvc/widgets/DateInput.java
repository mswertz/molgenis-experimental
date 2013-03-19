package org.molgenis.mvc.widgets;

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
	static String format = "MM/dd/yyyy";

	public DateInput(String name)
	{
		super(name);
		this.placeholder("mm/dd/yyyy");
		this.add(new Css("/res/css/datepicker.css"));
		this.add(new Script("/res/js/bootstrap-datepicker.js"));
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		String date = "";
		if(this.getObject() != null) new SimpleDateFormat(format).format(getObject());
		out.println("<input id=\"" + getId() + "\" type=\"text\" placeholder=\""+getPlaceholder()+"\" class=\"span2 date\" value=\"" + date
				+ "\" data-date-format=\"mm/dd/yyyy\">");
		out.println("<script>$('#" + getId() + "').datepicker({autoclose: true});</script>");

	}
}