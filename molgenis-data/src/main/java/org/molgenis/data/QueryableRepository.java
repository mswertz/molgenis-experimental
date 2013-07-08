package org.molgenis.data;

import java.io.Serializable;
import java.util.List;

import org.molgenis.Entity;

public interface QueryableRepository<E extends Entity> extends ReadonlyRepository<E>
{
	long count(); //override
	
	TypedQuery<E> query();
	
	long count(Query q); // new

	E findOne(Integer id); // override

	Iterable<E> findAll(Iterable<Integer> ids); // override

	Iterable<E> findAll(Query q); // new

	List<E> listAll(Query q);
}
