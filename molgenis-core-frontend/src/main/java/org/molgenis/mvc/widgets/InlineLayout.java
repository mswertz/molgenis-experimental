package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;

public class InlineLayout extends FormLayout<InlineLayout>
{
	public InlineLayout()
	{
		super();
	}
	
	
	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.println("<div class=\"form-inline\">");
		
		for (GuiElement<?> e : this.getChildren())
		{
			out.println("<span class=\"control-group form-inline\"><span class=\"controls\">");
			e.render(out);
			out.println("</span></span>");
		}
		
		out.println("</div>");

	}
}
