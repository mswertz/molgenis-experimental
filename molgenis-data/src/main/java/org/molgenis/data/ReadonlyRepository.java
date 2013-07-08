package org.molgenis.data;

import org.molgenis.Entity;

public interface ReadonlyRepository<E extends Entity> extends MetaDataRepository<E>
{
	Iterable<E> findAll(); //override
}
