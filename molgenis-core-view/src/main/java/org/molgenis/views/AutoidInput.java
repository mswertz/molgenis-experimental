package org.molgenis.views;


/**
 * Input for int values.
 */
public class AutoidInput extends ValidatingInput<AutoidInput, Integer>
{
	public AutoidInput(String name)
	{
		super(name, "digits");
		this.setReadonly(true);
	}
}
