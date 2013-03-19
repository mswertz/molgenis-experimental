package org.molgenis.data;

import java.util.List;

import org.hibernate.QueryException;

/**
 * Class to deal with data backends.
 */
public interface Backend
{
	/**
	 * Get an typed record by type and id
	 * 
	 * @throws BackendException
	 */
	<E extends IdentifiableRecord> E getById(Class<E> klass, Object id) throws BackendException;

	<E extends IdentifiableRecord> E getByLabel(Class<E> klass, String label) throws BackendException;

	/**
	 * Get a generic record by collectio name and id
	 * 
	 * @throws BackendException
	 */
	IdentifiableRecord getById(String collection, Object id) throws BackendException;

	/** list the data collections that this service can create queries for */
	List<String> getCollections();

	// Iterator<EntityModel> maar dan met iets breders

	/** list the classes that this service can create queries for */
	List<Class<? extends IdentifiableRecord>> getClasses();

	/**
	 * get a query for a source. E.g. 'dataset1'
	 * 
	 * @throws QueryException
	 */
	Query<? extends IdentifiableRecord> query(String collection) throws BackendException;

	/** get a query for a class. E.g. Sample.class */
	<E extends IdentifiableRecord> Query<E> query(Class<E> klass);

	/** transactional commands 
	 * @throws BackendException */
	public <E extends IdentifiableRecord> void add(E record) throws BackendException;

	public <E extends IdentifiableRecord> void add(Iterable<E> records);

	public <E extends IdentifiableRecord> void update(E record);

	public <E extends IdentifiableRecord> void update(Iterable<E> records);

	public <E extends IdentifiableRecord> void remove(E record);

	public <E extends IdentifiableRecord> void remove(Iterable<E> records);

	public <E extends IdentifiableRecord> void apply(BackendAction action, E record);

	public <E extends IdentifiableRecord> void apply(BackendAction action, Iterable<E> records);

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

	/** Loads record from backend and copies content of E on top of it 
	 * @throws BackendException */
	<E extends IdentifiableRecord> E load(E object) throws BackendException;
}