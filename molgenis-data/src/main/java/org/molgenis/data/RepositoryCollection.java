package org.molgenis.data;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;

import org.molgenis.Entity;

public interface RepositoryCollection<E extends MetaDataRepository<Entity>> extends Iterable<E>, Closeable
{
	public E getRepository(String tableName);

	public Iterable<String> getRepositoryNames() throws IOException;

	Iterator<E> iterator();
}
