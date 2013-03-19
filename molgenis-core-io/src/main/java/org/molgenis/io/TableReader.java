package org.molgenis.io;

import java.io.Closeable;
import java.io.IOException;

/**
 * Interface for reading multiple tables
 */
public interface TableReader extends Iterable<RecordReader>, Closeable
{
	public RecordReader getTupleReader(String tableName) throws IOException;

	public Iterable<String> getTableNames() throws IOException;
}
