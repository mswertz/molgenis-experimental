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

		this.renderTemplate(out, "<@datetime model.getId() model.getName() model.getValue() model.is Required()/>"); 
	}
	
	public String getValue()
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
		return date;
	}
}
