package org.molgenis.data.csv;

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
import org.molgenis.EntityImp;
import org.molgenis.FieldProcessor;
import org.molgenis.data.ReadonlyRepository;
import org.molgenis.data.RepositoryException;
import org.molgenis.data.processor.AbstractCellProcessor;
import org.molgenis.meta.EntityMetaData;
import org.molgenis.meta.FieldMetaData;
import org.molgenis.meta.types.StringField;

/**
 * Comma-Separated Values reader
 * 
 * @see <a href="http://tools.ietf.org/html/rfc4180">RFC 4180</a>
 */
public class CsvReader implements ReadonlyRepository<Entity>
{
	private static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");

	public static final char DEFAULT_SEPARATOR = ',';

	private final au.com.bytecode.opencsv.CSVReader csvReader;

	/** process cells after reading */
	private List<FieldProcessor> cellProcessors;

	/** column names index */
	private Map<String, Integer> colNamesMap;

	private EntityMetaData metaData;

	public void setMetaData(EntityMetaData metaData)
	{
		this.metaData = metaData;
	}

	public CsvReader(Reader reader, EntityMetaData metaData)
	{
		this(reader);
		this.setMetaData(metaData);
	}

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

	public EntityMetaData getMetaData()
	{
		try
		{
			if (colNamesMap == null)
			{
				colNamesMap = toColNamesMap(csvReader.readNext());
			}
			if (metaData == null)
			{
				metaData = new EntityMetaData();
				for (String fieldName : colNamesMap.keySet())
				{
					FieldMetaData fmd = new FieldMetaData();
					fmd.setName(fieldName);
					fmd.setType(new StringField());
					metaData.addField(fmd);
				}
			}
			return metaData;
		}
		catch (IOException e)
		{
			throw new RepositoryException(e);
		}
	}

	@Override
	public Iterable<Entity> findAll()
	{
		try
		{
			// create column header index once and reuse
			final Map<String, Integer> colNamesMap = this.colNamesMap == null ? toColNamesMap(csvReader.readNext()) : this.colNamesMap;

			return new Iterable<Entity>()
			{
				public Iterator<Entity> iterator()
				{
					return new Iterator<Entity>()
					{
						private EntityImp next;
						private boolean getNext = true;

						@Override
						public boolean hasNext()
						{
							return get() != null;
						}

						@Override
						public EntityImp next()
						{
							EntityImp entity = get();
							getNext = true;
							return entity;
						}

						private EntityImp get()
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
											// subsequent separators indicate
											// null
											// values instead of empty strings
											String value = values[i].isEmpty() ? null : values[i];
											values[i] = processCell(value, false);
										}
										if (colNamesMap != null) next = new EntityImp(colNamesMap,
												Arrays.asList(values));
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

	public void addFieldProcessor(FieldProcessor cellProcessor)
	{
		if (cellProcessors == null) cellProcessors = new ArrayList<FieldProcessor>();
		cellProcessors.add(cellProcessor);
	}

	public void close() throws IOException
	{
		csvReader.close();
	}
}
