package org.molgenis;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.molgenis.meta.EntityMetaData;
import org.molgenis.meta.FieldMetaData;

/**
 * Tuple backed by a {@link java.util.Map}
 */
public class EntityImp implements Entity
{
	private static final long serialVersionUID = 1L;

	private final Map<String, Object> valueMap = new LinkedHashMap<String, Object>();

	private EntityMetaData m = new EntityMetaData();

	private String idField = null;

	private String labelField = null;

	public EntityImp()
	{
	}

	/**
	 * Copy constructor
	 * 
	 * @param t
	 */
	public EntityImp(Entity t)
	{
		this();
		for (FieldMetaData f : t.getMetaData().getFields())
			m.addField(new FieldMetaData(f));
		this.set(t);
	}

	public EntityImp(Map<String, Integer> colNamesMap, List<String> asList)
	{
		for (String name : colNamesMap.keySet())
		{
			this.set(name, asList.get(colNamesMap.get(name)));
		}
	}

	public Object get(String colName)
	{
		return valueMap.get(colName);
	}

	public void set(String colName, Object val)
	{
		valueMap.put(colName, val);

		if (m.getField(colName) == null)
		{
			FieldMetaData f = new FieldMetaData();
			f.setName(colName);
			m.addField(f);
		}
	}

	public void set(Entity t)
	{
		for (String col : t.getMetaData().getFieldNames())
		{
			this.set(col, t.get(col));
		}
	}

	public EntityMetaData getMetaData()
	{
		return this.m;
	}

	public void set(Entity record, boolean strict)
	{
		for (FieldMetaData col : record.getMetaData().getFields())
		{
			if (record.get(col.getName()) != null) this.set(col.getName(), record.get(col.getName()));
		}

	}

	public int size()
	{
		return this.valueMap.size();
	}

	public List<FieldMetaData> getFields()
	{
		return getMetaData().getFields();
	}

	public Map<String, Object> getMap()
	{
		return this.valueMap;
	}

	@Override
	public String getIdField()
	{
		return this.idField;
	}

	@Override
	public String getLabelField()
	{
		return this.labelField;
	}

	@Override
	public Integer getIdValue()
	{
		Object o = this.get(this.getIdField());
		if (o != null) return (Integer) o;
		return null;
	}

	@Override
	public String getLabelValue()
	{
		Object o = this.get(this.getLabelField());
		if (o != null) return o.toString();
		return null;
	}

	@Override
	public Object get(FieldMetaData field)
	{
		if (field != null) return this.get(field.getName());
		return null;
	}
}
