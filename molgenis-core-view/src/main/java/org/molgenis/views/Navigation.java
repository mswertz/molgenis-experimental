package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



/**
 * Menu. Each menu Tab item can either have already contents OR be simply a
 * link.
 */
public class Navigation extends View<Navigation>
{
	public enum Position
	{
		LEFT, TOP_LEFT, TOP_RIGHT, BOTTOM
	};

	public enum Type
	{

	}

	// position of this menu
	private Position position = Position.TOP_LEFT;

	// active id
	private String active;

	public Navigation(String id)
	{
		super(id);
	}

	public Position getPosition()
	{
		return position;
	}

	public void setPosition(Position position)
	{
		this.position = position;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		new FreemarkerView("TabMenu.ftl", this).render(out);
	}

	@Override
	public Navigation add(View<?>... tab)
	{
		throw new RuntimeException("TabMenu.add() can only receive new Tab()");
	}

	public Navigation add(MenuItem... tabs)
	{
		super.add(tabs);

		return this;
	}

	public List<MenuItem> getItems()
	{
		List<MenuItem> result = new ArrayList<MenuItem>();
		for (View<?> el : this.getChildren())
		{
			result.add((MenuItem) el);
		}
		return result;
	}

	public Navigation setActive(String id)
	{
		for (View<?> el : this.getChildren())
		{
			if (el.getId().equals(id)) this.active = id;
			return this;
		}

		throw new RuntimeException("TabMenu.setActive(" + id + ") failed: unknown");
	}

	public String getActive()
	{
		if (this.active == null)
		{
			if (this.getChildren().size() > 0) return this.getChildren().get(0).getId();
			else
				return "THIS_MENU_HAS_NO_ITEMS";
		}
		return this.active;
	}
}
