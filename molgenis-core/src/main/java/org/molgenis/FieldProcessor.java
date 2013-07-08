package org.molgenis;

import java.io.Serializable;

public interface FieldProcessor extends Serializable
{
	public String process(String value);

	public boolean processHeader();

	public boolean processData();
}
