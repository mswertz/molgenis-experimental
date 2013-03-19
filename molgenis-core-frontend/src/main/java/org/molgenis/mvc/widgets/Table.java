package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.molgenis.util.tuple.Tuple;

/** Widget to render a table*/
public class Table extends GuiElement<Table>
{
	public Table(String id)
	{
		super(id);
	}

	Map<String,String> headers = new LinkedHashMap<String,String>();
	List<Tuple> rows = new ArrayList<Tuple>();

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.println("<table class=\"table table-striped table-condensed\"><thead><tr>");
		
		//header
		for(Entry<String,String> entry: headers.entrySet())
		{
			out.println("<th>"+entry.getValue()+"</th>");
		}
		out.println("</tr></thead><tbody>");
		
		//body
		for(Tuple row: rows)
		{
			out.println("<tr>");
			for(String key: headers.keySet())
			{
				out.print("<td>"+row.getString(key)+"</td>");
			}
			out.println("</tr>");
		}
		
		//close
		out.println("</tbody></table>");
	}
	
	public Table setHeaders(Map<String,String> titles)
	{
		headers.putAll(titles);
		
		return this;
	}
	
	public Table addRow(Tuple tuple)
	{
		if(tuple == null) throw new RuntimeException("Table.addRow() failed: null");
		
		//check if keys are known
		for(String key: tuple.getColNames())
		{
			if(!headers.containsKey(key)) headers.put(key, key);
		}
		
		//add the row
		rows.add(tuple);
		
		return this;
	}

//	public Table add(TupleTable source)
//	{
//		for(Tuple t: source)
//		{
//			this.addRow(t);
//		}
//		
//		return this;
//	}
}
