
/* File:        Test/html/TextEntity.java
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


import test.fields.TextEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity TextEntity
 * @see EntityForm
 */
public class TextEntityForm extends EntityForm<TextEntity>
{
	
	public TextEntityForm()
	{
		super();
	}
	
	public TextEntityForm(TextEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<TextEntity> getEntityClass()
	{
		return TextEntity.class;
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
		TextInput normalText = new TextInput("normalText");
		normalText.label("Normal Text");
		inputs.add(normalText);
		
		//readonlyText
		TextInput readonlyText = new TextInput("readonlyText");
		readonlyText.label("Readonly Text");
		inputs.add(readonlyText);
		
		//nillableText
		TextInput nillableText = new TextInput("nillableText");
		nillableText.label("Nillable Text");
		nillableText.nillable(true);
		inputs.add(nillableText);
		
		//defaultText
		TextInput defaultText = new TextInput("defaultText");
		defaultText.label("Defaulted Text");
		inputs.add(defaultText);
		

		return inputs;
	}
}


