package org.molgenis.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.hibernate.QueryException;
import org.molgenis.backend.QueryRule.Operator;

public abstract class QueryImp<E extends IdentifiableRecord> implements Query<E>
{
	protected final Vector<List<QueryRule>> rules = new Vector<List<QueryRule>>();

	final ArrayList<QueryRule> order = new ArrayList<QueryRule>();

	int limit = 0;

	int offset = 0;

	public QueryImp()
	{
		super();
		this.rules.add(new ArrayList<QueryRule>());
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
		if (this.rules.size() > 0)
		{
			List<QueryRule> rules = this.rules.lastElement();

			return rules;
		}
		else return new ArrayList<QueryRule>();
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