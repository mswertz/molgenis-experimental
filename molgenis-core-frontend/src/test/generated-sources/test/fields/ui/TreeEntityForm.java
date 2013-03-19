
/* File:        Test/html/TreeEntity.java
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


import test.fields.TreeEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity TreeEntity
 * @see EntityForm
 */
public class TreeEntityForm extends EntityForm<TreeEntity>
{
	
	public TreeEntityForm()
	{
		super();
	}
	
	public TreeEntityForm(TreeEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<TreeEntity> getEntityClass()
	{
		return TreeEntity.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("name");
		headers.add("parent");
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
		
		//parent
		XrefInput parent = new XrefInput("parent");
		parent.label("parent");
		parent.nillable(true);
		inputs.add(parent);
		

		return inputs;
	}
}


