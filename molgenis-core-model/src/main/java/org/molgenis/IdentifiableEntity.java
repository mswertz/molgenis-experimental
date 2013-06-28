package org.molgenis;


public interface IdentifiableEntity extends Entity
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
	
	public abstract String getIdField();

	/**
	 * Retrieves the human readible label for this record. This label is unique
	 * within its host collection
	 * 
	 * @return
	 */
	public abstract String getLabelValue();
}
