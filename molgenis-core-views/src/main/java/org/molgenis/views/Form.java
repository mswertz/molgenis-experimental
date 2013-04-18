package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;


public class Form extends View<Form>
{
	String legend;

	public static enum FormLayout
	{
		/** no labels */
		INLINE,
		/** labels above inputs */
		VERTICAL,
		/** labels left before inputs */
		HORIZONTAL
	};

	private VerticalLayout layout = new VerticalLayout(); 

	public Form()
	{
		super(randomId());
		super.add(this.layout);
	}

	@Override
	public Form add(View<?>... elements)
	{
		for (View<?> element : elements)
		{
			this.layout.add(element);
		}
		return this;
	}

	public Form(String id)
	{
		super(id);
	}

//	public FormLayout getType()
//	{
//		return layout;
//	}
//
//	public Form setLayout(FormLayout type)
//	{
//		this.layout = type;
//		return this;
//	}

	public String getLegend()
	{
		return legend;
	}

	public Form setLegend(String legend)
	{
		this.legend = legend;
		return this;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.println("<form id=\"" + getId() + "\">");
		for (View<?> el : this.getChildren())
		{
			el.render(out);
		}

		out.println("</form>");
		out.println("<script>$('#"
				+ getId()
				+ "').validate({ errorElement: 'span', errorClass:'help-inline', highlight:    function (element, errorClass) {"
				+ "$(element).parent().parent().addClass('error');}, unhighlight: function (element, errorClass) {$(element).parent().parent().removeClass('error');}});</script>");
	}
}
