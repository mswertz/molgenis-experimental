package org.molgenis.generators.doc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.molgenis.MolgenisOptions;
import org.molgenis.generators.MolgenisGenerator;
import org.molgenis.model.EntityModel;
import org.molgenis.model.ModuleModel;
import org.molgenis.model.MolgenisModel;

import freemarker.template.Template;

public class ObjectModelDocGen extends MolgenisGenerator
{
	public static final transient Logger logger = Logger.getLogger(ObjectModelDocGen.class);

	@Override
	public String getDescription()
	{
		return "Generates one documentation file describing all entities.";
	}

	@Override
	public void generate(MolgenisModel model, MolgenisOptions options) throws Exception
	{
		Template template = createTemplate("/" + getClass().getSimpleName() + ".java.ftl");
		Map<String, Object> templateArgs = createTemplateArguments(options);

		File target = new File(this.getDocumentationPath(options) + "/objectmodel.html");
		target.getParentFile().mkdirs();

		List<EntityModel> entityList = model.getEntities();
		List<ModuleModel> moduleList = model.getModules();
		entityList = MolgenisModel.sortEntitiesByDependency(entityList, model); // side
																				// effect?

		templateArgs.put("model", model);
		templateArgs.put("entities", entityList);
		templateArgs.put("modules", moduleList);
		OutputStream targetOut = new FileOutputStream(target);
		template.process(templateArgs, new OutputStreamWriter(targetOut, Charset.forName("UTF-8")));
		targetOut.close();

		logger.info("generated " + target);
	}

}
