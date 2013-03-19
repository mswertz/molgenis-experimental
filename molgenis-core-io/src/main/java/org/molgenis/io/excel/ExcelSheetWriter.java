package org.molgenis.io.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.molgenis.io.ListEscapeUtils;
import org.molgenis.io.Record;
import org.molgenis.io.RecordWriter;
import org.molgenis.io.processor.AbstractCellProcessor;
import org.molgenis.io.processor.CellProcessor;

public class ExcelSheetWriter implements RecordWriter
{
	private final org.apache.poi.ss.usermodel.Sheet sheet;
	private int row;

	/** process cells after reading */
	private List<CellProcessor> cellProcessors;

	private List<String> cachedColNames;

	ExcelSheetWriter(org.apache.poi.ss.usermodel.Sheet sheet, List<CellProcessor> cellProcessors)
	{
		if (sheet == null) throw new IllegalArgumentException("sheet is null");
		this.sheet = sheet;
		this.cellProcessors = cellProcessors;
		this.row = 0;
	}

	@Override
	public void writeColNames(Iterable<String> colNames) throws IOException
	{
		if (cachedColNames == null)
		{
			org.apache.poi.ss.usermodel.Row poiRow = sheet.createRow(row++);

			// write header
			int i = 0;
			List<String> processedColNames = new ArrayList<String>();
			for (String colName : colNames)
			{
				// process column name
				Cell cell = poiRow.createCell(i++, Cell.CELL_TYPE_STRING);
				cell.setCellValue(AbstractCellProcessor.processCell(colName, true, this.cellProcessors));
				processedColNames.add(colName);
			}

			// store header
			this.cachedColNames = processedColNames;
		}
	}

	@Override
	public void write(Record tuple) throws IOException
	{
		org.apache.poi.ss.usermodel.Row poiRow = sheet.createRow(row++);

		if (cachedColNames == null) throw new IOException("colnames are not cached");

		int i = 0;
		for (String colName : cachedColNames)
		{
			Cell cell = poiRow.createCell(i++, Cell.CELL_TYPE_STRING);
			cell.setCellValue(toValue(tuple.get(colName)));
		}

	}

	@Override
	public void addCellProcessor(CellProcessor cellProcessor)
	{
		if (cellProcessors == null) cellProcessors = new ArrayList<CellProcessor>();
		cellProcessors.add(cellProcessor);
	}

	@Override
	public void close() throws IOException
	{
		// noop
	}

	private String toValue(Object obj)
	{
		String value;
		if (obj == null)
		{
			value = null;
		}
		else if (obj instanceof List<?>)
		{
			value = ListEscapeUtils.toString((List<?>) obj);
		}
		else
		{
			value = obj.toString();
		}
		return AbstractCellProcessor.processCell(value, false, this.cellProcessors);
	}
}