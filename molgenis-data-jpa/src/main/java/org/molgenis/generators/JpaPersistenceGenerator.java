package org.molgenis.generators;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.log4j.Logger;
import org.molgenis.MolgenisOptions;
import org.molgenis.generators.MolgenisGenerator;
import org.molgenis.meta.MolgenisMetaData;

import freemarker.template.Template;

public class JpaPersistenceGenerator extends MolgenisGenerator
{
	private final static Logger logger = Logger.getLogger(JpaPersistenceGenerator.class);

	@Override
	public String getDescription()
	{
		return "Generates persistence.xml";
	}

	@Override
	public void generate(MolgenisMetaData model, MolgenisOptions options) throws Exception
	{
		Template template = createTemplate("/" + getClass().getSimpleName() + ".xml.ftl");
		Map<String, Object> templateArgs = createTemplateArguments(options);

		File target = new File(this.getSourcePath(options) + "/META-INF/persistence.xml");
		boolean created = target.getParentFile().mkdirs();
		if (!created && !target.getParentFile().exists())
		{
			throw new IOException("could not create " + target.getParentFile());
		}

		templateArgs.put("options", options);
		templateArgs.put("model", model);

		OutputStream targetOut = new FileOutputStream(target);
		template.process(templateArgs, new OutputStreamWriter(targetOut, Charset.forName("UTF-8")));
		targetOut.close();

		logger.info("generated " + target);
	}
}
