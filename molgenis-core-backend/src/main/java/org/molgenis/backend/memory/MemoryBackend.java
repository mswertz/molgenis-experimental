package org.molgenis.backend.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.molgenis.backend.Backend;
import org.molgenis.backend.BackendException;
import org.molgenis.backend.BackendImpl;
import org.molgenis.backend.IdentifiableRecord;
import org.molgenis.backend.Query;

public class MemoryBackend extends BackendImpl implements Backend
{
	Map<String, List<IdentifiableRecord>> data = new TreeMap<String, List<IdentifiableRecord>>();

	@Override
	public List<String> getCollections()
	{
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("not yet implemented");
	}

	@Override
	public List<Class<? extends IdentifiableRecord>> getClasses()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query<? extends IdentifiableRecord> query(String collection) throws BackendException
	{
		return new MemoryQuery(this.data.get(collection));
	}

	@Override
	public <E extends IdentifiableRecord> Query<E> query(Class<E> klass) throws BackendException
	{
		return (Query<E>) this.query(klass.getName());
	}

	@Override
	public <E extends IdentifiableRecord> void add(E record) throws BackendException
	{
		if(record == null) throw new BackendException("add(null) failed: cannot add null");
		String key = record.getClass().getName();
		if(!this.data.containsKey(key))
		{
			data.put(key, new ArrayList<IdentifiableRecord>());
		}
		//todo: unique check? would need indexed list
		data.get(key).add(record);
	}

	@Override
	public <E extends IdentifiableRecord> void add(Iterable<E> records) throws BackendException
	{
		for(E e: records) this.add(e);
	}

	@Override
	public <E extends IdentifiableRecord> void update(E record)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public <E extends IdentifiableRecord> void update(Iterable<E> records)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public <E extends IdentifiableRecord> void remove(E record)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public <E extends IdentifiableRecord> void remove(Iterable<E> records)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public <E extends IdentifiableRecord> void apply(BackendAction action, E record)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public <E extends IdentifiableRecord> void apply(BackendAction action, Iterable<E> records)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public <E extends IdentifiableRecord> E load(E object) throws BackendException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
