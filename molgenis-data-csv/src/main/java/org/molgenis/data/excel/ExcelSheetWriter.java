package org.molgenis.data.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.molgenis.Entity;
import org.molgenis.FieldProcessor;
import org.molgenis.data.ListEscapeUtils;
import org.molgenis.data.RepositoryException;
import org.molgenis.data.WriteonlyRepository;
import org.molgenis.data.processor.AbstractCellProcessor;
import org.molgenis.meta.EntityMetaData;

public class ExcelSheetWriter implements WriteonlyRepository<Entity>
{
	private final org.apache.poi.ss.usermodel.Sheet sheet;
	private int row;

	/** process cells after reading */
	private List<FieldProcessor> cellProcessors;

	private List<String> cachedColNames;

	ExcelSheetWriter(org.apache.poi.ss.usermodel.Sheet sheet, List<FieldProcessor> cellProcessors)
	{
		if (sheet == null) throw new IllegalArgumentException("sheet is null");
		this.sheet = sheet;
		this.cellProcessors = cellProcessors;
		this.row = 0;
	}

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
	public void save(Entity entity)
	{
		org.apache.poi.ss.usermodel.Row poiRow = sheet.createRow(row++);

		if (cachedColNames == null) throw new RepositoryException("colnames are not cached");

		int i = 0;
		for (String colName : cachedColNames)
		{
			Cell cell = poiRow.createCell(i++, Cell.CELL_TYPE_STRING);
			cell.setCellValue(toValue(entity.get(colName)));
		}
	}

	public void addCellProcessor(FieldProcessor cellProcessor)
	{
		if (cellProcessors == null) cellProcessors = new ArrayList<FieldProcessor>();
		cellProcessors.add(cellProcessor);
	}

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

	@Override
	public void save(Iterable<Entity> entities)
	{
		for(Entity e: entities) save(e);
	}

	@Override
	public EntityMetaData getMetaData()
	{
		throw new RepositoryException("ExcelSheetWriter.getMetaData() not yet implemented");
	}
}