package org.molgenis.io;

import java.io.Closeable;
import java.io.IOException;

public interface TableWriter extends Closeable
{
	public RecordWriter createTupleWriter(String tableName) throws IOException;
}
