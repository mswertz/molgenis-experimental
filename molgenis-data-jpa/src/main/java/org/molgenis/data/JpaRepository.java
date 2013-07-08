package org.molgenis.data;

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

import org.molgenis.Entity;
import org.molgenis.meta.EntityMetaData;

public abstract class JpaRepository<E extends Entity> implements CrudRepository<E>
{
	@PersistenceContext(unitName = "molgenis")
	private EntityManager entityManager;

	private EntityManager getEntityManager()
	{
		return entityManager;
	}

	public JpaRepository()
	{

	}

	public abstract Class<E> getEntityClass();

	@Override
	public Iterable<E> findAll()
	{
		return this.findAll(new Query());
	}
	
	@Override
	public List<E> listAll(Query q)
	{
		List<E> list = new ArrayList<E>();
		for (E e : findAll(q))
		{
			list.add(e);
		}
		return list;
	}

	@Override
	public long count()
	{
		return this.count(new Query());
	}

	// @Override
	// public <E extends Entity> E getByLabel(Class<E> klass, String label)
	// {
	// try
	// {
	// MEntity m = klass.newInstance().getModel();
	// String labelField = m.getXrefLabel();
	// Query q = new Query();
	// q.eq(labelField, label);
	// for (E e : this.find(klass, q))
	// return e;
	// }
	// catch (Exception e)
	// {
	// throw new
	// DatabaseException(String.format("cannot find klass '%s' by label '%s'",
	// klass, label));
	// }
	// return null;
	// }

	@Override
	public E findOne(Integer id)
	{
		return getEntityManager().find(getEntityClass(), id);
	}

	//huh?
	private void loadXrefs(E record)
	{
		EntityMetaData model = record.getMetaData();
//		for (MField f : model.getFields())
//		{
//			if (f.getType() instanceof XrefField)
//			{
//				Entity xrefEntity = (Entity) record.get(f.getName());
//				if(xrefEntity != null) record.set(f.getName(), getEntityManager().find(arg0, arg1)(xrefEntity.getIdValue()));
//			}
//			if (f.getType() instanceof MrefField)
//			{
//				List<Entity> loadedMrefs = new ArrayList<Entity>();
//				for (Entity r : TypeUtils.toList(Entity.class, record.get(f.getName())))
//				{
//					loadedMrefs.add(this.load(r));
//				}
//				record.set(f.getName(), loadedMrefs);
//			}
//		}
	}

	@Override
	public void update(E record)
	{
		EntityManager em = getEntityManager();
		em.merge(record);
		em.flush();
	}

	@Override
	public void update(Iterable<E> records)
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
	public void delete(E record)
	{
		EntityManager em = getEntityManager();
		em.remove(record);
		em.flush();
	}

	@Override
	public void delete(Iterable<E> records)
	{
		EntityManager em = getEntityManager();

		for (E r : records)
			em.remove(r);

		em.flush();
	}

//	@Override
//	public void apply(BackendAction action, E record)
//	{
//		throw new UnsupportedOperationException("not yet implemented");
//	}
//
//	@Override
//	public apply(BackendAction action, Iterable<E> records)
//	{
//		throw new UnsupportedOperationException("not yet implemented");
//	}

	/**
	 * returns true if this entity is contained, based on existence of ID
	 * 
	 * @throws DatabaseException
	 */
	@Override
	public boolean exists(Integer id)
	{
		return findOne(id) != null;
	}

	@Override
	public Iterable<E> findAll(Query q)
	{
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<E> cq = cb.createQuery(getEntityClass());
		Root<E> from = cq.from(getEntityClass());
		cq.select(from);

		// add filters
		this.createWhere(q, from, cq, cb);

		TypedQuery<E> tq = em.createQuery(cq);
		if (q.getLimit() > 0) tq.setMaxResults(q.getLimit());
		if (q.getPage() > 1) tq.setFirstResult((q.getPage() - 1) * q.getLimit());
		return tq.getResultList();
	}

	@Override
	public long count(Query q)
	{
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// gonna produce a number
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<E> from = cq.from(getEntityClass());
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
	public void save(E entity)
	{
		if(entity.getIdValue() == null)
		{
			getEntityManager().persist(entity);
		}
		else
		{
			getEntityManager().merge(entity);
		}
	}

	@Override
	public void save(Iterable<E> entities)
	{
		for(E e: entities) this.save(e);
	}

	@Override
	public void deleteAll()
	{
		delete(findAll());
	}

	@Override
	public void delete(Integer id)
	{
		delete(findOne(id));
	}
}