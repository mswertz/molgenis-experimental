package org.molgenis.mvc.widgets;

import java.io.IOException;
import java.io.PrintWriter;

public class Form extends GuiElement<Form>
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

	private FormLayout layout = FormLayout.VERTICAL;

	public Form(String id)
	{
		super(id);
	}

	public FormLayout getType()
	{
		return layout;
	}

	public Form setLayout(FormLayout type)
	{
		this.layout = type;
		return this;
	}

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
		out.println("<form id=\""+getId()+"\">");
		for (GuiElement<?> el : this.getChildren())
		{
			el.render(out);
		}

		out.println("</form>");
		out.println("<script>$('#"+getId()+"').validate({ errorElement: 'span', errorClass:'help-inline', highlight:    function (element, errorClass) {" +
				"$(element).parent().parent().addClass('error');}, unhighlight: function (element, errorClass) {$(element).parent().parent().removeClass('error');}});</script>");
	}

	public Button button(String name)
	{
		Button b = new Button(name);
		this.add(b);
		return b;
	}

	public StringInput string(String name)
	{
		StringInput i = new StringInput(name);
		this.add(i);
		return i;
	}

	public DateInput date(String name)
	{
		DateInput d = new DateInput(name);
		this.add(d);
		return d;
	}
}
