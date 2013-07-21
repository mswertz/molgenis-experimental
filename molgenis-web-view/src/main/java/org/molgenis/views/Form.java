package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;

import org.molgenis.Entity;
import org.molgenis.meta.FieldMetaData;
import org.molgenis.meta.types.AutoidField;

public class Form extends View<Form>
{
	String legend;

	public Form()
	{
		super(randomId());
		// super.add(this.layout);
	}
	
	public Form(View<?>...views)
	{
		this();
		this.add(views);
	}

	public Form add(FieldMetaData field)
	{
		this.add(FieldTypeInput.get(field));

		return this;
	}

	public Form(String id)
	{
		super(id);
	}

	public Form(Entity entity)
	{
		this(new VerticalLayout(), entity);
	}

	@SuppressWarnings(
	{ "unchecked", "rawtypes" })
	public Form(FormLayout<?> layout, Entity entity)
	{
		for (Object o : entity.getMetaData().getFields())
		{
			FieldMetaData f = (FieldMetaData) o;
			// if autoid then hide
			if (!(f.getType() instanceof AutoidField) || entity.get(f.getName()) != null)
			{
				HtmlInput input = FieldTypeInput.get(f);

				input.value(entity.get(f.getName()));
				input.label(f.getLabel());
				input.setRequired(!f.getNillable());

				layout.add(input);
			}
		}
		this.add(layout);
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
		out.println("<form id=\"" + getId() + "\">");
		for (View<?> v : this.getChildren())
		{
			v.render(out);
		}
		out.println("</form>");
		out.println("<script>$('#"
				+ getId()
				+ "').validate({ errorElement: 'span', errorClass:'help-inline', highlight:    function (element, errorClass) {"
				+ "$(element).parent().parent().addClass('error');}, unhighlight: function (element, errorClass) {$(element).parent().parent().removeClass('error');}});</script>");
	}
}
