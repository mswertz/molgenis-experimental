package org.molgenis.types;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.molgenis.model.MolgenisModelException;

public class DecimalField extends FieldType
{
	@Override
	public String getJavaPropertyType()
	{
		return "Double";
	}

	@Override
	public String getJavaAssignment(String value)
	{
		if(value == null || value.equals("") ) return "null";
		return ""+Double.parseDouble(value);
	}
	
	@Override
	public String getJavaPropertyDefault()
	{
		return getJavaAssignment(f.getDefaultValue());
	}
	
	@Override
	public String getMysqlType() throws MolgenisModelException
	{
		return "DECIMAL(65,30)";
	}
	
	@Override
	public String getOracleType() throws MolgenisModelException
	{
		return "NUMBER";
	}

	@Override
	public String getHsqlType()
	{
		return "DOUBLE";
	}
	
	@Override
	public String getXsdType()
	{
		return "decimal";
	}

	@Override
	public String getFormatString()
	{
		return "%.20g";
	}

	@Override
	public String getCppJavaPropertyType()
	{
		return "Ljava/lang/Double;";
	}

	@Override
	public String getCppPropertyType() throws MolgenisModelException
	{
		return "double";
	}

	public Class<?> getJavaType()
	{
		return Date.class;
	}

	public Double getTypedValue(String value) throws ParseException
	{
		return Double.parseDouble(value);
	}
	
	public String getName()
	{
		return "decimal";
	}
	
	@Override
	public List<String> getAllowedOperators()
	{
		return Arrays.asList("EQUALS", "NOT EQUALS", "LESS", "GREATER");
	}
}
