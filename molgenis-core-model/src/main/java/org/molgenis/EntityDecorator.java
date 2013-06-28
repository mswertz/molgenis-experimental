package org.molgenis;

import java.util.List;

import org.molgenis.model.EntityModel;
import org.molgenis.model.FieldModel;

public abstract class EntityDecorator implements Entity
{
	private static final long serialVersionUID = 1L;
	Entity entity;
	
	public EntityDecorator(Entity entity)
	{
		this.entity = entity;
	}
	
	@Override
	public EntityModel getModel()
	{
		return entity.getModel();
	}

	@Override
	public abstract Object get(String colName);

	@Override
	public void set(String field, Object value)
	{
		entity.set(field, value);
	}

	@Override
	public void set(Entity values) throws EntityException
	{
		entity.set(values);
	}

	@Override
	public void set(Entity values, boolean strict)
	{
		entity.set(values, strict);
	}

	@Override
	public int size()
	{
		return entity.size();
	}

	@Override
	public List<FieldModel> getFields()
	{
		return entity.getFields();
	}
}
