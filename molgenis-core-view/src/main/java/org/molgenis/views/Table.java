package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.molgenis.Entity;
import org.molgenis.MapEntity;
import org.molgenis.model.FieldModel;

import freemarker.template.Configuration;
import freemarker.template.Template;

/** Widget to render a table */
public class Table extends View<Table>
{
	Map<String, String> templates = new LinkedHashMap<String, String>();

	public Table()
	{
		super(randomId());
	}

	public Table(Iterable<? extends Entity> rows)
	{
		this();
		this.add(rows);
	}

	List<Entity> rows = new ArrayList<Entity>();

	public Table add(Iterable<? extends Entity> rows)
	{
		for (Entity r : rows)
			this.rows.add(r);
		return this;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		this.renderTemplate(out, "<@table model.rows/>");
	}

	public List<FieldModel> getFields()
	{
		if (rows.size() > 0) return rows.get(0).getFields();
		else return new ArrayList<FieldModel>();
	}

	public Table addRow(Entity tuple)
	{
		if (tuple == null) throw new RuntimeException("Table.addRow() failed: null");

		// add the row
		rows.add(tuple);

		return this;
	}

	public List<Entity> getRows()
	{
		if (templates.size() > 0)
		{
			List<Entity> result = new ArrayList<Entity>();
			for (Entity row : rows)
			{
				MapEntity e = new MapEntity();
				for(FieldModel f: row.getModel().getFields())
				{
					e.set(f.getName(), f.toString(row));
				}
				Map<String, Object> map = e.getMap();

				// update templates
				for (String key : templates.keySet())
				{
					e.set(key, applyTemplate(templates.get(key), map));
				}

				result.add(e);
			}
			return result;
		}
		else
		{
			return rows;
		}
	}

	private String applyTemplate(String template, Map<String, Object> map)
	{
		try
		{
			Template t = new Template("name", new StringReader(template), new Configuration());
			StringWriter out = new StringWriter();
			t.process(map, out);
			return out.toString();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void setRows(List<Entity> rows)
	{
		this.rows = rows;
	}

	public void template(String col, String value)
	{
		this.templates.put(col, value);
	}
}
