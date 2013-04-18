package org.molgenis.io;

import java.io.Closeable;
import java.io.IOException;

public interface TableCollectionWriter extends Closeable
{
	public TableWriter createTupleWriter(String tableName) throws IOException;
}
