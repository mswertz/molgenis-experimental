package org.molgenis.controllers;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;

import org.molgenis.views.View;
import org.testng.annotations.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class TestFreemarker
{

	@Test
	public void test() throws IOException, TemplateException
	{
		Configuration conf = new Configuration();
		conf.setClassForTemplateLoading(View.class, "");
		conf.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		String templateStr = "<#include \"MolgenisController.ftl\"/>\n<@warn>warning</@warn>";
		Template template = new Template("name", new StringReader(templateStr), conf);

		StringWriter writer = new StringWriter();
		template.process(new HashMap(), writer);
		writer.close();

		System.out.println(writer.toString());
	}

}
