package org.molgenis.io.record;

import java.util.ArrayList;
import java.util.List;

import org.molgenis.Record;
import org.molgenis.model.FieldModel;

public abstract class AbstractRecord implements Record
{
	private static final long serialVersionUID = 4028140818444568819L;

	public List<String> getFieldNames()
	{
		List<String> result = new ArrayList<String>();
		for(FieldModel f: this.getModel().getFields())
		{
			result.add(f.getName());
		}
		return result;
	}
}
