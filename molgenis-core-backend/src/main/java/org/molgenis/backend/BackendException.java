package org.molgenis.backend;

public class BackendException extends RuntimeException
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
