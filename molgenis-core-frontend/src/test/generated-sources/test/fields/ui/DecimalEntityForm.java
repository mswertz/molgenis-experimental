
/* File:        Test/html/DecimalEntity.java
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


import test.fields.DecimalEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity DecimalEntity
 * @see EntityForm
 */
public class DecimalEntityForm extends EntityForm<DecimalEntity>
{
	
	public DecimalEntityForm()
	{
		super();
	}
	
	public DecimalEntityForm(DecimalEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<DecimalEntity> getEntityClass()
	{
		return DecimalEntity.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("Normal Decimal");
		headers.add("Readonly Decimal");
		headers.add("Nillable Decimal");
		headers.add("Defaulted Decimal");
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
		
		//normalDecimal
		DecimalInput normalDecimal = new DecimalInput("normalDecimal");
		normalDecimal.label("Normal Decimal");
		inputs.add(normalDecimal);
		
		//readonlyDecimal
		DecimalInput readonlyDecimal = new DecimalInput("readonlyDecimal");
		readonlyDecimal.label("Readonly Decimal");
		inputs.add(readonlyDecimal);
		
		//nillableDecimal
		DecimalInput nillableDecimal = new DecimalInput("nillableDecimal");
		nillableDecimal.label("Nillable Decimal");
		nillableDecimal.nillable(true);
		inputs.add(nillableDecimal);
		
		//defaultDecimal
		DecimalInput defaultDecimal = new DecimalInput("defaultDecimal");
		defaultDecimal.label("Defaulted Decimal");
		inputs.add(defaultDecimal);
		

		return inputs;
	}
}


