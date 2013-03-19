package org.molgenis.types;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.molgenis.model.MolgenisModelException;

public class CategoricalType extends FieldType
{
	private Map<String, String> categoryMapping = new HashMap<String, String>();

	@Override
	public String getJavaPropertyType() throws MolgenisModelException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCppPropertyType() throws MolgenisModelException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJavaPropertyDefault() throws MolgenisModelException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJavaAssignment(String value) throws MolgenisModelException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getJavaType() throws MolgenisModelException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMysqlType() throws MolgenisModelException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getXsdType() throws MolgenisModelException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHsqlType() throws MolgenisModelException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormatString()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCppJavaPropertyType() throws MolgenisModelException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOracleType() throws MolgenisModelException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getTypedValue(String value) throws ParseException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName()
	{
		return "categorical";
	}

	/**
	 * @return For a categorical variable type, return the map of value->label pairs.
	 */
	public Map<String, String> getCategoryMapping() {
		return categoryMapping;
	}
}
