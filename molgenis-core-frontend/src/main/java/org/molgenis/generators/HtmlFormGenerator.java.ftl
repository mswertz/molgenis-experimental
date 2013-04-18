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

// molgenis
import org.molgenis.frontend.views.*;
import org.molgenis.backend.TypeUtils;

// generated
import ${entity.namespace}.${JavaName(entity)};

/**
 * A HtmlForm that is preloaded with all inputs for entity ${JavaName(entity)}
 * @see EntityForm
 */
public class ${JavaName(entity)}View extends Form
{
	
	public ${JavaName(entity)}View(${JavaName(entity)} record)
	{
<#list allFields(entity) as field>
		//${field.name}
		this.add(new ${JavaName(field.type)}Input("${field.name}")
			.label("${field.label}")
			.value(TypeUtils.to${settertype(field)}(record.get("${field.name}")))<#if field.nillable>
			.nillable(true)</#if>);	
				
</#list>	
	}
}


