package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;


/** Inject simply a bit of html */
public class Html extends View<Html>
{
	String contents;

	public Html(String contents)
	{
		super(randomId());
		this.contents = contents;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.write(this.contents);

	}

}
