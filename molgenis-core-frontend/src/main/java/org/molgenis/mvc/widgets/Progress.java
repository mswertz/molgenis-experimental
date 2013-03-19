package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Progress extends GuiElement<Progress>
{
	public enum Type
	{
		INFO, SUCCESS, WARNING, DANGER
	};

	Map<Type, Integer> progress = new HashMap<Type, Integer>();
	Map<Type, String> messages = new HashMap<Type, String>();

	public Progress()
	{
		super(randomId());
	}
	
	public Progress warn(Integer percent)
	{
		progress.put(Type.WARNING, percent);
		
		return this;
	}
	
	public Progress success(Integer percent)
	{
		progress.put(Type.SUCCESS, percent);
		
		return this;
	}

	public Progress danger(Integer percent)
	{
		progress.put(Type.DANGER, percent);
		
		return this;
	}
	
	public Progress info(Integer percent)
	{
		progress.put(Type.INFO, percent);
		
		return this;
	}
	
	public Progress warn(Integer percent, String message)
	{
		progress.put(Type.WARNING, percent);
		messages.put(Type.WARNING, message);
		return this;
	}
	
	public Progress success(Integer percent, String message)
	{
		progress.put(Type.SUCCESS, percent);
		messages.put(Type.SUCCESS, message);

		return this;
	}

	public Progress danger(Integer percent, String message)
	{
		progress.put(Type.DANGER, percent);
		messages.put(Type.DANGER, message);

		
		return this;
	}
	
	public Progress info(Integer percent, String message)
	{
		progress.put(Type.INFO, percent);
		messages.put(Type.INFO, message);

		return this;
	}
	
	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.println("<div class=\"progress progress-striped\">");
		for (Entry<Type, Integer> entry : progress.entrySet())
		{
			String message = messages.containsKey(entry.getKey()) ? messages.get(entry.getKey()): "" ;
			out.println("<div class=\"bar bar-"+entry.getKey().toString().toLowerCase()+"\" style=\"width: " + entry.getValue() + "%;\">"+message+"</div>");
		}
		out.println("</div>");

	}

}
