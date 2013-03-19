
/* File:        Test/html/CimplementsA.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * 
 * generator:   org.molgenis.ui.generators.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package test.inheritance.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;


// molgenis
import org.molgenis.ui.widgets.*;


import test.inheritance.CimplementsA;


/**
 * A HtmlForm that is preloaded with all inputs for entity CimplementsA
 * @see EntityForm
 */
public class CimplementsAForm extends EntityForm<CimplementsA>
{
	
	public CimplementsAForm()
	{
		super();
	}
	
	public CimplementsAForm(CimplementsA entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<CimplementsA> getEntityClass()
	{
		return CimplementsA.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("fieldA");
		headers.add("fieldC");
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
		
		//fieldA
		StringInput fieldA = new StringInput("fieldA");
		fieldA.label("fieldA");
		inputs.add(fieldA);
		
		//fieldC
		StringInput fieldC = new StringInput("fieldC");
		fieldC.label("fieldC");
		inputs.add(fieldC);
		

		return inputs;
	}
}


