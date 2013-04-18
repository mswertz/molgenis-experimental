package org.molgenis.backend.memory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.molgenis.backend.BackendException;
import org.molgenis.backend.IdentifiableRecord;
import org.molgenis.backend.QueryImp;
import org.molgenis.backend.QueryRule;

public class MemoryQuery<E extends IdentifiableRecord> extends QueryImp<E>
{
	List<E> data;

	public MemoryQuery(List<E> data)
	{
		this.data = data;
	}

	@Override
	public long count() throws BackendException
	{
		int count = 0;
		for (E e : data)
		{
			if (match(e)) count++;
		}
		return count;
	}

	private boolean match(E e)
	{
		for (QueryRule r : getRules())
		{
			switch (r.getOperator())
			{
				case EQUALS:
					if (e.get(r.getField()) != null && !e.get(r.getField()).equals(r.getValue())
							|| e.get(r.getField()) == null && r.getValue() != null)
					{
						return false;
					}
					break;
				default:
					throw new UnsupportedOperationException("Operator " + r.getOperator() + " not supported");
			}
		}
		// default to true unless falsified
		return true;
	}

	@Override
	public E getById(Object id) throws BackendException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator()
	{
		List<E> result = new ArrayList<E>();
		for (E e : this.data)
		{
			if (this.match(e)) result.add(e);
		}
		return result.iterator();
	}

}
