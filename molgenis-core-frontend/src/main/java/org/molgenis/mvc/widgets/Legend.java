package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;


public class Legend extends GuiElement<Legend>
{
	private String value;
	
	public Legend(String value)
	{
		super(randomId());
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

	public Legend value(String value)
	{
		this.value = value;
		return this;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.write("<legend>"+getValue()+"</legend>");
	}
}
