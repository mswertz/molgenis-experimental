package org.molgenis.generators;

import org.molgenis.generators.ForEachEntityGenerator;
import org.molgenis.meta.EntityMetaData;

public class JpaRepositoryGenerator extends ForEachEntityGenerator
{
	public JpaRepositoryGenerator()
	{
		//don't include abstract classes
		super(false);
	}
	@Override
	public String getDescription()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType()
	{
		return "Repository";
	}

	@Override
	public String getPackageName(EntityMetaData entity)
	{
		return entity.getNamespace();
	}
}
