package org.molgenis.mvc.demo;

import java.util.ArrayList;
import java.util.List;

import org.molgenis.mvc.widgets.DateInput;
import org.molgenis.mvc.widgets.DecimalInput;
import org.molgenis.mvc.widgets.EmailInput;
import org.molgenis.mvc.widgets.FormElement;
import org.molgenis.mvc.widgets.IntInput;
import org.molgenis.mvc.widgets.SelectInput;
import org.molgenis.mvc.widgets.StringInput;
import org.molgenis.mvc.widgets.TextInput;
import org.molgenis.mvc.widgets.UrlInput;


public class ExampleInputFactory
{
	public static List<FormElement<?>> createInputs(String prefix)
	{
		List<FormElement<?>> result = new ArrayList<FormElement<?>>();
		
		result.add(new StringInput(prefix+"_string").label("String:").placeholder("type a string"));
		result.add(new IntInput(prefix+"_int").label("Int:").placeholder("type an int"));
		result.add(new DecimalInput(prefix+"_decimal").label("Decimal:").placeholder("type a decimal"));
		result.add(new UrlInput(prefix+"_url").label("Url:").placeholder("type a url"));
		result.add(new EmailInput(prefix+"_email").label("Email:").placeholder("type a email"));
		result.add(new DateInput(prefix+"_date").label("Date:").placeholder("choose a date"));
		result.add(new SelectInput(prefix+"_select").label("Select:").option("aap").option("noot").option("mies"));
		result.add(new SelectInput(prefix+"_multi").multi(true).label("Multiselect:").option("aap").option("noot").option("mies"));
		
		result.add(new TextInput(prefix+"_text").label("Textarea:"));

		return result;
	}
}
