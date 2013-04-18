package org.molgenis.generators;

import org.apache.log4j.Logger;
import org.molgenis.generate.ForEachEntityGenerator;
import org.molgenis.model.EntityModel;

public class HtmlFormGenerator extends ForEachEntityGenerator
{
	public static final transient Logger logger = Logger.getLogger(HtmlFormGenerator.class);

	@Override
	public String getDescription()
	{
		return "Generates html forms for each entity.";
	}

	@Override
	public String getType()
	{
		return "View";
	}

	@Override
	public String getPackageName(EntityModel entity)
	{
		return entity.getNamespace()+".forms";
	}
}
