package org.molgenis.views;

/**
 * Input for decimal values.
 */
public class DecimalInput extends ValidatingInput<DecimalInput, Double>
{
	public DecimalInput(String name)
	{
		super(name,"number");
	}
}
