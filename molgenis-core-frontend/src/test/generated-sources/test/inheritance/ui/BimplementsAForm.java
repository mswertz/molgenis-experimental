
/* File:        Test/html/BimplementsA.java
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


import test.inheritance.BimplementsA;


/**
 * A HtmlForm that is preloaded with all inputs for entity BimplementsA
 * @see EntityForm
 */
public class BimplementsAForm extends EntityForm<BimplementsA>
{
	
	public BimplementsAForm()
	{
		super();
	}
	
	public BimplementsAForm(BimplementsA entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<BimplementsA> getEntityClass()
	{
		return BimplementsA.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("fieldA");
		headers.add("fieldB");
		headers.add("IssueType");
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
		
		//fieldB
		StringInput fieldB = new StringInput("fieldB");
		fieldB.label("fieldB");
		inputs.add(fieldB);
		
		//IssueType
		StringInput issueType = new StringInput("IssueType");
		issueType.label("IssueType");
		inputs.add(issueType);
		

		return inputs;
	}
}


