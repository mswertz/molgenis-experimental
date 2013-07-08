package org.molgenis.data.excel;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.molgenis.FieldProcessor;
import org.molgenis.data.RepositoryCollection;
import org.molgenis.data.RepositoryException;

public class ExcelWriter implements RepositoryCollection<ExcelSheetWriter>, Closeable
{
	private final Workbook workbook;
	private final OutputStream os;

	/** process cells after reading */
	private List<FieldProcessor> cellProcessors;

	public enum FileFormat
	{
		XLS, XLSX
	}

	public ExcelWriter(OutputStream os)
	{
		this(os, FileFormat.XLS);
	}

	public ExcelWriter(OutputStream os, FileFormat format)
	{
		if (os == null) throw new IllegalArgumentException("output stream is null");
		if (format == null) throw new IllegalArgumentException("format is null");
		this.os = os;
		this.workbook = format == FileFormat.XLS ? new HSSFWorkbook() : new XSSFWorkbook();
	}

	public ExcelWriter(File file) throws FileNotFoundException
	{
		this(new FileOutputStream(file), FileFormat.XLS);
	}

	public ExcelWriter(File file, FileFormat format) throws FileNotFoundException
	{
		this(new FileOutputStream(file), format);
	}

	@Override
	public ExcelSheetWriter getRepository(String tableName)
	{
		org.apache.poi.ss.usermodel.Sheet poiSheet = this.workbook.createSheet(tableName);
		return new ExcelSheetWriter(poiSheet, cellProcessors);
	}

	public void addCellProcessor(FieldProcessor cellProcessor)
	{
		if (cellProcessors == null) cellProcessors = new ArrayList<FieldProcessor>();
		cellProcessors.add(cellProcessor);
	}

	@Override
	public void close() throws IOException
	{
		try
		{
			this.workbook.write(os);
		}
		finally
		{
			this.os.close();
		}
	}

	@Override
	public Iterable<String> getRepositoryNames() throws IOException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<ExcelSheetWriter> iterator()
	{
		throw new RepositoryException("ExcelWriter.iterator() not yet implemented");
	}
}
