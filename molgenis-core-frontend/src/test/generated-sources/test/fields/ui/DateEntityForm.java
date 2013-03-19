
/* File:        Test/html/DateEntity.java
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


import test.fields.DateEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity DateEntity
 * @see EntityForm
 */
public class DateEntityForm extends EntityForm<DateEntity>
{
	
	public DateEntityForm()
	{
		super();
	}
	
	public DateEntityForm(DateEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<DateEntity> getEntityClass()
	{
		return DateEntity.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("Normal Date");
		headers.add("Readonly Date");
		headers.add("Nillable Date");
		headers.add("Auto Date");
		headers.add("Default Date");
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
		
		//normalDate
		DateInput normalDate = new DateInput("normalDate");
		normalDate.label("Normal Date");
		inputs.add(normalDate);
		
		//readonlyDate
		DateInput readonlyDate = new DateInput("readonlyDate");
		readonlyDate.label("Readonly Date");
		inputs.add(readonlyDate);
		
		//nillableDate
		DateInput nillableDate = new DateInput("nillableDate");
		nillableDate.label("Nillable Date");
		nillableDate.nillable(true);
		inputs.add(nillableDate);
		
		//autoDate
		DateInput autoDate = new DateInput("autoDate");
		autoDate.label("Auto Date");
		inputs.add(autoDate);
		
		//defaultDate
		DateInput defaultDate = new DateInput("defaultDate");
		defaultDate.label("Default Date");
		inputs.add(defaultDate);
		

		return inputs;
	}
}


