package org.molgenis.controllers;

import org.molgenis.data.Backend;
import org.molgenis.data.BackendException;
import org.molgenis.data.IdentifiableRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/** Renders an input form for an entity */
@Component
@Scope("request")
public abstract class EntityController<E extends IdentifiableRecord>
{	
	@Autowired
	Backend backend;
	
	public String getEditForm(Integer id) throws BackendException
	{			
		try
		{
			return "blaat"+ backend.getById(this.getEntityClass(), id).toString();
		}catch(Exception e)
		{
			return "error: "+e.getMessage();
		}
	}
	
	public String getEntityClassName()
	{
		return this.getEntityClass().getCanonicalName();
	}
	
	public abstract Class<E> getEntityClass();
}
