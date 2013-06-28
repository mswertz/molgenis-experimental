package org.molgenis.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.molgenis.Database;
import org.molgenis.DatabaseException;
import org.molgenis.Entity;
import org.molgenis.IdentifiableEntity;
import org.molgenis.Query;
import org.molgenis.QueryRule;
import org.molgenis.io.TypeUtils;
import org.molgenis.model.EntityModel;
import org.molgenis.model.FieldModel;
import org.molgenis.model.types.MrefField;
import org.molgenis.model.types.XrefField;
import org.springframework.stereotype.Repository;

@Repository
public class JpaDatabase implements Database
{
	@PersistenceContext(unitName = "molgenis")
	private EntityManager entityManager;

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public JpaDatabase()
	{

	}
	
	@Override
	public <E extends IdentifiableEntity> Iterable<E> find(Class<E> klass)
	{
		return this.find(klass, new Query());
	}

	@Override
	public <E extends IdentifiableEntity> long count(Class<E> klass)
	{
		return this.count(klass, new Query());
	}

	@Override
	public <E extends IdentifiableEntity> E getByLabel(Class<E> klass, String label)
	{
		try
		{
			EntityModel m = klass.newInstance().getModel();
			String labelField = m.getXrefLabel();
			Query q = new Query();
			q.eq(labelField, label);
			for (E e : this.find(klass, q))
				return e;
		}
		catch (Exception e)
		{
			throw new DatabaseException(String.format("cannot find klass '%s' by label '%s'", klass, label));
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IdentifiableEntity getById(String collection, Object id)
	{
		Class<? extends IdentifiableEntity> klass;
		try
		{
			klass = (Class<? extends IdentifiableEntity>) Class.forName(collection);
		}
		catch (ClassNotFoundException e)
		{
			throw new DatabaseException(e);
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
	public <E extends IdentifiableEntity> void add(E record)
	{
		EntityManager em = getEntityManager();
		this.loadXrefs(record);
		em.persist(record);
		em.flush();
	}

	private <E extends IdentifiableEntity> void loadXrefs(E record)
	{
		EntityModel model = record.getModel();
		for (FieldModel f : model.getFields())
		{
			if (f.getType() instanceof XrefField)
			{
				record.set(f.getName(), this.load((IdentifiableEntity) record.get(f.getName())));
			}
			if (f.getType() instanceof MrefField)
			{
				List<IdentifiableEntity> loadedMrefs = new ArrayList<IdentifiableEntity>();
				for (IdentifiableEntity r : TypeUtils.toList(IdentifiableEntity.class, record.get(f.getName())))
				{
					loadedMrefs.add(this.load(r));
				}
				record.set(f.getName(), loadedMrefs);
			}
		}
	}

	@Override
	public <E extends IdentifiableEntity> void add(Iterable<E> records)
	{
		EntityManager em = getEntityManager();
		int batchSize = 50;
		int batchCount = 0;
		for (E r : records)
		{
			em.persist(r);
			batchCount++;
			if (batchCount == batchSize)
			{
				em.flush();
				em.clear();
				batchCount = 0;
			}
		}
		em.flush();
	}

	@Override
	public <E extends IdentifiableEntity> void update(E record)
	{
		EntityManager em = getEntityManager();
		em.merge(record);
		em.flush();
	}

	@Override
	public <E extends IdentifiableEntity> void update(Iterable<E> records)
	{
		EntityManager em = getEntityManager();
		int batchSize = 500;
		int batchCount = 0;
		for (E r : records)
		{
			em.merge(r);
			batchCount++;
			if (batchCount == batchSize)
			{
				em.flush();
				em.clear();
				batchCount = 0;
			}
		}
		em.flush();

	}

	@Override
	public <E extends IdentifiableEntity> void remove(E record)
	{
		EntityManager em = getEntityManager();
		em.remove(record);
		em.flush();
	}

	@Override
	public <E extends IdentifiableEntity> void remove(Iterable<E> records)
	{
		EntityManager em = getEntityManager();

		for (E r : records)
			em.remove(r);

		em.flush();
	}

	@Override
	public <E extends IdentifiableEntity> void apply(BackendAction action, E record)
	{
		throw new UnsupportedOperationException("not yet implemented");
	}

	@Override
	public <E extends IdentifiableEntity> void apply(BackendAction action, Iterable<E> records)
	{
		throw new UnsupportedOperationException("not yet implemented");
	}

	@Override
	public List<Class<? extends IdentifiableEntity>> getClasses()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * returns true if this entity is contained, based on existence of ID
	 * 
	 * @throws DatabaseException
	 */
	@Override
	public <E extends IdentifiableEntity> E load(E object)
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
		throw new DatabaseException(String.format("load(%s) failed: no unique id or label included", object));
	}

	@Override
	public <E extends IdentifiableEntity> Iterable<E> find(Class<E> klass, Query q)
	{
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<E> cq = cb.createQuery(klass);
		Root<E> from = cq.from(klass);
		cq.select(from);

		// add filters
		this.createWhere(q, from, cq, cb);

		TypedQuery<E> tq = em.createQuery(cq);
		if (q.getLimit() > 0) tq.setMaxResults(q.getLimit());
		if (q.getPage() > 1) tq.setFirstResult( (q.getPage() - 1)* q.getLimit());
		return tq.getResultList();
	}

	public <E extends IdentifiableEntity> E getById(Class<E> klass, Object id) throws DatabaseException
	{
		return getEntityManager().find(klass, id);
	}

	@Override
	public <E extends IdentifiableEntity> long count(Class<E> klass, Query q) throws DatabaseException
	{
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// gonna produce a number
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<E> from = cq.from(klass);
		cq.select(cb.count(from));

		// add filters
		this.createWhere(q, from, cq, cb);

		// execute the query
		return em.createQuery(cq).getSingleResult();
	}

	private void createWhere(Query q, Root<?> from, CriteriaQuery<?> cq, CriteriaBuilder cb)
	{
		List<Predicate> where = this.createPredicates(from, cb, q.getRules());
		if (where != null) cq.where(cb.and(where.toArray(new Predicate[where.size()])));
		List<Order> orders = this.createOrder(from, cb, q.getRules());
		if (orders != null && orders.size() > 0) cq.orderBy(orders);
	}

	private List<Order> createOrder(Root<?> from, CriteriaBuilder cb, List<QueryRule> rules)
	{
		List<Order> orders = new ArrayList<Order>();

		for (QueryRule r : rules)
		{
			switch (r.getOperator())
			{
				case NESTED:
					orders.addAll(this.createOrder(from, cb, r.getNestedRules()));
					break;
				case SORTDESC:
					orders.add(cb.desc(from.get(r.getField())));
					break;
				case SORTASC:
					orders.add(cb.asc(from.get(r.getField())));
					break;
				default:
					break;
			}
		}

		return orders;
	}

	/** Converts MOLGENIS query rules into JPA predicates */
	@SuppressWarnings(
	{ "rawtypes", "unchecked" })
	private List<Predicate> createPredicates(Root<?> from, CriteriaBuilder cb, List<QueryRule> rules)
	{
		// default Query links criteria based on 'and'
		List<Predicate> andPredicates = new ArrayList<Predicate>();
		// optionally, subqueries can be formulated seperated by 'or'
		List<Predicate> orPredicates = new ArrayList<Predicate>();

		for (QueryRule r : rules)
		{
			switch (r.getOperator())
			{
				case NESTED:
					Predicate nested = cb.conjunction();
					for (Predicate p : createPredicates(from, cb, r.getNestedRules()))
					{
						nested.getExpressions().add(p);
					}
					andPredicates.add(nested);
					break;
				case OR:
					orPredicates.add(cb.and(andPredicates.toArray(new Predicate[andPredicates.size()])));
					andPredicates.clear();
					break;
				case EQUALS:
					andPredicates.add(cb.equal(from.get(r.getField()), r.getValue()));
					break;
				case LIKE:
					String like = "%" + r.getValue() + "%";
					String f = r.getField();
					andPredicates.add(cb.like(from.<String> get(f), like));
					break;
				default:
					// go into comparator based criteria, that need
					// conversion...
					Path<Comparable> field = from.get(r.getField());
					Object value = r.getValue();
					Comparable cValue = null;

					// convert to type
					if (field.getJavaType() == Integer.class)
					{
						if (value instanceof Integer) cValue = (Integer) value;
						else cValue = Integer.parseInt(value.toString());
					}
					else if (field.getJavaType() == Long.class)
					{
						if (value instanceof Long) cValue = (Long) value;
						else cValue = Long.parseLong(value.toString());
					}
					else if (field.getJavaType() == Date.class)
					{
						if (value instanceof Date) cValue = (Date) value;
						else cValue = Date.parse(value.toString());
					}
					else throw new RuntimeException("canno solve query rule:  " + r);

					// comparable values...
					switch (r.getOperator())
					{
						case GREATER:
							andPredicates.add(cb.greaterThan(field, cValue));
							break;
						case LESS:
							andPredicates.add(cb.lessThan(field, cValue));
							break;
						default:
							throw new RuntimeException("canno solve query rule:  " + r);
					}
			}
		}
		if (orPredicates.size() > 0)
		{
			if (andPredicates.size() > 0)
			{
				orPredicates.add(cb.and(andPredicates.toArray(new Predicate[andPredicates.size()])));
			}
			List<Predicate> result = new ArrayList<Predicate>();
			result.add(cb.or(orPredicates.toArray(new Predicate[andPredicates.size()])));
			return result;
		}
		else
		{
			if (andPredicates.size() > 0)
			{
				return andPredicates;
			}
			return new ArrayList<Predicate>();
		}
	}

	@Override
	public <E extends IdentifiableEntity> List<E> list(Class<E> klass, Query q)
	{
		List<E> list = new ArrayList<E>();
		for(E e: find(klass,q))
		{
			list.add(e);
		}
		return list;
	}
}