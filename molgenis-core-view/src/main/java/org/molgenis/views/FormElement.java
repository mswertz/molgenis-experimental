package org.molgenis.views;


public abstract class FormElement<T extends FormElement<T>> extends View<T>
{
	/** String constants for property name 'name' */
	public static final String NAME = "name";
	/** String constants for property name 'label' */
	public static final String LABEL = "label";
	/** The name of the input */
	protected String name;
	/** The label of the input. Defaults to 'name'. */
	private String label;
	
	public FormElement()
	{
		super(randomId());
	}

	public FormElement(String name)
	{
		super(randomId());
		this.name = name;
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