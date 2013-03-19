
/* File:        Test/html/FreemarkerEntity.java
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


import test.fields.FreemarkerEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity FreemarkerEntity
 * @see EntityForm
 */
public class FreemarkerEntityForm extends EntityForm<FreemarkerEntity>
{
	
	public FreemarkerEntityForm()
	{
		super();
	}
	
	public FreemarkerEntityForm(FreemarkerEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<FreemarkerEntity> getEntityClass()
	{
		return FreemarkerEntity.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("Normal Freemarker");
		headers.add("Readonly Freemarker");
		headers.add("Nillable Freemarker");
		headers.add("Defaulted Freemarker");
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
		
		//normalFreemarker
		StringInput normalFreemarker = new StringInput("normalFreemarker");
		normalFreemarker.label("Normal Freemarker");
		inputs.add(normalFreemarker);
		
		//readonlyFreemarker
		StringInput readonlyFreemarker = new StringInput("readonlyFreemarker");
		readonlyFreemarker.label("Readonly Freemarker");
		inputs.add(readonlyFreemarker);
		
		//nillableFreemarker
		StringInput nillableFreemarker = new StringInput("nillableFreemarker");
		nillableFreemarker.label("Nillable Freemarker");
		nillableFreemarker.nillable(true);
		inputs.add(nillableFreemarker);
		
		//defaultFreemarker
		StringInput defaultFreemarker = new StringInput("defaultFreemarker");
		defaultFreemarker.label("Defaulted Freemarker");
		inputs.add(defaultFreemarker);
		

		return inputs;
	}
}


