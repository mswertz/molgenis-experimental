package org.molgenis.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class UniqueModel
{
	@XmlTransient
	EntityModel entity;

	@XmlAttribute(name = "fields")
	String fields = null;

	@XmlAttribute(name = "description")
	String description;

	@XmlAttribute(name = "subclass")
	Boolean subclass;

	public UniqueModel()
	{

	}

	public UniqueModel(UniqueModel u)
	{
		this.entity = u.getEntity();
		this.fields = "";
		for (FieldModel f : u.getFields())
		{
			this.fields += "," + f.getName();
		}
		this.fields = this.fields.substring(1);
		this.description = u.getDescription();
		this.subclass = u.getSubclass();
	}

	// GETTERS AND SETTERS BELOW
	public void setFields(String fields)
	{
		this.fields = fields;
	}

	public List<FieldModel> getFields()
	{
		List<FieldModel> result = new ArrayList<FieldModel>();
		for (FieldModel f : entity.getAllFields())
		{
			for (String name : this.fields.split(","))
			{
				if (name.trim().equals(f.getName())) result.add(f);
			}
		}
		return result;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Boolean getSubclass()
	{
		return subclass;
	}

	public void setSubclass(Boolean subclass)
	{
		this.subclass = subclass;
	}

	public EntityModel getEntity()
	{
		return entity;
	}

	public void setEntity(EntityModel entity)
	{
		this.entity = entity;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		return result;
	}

	/**
	 * Two uniques are equal if they address the same fields
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		UniqueModel other = (UniqueModel) obj;
		if (fields == null)
		{
			if (other.fields != null) return false;
		}
		else if (!fields.equals(other.fields)) return false;
		return true;
	}
}
