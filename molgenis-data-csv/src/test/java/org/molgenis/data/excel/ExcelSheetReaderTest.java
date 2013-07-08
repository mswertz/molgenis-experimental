package org.molgenis.data.excel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;

import org.molgenis.Entity;
import org.molgenis.FieldProcessor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExcelSheetReaderTest
{
	private ExcelReader excelReader;
	private ExcelSheetReader excelSheetReader;

	@BeforeMethod
	public void setUp() throws IOException
	{
		excelReader = new ExcelReader(this.getClass().getResourceAsStream("/test.xls"));
		excelSheetReader = excelReader.getSheet("test");
	}

	@AfterMethod
	public void tearDown() throws IOException
	{
		excelReader.close();
	}

	@SuppressWarnings("resource")
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void ExcelSheetReader()
	{
		new ExcelSheetReader(null, true, null);
	}

	@Test
	public void addCellProcessor_header()
	{
		FieldProcessor processor = when(mock(FieldProcessor.class).processHeader()).thenReturn(true).getMock();
		excelSheetReader.addCellProcessor(processor);
		for (@SuppressWarnings("unused")
		Entity tuple : excelSheetReader.findAll())
		{
		}
		verify(processor).process("col1");
		verify(processor).process("col2");
	}

	@Test
	public void addCellProcessor_data()
	{
		FieldProcessor processor = when(mock(FieldProcessor.class).processData()).thenReturn(true).getMock();
		excelSheetReader.addCellProcessor(processor);
		for (Entity tuple : excelSheetReader.findAll())
			tuple.get("col2");
		verify(processor).process("val2");
		verify(processor).process("val4");
		verify(processor).process("val6");
	}

	@Test
	public void colNamesIterator() throws IOException
	{
		Iterator<String> colNamesIt = excelSheetReader.getMetaData().getFieldNames().iterator();
		assertTrue(colNamesIt.hasNext());
		assertEquals(colNamesIt.next(), "col1");
		assertTrue(colNamesIt.hasNext());
		assertEquals(colNamesIt.next(), "col2");
	}

	@Test
	public void getName()
	{
		assertEquals(excelSheetReader.getName(), "test");
	}

	@Test
	public void iterator()
	{
		Iterator<Entity> it = excelSheetReader.findAll().iterator();
		assertTrue(it.hasNext());

		Entity row1 = it.next();
		assertEquals(row1.get("col1"), "val1");
		assertEquals(row1.get("col2"), "val2");
		assertTrue(it.hasNext());

		Entity row2 = it.next();
		assertEquals(row2.get("col1"), "val3");
		assertEquals(row2.get("col2"), "val4");
		assertTrue(it.hasNext());

		Entity row3 = it.next();
		assertEquals(row3.get("col1"), "XXX");
		assertEquals(row3.get("col2"), "val6");
		assertTrue(it.hasNext());

		// test number cell (col1) and formula cell (col2)
		Entity row4 = it.next();
		assertEquals(row4.get("col1"), "1.2");
		assertEquals(row4.get("col2"), "2.4");
		assertFalse(it.hasNext());
	}

	@Test
	public void colNamesIteratorAndIterator() throws IOException
	{
		Iterator<String> colNamesIt = excelSheetReader.getMetaData().getFieldNames().iterator();
		assertTrue(colNamesIt.hasNext());
		assertEquals(colNamesIt.next(), "col1");
		assertTrue(colNamesIt.hasNext());
		assertEquals(colNamesIt.next(), "col2");

		Iterator<Entity> it = excelSheetReader.findAll().iterator();
		assertTrue(it.hasNext());

		Entity row1 = it.next();
		assertEquals(row1.get("col1"), "val1");
		assertEquals(row1.get("col2"), "val2");
		assertTrue(it.hasNext());

		Entity row2 = it.next();
		assertEquals(row2.get("col1"), "val3");
		assertEquals(row2.get("col2"), "val4");
		assertTrue(it.hasNext());

		Entity row3 = it.next();
		assertEquals(row3.get("col1"), "XXX");
		assertEquals(row3.get("col2"), "val6");
		assertTrue(it.hasNext());

		// test number cell (col1) and formula cell (col2)
		Entity row4 = it.next();
		assertEquals(row4.get("col1"), "1.2");
		assertEquals(row4.get("col2"), "2.4");
		assertFalse(it.hasNext());
	}
}
