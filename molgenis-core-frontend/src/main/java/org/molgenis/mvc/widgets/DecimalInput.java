package org.molgenis.mvc.widgets;

/**
 * Input for decimal values.
 */
public class DecimalInput extends ValidatingInput<DecimalInput, Float>
{
	public DecimalInput(String name)
	{
		super(name,"number");
	}
}
