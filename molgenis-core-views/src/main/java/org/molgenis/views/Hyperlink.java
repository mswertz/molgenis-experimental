package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;

/** Inject simply a bit of html */
public class Hyperlink extends View<Hyperlink>
{
	String label;
	String url;
	boolean disabled = false;

	public Hyperlink()
	{
		super(randomId());
	}

	public Hyperlink(String label, String url)
	{
		this();
		this.label = label;
		this.url = url;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.write(String.format("<a href=\"%s\">%s</a>", url, label));
	}

	public Hyperlink url(String url)
	{
		this.setUrl(url);
		return this;
	}

	public Hyperlink label(String label)
	{
		this.setLabel(label);
		return this;
	}

	public Hyperlink disable(boolean disable)
	{
		this.disabled = disable;
		return this;
	}

	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public boolean isDisabled()
	{
		return disabled;
	}
}
