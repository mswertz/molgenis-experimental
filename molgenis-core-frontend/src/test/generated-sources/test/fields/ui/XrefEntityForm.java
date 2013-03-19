
/* File:        Test/html/XrefEntity.java
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
import test.fields.OtherVarcharEntity;
import test.fields.XrefEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity XrefEntity
 * @see EntityForm
 */
public class XrefEntityForm extends EntityForm<XrefEntity>
{
	
	public XrefEntityForm()
	{
		super();
	}
	
	public XrefEntityForm(XrefEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<XrefEntity> getEntityClass()
	{
		return XrefEntity.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("Normal Xref");
		headers.add("Readonly Xref");
		headers.add("Nillable Xref");
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
		
		//normalXref
		XrefInput normalXref = new XrefInput("normalXref");
		normalXref.label("Normal Xref");
		inputs.add(normalXref);
		
		//readonlyXref
		XrefInput readonlyXref = new XrefInput("readonlyXref");
		readonlyXref.label("Readonly Xref");
		inputs.add(readonlyXref);
		
		//nillableXref
		XrefInput nillableXref = new XrefInput("nillableXref");
		nillableXref.label("Nillable Xref");
		nillableXref.nillable(true);
		inputs.add(nillableXref);
		

		return inputs;
	}
}


