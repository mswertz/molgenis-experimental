package org.molgenis.views;


/**
 * Input for long values.
 */
public class LongInput extends ValidatingInput<LongInput, String>
{


	public LongInput(String name)
	{
		super(name, "digits");
	}
}
