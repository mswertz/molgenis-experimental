package org.molgenis.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.molgenis.io.csv.CsvReader;
import org.molgenis.io.excel.ExcelReader;

public class TableCollectionReaderFactory
{
	private TableCollectionReaderFactory()
	{
	}

	public static TableCollectionReader create(File file) throws IOException
	{
		if (file == null) throw new IllegalArgumentException("file is null");
		if (!file.isFile()) throw new IllegalArgumentException("file is not a file: " + file.getName());
		return createTableReader(file);
	}

	public static TableCollectionReader create(List<File> files) throws IOException
	{
		if (files == null || files.isEmpty()) throw new IllegalArgumentException("files is null or empty");

		AggregateTableReader tableReader = new AggregateTableReader();
		for (File file : files)
			tableReader.addTableReader(createTableReader(file));

		return tableReader;
	}

	private static TableCollectionReader createTableReader(File file) throws IOException
	{
		if (file == null) throw new IllegalArgumentException("file is null");

		String name = file.getName();
		if (name.endsWith(".csv") || name.endsWith(".txt"))
		{
			String tableName = FilenameUtils.getBaseName(name);
			return new SingleTableReader(new CsvReader(file), tableName);
		}
		else if (name.endsWith(".tsv"))
		{
			String tableName = FilenameUtils.getBaseName(name);
			return new SingleTableReader(new CsvReader(file, '\t'), tableName);
		}
		else if (name.endsWith(".xls") || name.endsWith(".xlsx"))
		{
			return new ExcelReader(file);
		}
		else if (name.endsWith(".zip"))
		{
			return new ZipTableCollectionReader(new ZipFile(file));
		}
		else
		{
			throw new IOException("unknown file type: " + name);
		}
	}

	private static class SingleTableReader implements TableCollectionReader
	{
		private final TableReader tupleReader;
		private final String tableName;

		public SingleTableReader(TableReader tupleReader, String tableName)
		{
			if (tupleReader == null) throw new IllegalArgumentException("tuple reader is null");
			if (tableName == null) throw new IllegalArgumentException("table name is null");
			this.tupleReader = tupleReader;
			this.tableName = tableName;
		}

		@Override
		public Iterator<TableReader> iterator()
		{
			return Collections.singletonList(tupleReader).iterator();
		}

		@Override
		public void close() throws IOException
		{
			tupleReader.close();
		}

		@Override
		public TableReader getTupleReader(String tableName) throws IOException
		{
			return this.tableName.equals(tableName) ? tupleReader : null;
		}

		@Override
		public Iterable<String> getTableNames() throws IOException
		{
			return Collections.singletonList(tableName);
		}
	}

	private static class AggregateTableReader implements TableCollectionReader
	{
		private final List<TableCollectionReader> tableReaders;
		private final Map<String, TableReader> tupleReaders;

		public AggregateTableReader()
		{
			tableReaders = new ArrayList<TableCollectionReader>();
			tupleReaders = new LinkedHashMap<String, TableReader>();
		}

		@Override
		public Iterator<TableReader> iterator()
		{
			return Collections.<TableReader> unmodifiableCollection(tupleReaders.values()).iterator();
		}

		public void addTableReader(TableCollectionReader tableReader) throws IOException
		{
			tableReaders.add(tableReader);
			for (String tableName : tableReader.getTableNames())
				tupleReaders.put(tableName, tableReader.getTupleReader(tableName));
		}

		@Override
		public void close() throws IOException
		{
			for (TableCollectionReader tableReader : tableReaders)
				IOUtils.closeQuietly(tableReader);
		}

		@Override
		public TableReader getTupleReader(String tableName) throws IOException
		{
			return tupleReaders.get(tableName);
		}

		@Override
		public Iterable<String> getTableNames() throws IOException
		{
			return Collections.unmodifiableSet(tupleReaders.keySet());
		}
	}
}
