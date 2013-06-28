package org.molgenis.model.types;

import java.text.ParseException;

import org.molgenis.model.MolgenisModelException;

public class StringField extends FieldType
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
		return "VARCHAR("+f.getLength()+")";
	}
	
	@Override
	public String getOracleType() throws MolgenisModelException
	{
		return "VARCHAR2("+f.getLength()+")";
	}

	@Override
	public String getHsqlType() throws MolgenisModelException
	{
		return "VARCHAR("+f.getLength()+")";
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

	public Class<?> getJavaType()
	{
		return String.class;
	}

	@Override
	public String getTypedValue(String value) throws ParseException
	{
		return value;
	}


	public String getName()
	{
		return "string";
	}

	@Override
	public String toString(Object value)
	{
		if(value == null) return "";
		return value.toString();
	}
}