
/* File:        Test/html/IntEntity.java
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


import test.fields.IntEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity IntEntity
 * @see EntityForm
 */
public class IntEntityForm extends EntityForm<IntEntity>
{
	
	public IntEntityForm()
	{
		super();
	}
	
	public IntEntityForm(IntEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<IntEntity> getEntityClass()
	{
		return IntEntity.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("Normal Int");
		headers.add("Readonly Int");
		headers.add("Nillable Int");
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
		
		//normalInt
		IntInput normalInt = new IntInput("normalInt");
		normalInt.label("Normal Int");
		inputs.add(normalInt);
		
		//readonlyInt
		IntInput readonlyInt = new IntInput("readonlyInt");
		readonlyInt.label("Readonly Int");
		inputs.add(readonlyInt);
		
		//nillableInt
		IntInput nillableInt = new IntInput("nillableInt");
		nillableInt.label("Nillable Int");
		nillableInt.nillable(true);
		inputs.add(nillableInt);
		
		//defaultInt
		IntInput defaultInt = new IntInput("defaultInt");
		defaultInt.label("Defaulted Bool");
		inputs.add(defaultInt);
		

		return inputs;
	}
}


