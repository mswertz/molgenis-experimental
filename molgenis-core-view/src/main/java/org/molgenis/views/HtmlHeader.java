package org.molgenis.views;

public abstract class HtmlHeader
{
	String href;
	
	public HtmlHeader(String header)
	{
		this.href = header;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((href == null) ? 0 : href.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		HtmlHeader other = (HtmlHeader) obj;
		if (href == null)
		{
			if (other.href != null) return false;
		}
		else if (!href.equals(other.href)) return false;
		return true;
	}
}
