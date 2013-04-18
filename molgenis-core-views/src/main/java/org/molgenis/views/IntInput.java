package org.molgenis.views;


/**
 * Input for int values.
 */
public class IntInput extends ValidatingInput<IntInput, Integer>
{

	public IntInput(String name)
	{
		super(name, "digits");
	}
}
