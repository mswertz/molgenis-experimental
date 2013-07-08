package org.molgenis.data.processor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.molgenis.FieldProcessor;
import org.molgenis.data.processor.AbstractCellProcessor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AbstractFieldProcessorTest
{
	private List<FieldProcessor> processors;

	@BeforeMethod
	public void setUp()
	{
		FieldProcessor headerProcessor = mock(FieldProcessor.class);
		when(headerProcessor.processHeader()).thenReturn(true);
		when(headerProcessor.process("col")).thenReturn("COL");

		FieldProcessor dataProcessor = mock(FieldProcessor.class);
		when(dataProcessor.processData()).thenReturn(true);
		when(dataProcessor.process("val")).thenReturn("VAL");

		this.processors = Arrays.asList(headerProcessor, dataProcessor);
	}

	@Test
	public void processCell_null()
	{
		assertEquals(AbstractCellProcessor.processCell("val", false, null), "val");
	}

	@Test
	public void processCell_header()
	{
		assertEquals(AbstractCellProcessor.processCell("col", true, processors), "COL");
	}

	@Test
	public void processCell_data()
	{
		assertEquals(AbstractCellProcessor.processCell("val", false, processors), "VAL");
	}
}
