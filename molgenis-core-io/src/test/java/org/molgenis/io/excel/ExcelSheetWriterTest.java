package org.molgenis.io.excel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.molgenis.io.Record;
import org.molgenis.io.processor.CellProcessor;
import org.molgenis.io.record.MapRecord;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExcelSheetWriterTest
{
	private ExcelWriter excelWriter;
	private ByteArrayOutputStream bos;
	private ExcelSheetWriter excelSheetWriter;

	@BeforeMethod
	public void setUp() throws IOException
	{
		bos = new ByteArrayOutputStream();
		excelWriter = new ExcelWriter(bos);
		excelSheetWriter = (ExcelSheetWriter) excelWriter.createTupleWriter("sheet");
	}

	@AfterMethod
	public void tearDown() throws IOException
	{
		excelWriter.close();
	}

	@Test
	public void addCellProcessor() throws IOException
	{
		CellProcessor processor = when(mock(CellProcessor.class).processHeader()).thenReturn(true).getMock();

		MapRecord row1 = new MapRecord();
		row1.set("col1", "val1");
		row1.set("col2", "val2");

		excelSheetWriter.addCellProcessor(processor);
		excelSheetWriter.writeColNames(Arrays.asList("col1", "col2"));
		excelSheetWriter.write(row1);

		verify(processor).process("col1");
		verify(processor).process("col2");
	}

	@Test
	public void writeColNames() throws IOException
	{
		MapRecord row1 = new MapRecord();
		row1.set("col1", "val1");
		row1.set("col2", "val2");
		MapRecord row2 = new MapRecord();
		row2.set("col1", "val3");
		row2.set("col2", "val4");

		excelSheetWriter.writeColNames(Arrays.asList("col1", "col2"));
		excelSheetWriter.write(row1);
		excelSheetWriter.write(row2);
		excelWriter.close();

		ExcelReader excelReader = new ExcelReader(new ByteArrayInputStream(bos.toByteArray()), true);
		try
		{
			Iterator<Record> it = excelReader.getSheet("sheet").iterator();
			assertTrue(it.hasNext());
			Record tuple0 = it.next();
			assertEquals(tuple0.get("col1"), "val1");
			assertEquals(tuple0.get("col2"), "val2");
			assertTrue(it.hasNext());
			Record tuple1 = it.next();
			assertEquals(tuple1.get("col1"), "val3");
			assertEquals(tuple1.get("col2"), "val4");
			assertFalse(it.hasNext());
		}
		finally
		{
			excelReader.close();
		}
	}
}
