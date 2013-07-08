<#--
implementation notes:
* for nested collections we use List because that allows extra lazy load.
* we don't use CascadeType=persist|merge on associations because of performance and other problems
* 
-->
<#include "GeneratorHelper.ftl">
package ${package};

import org.molgenis.data.Query;
import org.molgenis.data.TypedQuery;
import org.molgenis.data.JpaRepository;

import org.springframework.stereotype.Component;

@Component
public class ${Name(entity)}Repository extends JpaRepository<${Name(entity)}>
{
	public Class<${Name(entity)}> getEntityClass()
	{
		return ${Name(entity)}.class;
	}
	
	@Override
	public ${Name(entity)}MetaData getMetaData()
	{
		return new ${Name(entity)}MetaData();
	}

	@Override
	public Iterable<${Name(entity)}> findAll(Iterable<Integer> ids)
	{
		return findAll(new Query().in("${entity.primaryKey.name}",ids));
	}

	@Override
	public void delete(Integer id)
	{
		this.delete(this.findOne(id));
	}
	
	@Override
	public TypedQuery<${Name(entity)}> query()
	{
		return new TypedQuery<${Name(entity)}>(this);
	}
}