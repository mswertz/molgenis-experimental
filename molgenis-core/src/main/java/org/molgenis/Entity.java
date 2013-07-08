package org.molgenis;

import java.io.Serializable;
import java.text.ParseException;

import org.molgenis.meta.EntityMetaData;
import org.molgenis.meta.FieldMetaData;

public interface Entity extends Serializable
{		
	/**
	 * Get meta model
	 */
	EntityMetaData getMetaData();

	/**
	 * Get the id field (typically autoid)
	 * @return
	 */
	String getIdField();
	
	/** 
	 * Get the label field (typically identifier)
	 * 
	 * @return
	 */
	String getLabelField();

	/**
	 * Retrieves the value of the designated column as Object.
	 * 
	 * @param columnName
	 * @return
	 */
	Object get(String colName);
	
	/**
	 * Retrieves the value of the designated column as Object.
	 * 
	 * @param columnName
	 * @return
	 */
	Object get(FieldMetaData field);

	/**
	 * 
	 * @param field
	 * @param value
	 */
	void set(String field, Object value);

	/**
	 * Set the properties of this entity using the values from another Entity.
	 * 
	 * @param values
	 * @throws ParseException
	 */
	void set(Entity values) throws EntityException;

	/**
	 * 
	 * @param values
	 * @param strict
	 *            indicate wether missing values should be set to null
	 */
	public void set(Entity values, boolean strict);

	/**
	 * Size
	 */
	public int size();
	
	/** 
	 * Get the id value
	 * @return id value
	 */
	Integer getIdValue();

	/**
	 * Get the string label
	 * @return
	 */
	String getLabelValue();
}
