package org.molgenis;

import java.util.List;


/**
 * Class to deal with data backends.
 */
public interface Database
{
	<E extends IdentifiableEntity> long count(Class<E> klass);
	
	<E extends IdentifiableEntity> long count(Class<E> klass, Query q);
	
	<E extends IdentifiableEntity> Iterable<E> find(Class<E> klass);
	
	<E extends IdentifiableEntity> Iterable<E> find(Class<E> klass, Query q);
	
	/**
	 * Get an typed record by type and id
	 * 
	 * @throws DatabaseException
	 */
	<E extends IdentifiableEntity> E getById(Class<E> klass, Object id);

	<E extends IdentifiableEntity> E getByLabel(Class<E> klass, String label);

	/**
	 * Get a generic record by collectio name and id
	 * 
	 * @throws DatabaseException
	 */
	IdentifiableEntity getById(String collection, Object id);

	/** list the data collections that this service can create queries for */
	List<String> getCollections();

	// Iterator<EntityModel> maar dan met iets breders

	/** list the classes that this service can create queries for */
	List<Class<? extends IdentifiableEntity>> getClasses();

	/** transactional commands 
	 * @throws DatabaseException */
	public <E extends IdentifiableEntity> void add(E record);

	public <E extends IdentifiableEntity> void add(Iterable<E> records);

	public <E extends IdentifiableEntity> void update(E record);

	public <E extends IdentifiableEntity> void update(Iterable<E> records);

	public <E extends IdentifiableEntity> void remove(E record);

	public <E extends IdentifiableEntity> void remove(Iterable<E> records);

	public <E extends IdentifiableEntity> void apply(BackendAction action, E record);

	public <E extends IdentifiableEntity> void apply(BackendAction action, Iterable<E> records);

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
	 * @throws DatabaseException */
	<E extends IdentifiableEntity> E load(E object);

	<E extends IdentifiableEntity> List<E> list(Class<E> klass, Query q);
}