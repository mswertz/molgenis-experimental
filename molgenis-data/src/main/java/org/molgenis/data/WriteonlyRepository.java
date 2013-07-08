package org.molgenis.data;

import org.molgenis.Entity;

public interface WriteonlyRepository<E extends Entity> extends MetaDataRepository<E>
{
	void save(E entity); // new

	void save(Iterable<E> entities); // new
}
