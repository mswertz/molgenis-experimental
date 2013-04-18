package org.molgenis;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import org.molgenis.model.EntityModel;

/**
 * Record is a minimal associative array that includes some meta data model to
 * describe it.
 */
public interface Record extends Serializable
{

	/**
	 * Iterate over the field annotations
	 */
	public abstract EntityModel getModel();

	/**
	 * Retrieves the value of the designated column as Object.
	 * 
	 * @param columnName
	 * @return
	 */
	public abstract Object get(String colName);

	/**
	 * 
	 * @param field
	 * @param value
	 */
	public void set(String field, Object value);

	/**
	 * Set the properties of this entity using the values from another record.
	 * 
	 * @param values
	 * @throws ParseException
	 */
	public void set(Record values) throws RecordException;

	/**
	 * 
	 * @param values
	 * @param strict
	 *            indicate wether missing values should be set to null
	 */
	public void set(Record values, boolean strict);

	/**
	 * Size
	 */
	public int size();

	/** Shorthand for (String key: getModel().getFields()) {key.getName();} */
	public List<String> getFieldNames();
}