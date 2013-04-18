package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Input for data time.
 * 
 * Thanks to http://www.malot.fr/bootstrap-datetimepicker/
 */
public class DatetimeInput extends HtmlInput<DatetimeInput, Date>
{
	private String format = "MM/dd/yyyy HH:mm";

	public DatetimeInput(String name)
	{
		super(name);
		this.add(new Css("/res/css/bootstrap-datetimepicker.css"));
		this.add(new Script("/res/js/bootstrap-datetimepicker.min.js"));
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		String date = "";
		if (this.getObject() != null)
		{
			date = new SimpleDateFormat(format).format(getObject());
		}
		else if(isRequired())
		{
			date = new SimpleDateFormat(format).format(new Date());
		}
		out.println(String.format("<div id=\"%s\" class=\"input-append date\"  data-date=\"%s\">",getId(),date));
		out.println(String.format("<input name=\"%s\" size=\"16\" type=\"text\" readonly />",	getName()));
		if (!isRequired()) out.println("<span class=\"add-on\"><i class=\"icon-remove\"></i></span>");
		out.println("<span class=\"add-on\"><i class=\"icon-th\"></i></span>");
		out.println("</div>");
		out.println(String
				.format("<script type=\"text/javascript\">$(\"#%s\").datetimepicker({format: 'mm/dd/yyyy hh:ii', autoclose: true, minuteStep: 1});</script>",
						getId()));
	}
}
