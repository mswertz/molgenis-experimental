package org.molgenis.data;

import java.io.Serializable;

import org.molgenis.Entity;


/**
 * Class to deal with data backends.
 */
public interface CrudRepository<E extends Entity> extends QueryableRepository<E>
{
	//management
	
	boolean exists(Integer id);
	
	void save(E entity); // override

	void save(Iterable<E> entities); // override
	
	void update(E record); //new

	void update(Iterable<E> records); //nw
	
	void delete(Integer id); //override
	
	void delete(E record); //override
	
	void delete(Iterable<E> entities); //override
	
	void deleteAll(); //override
	
	//E getByLabel(String label);

	//void apply(BackendAction action, E record);

	//void apply(BackendAction action, Iterable<E> records);

	/**
	 * Enumeration of complex database update actions supported by updateByName
	 */
	public enum BackendAction
	{
		/** add records , error on duplicate records */
		ADD,
		/** add, ignore existing records */
		ADD_IGNORE_EXISTING,
		/** add, update existing records */
		ADD_UPDATE_EXISTING,
		/**
		 * update records, throw an error if records are missing in the database
		 */
		UPDATE,
		/** update records, ignore missing records */
		UPDATE_IGNORE_MISSING,
		/**
		 * remove records in the list from database; throw an exception of
		 * records are missing in the database
		 */
		REMOVE,
		/** remove records in the list from database; ignore missing records */
		REMOVE_IGNORE_MISSING,
	}
}