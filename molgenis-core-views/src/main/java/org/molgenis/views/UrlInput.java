package org.molgenis.views;


/**
 * Input for hyperlinks
 */
public class UrlInput extends ValidatingInput<UrlInput, String>
{
	public UrlInput(String name)
	{
		super(name, "url");
	}
}
