
/* File:        Test/html/MrefEntity.java
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


import test.fields.VarcharEntity;
import test.fields.MrefEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity MrefEntity
 * @see EntityForm
 */
public class MrefEntityForm extends EntityForm<MrefEntity>
{
	
	public MrefEntityForm()
	{
		super();
	}
	
	public MrefEntityForm(MrefEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<MrefEntity> getEntityClass()
	{
		return MrefEntity.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("name");
		headers.add("Normal Mref");
		headers.add("Readonly Mref");
		headers.add("Nillable Mref");
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
		
		//name
		StringInput name = new StringInput("name");
		name.label("name");
		inputs.add(name);
		
		//normalMref
		MrefInput normalMref = new MrefInput("normalMref");
		normalMref.label("Normal Mref");
		inputs.add(normalMref);
		
		//readonlyMref
		MrefInput readonlyMref = new MrefInput("readonlyMref");
		readonlyMref.label("Readonly Mref");
		inputs.add(readonlyMref);
		
		//nillableMref
		MrefInput nillableMref = new MrefInput("nillableMref");
		nillableMref.label("Nillable Mref");
		nillableMref.nillable(true);
		inputs.add(nillableMref);
		

		return inputs;
	}
}


