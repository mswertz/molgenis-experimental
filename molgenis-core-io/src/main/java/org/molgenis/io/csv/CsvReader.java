package org.molgenis.io.csv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.molgenis.Entity;
import org.molgenis.MapEntity;
import org.molgenis.io.TableReader;
import org.molgenis.io.processor.AbstractCellProcessor;
import org.molgenis.io.processor.CellProcessor;

/**
 * Comma-Separated Values reader
 * 
 * @see <a href="http://tools.ietf.org/html/rfc4180">RFC 4180</a>
 */
public class CsvReader implements TableReader
{
	private static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");

	public static final char DEFAULT_SEPARATOR = ',';

	private final au.com.bytecode.opencsv.CSVReader csvReader;

	/** process cells after reading */
	private List<CellProcessor> cellProcessors;
	/** column names index */
	private Map<String, Integer> colNamesMap;

	public CsvReader(Reader reader)
	{
		this(reader, DEFAULT_SEPARATOR);
	}

	public CsvReader(Reader reader, char separator)
	{
		if (reader == null) throw new IllegalArgumentException("reader is null");
		this.csvReader = new au.com.bytecode.opencsv.CSVReader(reader, separator);
	}

	public CsvReader(File file) throws FileNotFoundException
	{
		this(new InputStreamReader(new FileInputStream(file), CHARSET_UTF8));
	}

	public CsvReader(File file, char separator) throws FileNotFoundException
	{
		this(new InputStreamReader(new FileInputStream(file), CHARSET_UTF8), separator);
	}

	@Override
	public Iterator<String> colNamesIterator() throws IOException
	{
		if (colNamesMap == null) colNamesMap = toColNamesMap(csvReader.readNext());
		return colNamesMap != null ? colNamesMap.keySet().iterator() : null;
	}

	@Override
	public Iterator<Entity> iterator()
	{
		try
		{
			// create column header index once and reuse
			final Map<String, Integer> colNamesMap = this.colNamesMap == null ? toColNamesMap(csvReader.readNext()) : this.colNamesMap;

			return new Iterator<Entity>()
			{
				private Entity next;
				private boolean getNext = true;

				@Override
				public boolean hasNext()
				{
					return get() != null;
				}

				@Override
				public Entity next()
				{
					Entity Record = get();
					getNext = true;
					return Record;
				}

				private Entity get()
				{
					if (getNext)
					{
						try
						{

							String[] values = csvReader.readNext();
							if (values != null)
							{
								for (int i = 0; i < values.length; ++i)
								{
									// subsequent separators indicate null
									// values instead of empty strings
									String value = values[i].isEmpty() ? null : values[i];
									values[i] = processCell(value, false);
								}
								if (colNamesMap != null) next = new MapEntity(colNamesMap, Arrays.asList(values));
							}
							else
							{
								next = null;
							}
							getNext = false;

						}
						catch (IOException e)
						{
							throw new RuntimeException(e);
						}
					}
					return next;
				}

				@Override
				public void remove()
				{
					throw new UnsupportedOperationException();
				}
			};
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	private Map<String, Integer> toColNamesMap(String[] headers)
	{
		if (headers == null) return null;
		if (headers.length == 0) return Collections.emptyMap();

		int capacity = (int) (headers.length / 0.75) + 1;
		Map<String, Integer> columnIdx = new LinkedHashMap<String, Integer>(capacity);
		for (int i = 0; i < headers.length; ++i)
		{
			String header = processCell(headers[i], true);
			columnIdx.put(header, i);
		}
		return columnIdx;
	}

	private String processCell(String value, boolean isHeader)
	{
		return AbstractCellProcessor.processCell(value, isHeader, this.cellProcessors);
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
		csvReader.close();
	}
}
