package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;

public class Warning extends Alert<Warning>
{
	public Warning(String message)
	{
		super(message, Type.warning);
	}
	
	@Override
	public void render(PrintWriter out) throws IOException {
		this.renderTemplate(out, "<@warn>"+getContents()+"</@warn>");
	}
	
}
