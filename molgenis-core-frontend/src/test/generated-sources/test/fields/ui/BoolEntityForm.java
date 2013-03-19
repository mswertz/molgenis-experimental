
/* File:        Test/html/BoolEntity.java
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


import test.fields.BoolEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity BoolEntity
 * @see EntityForm
 */
public class BoolEntityForm extends EntityForm<BoolEntity>
{
	
	public BoolEntityForm()
	{
		super();
	}
	
	public BoolEntityForm(BoolEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<BoolEntity> getEntityClass()
	{
		return BoolEntity.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("Normal Bool");
		headers.add("Readonly Bool");
		headers.add("Nillable Bool");
		headers.add("Defaulted Bool");
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
		
		//normalBool
		BoolInput normalBool = new BoolInput("normalBool");
		normalBool.label("Normal Bool");
		inputs.add(normalBool);
		
		//readonlyBool
		BoolInput readonlyBool = new BoolInput("readonlyBool");
		readonlyBool.label("Readonly Bool");
		inputs.add(readonlyBool);
		
		//nillableBool
		BoolInput nillableBool = new BoolInput("nillableBool");
		nillableBool.label("Nillable Bool");
		nillableBool.nillable(true);
		inputs.add(nillableBool);
		
		//defaultBool
		BoolInput defaultBool = new BoolInput("defaultBool");
		defaultBool.label("Defaulted Bool");
		inputs.add(defaultBool);
		

		return inputs;
	}
}


