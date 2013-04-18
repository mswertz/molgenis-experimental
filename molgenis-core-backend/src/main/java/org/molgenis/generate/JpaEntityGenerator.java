package org.molgenis.generate;

import org.molgenis.generate.ForEachEntityGenerator;
import org.molgenis.model.EntityModel;

public class JpaEntityGenerator extends ForEachEntityGenerator
{
	public JpaEntityGenerator()
	{
		super(true);
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
		return "";
	}

	@Override
	public String getPackageName(EntityModel entity)
	{
		return entity.getNamespace();
	}

}
