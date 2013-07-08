package org.molgenis;

import java.io.File;
import java.lang.reflect.Modifier;
import java.util.Set;

import org.apache.log4j.Logger;
import org.molgenis.generators.MolgenisGenerator;
import org.molgenis.meta.EntityMetaData;
import org.molgenis.meta.MolgenisMetaData;
import org.molgenis.meta.utils.MolgenisModelValidator;
import org.reflections.Reflections;

public class GenerateTestSources
{
	public static void main(String[] args) throws Exception
	{
		try
		{
			Logger logger = Logger.getLogger(GenerateTestSources.class);
			
			logger.info("GENERATE-DIR-REAL: "+System.getProperty("user.dir"));

			// parse all current models in model folder
			MolgenisMetaData model = new MolgenisMetaData();
			File mainModelDir = new File("src/main/resources/org/molgenis/model/");
			if (mainModelDir.exists())
			{
				for (File modelXml : mainModelDir.listFiles())
				{
					if (modelXml.getName().endsWith(".xml"))
					{
						logger.info("parsing model: " + modelXml);
						model.parse(modelXml);
					}
				}
			}

			File testModelDir = new File("src/test/resources/org/molgenis/model/");

			if (testModelDir.exists())
			{
				for (File modelXml : testModelDir.listFiles())
				{
					if (modelXml.getName().endsWith(".xml"))
					{
						logger.info("parsing model: " + modelXml);
						model.parse(modelXml);
					}
				}
			}
			// import the models from dependencies in classpath
			MolgenisModelValidator.validate(model);
			
			for(EntityMetaData e: model.getEntities())
			{
				logger.info("entity: "+e.getName());
			}

			// load relevant options
			MolgenisOptions options = new MolgenisOptions();
			options.output_doc = "src/test/site";
			options.output_src = "target/generated-sources/test/java";

			// generate for all available generators
			Reflections reflections = new Reflections("org.molgenis.generators");
			Set<Class<? extends MolgenisGenerator>> generatorClasses = reflections
					.getSubTypesOf(MolgenisGenerator.class);
			for (Class<? extends MolgenisGenerator> c : generatorClasses)
			{
				if (!c.isInterface() && !Modifier.isAbstract(c.getModifiers()))
				{
					logger.info("using: " + c.getSimpleName());
					MolgenisGenerator gen = (MolgenisGenerator) c.newInstance();
					gen.generate(model, options);

				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
}
