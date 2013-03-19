//package org.molgenis.query;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.molgenis.framework.db.QueryRule;
//import org.molgenis.framework.db.QueryRule.Operator;
//import org.molgenis.framework.tupletable.FilterableTupleTable;
//import org.molgenis.framework.tupletable.TableException;
//import org.molgenis.util.tuple.Tuple;
//
///** Query that encapsulates a FilterableTupleTable */
//public class TupleTableQuery implements Query<Tuple>
//{
//	FilterableTupleTable t;
//	List<QueryRule> rules = new ArrayList<QueryRule>();
//
//	public TupleTableQuery(FilterableTupleTable t)
//	{
//		this.t = t;
//	}
//
//	@Override
//	public Iterator<Tuple> iterator()
//	{
//		try
//		{
//			t.setFilters(rules);
//		}
//		catch (TableException e)
//		{
//			throw new RuntimeException(e);
//		}
//		return t.iterator();
//	}
//
//	@Override
//	public int count() throws QueryException
//	{
//		try
//		{
//			t.setFilters(rules);
//			return t.getCount();
//		}
//		catch (TableException e)
//		{
//			throw new QueryException(e);
//		}
//	}
//
//	@Override
//	public void addRule(QueryRule rule)
//	{
//		rules.add(rule);
//	}
//
//	@Override
//	public List<QueryRule> getRules()
//	{
//		return rules;
//	}
//
//	@Override
//	public Query<Tuple> search(String searchTerms) throws QueryException
//	{
//		rules.add(new QueryRule(Operator.SEARCH, searchTerms));
//		return this;
//	}
//
//	@Override
//	public Query<Tuple> like(String field, Object value)
//	{
//		rules.add(new QueryRule(field, Operator.LIKE, value));
//		return this;
//	}
//
//	@Override
//	public Query<Tuple> eq(String field, Object value)
//	{
//		rules.add(new QueryRule(field, Operator.EQUALS, value));
//		return this;
//	}
//
//	@Override
//	public Query<Tuple> in(String field, List<?> objectList)
//	{
//		rules.add(new QueryRule(field, Operator.IN, objectList));
//		return this;
//	}
//
//	@Override
//	public Query<Tuple> gt(String field, Object value)
//	{
//		rules.add(new QueryRule(field, Operator.GREATER, value));
//		return this;
//	}
//
//	@Override
//	public Query<Tuple> lt(String field, Object value)
//	{
//		rules.add(new QueryRule(field, Operator.LESS, value));
//		return this;
//	}
//
//	@Override
//	public Query<Tuple> or()
//	{
//		rules.add(new QueryRule(Operator.OR));
//		return this;
//	}
//
//	@Override
//	public Query<Tuple> and()
//	{
//		rules.add(new QueryRule(Operator.AND));
//		return this;
//	}
//
//	@Override
//	public Query<Tuple> limit(int limit)
//	{
//		t.setLimit(limit);
//		return this;
//	}
//
//	@Override
//	public Query<Tuple> offset(int offset)
//	{
//		t.setOffset(offset);
//		return this;
//	}
//
//	@Override
//	public Query<Tuple> asc(String orderByField)
//	{
//		rules.add(new QueryRule(Operator.SORTASC, orderByField));
//		return this;
//	}
//
//	@Override
//	public Query<Tuple> sortDESC(String orderByField)
//	{
//		rules.add(new QueryRule(Operator.SORTDESC, orderByField));
//		return this;
//	}
//}
