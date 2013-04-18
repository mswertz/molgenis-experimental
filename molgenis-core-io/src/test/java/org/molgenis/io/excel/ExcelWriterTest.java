package org.molgenis.io.excel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import org.molgenis.Record;
import org.molgenis.io.TableWriter;
import org.molgenis.io.excel.ExcelWriter.FileFormat;
import org.molgenis.io.processor.CellProcessor;
import org.molgenis.io.record.MapRecord;
import org.molgenis.model.EntityModel;
import org.molgenis.model.FieldModel;
import org.testng.annotations.Test;

public class ExcelWriterTest
{
	@SuppressWarnings("resource")
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void ExcelWriter()
	{
		new ExcelWriter((OutputStream) null);
	}

	@Test
	public void ExcelWriterFileFormat_default() throws IOException
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		new ExcelWriter(bos).close();
		byte[] b = bos.toByteArray();
		assertEquals(b[0] & 0xff, 0xD0);
		assertEquals(b[1] & 0xff, 0xCF);
		assertEquals(b[2] & 0xff, 0x11);
		assertEquals(b[3] & 0xff, 0xE0);
	}

	@Test
	public void ExcelWriterFileFormat_XLS() throws IOException
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		new ExcelWriter(bos, FileFormat.XLS).close();
		byte[] b = bos.toByteArray();
		assertEquals(b[0] & 0xff, 0xD0);
		assertEquals(b[1] & 0xff, 0xCF);
		assertEquals(b[2] & 0xff, 0x11);
		assertEquals(b[3] & 0xff, 0xE0);
	}

	@Test
	public void ExcelWriterFileFormat_XLSX() throws IOException
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		new ExcelWriter(bos, FileFormat.XLSX).close();
		byte[] b = bos.toByteArray();
		assertEquals(b[0] & 0xff, 0x50);
		assertEquals(b[1] & 0xff, 0x4B);
		assertEquals(b[2] & 0xff, 0x03);
		assertEquals(b[3] & 0xff, 0x04);
	}

	@Test
	public void addCellProcessor_header() throws IOException
	{
		CellProcessor processor = when(mock(CellProcessor.class).processHeader()).thenReturn(true).getMock();
		Record headerTuple = mock(Record.class);
		when(headerTuple.size()).thenReturn(2);
		
		EntityModel m = new EntityModel();
		m.addField(new FieldModel("col1"));
		m.addField(new FieldModel("col2"));
		
		when(headerTuple.getModel()).thenReturn(m);

		MapRecord row1 = new MapRecord();
		row1.set("col1", "val1");
		row1.set("col2", "val2");

		OutputStream os = mock(OutputStream.class);
		ExcelWriter excelWriter = new ExcelWriter(os);
		excelWriter.addCellProcessor(processor);
		try
		{
			TableWriter sheetWriter = excelWriter.createTupleWriter("sheet");
			sheetWriter.writeColNames(Arrays.asList("col1", "col2"));
			sheetWriter.write(row1);
		}
		finally
		{
			excelWriter.close();
		}
		verify(processor).process("col1");
		verify(processor).process("col2");
	}

	@Test
	public void addCellProcessor_data() throws IOException
	{
		CellProcessor processor = when(mock(CellProcessor.class).processData()).thenReturn(true).getMock();

		Record dataTuple = mock(Record.class);
		when(dataTuple.size()).thenReturn(2);
		when(dataTuple.get("col1")).thenReturn("val1");
		when(dataTuple.get("col2")).thenReturn("val2");
		
		EntityModel m = new EntityModel();
		m.addField(new FieldModel("col1"));
		m.addField(new FieldModel("col2"));
		
		when(dataTuple.getModel()).thenReturn(m);

		OutputStream os = mock(OutputStream.class);
		ExcelWriter excelWriter = new ExcelWriter(os);
		excelWriter.addCellProcessor(processor);
		try
		{
			TableWriter sheetWriter = excelWriter.createTupleWriter("sheet");
			sheetWriter.writeColNames(Arrays.asList("col1", "col2"));
			sheetWriter.write(dataTuple);
		}
		finally
		{
			excelWriter.close();
		}
		verify(processor).process("val1");
		verify(processor).process("val2");
	}

	@Test
	public void close() throws IOException
	{
		OutputStream os = mock(OutputStream.class);
		ExcelWriter excelWriter = new ExcelWriter(os);
		excelWriter.close();
		verify(os).close();
	}

	@Test
	public void createSheet() throws IOException
	{
		OutputStream os = mock(OutputStream.class);
		ExcelWriter excelWriter = new ExcelWriter(os);
		try
		{
			assertNotNull(excelWriter.createTupleWriter("sheet"));
		}
		finally
		{
			excelWriter.close();
		}
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void createSheet_null() throws IOException
	{
		OutputStream os = mock(OutputStream.class);
		ExcelWriter excelWriter = new ExcelWriter(os);
		try
		{
			assertNotNull(excelWriter.createTupleWriter(null));
		}
		finally
		{
			excelWriter.close();
		}
	}
}
