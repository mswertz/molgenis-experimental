package org.molgenis.views;


/**
 * Input for email values
 */
public class EmailInput extends ValidatingInput<EmailInput, String>
{
	public EmailInput(String name)
	{
		super(name, "email");
	}
}
