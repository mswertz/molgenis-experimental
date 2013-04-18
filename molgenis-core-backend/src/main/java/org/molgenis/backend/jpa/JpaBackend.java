package org.molgenis.backend.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.molgenis.backend.Backend;
import org.molgenis.backend.BackendException;
import org.molgenis.backend.BackendImpl;
import org.molgenis.backend.IdentifiableRecord;
import org.molgenis.backend.Query;
import org.molgenis.backend.TypeUtils;
import org.molgenis.model.EntityModel;
import org.molgenis.model.FieldModel;
import org.molgenis.types.MrefField;
import org.molgenis.types.XrefField;
import org.springframework.stereotype.Repository;

@Repository
public class JpaBackend extends BackendImpl implements Backend
{
	@PersistenceContext(unitName = "molgenis")
	private EntityManager entityManager;

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public JpaBackend()
	{

	}

	@Override
	public List<String> getCollections()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query<IdentifiableRecord> query(String collection)
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
	public <E extends IdentifiableRecord> void add(E record)
	{
		EntityManager em = getEntityManager();
		this.loadXrefs(record);
		em.persist(record);
		em.flush();
	}

	private <E extends IdentifiableRecord> void loadXrefs(E record)
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
	public <E extends IdentifiableRecord> E load(E object)
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
			result.set(object);

			return result;
		}
		if (object.getLabelValue() != null)
		{
			@SuppressWarnings("unchecked")
			E result = this.getByLabel((Class<E>) object.getClass(), object.getLabelValue());

			result.set(object);

			return result;
		}
		throw new BackendException(String.format("load(%s) failed: no unique id or label included", object));
	}
}