package org.molgenis.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.molgenis.MolgenisGenerator;
import org.molgenis.MolgenisModel;

@XmlAccessorType(XmlAccessType.FIELD)
public class ModuleModel
{
	@XmlAttribute
	private String name;
	
	@XmlElement
	private String description;
	
	@XmlTransient
	private MolgenisModel model;
	
	@XmlElement(name="entity")
	private List<EntityModel> entities = new ArrayList<EntityModel>();
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public synchronized List<EntityModel> getEntities()
	{
		return entities;
	}

	public synchronized void setEntities(List<EntityModel> entities)
	{
		this.entities = entities;
	}
	
	public EntityModel getEntity(String name)
	{
		if(name != null) for (EntityModel entity : entities)
		{
			if (entity.getName().toLowerCase().equals(name.toLowerCase()))
				return entity;
		}
		return null;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public MolgenisModel getModel()
	{
		return model;
	}

	public void setModel(MolgenisModel model)
	{
		this.model = model;
	}
}
