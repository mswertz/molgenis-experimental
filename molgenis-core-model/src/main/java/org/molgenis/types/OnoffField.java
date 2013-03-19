package org.molgenis.types;

import org.molgenis.model.MolgenisModelException;

public class OnoffField extends BoolField
{
	@Override
	public String getMysqlType() throws MolgenisModelException
	{
		return "INTEGER";
	}
}
