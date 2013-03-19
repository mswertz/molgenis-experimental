package org.molgenis.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.apache.log4j.Logger;
import org.molgenis.MolgenisModel;
import org.molgenis.types.FieldType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entity")
public class EntityModel
{
	@XmlTransient
	Logger logger = Logger.getLogger(EntityModel.class);

	@XmlTransient
	ModuleModel module;

	public static final int PRIMARY_KEY = 0;

	@XmlAttribute(required = true)
	private String name;

	@XmlAttribute
	private String label;

	@XmlElement
	private String description = "No description provided";

	@XmlElement(name = "field")
	private List<FieldModel> fields = new ArrayList<FieldModel>();

	@XmlElement(name = "unique")
	private List<UniqueModel> uniques = new ArrayList<UniqueModel>();

	@XmlElement(name = "index")
	private List<IndexModel> indices = new ArrayList<IndexModel>();

	@XmlAttribute(name = "extends")
	private String _extends = null;

	@XmlAttribute(name = "implements")
	private String _implements = null;

	@XmlAttribute(name = "decorator")
	private String _decorator = null;

	@XmlAttribute(name = "abstract")
	private Boolean _abstract = false;

	@XmlAttribute
	private String xref_label = null;

	@XmlAttribute
	private Boolean association = false;

	@XmlAttribute
	private Boolean system = false;

	public void setSystem(Boolean system)
	{
		this.system = system;
	}

	// CONSTRUCTORS
	public EntityModel()
	{

	}

	// HELPER METHODS
	public FieldModel getField(String name)
	{
		for (FieldModel f : fields)
		{
			if (f.getName().trim().equals(name.trim())) return f;
		}
		return null;
	}

	public void addField(FieldModel e)
	{
		e.setEntity(this);
		fields.add(e);
	}

	public void removeField(int index)
	{
		fields.remove(index);
	}

	public String getNamespace()
	{
		return getModel().getName() + "." + getModule().getName();
	}

	public List<FieldModel> getAllFields()
	{
		Map<String, FieldModel> result = new LinkedHashMap<String, FieldModel>();

		if (this.getExtends() != null)
		{
			for (FieldModel f : this.getExtends().getAllFields())
			{
				result.put(f.getName(), f);
			}
		}

		for (EntityModel iface : this.getImplements())
		{
			for (FieldModel f : iface.getAllFields())
			{
				result.put(f.getName(), f);
			}
		}

		for (FieldModel f : this.getFields())
		{
			result.put(f.getName(), f);
		}
		return new ArrayList<FieldModel>(result.values());
	}

	public EntityModel getExtends()
	{
		return this.getModel().getEntity(this._extends);
	}

	public List<EntityModel> getImplements()
	{
		List<EntityModel> result = new ArrayList<EntityModel>();
		if (this._implements != null) for (String name : this._implements.split(","))
		{
			if (!"".equals(name.trim())) result.add(this.module.getModel().getEntity(name));
		}
		return result;

	}

	public List<FieldModel> getFieldsOf(FieldType typeField)
	{
		List<FieldModel> result = new ArrayList<FieldModel>();
		for (FieldModel f : this.getFields())
		{
			if (f.getType().equals(typeField.getName())) result.add(f);
		}
		return result;
	}

	public FieldModel getAllField(String fieldName)
	{
		FieldModel f = getField(fieldName);
		if (f == null && this.hasExtends()) return this.getExtends().getAllField(fieldName);
		else
			return f;
	}

	public List<FieldModel> getImplementedFieldsOf(FieldType fieldType)
	{
		List<FieldModel> result = new ArrayList<FieldModel>();
		for (EntityModel em : this.getAllExtends())
		{
			result.addAll(em.getFieldsOf(fieldType));
		}
		return result;
	}

	public FieldModel getPrimaryKey()
	{
		if(this.getUniques().size() >0 )
			return this.getUniques().get(0).getFields().get(0);
		return null;
	}

	public List<EntityModel> getAllImplements()
	{
		List<EntityModel> result = new ArrayList<EntityModel>();
	
		for (EntityModel impl : this.getImplements())
		{
			result.add(impl);
			result.addAll(impl.getAllImplements());
		}

		return result;
	}

	public List<EntityModel> getAllExtends()
	{
		List<EntityModel> result = new ArrayList<EntityModel>();

		if (this.getExtends() != null)
		{
			result.add(this.getExtends());
			result.addAll(this.getExtends().getAllExtends());
		}

		return result;
	}

	public void addField(int i, FieldModel f)
	{
		this.getFields().add(i, f);
	}

	public void removeField(FieldModel field)
	{
		this.fields.remove(field);
	}

	public List<UniqueModel> getAllUniques()
	{
		//uniques may be multiple so check uniqueness of fields
		Set<UniqueModel> result = new HashSet<UniqueModel>();

		for (UniqueModel u : this.getUniques())
		{
			if (!result.contains(u)) result.add(u);
		}

		for (EntityModel m : this.getAllExtends())
		{
			for (UniqueModel u : m.getAllUniques())
			{
				if (!result.contains(u)) result.add(u);
			}
		}
		
		for (EntityModel m : this.getAllImplements())
		{
			for (UniqueModel u : m.getAllUniques())
			{
				if (!result.contains(u)) result.add(u);
			}
		}

		return new ArrayList<UniqueModel>(result);
	}

	public void setXrefLabel(List<FieldModel> labels)
	{
		String label_string = "";
		for (FieldModel label : labels)
		{
			if (!label.equals(labels.get(0)))
			{
				label_string += ",";
			}
			label_string += label.getName();
		}
		this.setXrefLabel(label_string);
	}

	public List<EntityModel> getAllDescendants()
	{
		List<EntityModel> result = new ArrayList<EntityModel>();

		for (EntityModel em : this.getModel().getEntities())
		{
			if (this.getName().equals(em.getExtends()))
			{
				result.add(em);
				result.addAll(em.getAllDescendants());
			}
		}

		return result;
	}

	public List<FieldModel> getKeyFields(int keyIndex)
	{
		if (this.getUniques().size() > keyIndex) return this.getUniques().get(keyIndex).getFields();
		return new ArrayList<FieldModel>();
	}

	// GETTERS and SETTERS
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
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public boolean getSystem()
	{
		return this.system;
	}

	public List<FieldModel> getFields()
	{
		return fields;
	}

	public void setFields(List<FieldModel> fields)
	{
		this.fields = fields;
	}

	public List<UniqueModel> getUniques()
	{
		List<UniqueModel> result = new ArrayList<UniqueModel>();

		if (hasImplements())
		{
			for (EntityModel e : getImplements())
			{
				// we need to rewrite the uniques to point to the right entity
				for (UniqueModel u : e.getUniques())
				{
					UniqueModel copy = new UniqueModel(u);
					u.setEntity(this);
					if (!result.contains(copy))
					{
						result.add(copy);
					}
				}
			}
		}

		for (UniqueModel u : this.uniques)
		{
			result.add(u);
		}
		return result;
	}

	public void setUniques(List<UniqueModel> uniques)
	{
		this.uniques = uniques;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Boolean getAbstract()
	{
		return _abstract;
	}

	public void setAbstract(Boolean _abstract)
	{
		this._abstract = _abstract;
	}

	public void setExtends(String _extends)
	{
		this._extends = _extends;
	}

	public String getDecorator()
	{
		return _decorator;
	}

	public void setDecorator(String _decorator)
	{
		this._decorator = _decorator;
	}

	public Boolean getAssociation()
	{
		return association;
	}

	public void setAssociation(Boolean association)
	{
		this.association = association;
	}

	public String getXrefLabel()
	{
		if (xref_label == null)
		{
			//return this.getPrimaryKey().getName();
		}
		return xref_label;
	}

	public void setXrefLabel(String xref_label)
	{
		this.xref_label = xref_label;
	}

	public List<FieldModel> getImplementedFields()
	{
		Map<String,FieldModel> result = new LinkedHashMap<String,FieldModel>();
		
		for (EntityModel i : this.getImplements())
		{
			for(FieldModel f: i.getAllFields())
			{
				if(!result.containsKey(f.getName())) result.put(f.getName(), f);
			}
		}
		
		for(FieldModel f: this.getFields())
		{
			if(!result.containsKey(f.getName()))  result.put(f.getName(), f);
		}

		return new ArrayList<FieldModel>(result.values());
	}

	public void setImplements(String _implements)
	{
		this._implements = _implements;
	}

	public void validateExtendsAndImplements(MolgenisModel model) throws MolgenisModelException
	{
		logger.debug("validate 'extends' and 'implements' relationships...");

		List<EntityModel> ifaces = this.getAllImplements();
		for (EntityModel iface : ifaces)
		{
			if (!iface.getAbstract()) throw new MolgenisModelException(this.getName() + " cannot implement " + iface.getName() + " because it is not abstract");

			// copy primary key and xref_label from interface to subclass,
			// a primary key can have only one field.
			// usually it is a auto_number int
			// composite keys are ignored
			try
			{
				FieldModel pkeyField = null;
				if (iface.getUniques().size() > 0 && iface.getUniques().get(0).getFields().size() == 1)
				{
					pkeyField = iface.getUniques().get(0).getFields().get(0);
					// if not already exists
					if (this.getField(pkeyField.getName()) == null)
					{
						FieldModel field = new FieldModel(pkeyField);
						field.setEntity(this);
						field.setAuto(pkeyField.getAuto());
						field.setNillable(pkeyField.getNillable());
						field.setReadonly(pkeyField.getReadonly());

						field.setSystem(true);
						field.setXrefEntity(iface.getName());
						field.setHidden(true);

						logger.debug("copy primary key " + field.getName() + " from interface " + iface.getName() + " to " + this.getName());
						this.addField(field);
					}
				}

			}
			catch (Exception e)
			{
				e.printStackTrace();
				throw new MolgenisModelException(e.getMessage());
			}
		}

		EntityModel parent = this.getExtends();

		if (parent == null) throw new MolgenisModelException("superclass '" + this.getExtends() + "' for '" + this.getName() + "' is missing");

		if (parent != null)
		{
			if (parent.getAbstract()) throw new MolgenisModelException(this.getName() + " cannot extend " + parent.getName() + " because superclas " + parent.getName() + " is abstract (use implements)");
			if (this.getAbstract()) throw new MolgenisModelException(this.getName() + " cannot extend " + parent.getName() + " because " + this.getName() + " itself is abstract");
		}
	}

	/**
	 * Copy fields to subclasses (redundantly) so this field can be part of an
	 * extra constraint. E.g. a superclass has non-unique field 'name'; in the
	 * subclass it is said to be unique and a copy is made to capture this
	 * constraint in the table for the subclass.
	 * 
	 * @param model
	 * @throws MolgenisModelException
	 */
	public void copyFieldsToSubclassToEnforceConstraints(MolgenisModel model) throws MolgenisModelException
	{
		logger.debug("copy fields to subclass for constrain checking...");

		// copy keyfields to subclasses to ensure that keys can be
		// enforced (if the key includes superclass fields).
		if (this.getExtends() != null)
		{
			for (UniqueModel aKey : this.getUniques())
			{
				for (FieldModel f : aKey.getFields())
				{
					if (this.getField(f.getName()) == null)
					{
						// copy the field
						FieldModel copy = new FieldModel(f);
						copy.setEntity(this);
						copy.setAuto(f.getAuto());
						copy.setSystem(true);
						this.addField(copy);

						logger.warn(aKey.toString() + " cannot be enforced on " + this.getName() + ", copying " + f.getEntity().getName() + "." + f.getName() + " to subclass as " + copy.getName());
					}
				}
			}
		}
	}

	public void addUnique(List<String> unique, Boolean isSubclass)
	{
		UniqueModel u = new UniqueModel();
		u.setSubclass(isSubclass);
		String unique_fields = "";
		for (String key : unique)
		{
			if (!key.equals(unique.get(0))) unique_fields += ",";
			unique_fields += key;
		}
		u.setFields(unique_fields);
		this.getUniques().add(u);
	}

	public void addUnique(String field, String description)
	{
		UniqueModel u = new UniqueModel();
		u.setDescription(description);
		u.setFields(field);
		getUniques().add(u);
	}

	public void addUnique(Vector<String> unique)
	{
		this.addUnique(unique, false);
	}

	public MolgenisModel getModel()
	{
		return this.getModule().getModel();
	}

	public boolean hasImplements()
	{
		return this.getImplements().size() > 0;
	}

	public Boolean hasExtends()
	{
		return this.getExtends() != null;
	}

	/**
	 * Returns the root of the entity hierarchy this entity belongs to.
	 * 
	 * @return Entity
	 */
	public EntityModel getRootAncestor()
	{
		if (this.getExtends() != null)
		{
			return this.getExtends().getRootAncestor();
		}
		else
		{
			return this;
		}
	}

	public ModuleModel getModule()
	{
		return module;
	}

	public void setModule(ModuleModel module)
	{
		this.module = module;
	}

	public boolean isRootAncestor()
	{
		return this.equals(this.getRootAncestor());
	}

	public void addUnique(int i, UniqueModel m)
	{
		this.uniques.add(i, m);
	}

	public List<FieldModel> getInheritedFields()
	{
		if (this.hasExtends()) return getExtends().getAllFields();
		return new ArrayList<FieldModel>();
	}

	public List<UniqueModel> getUniqueKeysWithoutPk() throws MolgenisModelException
	{
		List<UniqueModel> result = new ArrayList<UniqueModel>();

		if (hasImplements())
		{
			for (EntityModel e : getImplements())
			{
				// we need to rewrite the uniques to point to the right entity
				for (UniqueModel u : e.getUniques())
				{
					if (u.getFields().get(0).getAuto())
					{
						continue;
					}
					UniqueModel copy = new UniqueModel(u);
					u.setEntity(this);
					if (!result.contains(copy))
					{
						result.add(copy);
					}
				}
			}
		}

		for (UniqueModel u : this.getUniques())
		{
			if (u.getFields().get(0).getAuto())
			{
				continue;
			}
			result.add(u);
		}
		return result;
	}

	public boolean hasDescendants()
	{
		return getDescendants().size() > 0;
	}

	/**
	 * Get the subclasses of this entity.
	 */
	public List<EntityModel> getDescendants()
	{
		Vector<EntityModel> descendants = new Vector<EntityModel>();

		// get the model
		for (EntityModel e : getModel().getEntities())
		{
			if (e.hasExtends() && e.getExtends().getName().equals(getName()))
			{
				descendants.add(e);
			}
		}

		return descendants;
	}

	public List<IndexModel> getIndices()
	{
		return indices;
	}

	public void setIndices(List<IndexModel> indices)
	{
		this.indices = indices;
	}
	
	public String toString()
	{
		return String.format("entity(name=%s)", this.getName());
	}
}
