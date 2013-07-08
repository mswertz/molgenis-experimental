package org.molgenis.data.processor;

import java.util.List;

import org.molgenis.FieldProcessor;

public abstract class AbstractCellProcessor implements FieldProcessor
{
	private static final long serialVersionUID = 1L;

	private final boolean processHeader;
	private final boolean processData;

	public AbstractCellProcessor()
	{
		this(true, true);
	}

	public AbstractCellProcessor(boolean processHeader, boolean processData)
	{
		this.processHeader = processHeader;
		this.processData = processData;
	}

	@Override
	public boolean processHeader()
	{
		return this.processHeader;
	}

	@Override
	public boolean processData()
	{
		return this.processData;
	}

	public static String processCell(String value, boolean isHeader, List<FieldProcessor> cellProcessors)
	{
		if (cellProcessors != null)
		{
			for (FieldProcessor cellProcessor : cellProcessors)
			{
				boolean process = (isHeader && cellProcessor.processHeader())
						|| (!isHeader && cellProcessor.processData());
				if (process) value = cellProcessor.process(value);
			}
		}
		return value;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (processData ? 1231 : 1237);
		result = prime * result + (processHeader ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		AbstractCellProcessor other = (AbstractCellProcessor) obj;
		if (processData != other.processData) return false;
		if (processHeader != other.processHeader) return false;
		return true;
	}
}
