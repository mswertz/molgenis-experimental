//package org.molgenis.data;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.zip.ZipFile;
//
//import org.apache.commons.io.FilenameUtils;
//import org.apache.commons.io.IOUtils;
//import org.molgenis.Entity;
//import org.molgenis.data.csv.CsvReader;
//import org.molgenis.data.csv.ZipfileRepositoryCollection;
//import org.molgenis.data.excel.ExcelReader;
//
//public class TableCollectionReaderFactory
//{
//	private TableCollectionReaderFactory()
//	{
//	}
//
//	public static RepositoryCollection<ReadonlyRepository<Entity<Serializable>,Serializable>> create(File file) throws IOException
//	{
//		if (file == null) throw new IllegalArgumentException("file is null");
//		if (!file.isFile()) throw new IllegalArgumentException("file is not a file: " + file.getName());
//		return createTableReader(file);
//	}
//
//	public static RepositoryCollection<ReadonlyRepository<Entity<Serializable>,Serializable> create(List<File> files) throws IOException
//	{
//		if (files == null || files.isEmpty()) throw new IllegalArgumentException("files is null or empty");
//
//		AggregateTableReader tableReader = new AggregateTableReader();
//		for (File file : files)
//			tableReader.addRepository(createTableReader(file));
//
//		return tableReader;
//	}
//
//	private static RepositoryCollection<ReadonlyRepository<Entity<Serializable>,Serializable>> createTableReader(File file) throws IOException
//	{
//		if (file == null) throw new IllegalArgumentException("file is null");
//
//		String name = file.getName();
//		if (name.endsWith(".csv") || name.endsWith(".txt"))
//		{
//			String tableName = FilenameUtils.getBaseName(name);
//			return new SingleTableReader(new CsvReader(file), tableName);
//		}
//		else if (name.endsWith(".tsv"))
//		{
//			String tableName = FilenameUtils.getBaseName(name);
//			return new SingleTableReader(new CsvReader(file, '\t'), tableName);
//		}
//		else if (name.endsWith(".xls") || name.endsWith(".xlsx"))
//		{
//			return new ExcelReader(file);
//		}
//		else if (name.endsWith(".zip"))
//		{
//			return new ZipfileRepositoryCollection(new ZipFile(file));
//		}
//		else
//		{
//			throw new IOException("unknown file type: " + name);
//		}
//	}
//
//	private static class SingleTableReader implements RepositoryCollection<ReadonlyRepository<Entity<Serializable>,Serializable>>
//	{
//		private final TableReader tupleReader;
//		private final String tableName;
//
//		public SingleTableReader(TableReader tupleReader, String tableName)
//		{
//			if (tupleReader == null) throw new IllegalArgumentException("tuple reader is null");
//			if (tableName == null) throw new IllegalArgumentException("table name is null");
//			this.tupleReader = tupleReader;
//			this.tableName = tableName;
//		}
//
//		@Override
//		public Iterator<TableReader> iterator()
//		{
//			return Collections.singletonList(tupleReader).iterator();
//		}
//
//		@Override
//		public void close() throws IOException
//		{
//			tupleReader.close();
//		}
//
//		@Override
//		public CsvReader getRepository(String tableName)
//		{
//			return this.tableName.equals(tableName) ? tupleReader : null;
//		}
//
//		@Override
//		public Iterable<String> getRepositoryNames()
//		{
//			return Collections.singletonList(tableName);
//		}
//	}
//
//	private static class AggregateTableReader implements RepositoryCollection<ReadonlyRepository<Entity<Serializable>,Serializable>>
//	{
//		private final List<ReadonlyRepository<Entity<Serializable>,Serializable>> tableReaders;
//		private final Map<String, ReadonlyRepository<Entity<Serializable>,Serializable>> tupleReaders;
//
//		public AggregateTableReader()
//		{
//			tableReaders = new ArrayList<ReadonlyRepository<Entity<Serializable>,Serializable>>();
//			tupleReaders = new LinkedHashMap<String, ReadonlyRepository<Entity<Serializable>,Serializable>>();
//		}
//
//		@Override
//		public Iterator<ReadonlyRepository<Entity<Serializable>,Serializable>> iterator()
//		{
//			return Collections.<ReadonlyRepository<Entity<Serializable>,Serializable>> unmodifiableCollection(tupleReaders.values()).iterator();
//		}
//
//		public void addTableReader(RepositoryCollection<ReadonlyRepository<Entity<Serializable>,Serializable>> tableReader) throws IOException
//		{
//			tableReaders.add(tableReader);
//			for (String tableName : tableReader.getRepositoryNames())
//				tupleReaders.put(tableName, tableReader.getRepository(tableName));
//		}
//
//		@Override
//		public void close() throws IOException
//		{
//			for (RepositoryCollection tableReader : tableReaders)
//				IOUtils.closeQuietly(tableReader);
//		}
//
//		@Override
//		public ReadonlyRepository<Entity<Serializable>, Serializable> getRepository(String tableName)
//		{
//			return tupleReaders.get(tableName);
//		}
//
//		@Override
//		public Iterable<String> getRepositoryNames()
//		{
//			return Collections.unmodifiableSet(tupleReaders.keySet());
//		}
//	}
//}
