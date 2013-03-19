package org.molgenis.types;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.molgenis.model.MolgenisModelException;

public class LongField extends FieldType
{
	@Override
	public String getJavaPropertyType()
	{
		return "Long";
	}

	@Override
	public String getJavaAssignment(String value)
	{
		if (value == null || value.equals("") ) return "null";
		return "" + Long.parseLong(value) + "L";
	}

	
	@Override
	public String getJavaPropertyDefault()
	{
		return getJavaAssignment(f.getDefaultValue());
	}
	
	@Override
	public String getMysqlType() throws MolgenisModelException
	{
		return "BIGINT";
	}
	
	@Override
	public String getOracleType() throws MolgenisModelException
	{
		return "NUMBER (19,0)";
	}

	@Override
	public String getHsqlType()
	{
		return "LONG";
	}
	@Override
	public String getXsdType()
	{
		return "boolean";
	}

	@Override
	public String getFormatString()
	{
		return "%d";
	}

	@Override
	public String getCppPropertyType() throws MolgenisModelException
	{
		return "long";
	}
	
	@Override
	public String getCppJavaPropertyType()
	{
		return "Ljava/lang/Long;";
	}

	public Class<?> getJavaType()
	{
		return Long.class;
	}

	public Long getTypedValue(String value) throws ParseException
	{
		return Long.parseLong(value);
	}
	
	public String getName()
	{
		return "long";
	}
	
	@Override
	public List<String> getAllowedOperators()
	{
		return Arrays.asList("EQUALS", "NOT EQUALS", "LESS", "GREATER");
	}

}
