package org.molgenis.data;

import java.util.List;

import org.molgenis.io.Record;

//Discussion: 'not', 'fuzzy', 'facetted', ...
public interface Query<E extends IdentifiableRecord> extends Iterable<E>
{
	long count() throws BackendException;

	E getById(Object id) throws BackendException;

	/** Add rules to the query */
	void addRule(QueryRule addRules);

	/** Get current rules */
	List<QueryRule> getRules();

	/** Shorthand for addRule(new QueryRule(field, Operator.SEARCH, value) */
	Query<E> search(String searchTerms) throws BackendException;

	/** Shorthand for addRule(new QueryRule(field, Operator.LIKE, value) */
	Query<E> like(String field, Object value);

	/** Shorthand for addRule(new QueryRule(field, Operator.EQUALS, value) */
	Query<E> eq(String field, Object value);

	/** Shorthand for addRule(new QueryRule(field, Operator.IN, objectlist) */
	Query<E> in(String field, List<?> objectList);

	/** Shorthand for addRule(new QueryRule(field, Operator.GREATER, value) */
	Query<E> gt(String field, Object value);

	/** Shorthand for addRule(new QueryRule(field, Operator.LESS, value) */
	Query<E> lt(String field, Object value);

	/**
	 * Shorthand for addRule(new QueryRule(field, Operator.GREATER_EQUAL, value)
	 */
	Query<E> ge(String field, Object value);

	/** Shorthand for addRule(new QueryRule(field, Operator.LESS_EQUAL, value) */
	Query<E> le(String field, Object value);

	/** Shorthand for addRule(new QueryRule(Operator.LIMIT, limit) */
	Query<E> limit(int limit);

	/** Shorthand for addRule(new QueryRule(Operator.OFFSET, offset) */
	Query<E> offset(int offset);

	/** Shorthand for addRule(new QueryRule(Operator.SORT_ASC, field) */
	Query<E> asc(String orderByField);

	/** Shorthand for addRule(new QueryRule(Operator.SORT_DESC, field) */
	Query<E> sortDESC(String orderByField);

	/**
	 * Enable complex nested queries like {a = 1 and b = 1} or {a = 2 and b = 2}
	 */
	Query<E> nest();

	/** Get out of the current nested condition, see nest() */
	Query<E> unnest();

	/** Close all nested conditions */
	Query<E> unnestAll();

	/** seperate rules before and after this statement with an 'or' */
	Query<E> or();

	/**
	 * Shorthand for addRule(new QueryRule(field, Operator.GREATER, from), new
	 * QueryRule(field, Operator.LESS, to));
	 */
	Query<E> rng(String field, Object from, Object to);
}
