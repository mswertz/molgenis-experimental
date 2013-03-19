
/* File:        Test/html/GuessMeXref.java
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


import test.inheritance.GuessMeXref;


/**
 * A HtmlForm that is preloaded with all inputs for entity GuessMeXref
 * @see EntityForm
 */
public class GuessMeXrefForm extends EntityForm<GuessMeXref>
{
	
	public GuessMeXrefForm()
	{
		super();
	}
	
	public GuessMeXrefForm(GuessMeXref entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<GuessMeXref> getEntityClass()
	{
		return GuessMeXref.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("guessMeXrefId");
		headers.add("guessMeId");
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
		
		//guessMeXrefId
		IntInput guessMeXrefId = new IntInput("guessMeXrefId");
		guessMeXrefId.label("guessMeXrefId");
		inputs.add(guessMeXrefId);
		
		//guessMeId
		IntInput guessMeId = new IntInput("guessMeId");
		guessMeId.label("guessMeId");
		inputs.add(guessMeId);
		

		return inputs;
	}
}


