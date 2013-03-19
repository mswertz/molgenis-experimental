package org.molgenis.io.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.molgenis.io.ListEscapeUtils;
import org.molgenis.io.Record;
import org.molgenis.io.RecordWriter;
import org.molgenis.io.processor.AbstractCellProcessor;
import org.molgenis.io.processor.CellProcessor;

public class CsvWriter implements RecordWriter
{
	private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	public static final char DEFAULT_SEPARATOR = ',';

	private final au.com.bytecode.opencsv.CSVWriter csvWriter;
	/** process cells before writing */
	private List<CellProcessor> cellProcessors;

	private List<String> cachedColNames;

	public CsvWriter(Writer writer)
	{
		this(writer, ',');
	}

	public CsvWriter(Writer writer, char separator)
	{
		if (writer == null) throw new IllegalArgumentException("writer is null");
		this.csvWriter = new au.com.bytecode.opencsv.CSVWriter(writer, separator);
	}

	public CsvWriter(OutputStream os)
	{
		this(new OutputStreamWriter(os, DEFAULT_CHARSET));
	}

	public CsvWriter(OutputStream os, char separator)
	{
		this(new OutputStreamWriter(os, DEFAULT_CHARSET), separator);
	}

	public CsvWriter(File file) throws FileNotFoundException
	{
		this(new OutputStreamWriter(new FileOutputStream(file), DEFAULT_CHARSET), DEFAULT_SEPARATOR);
	}

	public CsvWriter(File file, char separator) throws FileNotFoundException
	{
		this(new OutputStreamWriter(new FileOutputStream(file), DEFAULT_CHARSET), separator);
	}

	@Override
	public void writeColNames(Iterable<String> colNames) throws IOException
	{
		if (cachedColNames == null)
		{
			List<String> processedColNames = new ArrayList<String>();
			for (String colName : colNames)
			{
				// process column name
				String processedColName = AbstractCellProcessor.processCell(colName, true, this.cellProcessors);
				processedColNames.add(processedColName);
			}

			// write column names
			this.csvWriter.writeNext(processedColNames.toArray(new String[0]));
			if (this.csvWriter.checkError()) throw new IOException();

			// store filtered column names
			cachedColNames = processedColNames;
		}
	}

	@Override
	public void write(Record tuple) throws IOException
	{
		String[] values;
		if (cachedColNames != null)
		{
			int i = 0;
			values = new String[cachedColNames.size()];
			for (String colName : cachedColNames)
				values[i++] = toValue(tuple.get(colName));
		}
		else
		{
			values = new String[tuple.size()];
			for (int i = 0; i < tuple.size(); ++i)
				values[i] = toValue(tuple.get(Integer.toString(i)));
		}

		this.csvWriter.writeNext(values);
		if (this.csvWriter.checkError()) throw new IOException();
	}

	@Override
	public void addCellProcessor(CellProcessor cellProcessor)
	{
		if (cellProcessors == null) cellProcessors = new ArrayList<CellProcessor>();
		cellProcessors.add(cellProcessor);
	}

	@Override
	public void close() throws IOException
	{
		this.csvWriter.close();
	}

	private String toValue(Object obj)
	{
		String value;
		if (obj == null)
		{
			value = null;
		}
		else if (obj instanceof List<?>)
		{
			// TODO apply cell processors to list elements?
			value = ListEscapeUtils.toString((List<?>) obj);
		}
		else
		{
			value = obj.toString();
		}
		return AbstractCellProcessor.processCell(value, false, this.cellProcessors);
	}
}
