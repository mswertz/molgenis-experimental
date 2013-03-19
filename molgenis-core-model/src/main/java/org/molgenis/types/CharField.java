package org.molgenis.types;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.molgenis.model.MolgenisModelException;

public class CharField extends FieldType
{
	@Override
	public String getJavaAssignment(String value) throws MolgenisModelException
	{
		if(value == null || value.equals("") ) return "null";
		return "\""+value+"\"";
	}
	
	@Override
	public String getJavaPropertyDefault() throws MolgenisModelException
	{
		return getJavaAssignment(f.getDefaultValue());
	}

	@Override
	public String getJavaPropertyType() throws MolgenisModelException
	{
		return "String";
	}

	@Override
	public String getMysqlType() throws MolgenisModelException
	{
		return "CHAR("+f.getLength()+")";
	}
	
	@Override
	public String getOracleType() throws MolgenisModelException
	{
		return "CHAR("+f.getLength()+")";
	}

	@Override
	public String getHsqlType() throws MolgenisModelException
	{
		return "CHAR("+f.getLength()+")";
	}
	@Override
	public String getXsdType() throws MolgenisModelException
	{
		return "string";
	}

	@Override
	public String getFormatString()
	{
		return "%s";
	}

	@Override
	public String getCppPropertyType() throws MolgenisModelException
	{
		return "string";
	}

	@Override
	public String getCppJavaPropertyType()
	{
		return "Ljava/lang/String;";
	}

	@Override
	public Class<?> getJavaType()
	{
		return String.class;
	}

	public String getTypedValue(String value) throws ParseException
	{
		return value;
	}

	public String getName()
	{
		return "char";
	}
	
	@Override
	public List<String> getAllowedOperators()
	{
		return Arrays.asList("EQUALS", "NOT EQUALS", "LESS", "GREATER", "LIKE");
	}
}
