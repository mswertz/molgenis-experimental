package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Input for select box
 * 
 * Thanks to http://ivaynberg.github.com/select2
 */
public class SelectInput extends HtmlInput<SelectInput, Date>
{
	Map<String,String> values = new LinkedHashMap<String,String>();
	
	boolean multi = false;
	
	public SelectInput(String name)
	{
		super(name);
		this.add(new Css("/res/css/select2.css"));
		this.add(new Script("/res/js/select2.js"));
	}
	
	public SelectInput option(String value)
	{
		values.put(value,value);
		return this;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		String multiple = multi ? " multiple" : "";
		out.println("<select"+multiple+" id=\""+getId()+"\" width=\"50%\">");
		
		if(isNillable() && !isMulti()) out.println("<option value=\"\"></option>");
		for(String key: values.keySet())
		{
			out.println("<option value=\""+key+"\">"+values.get(key)+"</option>");
		}
		
		out.println("</select><script>$(document).ready(function(){$('#"+getId()+"').select2({width: 'element'})});</script>");
	}

	public boolean isMulti()
	{
		return multi;
	}

	public SelectInput multi(boolean multi)
	{
		this.multi = multi;
		return this;
	}
}