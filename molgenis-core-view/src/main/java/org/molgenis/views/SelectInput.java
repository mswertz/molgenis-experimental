package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Input for select box
 * 
 * Thanks to http://ivaynberg.github.com/select2
 */
public class SelectInput extends HtmlInput<SelectInput, String>
{
	Map<String, String> values = new LinkedHashMap<String, String>();

	boolean multi = false;

	public SelectInput(String name)
	{
		super(name);
		this.add(new Css("/res/css/select2.css"));
		this.add(new Script("/res/js/select2.js"));
	}

	public SelectInput option(String value)
	{
		values.put(value, value);
		return this;
	}

	public SelectInput option(String key, String value)
	{
		values.put(key, value);
		return this;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		String multiple = multi ? " multiple" : "";
		out.println(String.format("<select %s id=\"%s\" class=\"populate placeholder\" name=\"%s\" width=\"50%%\">",
				multiple, getId(), getName()));

		if (!isRequired() && !isMulti()) out.println("<option value=\"\"></option>");
		for (String key : values.keySet())
		{
			if (key != null && key.equals(getValue())) out.println("<option selected value=\"" + key + "\">"
					+ values.get(key) + "</option>");
			else out.println("<option value=\"" + key + "\">" + values.get(key) + "</option>");
		}

		String clear = isRequired() ? "" : ", allowClear: true";
		out.println(String
				.format("</select><script>$(document).ready(function(){$('#%s').select2({width: 'element', placeholder: '%s'%s})});</script>",
						getId(), getPlaceholder(), clear));
	}

	public boolean isMulti()
	{
		return multi;
	}

	public SelectInput multi()
	{
		this.multi = true;
		return this;
	}
}