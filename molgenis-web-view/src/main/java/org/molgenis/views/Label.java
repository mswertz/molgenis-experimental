package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;



public class Label extends View<Label>
{
	private String value;
	
	public Label(String value)
	{
		super(randomId());
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

	public Label value(String value)
	{
		this.value = value;
		return this;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.write("<label>"+getValue()+"</label>");
	}
}
