package org.molgenis.views;

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
import freemarker.cache.StringTemplateLoader;
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
public class FreemarkerView extends View<FreemarkerView> {

	// wrapper of this template
	private freemarker.template.Configuration conf = null;
	private String templatePath;
	private transient Logger logger = Logger.getLogger(FreemarkerView.class);
	private Map<String, Object> arguments = new LinkedHashMap<String, Object>();
	private Object model;

	public FreemarkerView(String templatePath, Object model) {
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
	public FreemarkerView(Class<?> klazz, Map<String, Object> templateArgs) {
		this(klazz.getCanonicalName().replace(".", "/") + ".ftl", templateArgs);
	}

	public FreemarkerView(String templatePath, Map<String, Object> templateArgs) {
		super();
		this.templatePath = templatePath;
		this.arguments = templateArgs;
	}

	public FreemarkerView() {
		super();
	}

	@SuppressWarnings("deprecation")
	public String render(String templatePath, String templateString,
			Map<String, Object> templateArgs)// ,
	// boolean
	// usePublicFieldModels)
	{
		logger.debug("trying to render " + templatePath);
		
		String  theTemplate = "";
		try {
			// keep configuration in session so we can reuse it
			if (conf == null) {
				logger.debug("create freemarker config");
				// create configuration
				conf = new freemarker.template.Configuration();
				conf.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

				List<TemplateLoader> loaders = new ArrayList<TemplateLoader>();

				loaders.add(new ClassTemplateLoader());

				for (Object key : templateArgs.keySet()) {
					if ("model".equals(key) && templateArgs.get(key) != null) {
						loaders.add(new ClassTemplateLoader(templateArgs.get(
								key).getClass()));

						// also add superclass because of generated code
						loaders.add(new ClassTemplateLoader(templateArgs
								.get(key).getClass().getSuperclass()));
					}
				}
				
				if(templateString != null)
				{
					   StringTemplateLoader stringLoader = new StringTemplateLoader();
					   stringLoader.putTemplate(getId(), templateString);
					   loaders.add(stringLoader);
				}
				
				loaders.add(new FileTemplateLoader());
				loaders.add(new FileTemplateLoader(new File("/")));

				MultiTemplateLoader mLoader = new MultiTemplateLoader(
						loaders.toArray(new TemplateLoader[loaders.size()]));
				conf.setTemplateLoader(mLoader);
				logger.debug("created freemarker config");
			}

			StringWriter writer = new StringWriter();

			Template template;

			if (templateString != null) {
				template = conf.getTemplate(getId());
			} else
				template = conf.getTemplate(templatePath);
			template.process(templateArgs, writer);
			writer.close();

			return writer.toString();

		} catch (Exception e) {
			logger.error("rendering of template " + templatePath + " failed:\n"+theTemplate);
			e.printStackTrace();

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw, true);
			e.printStackTrace(pw);
			pw.flush();
			sw.flush();

			return sw.toString().replace("\n", "<br/>");

		}
	}

	public void render(String templateString, PrintWriter writer) {
		Map<String, Object> templateArgs = new LinkedHashMap<String, Object>(
				this.arguments);

		templateArgs.put("model", model);

		writer.print(this.render(templatePath, templateString, templateArgs));
	}

	@Override
	public void render(PrintWriter out) {
		this.render(null, out);
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public void addParameter(String name, Object value) {
		this.arguments.put(name, value);
	}
}
