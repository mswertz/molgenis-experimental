package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Tabs extends View<Tabs>
{
	List<Hyperlink> items = new ArrayList<Hyperlink>();
	Hyperlink active;

	public Tabs()
	{
		super(randomId());
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		this.renderTemplate(out, "<@tabs model.id model.active model.items/>");
	}

	public Hyperlink getActive()
	{
		if (active == null) if (items.size() > 0) return items.get(0);
		return null;
	}
	
	@Override
	public Tabs add(View<?> ... view)
	{
		throw new UnsupportedOperationException();
	}
	
	public Tabs item(Hyperlink h)
	{
		this.items.add(h);
		return this;
	}
	
	public Tabs item(String label, String href)
	{
		return this.item(new Hyperlink().label(label).href(href));
	}
	
	
	public List<Hyperlink> getItems()
	{
		return this.items;
	}
}
