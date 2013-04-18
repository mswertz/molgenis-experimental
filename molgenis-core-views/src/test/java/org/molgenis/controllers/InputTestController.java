package org.molgenis.controllers;

import java.io.File;
import java.util.Date;

import org.molgenis.MolgenisController;
import org.molgenis.views.Div;
import org.molgenis.views.Form;
import org.molgenis.views.HtmlInput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test/input")
public class InputTestController extends MolgenisController
{
	@RequestMapping
	public Div index()
	{
		return div(
				H1("Choose input to test:"),
				href("string", "string"), br(),
				href("integer", "integer"), br(),
				href("decimal", "decimal"), br(),
				href("bool", "bool"), br(),
				href("date", "date"), br(),
				href("datetime", "datetime"), br(),
				href("select", "select"), br(),
				href("xref", "xref"), br(),
				href("mref", "mref"), br(),
				href("email", "email"), br(),
				href("password", "password"), br(),
				href("text", "text"), br(),
				href("richtext", "richtext"), br(),
				href("file", "file"), br());

	}

	@RequestMapping("string")
	public Form string(String value, String placeholder, boolean required)
	{
		return create(string("value").value(value).label("string"), placeholder, required);
	}

	@RequestMapping("email")
	public Form email(String value, String placeholder, boolean required)
	{
		return create(email("value").value(value).label("email"), placeholder, required);
	}

	@RequestMapping("password")
	public Form password(String placeholder, boolean required)
	{
		return create(password("value").label("password"), placeholder, required);
	}

	@RequestMapping("text")
	public Form text(String value, String placeholder, boolean required)
	{
		return create(text("value").value(value).label("string"), placeholder, required);
	}

	@RequestMapping("richtext")
	public Form richtext(String value, String placeholder, boolean required)
	{
		return create(richtext("value").value(value).label("string"), placeholder, required);
	}

	public Form create(HtmlInput<?, ?> input, String placeholder, boolean required)
	{
		return form(
				legend(input.getClass().getSimpleName() + " test form"),
				string("placeholder").label("placeholder?").value(placeholder),
				help("Change and click OK to see placeholder"),
				bool("required").label("required?").value(required),
				help("Change and click OK to see required version"),
				input.required(required).placeholder(placeholder),
				post("ok", ""),
				href("back", "."));
	}

	@RequestMapping("select")
	public Form select(String value, String placeholder, boolean required)
	{
		return create(select("value").value(value).option("aap").option("noot").option("mies"), placeholder, required);
	}

	@RequestMapping("integer")
	public Form integer(Integer value, String placeholder, boolean required)
	{
		return create(integer("value").value(value).label("string"), placeholder, required);
	}

	@RequestMapping("decimal")
	public Form decimal(Double value, String placeholder, boolean required)
	{
		return create(decimal("value").value(value).label("string"), placeholder, required);
	}

	@RequestMapping("bool")
	public Form bool(Boolean value)
	{
		return form(
				legend("BoolInput test form"),
				bool("value").value(value).label("bool").required(),
				post("ok", ""),
				href("back", "."));
	}

	@RequestMapping("date")
	public Form date(Date value)
	{
		return form(
				legend("Data input test form"),
				date("value").value(value).label("date").required(),
				post("ok", ""),
				href("back", "."));
	}

	@RequestMapping("datetime")
	public Form datetime(Date value, String placeholder, boolean required)
	{
		return create(datetime("value").value(value).label("datetime"), placeholder, required);
	}

	@RequestMapping("xref")
	public Form xref(String value, String placeholder, boolean required)
	{
		return create(xref("value", "test").value(value).label("xref"), placeholder, required);
	}

	@RequestMapping("mref")
	public Form mref(String[] value, String placeholder, boolean required)
	{
		return create(mref("value", "test").value(value).label("mref"), placeholder, required);
	}
	
	@RequestMapping("file")
	public Form file(File value, String placeholder, boolean required)
	{
		return create(file("file").value(value).label("file"), placeholder, required);
	}
	
	@RequestMapping("freemarker")
	public Form file(String value, String placeholder, boolean required)
	{
		return create(freemarker("file").value(value).label("file"), placeholder, required);
	}
}
