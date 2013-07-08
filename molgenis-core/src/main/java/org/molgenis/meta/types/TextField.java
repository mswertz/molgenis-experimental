package org.molgenis.meta.types;

import java.text.ParseException;

import org.molgenis.meta.MetaDataException;

public class TextField extends FieldType
{
	@Override
	public String getJavaAssignment(String value)
	{
		if(value == null ||value.equals("") ) return "null";
		return "\""+value+"\"";
	}
	
	@Override
	public String getJavaPropertyDefault()
	{
		return getJavaAssignment(f.getDefaultValue());
	}
	
	@Override
	public String getMysqlType() throws MetaDataException
	{
		return "TEXT";
	}
	
	@Override
	public String getOracleType()
	{
		// TODO Auto-generated method stub
		return "VARCHAR";
	}

	@Override
	public String getHsqlType() throws MetaDataException
	{
		//these guys don't have TEXT?
		return "VARCHAR";
	}
	
	@Override
	public String getXsdType() throws MetaDataException
	{
		// TODO Auto-generated method stub
		return "text";
	}

	@Override
	public String getJavaPropertyType() throws MetaDataException
	{
		return "String";
	}

	@Override
	public String getFormatString()
	{
		return "%s";
	}

	@Override
	public String getCppPropertyType() throws MetaDataException
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
		return "text";
	}
	
	@Override
	public String toString(Object value)
	{
		if(value == null) return "";
		return value.toString();
	}
}
