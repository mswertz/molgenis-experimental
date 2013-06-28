package org.molgenis;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.molgenis.model.EntityModel;
import org.molgenis.model.FieldModel;

/**
 * Tuple backed by a {@link java.util.Map}
 */
public class MapEntity implements Entity
{
	private static final long serialVersionUID = 1L;

	private final Map<String, Object> valueMap = new LinkedHashMap<String, Object>();

	private EntityModel m = new EntityModel();

	public MapEntity()
	{
	}

	/**
	 * Copy constructor
	 * 
	 * @param t
	 */
	public MapEntity(Entity t)
	{
		this();
		for (FieldModel f : t.getFields())
			m.addField(new FieldModel(f));
		this.set(t);
	}

	public MapEntity(Map<String, Integer> colNamesMap, List<String> asList)
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
	public void set(Entity t)
	{
		for (String col : t.getModel().getFieldNames())
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
	public void set(Entity record, boolean strict)
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

	@Override
	public List<FieldModel> getFields()
	{
		return getModel().getFields();
	}

	public Map<String, Object> getMap()
	{
		return this.valueMap;
	}
}
