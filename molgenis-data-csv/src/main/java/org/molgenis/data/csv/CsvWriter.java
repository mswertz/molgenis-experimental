package org.molgenis.data.csv;

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

import org.molgenis.Entity;
import org.molgenis.FieldProcessor;
import org.molgenis.data.ListEscapeUtils;
import org.molgenis.data.RepositoryException;
import org.molgenis.data.WriteonlyRepository;
import org.molgenis.data.processor.AbstractCellProcessor;
import org.molgenis.meta.EntityMetaData;

public class CsvWriter implements WriteonlyRepository<Entity>
{
	private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	public static final char DEFAULT_SEPARATOR = ',';

	private final au.com.bytecode.opencsv.CSVWriter csvWriter;

	/** process cells before writing */
	private List<FieldProcessor> cellProcessors;

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
	public void save(Entity dataTuple)
	{
		String[] values;
		if (cachedColNames != null)
		{
			int i = 0;
			values = new String[cachedColNames.size()];
			for (String colName : cachedColNames)
				values[i++] = toValue(dataTuple.get(colName));
		}
		else
		{
			values = new String[dataTuple.size()];
			for (int i = 0; i < dataTuple.size(); ++i)
				values[i] = toValue(dataTuple.get(Integer.toString(i)));
		}

		this.csvWriter.writeNext(values);
		if (this.csvWriter.checkError()) throw new RepositoryException();
	}

	public void addCellProcessor(FieldProcessor cellProcessor)
	{
		if (cellProcessors == null) cellProcessors = new ArrayList<FieldProcessor>();
		cellProcessors.add(cellProcessor);
	}

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

	@Override
	public void save(Iterable<Entity> entities)
	{
		for (Entity e : entities)
			save(e);
	}

	@Override
	public EntityMetaData getMetaData()
	{
		throw new RepositoryException("CsvWriter.getMetaData() needs to be implemented");
	}
}
