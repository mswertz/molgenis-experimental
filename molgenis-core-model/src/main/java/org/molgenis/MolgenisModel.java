package org.molgenis;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.validation.SchemaFactory;

import org.apache.log4j.Logger;
import org.molgenis.model.EntityModel;
import org.molgenis.model.FieldModel;
import org.molgenis.model.ModuleModel;
import org.molgenis.model.MolgenisModelException;
import org.molgenis.model.UniqueModel;
import org.molgenis.model.utils.MolgenisModelValidator;
import org.molgenis.types.MrefField;
import org.molgenis.types.XrefField;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

@XmlRootElement(name = "molgenis")
@XmlAccessorType(XmlAccessType.FIELD)
// so use fields bypassing get/set
public class MolgenisModel
{
	@XmlAttribute
	private String name;

	@XmlAttribute
	private String label;

	@XmlAttribute
	private String version;

	@XmlElement(name = "module")
	private List<ModuleModel> modules = new ArrayList<ModuleModel>();

	// GETTERS AND SETTERS
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLabel()
	{
		if(label == null) return getName();
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public List<EntityModel> getEntities()
	{
		List<EntityModel> result = new ArrayList<EntityModel>();
		for (ModuleModel m : this.getModules())
		{
			result.addAll(m.getEntities());
		}
		return result;
	}

	// added function addModule to add module to model
	public void addModule(ModuleModel e)
	{
		modules.add(e);
	}

	public EntityModel getEntity(String name)
	{
		for (ModuleModel module : modules)
		{
			EntityModel entity = module.getEntity(name);
			if (entity != null && entity.getName().equals(name)) return entity;
		}
		return null;
	}

	public String findModuleNameForEntity(String name)
	{
		for (ModuleModel module : modules)
		{
			for (EntityModel entity : module.getEntities())
			{
				if (entity.getName().equalsIgnoreCase(name)) return module.getName();
			}
		}
		return null;
	}

	/**
	 * find entity across local entities, and the ones contained in modules
	 * 
	 * @param name
	 * @return
	 */
	public EntityModel findEntity(String name)
	{
		for (ModuleModel module : modules)
		{
			for (EntityModel entity : module.getEntities())
			{
				if (entity.getName().toLowerCase().equals(name.toLowerCase())) return entity;
			}
		}
		return null;
	}

	public ModuleModel getModule(String name)
	{
		for (ModuleModel module : modules)
		{
			if (module.getName().toLowerCase().equals(name.toLowerCase())) return module;
		}

		return null;
	}

	/**
	 * Remove module, and return the index of the module that came before this
	 * one in the list (for GUI select purposes). If it is the last module,
	 * return null.
	 * 
	 * @param name
	 * @return
	 */
	public Integer removeModule(String name)
	{
		for (int i = 0; i < modules.size(); i++)
		{
			if (modules.get(i).getName().toLowerCase().equals(name.toLowerCase()))
			{
				modules.remove(i);
				if (modules.size() > 0)
				{
					return (i == 0 ? 0 : i - 1);
				}
				else
				{
					return null;
				}
			}
		}
		return null;
	}

	public synchronized List<ModuleModel> getModules()
	{
		return modules;
	}

	public synchronized void setModules(List<ModuleModel> modules)
	{
		this.modules = modules;
	}

	/**
	 * Find and remove an entity from either root or a module. If there are
	 * entities in the module or root left, jump to the previous one in the
	 * list. If there are no entities left in the root, return the name of the
	 * root. If there are no entities left in the module, return the name of the
	 * module.
	 * 
	 * @param string
	 * @return
	 */
	public String findRemoveEntity(String name)
	{
		for (ModuleModel module : modules)
		{
			for (int i = 0; i < module.getEntities().size(); i++)
			{
				if (module.getEntities().get(i).getName().toLowerCase().equals(name.toLowerCase()))
				{
					module.getEntities().remove(i);

					if (module.getEntities().size() > 0)
					{
						if (i == 0)
						{
							return module.getEntities().get(0).getName();
						}
						else
						{
							return module.getEntities().get(i - 1).getName();
						}
					}
					else
					{
						return null;
					}
				}
			}
		}
		return null;
	}

	public static MolgenisModel parse(File xml) throws MolgenisModelException
	{
		JAXBContext context;
		try
		{
			// parse xml
			context = JAXBContext.newInstance(MolgenisModel.class);
			Unmarshaller um = context.createUnmarshaller();
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			URL url = MolgenisModel.class.getResource("model/molgenis.xsd");
			um.setSchema(sf.newSchema(url));
			MolgenisModel model = (MolgenisModel) um.unmarshal(xml);

			// create reverese links
			for (ModuleModel module : model.getModules())
			{
				module.setModel(model);

				for (EntityModel entity : module.getEntities())
				{
					entity.setModule(module);
					
					for(FieldModel field: entity.getFields())
					{
						field.setEntity(entity);
					}
					
					for (UniqueModel unique : entity.getUniques())
					{
						unique.setEntity(entity);
					}
				}
			}

			// validate
			MolgenisModelValidator.validate(model);

			return model;
		}
		catch (JAXBException e)
		{
			Throwable le = e.getLinkedException();

			if (le instanceof SAXParseException)
			{
				System.out.println("Error on line " + ((SAXParseException) le).getLineNumber() + "\n" + le.getMessage()
						+ "\n");
			}
			else
				e.printStackTrace();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		throw new MolgenisModelException("parsing failed");
	}

	public static List<EntityModel> sortEntitiesByDependency(List<EntityModel> entityList, MolgenisModel model)
			throws MolgenisModelException
	{
		List<EntityModel> result = new ArrayList<EntityModel>();

		boolean found = true;
		List<EntityModel> toBeMoved = new ArrayList<EntityModel>();
		while (entityList.size() > 0 && found)
		{
			found = false;
			for (EntityModel entity : entityList)
			{
				List<String> deps = getDependencies(entity, model);

				// check if all deps are there
				boolean missing = false;
				for (String dep : deps)
				{
					if (indexOf(result, dep) < 0)
					{
						missing = true;
						break;
					}
				}

				if (!missing)
				{
					toBeMoved.add(entity);
					result.add(entity);
					found = true;
					break;
				}
			}

			for (EntityModel e : toBeMoved)
				entityList.remove(e);
			toBeMoved.clear();
		}

		// list not empty, cyclic?
		for (EntityModel e : entityList)
		{
			Logger.getLogger(MolgenisModel.class).error(
					"cyclic relations to '" + e.getName() + "' depends on " + getDependencies(e, model));
			result.add(e);
		}

		return result;
	}

	private static List<String> getDependencies(EntityModel currentEntity, MolgenisModel model)
			throws MolgenisModelException
	{
		Set<String> dependencies = new HashSet<String>();

		for (FieldModel field : currentEntity.getAllFields())
		{
			if (field.getType() instanceof XrefField)
			{
				dependencies.add(field.getXrefEntity().getName());

				EntityModel xrefEntity = field.getXrefEntity();

				// also all subclasses have this xref!!!!
				for (EntityModel e : xrefEntity.getAllDescendants())
				{
					if (!dependencies.contains(e.getName())) dependencies.add(e.getName());
				}
			}
			if (field.getType() instanceof MrefField)
			{
				dependencies.add(field.getXrefEntity().getName()); // mref
				// fields
				// including super classes and extends
				for (EntityModel entity : model.getEntity(field.getXrefEntity().getName()).getAllExtends())
				{
					dependencies.add(entity.getName());
				}
			}
		}

		dependencies.remove(currentEntity.getName());
		return new ArrayList<String>(dependencies);
	}

	private static int indexOf(List<EntityModel> entityList, String entityName)
	{
		for (int i = 0; i < entityList.size(); i++)
		{
			if (entityList.get(i).getName().equals(entityName)) return i;
		}
		return -1;
	}
	
	public int getNumberOfReferencesTo(EntityModel e) throws MolgenisModelException
	{
		int count = 0;

		for (EntityModel entity : this.getEntities())
		{
			for (FieldModel field : entity.getImplementedFields())
			{
				if (field.getType() instanceof XrefField || field.getType() instanceof MrefField)
				{
					String xrefEntity = field.getXrefEntity().getName();
					if (xrefEntity != null && xrefEntity.equals(e.getName())) count++;
				}
			}
		}
		return count;
	}
}
