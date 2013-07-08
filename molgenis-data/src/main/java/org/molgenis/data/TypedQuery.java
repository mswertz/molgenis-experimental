package org.molgenis.data;

import java.io.Serializable;

import org.molgenis.Entity;

public class TypedQuery<E extends Entity> extends Query
{
	QueryableRepository<E> repository;
	
	public TypedQuery(QueryableRepository<E> repository)
	{
		this.repository = repository;
	}
	
	public Iterable<E> find()
	{
		return repository.findAll(this);
	}
	
	public long count()
	{
		return repository.count(this);
	}
}
