package org.molgenis.views;

import java.util.List;


public abstract class FormLayout<T extends FormLayout<T>> extends View<HorizontalLayout>
{
	public FormLayout()
	{
		super(randomId());
	}

	public FormLayout<T> add(FormElement<?> input)
	{
		super.add(input);
		return this;
	}

	public FormLayout<T> add(List<FormElement<?>> inputs)
	{
		for (FormElement<?> i : inputs)
		{
			super.add(i);
		}
		return this;
	}
}
