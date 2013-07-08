package org.molgenis.data;

import java.io.IOException;

public class RepositoryException extends RuntimeException
{
	public RepositoryException(IOException e)
	{
		super(e);
	}

	public RepositoryException()
	{
		super();
	}

	public RepositoryException(String string)
	{
		super(string);
	}

	private static final long serialVersionUID = 1L;
}
