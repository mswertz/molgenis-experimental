package org.molgenis.controllers;

import java.io.Serializable;
import java.util.List;

import org.molgenis.Entity;
import org.molgenis.data.CrudRepository;
import org.molgenis.data.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class EntityService<E extends Entity>
{
	public abstract CrudRepository<E> getRepository();

	public EntityService()
	{
		super();
	}
	
	public abstract Class<E> getEntityClass();

	public Iterable<E> find(Query q)
	{
		return getRepository().findAll(q);
	}

	@Transactional
	public void add(E entity)
	{
		getRepository().save(entity);
	}

	@Transactional
	public void update(E entity)
	{
		getRepository().save(entity);
	}

	@Transactional
	public void remove(Integer id)
	{
		getRepository().delete(id);
	}

	public E getById(Integer id)
	{
		return getRepository().findOne(id);
	}

	public long count()
	{
		return getRepository().count();
	}

	public List<E> list(Query q)
	{
		return getRepository().listAll(q);
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