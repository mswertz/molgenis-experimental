package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;

import org.molgenis.mvc.widgets.Form.FormLayout;

public abstract class FormElement<T extends FormElement<T>> extends GuiElement<T>
{
	/** String constants for property name 'name' */
	public static final String NAME = "name";
	/** String constants for property name 'label' */
	public static final String LABEL = "label";
	/** Hind on how to render */
	private FormLayout type = FormLayout.INLINE;
	/** The name of the input */
	protected String name;
	/** The label of the input. Defaults to 'name'. */
	private String label;

	public FormElement(String id)
	{
		super(id);
	}

	public String getLabel()
	{
		if (label == null) return "";
		return label;
	}

	@SuppressWarnings("unchecked")
	public T label(String label)
	{
		// assert (label != null); fails web tests due to label -> null
		// constructors, so allow it
		this.label = label;
		return (T) this;
	}

	public String getName()
	{
		if (name == null) return this.getId();
		return name;
	}

	@SuppressWarnings("unchecked")
	public T setName(String name)
	{
		this.name = name;
		return (T) this;
	}

}