
/* File:        Test/html/OtherVarcharEntity.java
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


import test.fields.OtherVarcharEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity OtherVarcharEntity
 * @see EntityForm
 */
public class OtherVarcharEntityForm extends EntityForm<OtherVarcharEntity>
{
	
	public OtherVarcharEntityForm()
	{
		super();
	}
	
	public OtherVarcharEntityForm(OtherVarcharEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<OtherVarcharEntity> getEntityClass()
	{
		return OtherVarcharEntity.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("Normal Varchar");
		headers.add("Readonly Varchar");
		headers.add("Nillable Varchar");
		headers.add("Defaulted Varchar");
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
		
		//normalVarchar
		StringInput normalVarchar = new StringInput("normalVarchar");
		normalVarchar.label("Normal Varchar");
		inputs.add(normalVarchar);
		
		//readonlyVarchar
		StringInput readonlyVarchar = new StringInput("readonlyVarchar");
		readonlyVarchar.label("Readonly Varchar");
		inputs.add(readonlyVarchar);
		
		//nillableVarchar
		StringInput nillableVarchar = new StringInput("nillableVarchar");
		nillableVarchar.label("Nillable Varchar");
		nillableVarchar.nillable(true);
		inputs.add(nillableVarchar);
		
		//defaultVarchar
		StringInput defaultVarchar = new StringInput("defaultVarchar");
		defaultVarchar.label("Defaulted Varchar");
		inputs.add(defaultVarchar);
		

		return inputs;
	}
}


