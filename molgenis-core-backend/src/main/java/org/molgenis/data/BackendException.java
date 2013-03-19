package org.molgenis.data;

public class BackendException extends Exception
{
	private static final long serialVersionUID = 1L;

	public BackendException(Exception e)
	{
		super(e);
	}

	public BackendException(String message)
	{
		super(message);
	}
}
