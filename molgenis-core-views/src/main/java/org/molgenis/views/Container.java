package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * Container, contains text (or html) contents and/or child views
 * 
 * @param <T>
 *            parameterized by subtype
 */
public abstract class Container<T extends Container<T>> extends View<T>
{

	protected String contents = "";

	public Container(View<?>... elements)
	{
		super(elements);
	}

	public Container(String contents)
	{
		super(randomId());
		this.contents = contents;
	}

	public String getContents()
	{
		return contents;
	}

	public Container<T> contents(String contents)
	{
		this.contents = contents;
		return this;
	}

	public abstract void render(PrintWriter out) throws IOException;
}
