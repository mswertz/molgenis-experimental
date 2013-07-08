package org.molgenis.data.csv;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;

import org.molgenis.Entity;
import org.molgenis.EntityImp;
import org.molgenis.FieldProcessor;
import org.testng.annotations.Test;

public class CsvWriterTest
{
	@SuppressWarnings("resource")
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void CsvWriter()
	{
		new CsvWriter((Writer) null);
	}

	@Test
	public void addCellProcessor_header() throws IOException
	{
		FieldProcessor processor = when(mock(FieldProcessor.class).processHeader()).thenReturn(true).getMock();

		EntityImp tuple = new EntityImp();
		tuple.set("col1", "val1");
		tuple.set("col2", "val2");

		CsvWriter csvWriter = new CsvWriter(new StringWriter());
		try
		{
			csvWriter.addCellProcessor(processor);
			csvWriter.writeColNames(Arrays.asList("col1", "col2"));
			csvWriter.save(tuple);
		}
		finally
		{
			csvWriter.close();
		}
		verify(processor).process("col1");
		verify(processor).process("col2");
	}

	@Test
	public void addCellProcessor_data() throws IOException
	{
		FieldProcessor processor = when(mock(FieldProcessor.class).processData()).thenReturn(true).getMock();

		Entity dataTuple = mock(Entity.class);
		when(dataTuple.size()).thenReturn(2);
		when(dataTuple.get("0")).thenReturn("val1");
		when(dataTuple.get("1")).thenReturn("val2");

		CsvWriter csvWriter = new CsvWriter(new StringWriter());
		try
		{
			csvWriter.addCellProcessor(processor);
			csvWriter.save(dataTuple);
		}
		finally
		{
			csvWriter.close();
		}
		verify(processor).process("val1");
		verify(processor).process("val2");
	}

	@Test
	public void write() throws IOException
	{
		StringWriter strWriter = new StringWriter();
		CsvWriter csvWriter = new CsvWriter(strWriter);
		try
		{
			csvWriter.writeColNames(Arrays.asList("col1", "col2"));
			EntityImp row1 = new EntityImp();
			row1.set("col1", "val1");
			row1.set("col2", "val2");
			csvWriter.save(row1);
			assertEquals(strWriter.toString(), "\"col1\",\"col2\"\n\"val1\",\"val2\"\n");
		}
		finally
		{
			csvWriter.close();
		}
	}

	@Test
	public void write_Tsv() throws IOException
	{
		StringWriter strWriter = new StringWriter();
		CsvWriter csvWriter = new CsvWriter(strWriter, '\t');
		try
		{
			csvWriter.writeColNames(Arrays.asList("col1", "col2"));
			EntityImp row1 = new EntityImp();
			row1.set("col1", "val1");
			row1.set("col2", "val2");
			csvWriter.save(row1);
			assertEquals(strWriter.toString(), "\"col1\"\t\"col2\"\n\"val1\"\t\"val2\"\n");
		}
		finally
		{
			csvWriter.close();
		}
	}

	@Test
	public void close() throws IOException
	{
		// FIXME enable when double closing bug in opencsv is fixed
		// Writer writer = mock(Writer.class);
		// CsvWriter csvWriter = new CsvWriter(writer);
		// csvWriter.close();
		// verify(writer).close();
	}
}
