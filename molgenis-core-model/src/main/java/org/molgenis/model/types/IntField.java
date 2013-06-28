package org.molgenis.model.types;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.molgenis.model.MolgenisModelException;

public class IntField extends FieldType
{
	@Override
	public String getJavaPropertyType() throws MolgenisModelException
	{
		return "Integer";
	}
	
	@Override
	public String getJavaAssignment(String value)
	{
		if(value == null || value.equals("")) return "null";
		return ""+Integer.parseInt(value);
	}
	
	@Override
	public String getJavaPropertyDefault()
	{
		return getJavaAssignment(f.getDefaultValue());
	}
	
	@Override
	public String getMysqlType() throws MolgenisModelException
	{
		return "INTEGER";
	}
	
	@Override
	public String getOracleType() throws MolgenisModelException
	{
		return "NUMBER (10,0)";
	}
	
	public String getJavaSetterType() throws MolgenisModelException
	{
		return "Integer";
	}

	@Override
	public String getHsqlType()
	{
		return "INT";
	}
	@Override
	public String getXsdType()
	{
		return "int";
	}

	@Override
	public String getFormatString()
	{
		return "%d";
	}

	@Override
	public String getCppPropertyType() throws MolgenisModelException
	{
		return "int";
	}
	
	@Override
	public String getCppJavaPropertyType()
	{
		return "Ljava/lang/Integer;";
	}

	public Class<?> getJavaType()
	{
		return Integer.class;
	}

	public Object getTypedValue(String value) throws ParseException
	{
		return Integer.parseInt(value);
	}
	
	public String getName()
	{
		return "int";
	}
	
	@Override
	public List<String> getAllowedOperators()
	{
		return Arrays.asList("EQUALS", "NOT EQUALS", "LESS", "GREATER");
	}
	
	@Override
	public String toString(Object value)
	{
		if(value == null) return "";
		return value.toString();
	}
}
