package org.molgenis.io;

import java.io.Closeable;
import java.io.IOException;

import org.molgenis.Record;
import org.molgenis.io.processor.CellProcessor;

public interface TableWriter extends Closeable
{
	/**
	 * write column names header
	 * 
	 * @param Record
	 * @throws IOException
	 */
	public void writeColNames(Iterable<String> colNames) throws IOException;

	/**
	 * write row of values
	 * 
	 * @param Record
	 * @throws IOException
	 */
	public void write(Record Record) throws IOException;

	/**
	 * Add a cell processor to process cell values
	 * 
	 * @param cellProcessor
	 */
	public void addCellProcessor(CellProcessor cellProcessor);
}
