package org.molgenis.data;

import org.molgenis.Entity;
import org.molgenis.meta.EntityMetaData;

public interface MetaDataRepository<E extends Entity>
{
	EntityMetaData getMetaData(); //new
}
