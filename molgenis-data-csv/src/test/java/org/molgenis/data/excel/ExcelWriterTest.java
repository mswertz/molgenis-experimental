package org.molgenis.data.excel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import org.molgenis.Entity;
import org.molgenis.EntityImp;
import org.molgenis.FieldProcessor;
import org.molgenis.data.excel.ExcelSheetWriter;
import org.molgenis.data.excel.ExcelWriter;
import org.molgenis.data.excel.ExcelWriter.FileFormat;
import org.molgenis.meta.EntityMetaData;
import org.molgenis.meta.FieldMetaData;
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
		FieldProcessor processor = when(mock(FieldProcessor.class).processHeader()).thenReturn(true).getMock();
		Entity headerTuple = mock(Entity.class);
		when(headerTuple.size()).thenReturn(2);
		
		EntityMetaData m = new EntityMetaData();
		m.addField(new FieldMetaData("col1"));
		m.addField(new FieldMetaData("col2"));
		
		when(headerTuple.getMetaData()).thenReturn(m);

		EntityImp row1 = new EntityImp();
		row1.set("col1", "val1");
		row1.set("col2", "val2");

		OutputStream os = mock(OutputStream.class);
		ExcelWriter excelWriter = new ExcelWriter(os);
		excelWriter.addCellProcessor(processor);
		try
		{
			ExcelSheetWriter sheetWriter = excelWriter.getRepository("sheet");
			sheetWriter.writeColNames(Arrays.asList("col1", "col2"));
			sheetWriter.save(row1);
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
		FieldProcessor processor = when(mock(FieldProcessor.class).processData()).thenReturn(true).getMock();

		Entity dataTuple = mock(Entity.class);
		when(dataTuple.size()).thenReturn(2);
		when(dataTuple.get("col1")).thenReturn("val1");
		when(dataTuple.get("col2")).thenReturn("val2");
		
		EntityMetaData m = new EntityMetaData();
		m.addField(new FieldMetaData("col1"));
		m.addField(new FieldMetaData("col2"));
		
		when(dataTuple.getMetaData()).thenReturn(m);

		OutputStream os = mock(OutputStream.class);
		ExcelWriter excelWriter = new ExcelWriter(os);
		excelWriter.addCellProcessor(processor);
		try
		{
			ExcelSheetWriter sheetWriter = excelWriter.getRepository("sheet");
			sheetWriter.writeColNames(Arrays.asList("col1", "col2"));
			sheetWriter.save(dataTuple);
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
			assertNotNull(excelWriter.getRepository("sheet"));
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
			assertNotNull(excelWriter.getRepository(null));
		}
		finally
		{
			excelWriter.close();
		}
	}
}
