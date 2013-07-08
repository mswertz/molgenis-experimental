package org.molgenis.views;

import org.molgenis.meta.FieldMetaData;


/**
 * Input for string data. Renders as a <code>textarea</code>.
 */
public class StringInput extends ValidatingInput<StringInput, String>
{
	public StringInput(String name)
	{
		super(name, "");
	}
}
