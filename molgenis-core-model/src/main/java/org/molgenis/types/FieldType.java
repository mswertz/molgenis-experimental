package org.molgenis.types;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.molgenis.MolgenisTypes;
import org.molgenis.model.FieldModel;
import org.molgenis.model.MolgenisModelException;

/**
 * Definition of a MOLGENIS field type. For example <field name="x"
 * type="string" would relate to type StringField
 */
public abstract class FieldType
{
	/**
	 * For xref purposes we sometimes need a handle of the field this type was
	 * defined as part of.
	 */
	protected FieldModel f;

	/**
	 * Get the field type from a field. Equal to field.getType();
	 * 
	 * @param f
	 * @return
	 * @throws MolgenisModelException
	 */
	public FieldType getFieldType(FieldModel f) throws MolgenisModelException
	{
		return MolgenisTypes.get(f);
	}

	/**
	 * 
	 * @return
	 * @throws MolgenisModelException
	 */
	public String getJavaSetterType() throws MolgenisModelException
	{
		return this.getJavaPropertyType();
	}
	
	public String getJavaGetterType() throws MolgenisModelException
	{
		return this.getJavaSetterType();
	}

	/**
	 * Product the Java type of this field type. Default: "String".
	 * 
	 * @return type in java code
	 * @throws MolgenisModelException
	 */
	abstract public String getJavaPropertyType() throws MolgenisModelException;
	
	/**
	 * Product the Java type of this field type. Default: "String".
	 * 
	 * @return type in java code
	 * @throws MolgenisModelException
	 */
	abstract public String getCppPropertyType() throws MolgenisModelException;

	/**
	 * Produce a valid Java snippet to set the default of a field, using the
	 * 'getDefault' function of that field. Default: "\""+f.getDefault()+"\"".
	 * 
	 * @return default in java code
	 * @throws MolgenisModelException
	 */
	abstract public String getJavaPropertyDefault()
			throws MolgenisModelException;

	/**
	 * Produce a valid Java snippet to set a value for field.
	 * 
	 * @return default in java code
	 * @throws MolgenisModelException
	 */
	public abstract String getJavaAssignment(String value)
			throws MolgenisModelException;

	/**
	 * Produce the Java class corresponding to the value
	 * @return Java class
	 * @throws MolgenisModelException
	 */
	public abstract Class<?> getJavaType() throws MolgenisModelException;
	
	/**
	 * Produce a valid mysql snippet indicating the mysql type. E.g. "BOOL".
	 * 
	 * @return mysql type string
	 * @throws MolgenisModelException
	 */
	abstract public String getMysqlType() throws MolgenisModelException;

	/**
	 * Produce valid XSD type
	 */
	abstract public String getXsdType() throws MolgenisModelException;

	/**
	 * Convert a list of string to comma separated values.
	 * 
	 * @param elements
	 * @return csv
	 */
	public String toCsv(List<String> elements)
	{
		String result = "";

		for (String str : elements)
		{
			result += ((elements.get(0) == str) ? "" : ",") + "'" + str + "'";
		}

		return result;
	}

	/**
	 * Produce a valid hsql snippet indicating the mysql type. E.g. "BOOL".
	 * 
	 * @return hsql type string
	 * @throws MolgenisModelException
	 */
	public abstract String getHsqlType() throws MolgenisModelException;

	public void setField(FieldModel f)
	{
		this.f = f;
	}

	/**
	 * Get the format string, e.g. '%s'
	 * @return
	 */
	public abstract String getFormatString();

	/**
	 * The string value of this type, e.g. 'int' or 'xref'.
	 */
	public String toString()
	{
		return this.getClass().getSimpleName().replace("Field", "")
				.toLowerCase();
	}
  	
	public abstract String getCppJavaPropertyType() throws MolgenisModelException;

	public abstract String getOracleType() throws MolgenisModelException;
	
	public abstract Object getTypedValue(String value) throws ParseException;
	
	public abstract String getName();

	public List<String> getAllowedOperators() {
		return Arrays.asList("EQUALS", "NOT EQUALS");
	}
}
