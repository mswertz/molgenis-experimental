package org.molgenis.data.excel;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.molgenis.Entity;
import org.molgenis.FieldProcessor;
import org.molgenis.EntityImp;
import org.molgenis.data.ReadonlyRepository;
import org.molgenis.data.processor.AbstractCellProcessor;
import org.molgenis.meta.EntityMetaData;
import org.molgenis.meta.FieldMetaData;
import org.molgenis.meta.types.StringField;

public class ExcelSheetReader implements ReadonlyRepository<Entity>
{
	private final org.apache.poi.ss.usermodel.Sheet sheet;

	private final boolean hasHeader;

	/** process cells after reading */
	private List<FieldProcessor> cellProcessors;

	/** column names index */
	private Map<String, Integer> colNamesMap;

	public ExcelSheetReader(org.apache.poi.ss.usermodel.Sheet sheet, boolean hasHeader, List<FieldProcessor> cellProcessors)
	{
		if (sheet == null) throw new IllegalArgumentException("sheet is null");
		this.sheet = sheet;
		this.hasHeader = hasHeader;
		this.cellProcessors = cellProcessors;
	}

	public String getName()
	{
		return sheet.getSheetName();
	}

	public long count()
	{
		return sheet.getLastRowNum() + 1; // getLastRowNum is 0-based
	}

	public EntityMetaData getMetaData()
	{
		if (!hasHeader) return null;

		Iterator<Row> it = sheet.iterator();
		if (!it.hasNext()) return null;

		if (colNamesMap == null) colNamesMap = toColNamesMap(it.next());

		EntityMetaData emd = new EntityMetaData();
		for (String s : colNamesMap.keySet())
		{
			FieldMetaData fmd = new FieldMetaData();
			fmd.setName(s);
			fmd.setType(new StringField());
			emd.addField(fmd);
		}
		return emd;
	}

	@Override
	public Iterable<Entity> findAll()
	{
		final Iterator<Row> it = sheet.iterator();
		if (!it.hasNext()) return Collections.<Entity> emptyList();

		// create column header index once and reuse
		final Map<String, Integer> colNamesMap;
		if (hasHeader)
		{
			Row headerRow = it.next();
			colNamesMap = this.colNamesMap == null ? toColNamesMap(headerRow) : this.colNamesMap;
		}
		else colNamesMap = null;

		return new Iterable<Entity>()
		{
			public Iterator<Entity> iterator()
			{
				return new Iterator<Entity>()
				{
					@Override
					public boolean hasNext()
					{
						return it.hasNext();
					}

					@Override
					public Entity next()
					{
						return new RowIndexEntity(it.next(), colNamesMap, cellProcessors);
					}

					@Override
					public void remove()
					{
						throw new UnsupportedOperationException();
					}
				};
			}
		};
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

	private Map<String, Integer> toColNamesMap(Row headerRow)
	{
		if (headerRow == null) return null;

		Map<String, Integer> columnIdx = new LinkedHashMap<String, Integer>();
		int i = 0;
		for (Iterator<Cell> it = headerRow.cellIterator(); it.hasNext();)
		{
			String header = AbstractCellProcessor.processCell(it.next().getStringCellValue(), true, cellProcessors);
			columnIdx.put(header, i++);
		}
		return columnIdx;
	}

	private static String toValue(Cell cell, List<FieldProcessor> cellProcessors)
	{
		String value;
		switch (cell.getCellType())
		{
			case Cell.CELL_TYPE_BLANK:
				value = null;
				break;
			case Cell.CELL_TYPE_STRING:
				value = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) value = cell.getDateCellValue().toString();
				else
				{
					// excel stores integer values as double values
					// read an integer if the double value equals the
					// integer value
					double x = cell.getNumericCellValue();
					if (x == Math.rint(x) && !Double.isNaN(x) && !Double.isInfinite(x)) value = String.valueOf((int) x);
					else value = String.valueOf(x);
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				value = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA:
				// evaluate formula
				FormulaEvaluator evaluator = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
				CellValue cellValue = evaluator.evaluate(cell);
				switch (cellValue.getCellType())
				{
					case Cell.CELL_TYPE_BOOLEAN:
						value = String.valueOf(cellValue.getBooleanValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						// excel stores integer values as double values
						// read an integer if the double value equals the
						// integer value
						double x = cellValue.getNumberValue();
						if (x == Math.rint(x) && !Double.isNaN(x) && !Double.isInfinite(x)) value = String
								.valueOf((int) x);
						else value = String.valueOf(x);
						break;
					case Cell.CELL_TYPE_STRING:
						value = cellValue.getStringValue();
						break;
					case Cell.CELL_TYPE_BLANK:
						value = null;
						break;
					default:
						throw new RuntimeException("unsupported cell type: " + cellValue.getCellType());
				}
				break;
			default:
				throw new RuntimeException("unsupported cell type: " + cell.getCellType());
		}
		return AbstractCellProcessor.processCell(value, false, cellProcessors);
	}

	private static class RowIndexEntity extends EntityImp
	{
		private static final long serialVersionUID = 1L;

		private final transient Row row;
		private final Map<String, Integer> colNamesMap;
		private final List<FieldProcessor> cellProcessors;

		public RowIndexEntity(Row row, Map<String, Integer> colNamesMap, List<FieldProcessor> cellProcessors)
		{
			if (row == null) throw new IllegalArgumentException("row is null");
			if (colNamesMap == null) throw new IllegalArgumentException("column names map is null");
			this.row = row;
			this.colNamesMap = colNamesMap;
			this.cellProcessors = cellProcessors;
		}

		@Override
		public int size()
		{
			return colNamesMap.size();
		}

		@Override
		public Object get(String colName)
		{
			Integer col = colNamesMap.get(colName);
			return col != null ? get(col) : null;
		}

		public Object get(int col)
		{
			Cell cell = row.getCell(col);
			return cell != null ? toValue(cell, cellProcessors) : null;
		}
	}
}
