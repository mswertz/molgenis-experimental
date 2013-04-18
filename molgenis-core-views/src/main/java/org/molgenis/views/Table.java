package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.molgenis.Record;
import org.molgenis.model.FieldModel;

/** Widget to render a table */
public class Table extends View<Table>
{
	public Table()
	{
		super(randomId());
	}

	List<Record> rows = new ArrayList<Record>();

	public Table add(Iterable<Record> rows)
	{
		for (Record r : rows)
			this.rows.add(r);
		return this;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.println("<table class=\"table table-striped table-condensed\"><thead><tr>");

		// header
		List<String> headers = new ArrayList<String>();
		if (rows.size() > 0) for (FieldModel f : rows.get(0).getModel().getFields())
		{
			out.println("<th>" + f.getLabel() + "</th>");
			headers.add(f.getName());
		}
		out.println("</tr></thead><tbody>");

		// body
		for (Record row : rows)
		{
			out.println("<tr>");
			for (String key : headers)
			{
				out.print("<td>" + row.get(key) + "</td>");
			}
			out.println("</tr>");
		}

		// close
		out.println("</tbody></table>");
	}

	public Table addRow(Record tuple)
	{
		if (tuple == null) throw new RuntimeException("Table.addRow() failed: null");

		// add the row
		rows.add(tuple);

		return this;
	}
}
