package org.molgenis.model.types;

import java.text.ParseException;

import org.molgenis.model.FieldModel;
import org.molgenis.model.MolgenisModelException;

public class XrefField extends FieldType 
{	
	@Override
	public String getJavaAssignment(String value)
	{
		return "NOT IMPLEMENTED";
	}
	
	@Override
	public String getJavaPropertyType() throws MolgenisModelException
	{
		return f.getXrefEntity().getNamespace()+"."+f.getXrefEntity().getName();
	}
	
	@Override
	public String getJavaPropertyDefault()
	{
		if(f.getDefaultValue() == null || f.getDefaultValue() == "") return "null";
		return f.getDefaultValue();
	}
	
	public String getJavaGetterType()
	{
		return "List";
	}
	
	@Override
	public String getMysqlType() throws MolgenisModelException
	{
		return getFieldType(f.getXrefField()).getMysqlType();
	}
	
	@Override
	public String getOracleType() throws MolgenisModelException
	{
		return getFieldType(f.getXrefField()).getOracleType();
	}

	@Override
	public String getHsqlType() throws MolgenisModelException
	{
		return getFieldType(f.getXrefField()).getHsqlType();
	}
	
	public String getXsdType() throws MolgenisModelException
	{
		return getFieldType(f.getXrefField()).getXsdType();
	}

	@Override
	public String getFormatString()
	{
		return "";
	}

	@Override
	public String getCppPropertyType() throws MolgenisModelException
	{
		FieldModel f_ref = f.getXrefField();
		return getFieldType(f_ref).getCppPropertyType();
	}
	
	@Override
	public String getCppJavaPropertyType() throws MolgenisModelException
	{
		FieldModel f_ref = f.getXrefField();
		return getFieldType(f_ref).getCppJavaPropertyType();
	}

	@Override
	public Class<?> getJavaType()
	{
		return null;
	}

	@Override
	public Object getTypedValue(String value) throws ParseException
	{
		throw new UnsupportedOperationException("Xref conversion not supported.");
	}
	
	public String getName()
	{
		return "xref";
	}
	
	@Override
	public String toString(Object value)
	{
		if(value == null) return "";
		return value.toString();
	}

}
