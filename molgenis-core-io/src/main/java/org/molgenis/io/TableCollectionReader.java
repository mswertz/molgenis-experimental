package org.molgenis.io;

import java.io.Closeable;
import java.io.IOException;

/**
 * Interface for reading multiple tables
 */
public interface TableCollectionReader extends Iterable<TableReader>, Closeable
{
	public TableReader getTupleReader(String tableName) throws IOException;

	public Iterable<String> getTableNames() throws IOException;
}
