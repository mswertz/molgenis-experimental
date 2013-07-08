package org.molgenis.data.csv;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.annotation.Nullable;

import org.molgenis.data.RepositoryCollection;
import org.molgenis.data.RepositoryException;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;

public class CsvZipRepositoryCollection implements RepositoryCollection<CsvReader>
{
	private final ZipFile zipFile;
	private final Map<String, ZipEntry> tableNameMap;

	public CsvZipRepositoryCollection(ZipFile zipFile) throws IOException
	{
		if (zipFile == null) throw new IllegalArgumentException("zip file is null");
		this.zipFile = zipFile;

		// init table name map
		tableNameMap = new LinkedHashMap<String, ZipEntry>();
		for (Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();)
		{
			ZipEntry zipEntry = e.nextElement();

			// remove extension from filename
			int pos = zipEntry.getName().lastIndexOf('.');
			String tableName = pos != -1 ? zipEntry.getName().substring(0, pos) : zipEntry.getName();

			tableNameMap.put(tableName, zipEntry);
		}
	}

	@Override
	public Iterator<CsvReader> iterator()
	{
		return Iterators.transform(tableNameMap.values().iterator(), new Function<ZipEntry, CsvReader>()
		{
			@Override
			@Nullable
			public CsvReader apply(@Nullable
			ZipEntry zipEntry)
			{
				return toCsvReader(zipEntry);
			}
		});
	}

	@Override
	public CsvReader getRepository(String tableName)
	{
		ZipEntry zipEntry = tableNameMap.get(tableName);
		return zipEntry != null ? toCsvReader(zipEntry) : null;
	}

	@Override
	public Iterable<String> getRepositoryNames() throws IOException
	{
		return tableNameMap.keySet();
	}

	private CsvReader toCsvReader(ZipEntry zipEntry)
	{
		try
		{
			String name = zipEntry.getName();
			if (name.endsWith(".csv") || name.endsWith(".txt"))
			{
				Reader reader = new InputStreamReader(zipFile.getInputStream(zipEntry), Charset.forName("UTF-8"));
				return new CsvReader(reader);
			}
			else if (name.endsWith(".tsv"))
			{
				Reader reader = new InputStreamReader(zipFile.getInputStream(zipEntry), Charset.forName("UTF-8"));
				return new CsvReader(reader, '\t');
			}
			else
			{
				throw new RepositoryException("unknown file type: " + name);
			}
		}
		catch (IOException e)
		{
			throw new RepositoryException(e);
		}
	}

	@Override
	public void close() throws IOException
	{
		//none
	}
}