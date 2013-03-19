<#include "GeneratorHelper.ftl">

<#--#####################################################################-->
<#--                                                                   ##-->
<#--         START OF THE OUTPUT                                       ##-->
<#--                                                                   ##-->
<#--#####################################################################-->
/* File:        ${Name(model)}/html/${entity.getName()}.java
 * Copyright:   GBIC 2000-${year?c}, all rights reserved
 * Date:        ${date}
 * 
 * generator:   ${generator} ${version}
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package ${package};

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;


// molgenis
import org.molgenis.ui.widgets.*;


${imports(model, entity, "")}

/**
 * A HtmlForm that is preloaded with all inputs for entity ${JavaName(entity)}
 * @see EntityForm
 */
public class ${JavaName(entity)}Form extends EntityForm<${JavaName(entity)}>
{
	
	public ${JavaName(entity)}Form()
	{
		super();
	}
	
	public ${JavaName(entity)}Form(${JavaName(entity)} entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<${JavaName(entity)}> getEntityClass()
	{
		return ${JavaName(entity)}.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
<#list entity.getAllFields() as field>
		headers.add("${field.label}");
</#list>
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?,?>> getInputs()
	{	
		List<HtmlInput<?,?>> inputs = new ArrayList<HtmlInput<?,?>>();	
				
<#list allFields(entity) as field>
		//${field.name}
		${JavaName(field.type)}Input ${name(field)} = new ${JavaName(field.type)}Input("${field.name}");
		${name(field)}.label("${field.label}");<#if field.nillable>
		${name(field)}.nillable(true);</#if>
		inputs.add(${name(field)});
		
</#list>	

		return inputs;
	}
}


