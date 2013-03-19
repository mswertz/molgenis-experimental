
/* File:        Test/html/RichtextEntity.java
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


import test.fields.RichtextEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity RichtextEntity
 * @see EntityForm
 */
public class RichtextEntityForm extends EntityForm<RichtextEntity>
{
	
	public RichtextEntityForm()
	{
		super();
	}
	
	public RichtextEntityForm(RichtextEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<RichtextEntity> getEntityClass()
	{
		return RichtextEntity.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("Normal Text");
		headers.add("Readonly Text");
		headers.add("Nillable Text");
		headers.add("Defaulted Text");
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
		
		//normalText
		StringInput normalText = new StringInput("normalText");
		normalText.label("Normal Text");
		inputs.add(normalText);
		
		//readonlyText
		StringInput readonlyText = new StringInput("readonlyText");
		readonlyText.label("Readonly Text");
		inputs.add(readonlyText);
		
		//nillableText
		StringInput nillableText = new StringInput("nillableText");
		nillableText.label("Nillable Text");
		nillableText.nillable(true);
		inputs.add(nillableText);
		
		//defaultText
		StringInput defaultText = new StringInput("defaultText");
		defaultText.label("Defaulted Text");
		inputs.add(defaultText);
		

		return inputs;
	}
}


