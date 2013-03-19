
/* File:        Test/html/EnumEntity.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * 
 * generator:   org.molgenis.ui.generators.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package test.fields.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;


// molgenis
import org.molgenis.ui.widgets.*;


import test.fields.EnumEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity EnumEntity
 * @see EntityForm
 */
public class EnumEntityForm extends EntityForm<EnumEntity>
{
	
	public EnumEntityForm()
	{
		super();
	}
	
	public EnumEntityForm(EnumEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<EnumEntity> getEntityClass()
	{
		return EnumEntity.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("Normal Enum");
		headers.add("Readonly Enum");
		headers.add("Nillable Enum");
		headers.add("Defaulted Enum");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?,?>> getInputs()
	{	
		List<HtmlInput<?,?>> inputs = new ArrayList<HtmlInput<?,?>>();	
				
		//__type
		EnumInput __type = new EnumInput("__type");
		__type.label("__type");
		inputs.add(__type);
		
		//id
		IntInput id = new IntInput("id");
		id.label("id");
		inputs.add(id);
		
		//normalEnum
		EnumInput normalEnum = new EnumInput("normalEnum");
		normalEnum.label("Normal Enum");
		inputs.add(normalEnum);
		
		//readonlyEnum
		EnumInput readonlyEnum = new EnumInput("readonlyEnum");
		readonlyEnum.label("Readonly Enum");
		inputs.add(readonlyEnum);
		
		//nillableEnum
		EnumInput nillableEnum = new EnumInput("nillableEnum");
		nillableEnum.label("Nillable Enum");
		nillableEnum.nillable(true);
		inputs.add(nillableEnum);
		
		//defaultEnum
		EnumInput defaultEnum = new EnumInput("defaultEnum");
		defaultEnum.label("Defaulted Enum");
		inputs.add(defaultEnum);
		

		return inputs;
	}
}


