package org.molgenis.backend;

import org.molgenis.model.EntityModel;

public abstract class BackendImpl implements Backend
{

	public BackendImpl()
	{
		super();
	}

	@Override
	public <E extends IdentifiableRecord> E getById(Class<E> klass, Object id)
	{
		return this.query(klass).getById(id);
	}

	@Override
	public <E extends IdentifiableRecord> E getByLabel(Class<E> klass, String label)
	{
		try
		{
			EntityModel m = klass.newInstance().getModel();
			String labelField = m.getXrefLabel();
			Query<E> q = this.query(klass);
			q.eq(labelField, label);
			for (E e : q)
				return e;
		}
		catch (Exception e)
		{
			throw new BackendException(String.format("cannot find klass '%s' by label '%s'", klass, label));
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IdentifiableRecord getById(String collection, Object id)
	{
		Class<? extends IdentifiableRecord> klass;
		try
		{
			klass = (Class<? extends IdentifiableRecord>) Class.forName(collection);
		}
		catch (ClassNotFoundException e)
		{
			throw new BackendException(e);
		}
		return this.getById(klass, id);
	}

}