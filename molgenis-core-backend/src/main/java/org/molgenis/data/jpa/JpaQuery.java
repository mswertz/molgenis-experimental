package org.molgenis.data.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.QueryException;
import org.molgenis.data.BackendException;
import org.molgenis.data.Query;
import org.molgenis.data.QueryRule;
import org.molgenis.data.QueryRule.Operator;
import org.molgenis.data.IdentifiableRecord;

public class JpaQuery<E extends IdentifiableRecord> implements Query<E>
{
	private Class<E> klass;

	// container of our entity manager etc
	private JpaBackend backend;

	// our query rules, can be nested
	final Vector<List<QueryRule>> rules = new Vector<List<QueryRule>>();

	// our order rules, cannot be nested
	final ArrayList<QueryRule> order = new ArrayList<QueryRule>();

	// limit = 0;
	int limit = 0;

	// offset = 0;
	int offset = 0;

	private EntityManager getEntityManager()
	{
		return backend.getEntityManager();
	}

	public JpaQuery(Class<E> klass, JpaBackend backend)
	{
		this.klass = klass;
		this.backend = backend;
		this.rules.add(new ArrayList<QueryRule>());
	}

	@Override
	public Iterator<E> iterator()
	{
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<E> cq = cb.createQuery(klass);
		Root<E> from = cq.from(klass);
		cq.select(from);

		// add filters
		this.createWhere(from, cq, cb);

		return em.createQuery(cq).getResultList().iterator();
	}

	@Override
	public E getById(Object id) throws BackendException
	{
		// todo
		return getEntityManager().find(klass, id);
	}

	@Override
	public long count() throws BackendException
	{
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// gonna produce a number
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<E> from = cq.from(klass);
		cq.select(cb.count(from));

		// add filters
		this.createWhere(from, cq, cb);

		// execute the query
		return em.createQuery(cq).getSingleResult();
	}

	private void createWhere(Root<E> from, CriteriaQuery<?> cq, CriteriaBuilder cb)
	{
		List<Predicate> where = this.createPredicates(from, cb, this.getRules());
		if (where != null) cq.where(cb.and(where.toArray(new Predicate[where.size()])));
		List<Order> orders = this.createOrder(from, cb, this.getRules());
		if (orders != null && orders.size() > 0) cq.orderBy(orders);
	}

	private List<Order> createOrder(Root<E> from, CriteriaBuilder cb, List<QueryRule> rules)
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
	private List<Predicate> createPredicates(Root<E> from, CriteriaBuilder cb, List<QueryRule> rules)
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
					andPredicates.add(cb.equal(from.get(r.getField()), r.getValue()));
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
	public void addRule(QueryRule addRules)
	{
		this.rules.lastElement().add(addRules);
	}

	@Override
	public List<QueryRule> getRules()
	{
		if (this.rules.size() > 1) throw new QueryException("Nested query not closed, use unnest() or unnestAll()");
		List<QueryRule> rules = this.rules.lastElement();
		return rules;
	}

	@Override
	public Query<E> search(String searchTerms) throws QueryException
	{
		rules.lastElement().add(new QueryRule(Operator.SEARCH, searchTerms));
		return this;
	}

	@Override
	public Query<E> or()
	{
		rules.lastElement().add(new QueryRule(Operator.OR));
		return this;
	}

	@Override
	public Query<E> like(String field, Object value)
	{
		rules.lastElement().add(new QueryRule(field, Operator.LIKE, value));
		return this;
	}

	@Override
	public Query<E> eq(String field, Object value)
	{
		rules.lastElement().add(new QueryRule(field, Operator.EQUALS, value));
		return this;
	}

	@Override
	public Query<E> in(String field, List<?> objectList)
	{
		rules.lastElement().add(new QueryRule(field, Operator.IN, objectList));
		return this;
	}

	@Override
	public Query<E> gt(String field, Object value)
	{
		rules.lastElement().add(new QueryRule(field, Operator.GREATER, value));
		return this;
	}

	@Override
	public Query<E> ge(String field, Object value)
	{
		rules.lastElement().add(new QueryRule(field, Operator.GREATER_EQUAL, value));
		return this;
	}
	
	@Override
	public Query<E> le(String field, Object value)
	{
		rules.lastElement().add(new QueryRule(field, Operator.LESS_EQUAL, value));
		return this;
	}
	
	
	@Override
	public Query<E> lt(String field, Object value)
	{
		rules.lastElement().add(new QueryRule(field, Operator.LESS, value));
		return this;
	}

	@Override
	public Query<E> limit(int limit)
	{
		this.limit = limit;
		return this;
	}

	@Override
	public Query<E> offset(int offset)
	{
		this.offset = offset;
		return this;
	}

	@Override
	public Query<E> asc(String orderByField)
	{
		rules.lastElement().add(new QueryRule(Operator.SORTASC, orderByField));
		return this;
	}

	@Override
	public Query<E> sortDESC(String orderByField)
	{
		rules.lastElement().add(new QueryRule(Operator.SORTDESC, orderByField));
		return this;
	}

	@Override
	public Query<E> nest()
	{
		// add element to our nesting list...
		this.rules.add(new ArrayList<QueryRule>());
		return this;
	}

	@Override
	public Query<E> unnest()
	{
		if (this.rules.size() == 1) throw new QueryException("Cannot unnest root element of query");

		// remove last element and add to parent as nested rule
		QueryRule nested = new QueryRule(Operator.NESTED, this.rules.lastElement());
		this.rules.remove(this.rules.lastElement());
		this.rules.lastElement().add(nested);
		return this;
	}

	@Override
	public Query<E> unnestAll()
	{
		while (this.rules.size() > 1)
		{
			unnest();
		}
		return this;
	}

	@Override
	public Query<E> rng(String field, Object smaller, Object bigger)
	{
		this.gt(field, smaller);
		this.lt(field, bigger);
		return this;
	}
}
