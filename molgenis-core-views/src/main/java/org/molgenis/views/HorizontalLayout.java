package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;


public class HorizontalLayout extends FormLayout<HorizontalLayout>
{
	public HorizontalLayout()
	{
		super();
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.println("<div class=\"form-horizontal\">");
		for (View<?> i : this.getChildren())
		{
			if (i instanceof HtmlInput)
			{
				HtmlInput<?,?> input = (HtmlInput<?,?>)i;
				out.println(" <div class=\"control-group\"><label class=\"control-label\" for=\"" + input.getName() + "\">" + input.getLabel() + "</label><div class=\"controls\">");
				i.render(out);
				out.println("</div></div>");
			}
			else
			{
				i.render(out);
			}
		}
		out.println("</div>");
	}

}
