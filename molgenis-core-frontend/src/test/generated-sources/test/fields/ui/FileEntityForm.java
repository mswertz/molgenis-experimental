
/* File:        Test/html/FileEntity.java
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


import test.fields.FileEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity FileEntity
 * @see EntityForm
 */
public class FileEntityForm extends EntityForm<FileEntity>
{
	
	public FileEntityForm()
	{
		super();
	}
	
	public FileEntityForm(FileEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<FileEntity> getEntityClass()
	{
		return FileEntity.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("Normal File");
		headers.add("Readonly File");
		headers.add("Nillable File");
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
		
		//normalFile
		FileInput normalFile = new FileInput("normalFile");
		normalFile.label("Normal File");
		inputs.add(normalFile);
		
		//readonlyFile
		FileInput readonlyFile = new FileInput("readonlyFile");
		readonlyFile.label("Readonly File");
		inputs.add(readonlyFile);
		
		//nillableFile
		FileInput nillableFile = new FileInput("nillableFile");
		nillableFile.label("Nillable File");
		nillableFile.nillable(true);
		inputs.add(nillableFile);
		

		return inputs;
	}
}


