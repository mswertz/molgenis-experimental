package org.molgenis.views;

public class Script extends HtmlHeader
{
	public Script(String href)
	{
		super(href);
	}

	@Override
	public String toString()
	{
		return "<script src=\""+href+"\"></script>";
	}

}
