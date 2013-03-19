
/* File:        Test/html/DateTimeEntity.java
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


import test.fields.DateTimeEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity DateTimeEntity
 * @see EntityForm
 */
public class DateTimeEntityForm extends EntityForm<DateTimeEntity>
{
	
	public DateTimeEntityForm()
	{
		super();
	}
	
	public DateTimeEntityForm(DateTimeEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<DateTimeEntity> getEntityClass()
	{
		return DateTimeEntity.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("Normal DateTime");
		headers.add("Readonly DateTime");
		headers.add("Nillable DateTime");
		headers.add("Auto DateTime");
		headers.add("Default DateTime");
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
		
		//normalDateTime
		DatetimeInput normalDateTime = new DatetimeInput("normalDateTime");
		normalDateTime.label("Normal DateTime");
		inputs.add(normalDateTime);
		
		//readonlyDateTime
		DatetimeInput readonlyDateTime = new DatetimeInput("readonlyDateTime");
		readonlyDateTime.label("Readonly DateTime");
		inputs.add(readonlyDateTime);
		
		//nillableDateTime
		DatetimeInput nillableDateTime = new DatetimeInput("nillableDateTime");
		nillableDateTime.label("Nillable DateTime");
		nillableDateTime.nillable(true);
		inputs.add(nillableDateTime);
		
		//autoDateTime
		DatetimeInput autoDateTime = new DatetimeInput("autoDateTime");
		autoDateTime.label("Auto DateTime");
		inputs.add(autoDateTime);
		
		//defaultDateTime
		DatetimeInput defaultDateTime = new DatetimeInput("defaultDateTime");
		defaultDateTime.label("Default DateTime");
		inputs.add(defaultDateTime);
		

		return inputs;
	}
}


