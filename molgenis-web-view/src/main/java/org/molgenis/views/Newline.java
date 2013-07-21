package org.molgenis.views;

import java.io.PrintWriter;

public class Newline extends View<Newline>
{
	@Override
	public void render(PrintWriter out)
	{
		out.write("<br/>");
	}
}
