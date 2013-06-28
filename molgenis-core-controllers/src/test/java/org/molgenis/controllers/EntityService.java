package org.molgenis.controllers;

import java.util.List;

import org.molgenis.Database;
import org.molgenis.IdentifiableEntity;
import org.molgenis.Query;
import org.molgenis.test.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class EntityService<E extends IdentifiableEntity>
{
	@Autowired
	Database db;

	public EntityService()
	{
		super();
	}
	
	public abstract Class<E> getEntityClass();

	public Iterable<E> find(Query q)
	{
		return db.find(getEntityClass(),q);
	}

	@Transactional
	public void add(E entity)
	{
		db.add(entity);
	}

	@Transactional
	public void update(E entity)
	{
		db.update(entity);
	}

	@Transactional
	public void remove(int id)
	{
		db.remove(db.getById(getEntityClass(), id));
	}

	public E getById(Integer id)
	{
		return db.getById(getEntityClass(), id);
	}

	public long count()
	{
		return db.count(getEntityClass());
	}

	public List<E> list(Query q)
	{
		return db.list(getEntityClass(), q);
	}

	public E create()
	{
		try
		{
			return this.getEntityClass().newInstance();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

}