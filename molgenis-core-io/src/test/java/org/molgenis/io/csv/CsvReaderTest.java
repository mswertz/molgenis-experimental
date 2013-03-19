package org.molgenis.io.csv;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.molgenis.io.Record;
import org.molgenis.io.processor.CellProcessor;
import org.testng.annotations.Test;

public class CsvReaderTest
{
	@SuppressWarnings("resource")
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void CsvReader()
	{
		new CsvReader((Reader) null);
	}

	@Test
	public void addCellProcessor_header() throws IOException
	{
		CellProcessor processor = when(mock(CellProcessor.class).processHeader()).thenReturn(true).getMock();
		CsvReader csvReader = new CsvReader(new StringReader("col1,col2\nval1,val2"), ',');
		try
		{
			csvReader.addCellProcessor(processor);
			for (@SuppressWarnings("unused")
			Record tuple : csvReader)
			{
			}
			verify(processor).process("col1");
			verify(processor).process("col2");
		}
		finally
		{
			csvReader.close();
		}
	}

	@Test
	public void addCellProcessor_data() throws IOException
	{
		CellProcessor processor = when(mock(CellProcessor.class).processData()).thenReturn(true).getMock();
		CsvReader csvReader = new CsvReader(new StringReader("col1,col2\nval1,val2"), ',');
		try
		{
			csvReader.addCellProcessor(processor);
			for (@SuppressWarnings("unused")
			Record tuple : csvReader)
			{
			}
			verify(processor).process("val1");
			verify(processor).process("val2");
		}
		finally
		{
			csvReader.close();
		}
	}

	@Test
	public void colNamesIterator() throws IOException
	{
		CsvReader csvReader = new CsvReader(new StringReader("col1,col2\nval1,val2"), ',');
		try
		{
			Iterator<String> colNamesIt = csvReader.colNamesIterator();
			assertTrue(colNamesIt.hasNext());
			assertEquals(colNamesIt.next(), "col1");
			assertTrue(colNamesIt.hasNext());
			assertEquals(colNamesIt.next(), "col2");
		}
		finally
		{
			csvReader.close();
		}
	}

	/**
	 * Test based on au.com.bytecode.opencsv.CSVReaderTest
	 * 
	 * @throws IOException
	 */
	@Test
	public void iterator() throws IOException
	{
		StringBuilder sb = new StringBuilder();
		sb.append("a,b,c").append('\n'); // standard case
		sb.append("a,\"b,b,b\",c").append('\r'); // quoted elements
		sb.append(",,").append("\n"); // empty elements
		sb.append("a,\"PO Box 123,\nKippax,ACT. 2615.\nAustralia\",d.").append("\r\n");
		// Test quoted quote chars
		sb.append("\"Glen \"\"The Man\"\" Smith\",Athlete,Developer\n");
		sb.append("\"\"\"\"\"\",\"test\"\n"); // """""","test" representing: "",
												// test
		sb.append("\"a\nb\",b,\"\nd\",e\n");
		String csvString = sb.toString();
	}

	@Test
	public void iterator_emptyValues() throws IOException
	{
		String csvString = "col1,col2,col3\n,,\n";
		CsvReader csvReader = new CsvReader(new StringReader(csvString));
		try
		{
			Iterator<Record> it = csvReader.iterator();
			assertTrue(it.hasNext());
			Record tuple = it.next();
			assertEquals(tuple.get("col1"),null);
		}
		finally
		{
			csvReader.close();
		}
	}

	@Test
	public void iterator_separator() throws IOException
	{
		CsvReader tsvReader = new CsvReader(new StringReader("col1\tcol2\nval1\tval2\n"), '\t');
		try
		{
			Iterator<Record> it = tsvReader.iterator();
			Record t0 = it.next();
			assertEquals(t0.get("col1"), "val1");
			assertEquals(t0.get("col2"), "val2");
			assertFalse(it.hasNext());
		}
		finally
		{
			tsvReader.close();
		}
	}

	@Test
	public void colNamesIteratorAndIterator() throws IOException
	{
		CsvReader csvReader = new CsvReader(new StringReader("col1,col2\nval1,val2"), ',');
		try
		{
			Iterator<String> colNamesIt = csvReader.colNamesIterator();
			assertTrue(colNamesIt.hasNext());
			assertEquals(colNamesIt.next(), "col1");
			assertTrue(colNamesIt.hasNext());
			assertEquals(colNamesIt.next(), "col2");

			Iterator<Record> it = csvReader.iterator();
			Record t0 = it.next();
			assertEquals(t0.get("col1"), "val1");
			assertEquals(t0.get("col2"), "val2");
			assertFalse(it.hasNext());
		}
		finally
		{
			csvReader.close();
		}
	}

	@Test
	public void close() throws IOException
	{
		Reader reader = mock(Reader.class);
		CsvReader csvReader = new CsvReader(reader);
		csvReader.close();
		verify(reader).close();
	}
}
