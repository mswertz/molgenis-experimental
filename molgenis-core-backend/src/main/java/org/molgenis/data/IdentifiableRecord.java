package org.molgenis.data;

import org.molgenis.io.Record;
import org.molgenis.model.FieldModel;

public interface IdentifiableRecord extends Record
{
	//FieldModel getIdField();
		
	//FieldModel getLabelField();
		
	/**
	 * Retrieves the value used to identify the record within its host
	 * collection\
	 * 
	 * @return id value
	 */
	public abstract Object getIdValue();

	/**
	 * Retrieves the human readible label for this record. This label is unique
	 * within its host collection
	 * 
	 * @return
	 */
	public abstract String getLabelValue();
}
