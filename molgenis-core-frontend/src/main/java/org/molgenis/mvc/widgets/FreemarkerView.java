package org.molgenis.mvc.widgets;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * FreemarkerView uses a Freemarker template to render the user interface. The
 * Freemarker template will get as parameters:
 * <ol>
 * <li>application - result of
 * model.getController().getApplicationController().getModel()
 * <li>model - result of getModel()
 * <li>screen - deprecated, synonym of model
 * <li>viewhelper - all kinds of helper methods
 * <li>show - parameter influencing whole app or only one screen rendering
 * </ol>
 * 
 * @see http://www.freemarker.org
 */
public class FreemarkerView extends GuiElement
{

	// wrapper of this template
	private freemarker.template.Configuration conf = null;
	private String templatePath;
	private transient Logger logger = Logger.getLogger(FreemarkerView.class);
	private Map<String, Object> arguments = new LinkedHashMap<String, Object>();
	private Object model;

	public FreemarkerView(String templatePath, Object model)
	{
		super(templatePath);
		this.model = model;
		this.templatePath = templatePath;
		// this.usePublicFieldModels = usePublicFieldModels;
	}

	/**
	 * Assumes template to be klazzpath + ".ftl"
	 * 
	 * @param klazz
	 * @param templateArgs
	 */
	public FreemarkerView(Class<?> klazz, Map<String, Object> templateArgs)
	{
		this(klazz.getCanonicalName().replace(".", "/") + ".ftl", templateArgs);
	}

	public FreemarkerView(String templatePath, Map<String, Object> templateArgs)
	{
		super(null);
		this.templatePath = templatePath;
		this.arguments = templateArgs;
	}

	public FreemarkerView()
	{
		super(null);
	}

	@SuppressWarnings("deprecation")
	public String render(String templatePath, Map<String, Object> templateArgs)// ,
																				// boolean
																				// usePublicFieldModels)
	{
		logger.debug("trying to render " + templatePath);
		try
		{
			// keep configuration in session so we can reuse it
			if (conf == null)
			{
				logger.debug("create freemarker config");
				// create configuration
				conf = new freemarker.template.Configuration();
				conf.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

				List<TemplateLoader> loaders = new ArrayList<TemplateLoader>();

				// create template loader
				// load templates from MOLGENIS
				//loaders.add(new ClassTemplateLoader(MolgenisOriginalStyle.class, ""));
				// load templates from plugins, can be anywere
				// (nb this method is deprecated but I can't see why)
				loaders.add(new ClassTemplateLoader());

				for (Object key : templateArgs.keySet())
				{
					if ("model".equals(key) && templateArgs.get(key) != null)
					{
						loaders.add(new ClassTemplateLoader(templateArgs.get(key).getClass()));

						// also add superclass because of generated code
						loaders.add(new ClassTemplateLoader(templateArgs.get(key).getClass().getSuperclass()));
					}
				}
				loaders.add(new FileTemplateLoader());
				loaders.add(new FileTemplateLoader(new File("/")));

				// ClassTemplateLoader loader1 = new ClassTemplateLoader(
				// Object.class, "");
				// ClassTemplateLoader loader2 = new ClassTemplateLoader(
				// getClass().getSuperclass(), "");
				MultiTemplateLoader mLoader = new MultiTemplateLoader(
						loaders.toArray(new TemplateLoader[loaders.size()]));
				conf.setTemplateLoader(mLoader);
				logger.debug("created freemarker config");
			}

			// merge template
			//conf.addAutoInclude("ScreenViewHelper.ftl");

			//WidgetFactory.configure(conf);

			Template template = conf.getTemplate(templatePath);
			StringWriter writer = new StringWriter();

			template.process(templateArgs, writer);
			writer.close();

			return writer.toString();

		}
		catch (Exception e)
		{
			logger.error("rendering of template " + templatePath + " failed:");
			e.printStackTrace();

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw, true);
			e.printStackTrace(pw);
			pw.flush();
			sw.flush();

			return sw.toString().replace("\n", "<br/>");

		}
	}

	@Override
	public void render(PrintWriter writer)
	{
		// get the database for this application
		// Database db =
		// this.getModel().getController().getApplicationController().getDatabase();

		// create template parameters
		Map<String, Object> templateArgs = new LinkedHashMap<String, Object>(this.arguments);

		templateArgs.put("screen", model);
		templateArgs.put("model", model);
		//templateArgs.put("widgetfactory", new WidgetFactory());
		//templateArgs.put("typeFieldModel", FieldModel.TYPE_FIELD);

		writer.print(this.render(templatePath, templateArgs));
	}

	public String getTemplatePath()
	{
		return templatePath;
	}

	public void setTemplatePath(String templatePath)
	{
		this.templatePath = templatePath;
	}

	public void addParameter(String name, Object value)
	{
		this.arguments.put(name, value);
	}
}
