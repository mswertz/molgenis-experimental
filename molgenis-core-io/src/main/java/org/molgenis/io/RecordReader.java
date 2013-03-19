package org.molgenis.io;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;

import org.molgenis.io.processor.CellProcessor;

/**
 * Interface for reading all rows of a table
 */
public interface RecordReader extends Iterable<Record>, Closeable
{
	/**
	 * Returns an iterator over the corresponding column names for this Record
	 * 
	 * @return
	 */
	public Iterator<String> colNamesIterator() throws IOException;

	/**
	 * Add a cell processor to process cell values
	 * 
	 * @param cellProcessor
	 */
	public void addCellProcessor(CellProcessor cellProcessor);
}
