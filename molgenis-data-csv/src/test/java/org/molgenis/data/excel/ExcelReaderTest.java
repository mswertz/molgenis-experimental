package org.molgenis.data.excel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.molgenis.Entity;
import org.molgenis.FieldProcessor;
import org.molgenis.data.excel.ExcelReader;
import org.molgenis.data.excel.ExcelSheetReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExcelReaderTest
{
	private ExcelReader excelReader;

	@BeforeMethod
	public void setUp() throws IOException
	{
		excelReader = new ExcelReader(this.getClass().getResourceAsStream("/test.xls"));
	}

	@AfterMethod
	public void tearDown() throws IOException
	{
		excelReader.close();
	}

	@SuppressWarnings("resource")
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void ExcelReader() throws IOException
	{
		new ExcelReader((InputStream) null);
	}

	@Test
	public void addCellProcessor_header() throws IOException
	{
		FieldProcessor processor = when(mock(FieldProcessor.class).processHeader()).thenReturn(true).getMock();
		excelReader.addCellProcessor(processor);
		for (ExcelSheetReader sheetReader : excelReader)
		{
			for (@SuppressWarnings("unused")
			Entity tuple : sheetReader.findAll())
			{
			}
		}
		verify(processor).process("col1");
		verify(processor).process("col2");
	}

	@Test
	public void addCellProcessor_data() throws IOException
	{
		FieldProcessor processor = when(mock(FieldProcessor.class).processData()).thenReturn(true).getMock();
		excelReader.addCellProcessor(processor);
		for (ExcelSheetReader sheetReader : excelReader)
			for (Entity tuple : sheetReader.findAll())
				tuple.get("col2");
		verify(processor).process("val2");
		verify(processor).process("val4");
		verify(processor).process("val6");
	}

	@Test
	public void getNumberOfSheets() throws IOException
	{
		assertEquals(excelReader.getNumberOfSheets(), 3);
	}

	@Test
	public void getSheetint() throws IOException
	{
		assertNotNull(excelReader.getSheet(0));
		assertNotNull(excelReader.getSheet(1));
		assertNotNull(excelReader.getSheet(2));
	}

	@Test
	public void getSheetString() throws IOException
	{
		assertNotNull(excelReader.getSheet("test"));
		assertNotNull(excelReader.getSheet("Blad2"));
		assertNotNull(excelReader.getSheet("Blad3"));
		assertNull(excelReader.getSheet("doesnotexist"));
	}

	@Test
	public void iterator()
	{
		Iterator<ExcelSheetReader> it = excelReader.iterator();
		assertTrue(it.hasNext());
		assertNotNull(it.next());
		assertTrue(it.hasNext());
		assertNotNull(it.next());
		assertTrue(it.hasNext());
		assertNotNull(it.next());
		assertFalse(it.hasNext());
	}
}
