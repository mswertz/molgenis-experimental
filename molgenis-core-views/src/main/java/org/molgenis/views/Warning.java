package org.molgenis.views;

public class Warning extends Alert<Warning>
{
	public Warning(String message)
	{
		super(message, Type.WARNING);
	}
}
