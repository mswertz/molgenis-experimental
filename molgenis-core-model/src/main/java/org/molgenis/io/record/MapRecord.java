package org.molgenis.io.record;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.molgenis.Record;
import org.molgenis.model.EntityModel;
import org.molgenis.model.FieldModel;

/**
 * Tuple backed by a {@link java.util.Map}
 */
public class MapRecord extends AbstractRecord implements Record
{
	private static final long serialVersionUID = 1L;

	private final Map<String, Object> valueMap = new LinkedHashMap<String, Object>();

	private EntityModel m = new EntityModel();

	public MapRecord()
	{
	}

	/**
	 * Copy constructor
	 * 
	 * @param t
	 */
	public MapRecord(Record t)
	{
		this();
		this.set(t);
	}

	public MapRecord(Map<String, Integer> colNamesMap, List<String> asList)
	{
		for (String name : colNamesMap.keySet())
		{
			this.set(name, asList.get(colNamesMap.get(name)));
		}
	}

	@Override
	public Object get(String colName)
	{
		return valueMap.get(colName);
	}

	@Override
	public void set(String colName, Object val)
	{
		valueMap.put(colName, val);

		if (m.getField(colName) == null)
		{
			FieldModel f = new FieldModel();
			f.setName(colName);
			m.addField(f);
		}
	}

	@Override
	public void set(Record t)
	{
		for (String col : t.getFieldNames())
		{
			this.set(col, t.get(col));
		}
	}

	@Override
	public EntityModel getModel()
	{
		return this.m;
	}

	@Override
	public void set(Record record, boolean strict)
	{
		for (FieldModel col : record.getModel().getFields())
		{
			if (record.get(col.getName()) != null) this.set(col.getName(), record.get(col.getName()));
		}

	}

	@Override
	public int size()
	{
		return this.valueMap.size();
	}
}
