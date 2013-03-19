package org.molgenis.data.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.molgenis.data.Backend;
import org.molgenis.data.BackendException;
import org.molgenis.data.IdentifiableRecord;
import org.molgenis.data.Query;
import org.molgenis.data.TypeUtils;
import org.molgenis.io.Record;
import org.molgenis.model.EntityModel;
import org.molgenis.model.FieldModel;
import org.molgenis.types.MrefField;
import org.molgenis.types.XrefField;
import org.springframework.stereotype.Repository;

@Repository("aap")
public class JpaBackend implements Backend
{
	@PersistenceContext(unitName = "molgenis")
	private EntityManager entityManager;

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	@Override
	public <E extends IdentifiableRecord> E getById(Class<E> klass, Object id) throws BackendException
	{
		return this.query(klass).getById(id);
	}

	@Override
	public <E extends IdentifiableRecord> E getByLabel(Class<E> klass, String label) throws BackendException
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

	public JpaBackend()
	{

	}

	@SuppressWarnings("unchecked")
	@Override
	public IdentifiableRecord getById(String collection, Object id) throws BackendException
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

	@Override
	public List<String> getCollections()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query<IdentifiableRecord> query(String collection) throws BackendException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E extends IdentifiableRecord> Query<E> query(Class<E> klass)
	{
		return new JpaQuery<E>(klass, this);
	}

	@Override
	public <E extends IdentifiableRecord> void add(E record) throws BackendException
	{
		EntityManager em = getEntityManager();
		this.loadXrefs(record);
		em.persist(record);
		em.flush();
	}

	private <E extends IdentifiableRecord> void loadXrefs(E record) throws BackendException
	{
		EntityModel model = record.getModel();
		for (FieldModel f : model.getFields())
		{
			if (f.getType() instanceof XrefField)
			{
				record.set(f.getName(), this.load((IdentifiableRecord) record.get(f.getName())));
			}
			if (f.getType() instanceof MrefField)
			{
				List<IdentifiableRecord> loadedMrefs = new ArrayList<IdentifiableRecord>();
				for (IdentifiableRecord r : TypeUtils.toList(IdentifiableRecord.class, record.get(f.getName())))
				{
					loadedMrefs.add(this.load(r));
				}
				record.set(f.getName(), loadedMrefs);
			}
		}
	}

	@Override
	public <E extends IdentifiableRecord> void add(Iterable<E> records)
	{
		EntityManager em = getEntityManager();
		for (E r : records)
			em.persist(r);
		em.flush();
	}

	@Override
	public <E extends IdentifiableRecord> void update(E record)
	{
		EntityManager em = getEntityManager();
		em.merge(record);
		em.flush();
	}

	@Override
	public <E extends IdentifiableRecord> void update(Iterable<E> records)
	{
		EntityManager em = getEntityManager();
		for (E r : records)
			em.merge(r);
		em.flush();

	}

	@Override
	public <E extends IdentifiableRecord> void remove(E record)
	{
		EntityManager em = getEntityManager();
		em.remove(record);
		em.flush();
	}

	@Override
	public <E extends IdentifiableRecord> void remove(Iterable<E> records)
	{
		EntityManager em = getEntityManager();

		for (E r : records)
			em.remove(r);

		em.flush();
	}

	@Override
	public <E extends IdentifiableRecord> void apply(BackendAction action, E record)
	{
		throw new UnsupportedOperationException("not yet implemented");
	}

	@Override
	public <E extends IdentifiableRecord> void apply(BackendAction action, Iterable<E> records)
	{
		throw new UnsupportedOperationException("not yet implemented");
	}

	@Override
	public List<Class<? extends IdentifiableRecord>> getClasses()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * returns true if this entity is contained, based on existence of ID
	 * 
	 * @throws BackendException
	 */
	@Override
	public <E extends IdentifiableRecord> E load(E object) throws BackendException
	{
		EntityManager em = this.getEntityManager();
		if (object == null)
		{
			return null;
		}
		if (em.contains(object))
		{
			return object;
		}
		if (object.getIdValue() != null)
		{
			@SuppressWarnings("unchecked")
			E result = this.getById((Class<E>) object.getClass(), object.getIdValue());
			try
			{
				result.set(object);
			}
			catch (Exception e)
			{
				throw new BackendException(e);
			}
			return result;
		}
		if (object.getLabelValue() != null)
		{
			@SuppressWarnings("unchecked")
			E result = this.getByLabel((Class<E>) object.getClass(), object.getLabelValue());
			try
			{
				result.set(object);
			}
			catch (Exception e)
			{
				throw new BackendException(e);
			}
			return result;
		}
		throw new BackendException(String.format("load(%s) failed: no unique id or label included", object));
	}
}