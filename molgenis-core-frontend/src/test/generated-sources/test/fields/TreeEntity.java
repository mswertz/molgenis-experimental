
/* File:        test/model/TreeEntity.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.fields;

/**
 * TreeEntity: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "TreeEntity", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "name" }), @javax.persistence.UniqueConstraint( columnNames={ "name" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.fields.db.TreeEntityEntityListener.class})
public class TreeEntity extends org.molgenis.db.common.AbstractEntity 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String __TYPE = "__type";
	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String PARENT = "parent";
	public final static String PARENT_NAME = "parent_name";
	
	//static methods
	/**
	 * Shorthand for db.query(TreeEntity.class).
	 */
	public static org.molgenis.db.Query<? extends TreeEntity> query(org.molgenis.db.Database db)
	{
		return db.query(TreeEntity.class);
	}
	
	/**
	 * Shorthand for db.find(TreeEntity.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends TreeEntity> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(TreeEntity.class, rules);
	}	
	
	/**
	 * TreeEntity
	 */
	public static TreeEntity findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<TreeEntity> q = db.query(TreeEntity.class);
		q.eq(TreeEntity.ID, id);
		java.util.List<TreeEntity> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * TreeEntity
	 */
	public static TreeEntity findByName(org.molgenis.db.Database db, String name) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<TreeEntity> q = db.query(TreeEntity.class);
		q.eq(TreeEntity.NAME, name);
		java.util.List<TreeEntity> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//Subtypes have to be set to allow searching[type=enum]
	@javax.persistence.Column(name="__type", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="__type")
	
				

	@javax.validation.constraints.NotNull
	private String __type =  null;
	@javax.persistence.Transient
	private String __type_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.db.common.ValueLabel> __type_options = new java.util.ArrayList<org.molgenis.db.common.ValueLabel>();


	//No description provided[type=int]
    @javax.persistence.Id @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Column(name="id", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="id")
	
	//@javax.validation.constraints.NotNull
	private Integer id =  null;


	//No description provided[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="name", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	@javax.validation.constraints.NotNull
	private String name =  null;


	//No description provided[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="parent")   	
	
				

	private test.fields.TreeEntity parent = null;
	@javax.persistence.Transient
	private Integer parent_id = null;	
	
	@javax.persistence.Transient
	private String parent_name = null;						


	//constructors
	public TreeEntity()
	{
	
		//options for enum __Type
		__type_options.add(new org.molgenis.db.common.ValueLabel("[TreeEntity]","[TreeEntity]"));
	}
	
	//getters and setters
	/**
	 * Get the Subtypes have to be set to allow searching.
	 * @return __type.
	 */
	public String get__Type()
	{
		return this.__type;
	}
	
	@Deprecated
	public String get__Type(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Subtypes have to be set to allow searching.
	 * @param __type
	 */
	public void set__Type( String __type)
	{
		
		this.__type = __type;
	}

	
	/**
	 * Get tha label for enum __Type.
	 */
	public String get__TypeLabel()
	{
		return this.__type_label;
	}
	
	/**
	 * __Type is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.db.common.ValueLabel> get__TypeOptions()
	{
		return __type_options;
	}	
	

	/**
	 * Get the No description provided.
	 * @return id.
	 */
	public Integer getId()
	{
		return this.id;
	}
	
	
	/**
	 * Set the No description provided.
	 * @param id
	 */
	public void setId( Integer id)
	{
		this.id = id;
	}

	

	/**
	 * Get the No description provided.
	 * @return name.
	 */
	public String getName()
	{
		return this.name;
	}
	
	@Deprecated
	public String getName(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param name
	 */
	public void setName( String name)
	{
		
		this.name = name;
	}

	

	/**
	 * Get the No description provided.
	 * @return parent.
	 */
	public test.fields.TreeEntity getParent()
	{
		return this.parent;
	}
	
	@Deprecated
	public test.fields.TreeEntity getParent(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param parent
	 */
	public void setParent( test.fields.TreeEntity parent)
	{
		
		this.parent = parent;
	}

	
	
	/**
	 * Set foreign key for field parent.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setParent_Id(Integer parent_id)
	{
		this.parent_id = parent_id;
	}	

	public void setParent(Integer parent_id)
	{
		this.parent_id = parent_id;
	}
	
	public Integer getParent_Id()
	{
		
		if(parent != null) 
		{
			return parent.getId();
		}
		else
		{
			return parent_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Parent to TreeEntity.Id.
	 */
	public String getParent_Name()
	{		
		//FIXME should we auto-load based on getParent()?	
		if(parent != null) {
			return parent.getName();
		} else {
			return parent_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Parent to <a href="TreeEntity.html#Id">TreeEntity.Id</a>.
	 * Implies setParent(null) until save
	 */
	public void setParent_Name(String parent_name)
	{
		this.parent_name = parent_name;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("__type"))
			return get__Type();
		if(name.toLowerCase().equals("__type_label"))
			return get__TypeLabel();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("name"))
			return getName();
		if (name.toLowerCase().equals("parent"))
			return getParent();
		if(name.toLowerCase().equals("parent_id"))
			return getParent_Id();
		if(name.toLowerCase().equals("parent_name"))
			return getParent_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getName() == null) throw new org.molgenis.db.common.DatabaseException("required field name is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("TreeEntity___type") != null) this.set__Type(tuple.getString("TreeEntity___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("TreeEntity_id") != null) this.setId(tuple.getInt("TreeEntity_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("TreeEntity_name") != null) this.setName(tuple.getString("TreeEntity_name"));
			//set Parent
			if( strict || tuple.getInt("parent_id") != null) this.setParent(tuple.getInt("parent_id"));
			if( tuple.getInt("TreeEntity_parent_id") != null) this.setParent(tuple.getInt("TreeEntity_parent_id"));
			//alias of xref
			if( tuple.getObject("parent") != null) this.setParent(tuple.getInt("parent"));
			if( tuple.getObject("TreeEntity_parent") != null) this.setParent(tuple.getInt("TreeEntity_parent"));
			//set label for field Parent
			if( strict || tuple.getObject("parent_name") != null) this.setParent_Name(tuple.getString("parent_name"));			
			if( tuple.getObject("TreeEntity_parent_FieldModel(entity=TreeEntity, name=name, type=varchar[null], auto=false, nillable=false, readonly=false, unique=true, default=null)") != null ) this.setParent_Name(tuple.getString("TreeEntity_parent_name"));		
		}
		//org.apache.log4j.Logger.getLogger("test").debug("set "+this);
	}
	
	
	
	

	@Override
	public String toString()
	{
		return this.toString(false);
	}
	
	public String toString(boolean verbose)
	{
		String result = "TreeEntity(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= " parent_id='" + getParent_Id()+"' ";	
		result+= " parent_name='" + getParent_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of TreeEntity.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		{
			fields.add("__type");
		}
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("name");
		}
		{
			fields.add("parent_id");
		}
		fields.add("parent_name");
		return fields;
	}	

	public java.util.Vector<String> getFields()
	{
		return getFields(false);
	}

	@Override
	public String getIdField()
	{
		return "id";
	}
	

	
	@Override
	public java.util.List<String> getLabelFields()
	{
		java.util.List<String> result = new java.util.ArrayList<String>();
		result.add("name");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "__type" +sep
		+ "id" +sep
		+ "name" +sep
		+ "parent" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("parent")) {
            return "id";
        }
        
        return null;
    }	

	@Override
	public boolean equals(Object obj) {
   		if (obj == null) { return false; }
   		if (obj == this) { return true; }
   		if (obj.getClass() != getClass()) {
     		return false;
   		}
		TreeEntity rhs = (TreeEntity) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//name
				.append(name, rhs.getName())
		//name
				.append(name, rhs.getName())
                .isEquals();
  	}

  	@Override
    public int hashCode() {
    	int firstNumber = this.getClass().getName().hashCode();
    	int secondNumber = this.getClass().getSimpleName().hashCode();
    	if(firstNumber % 2 == 0) {
    	  firstNumber += 1;
    	}
    	if(secondNumber % 2 == 0) {
    		secondNumber += 1;
    	}
    
		return new org.apache.commons.lang.builder.HashCodeBuilder(firstNumber, secondNumber)
				.append(name)
				.append(name)
   			.toHashCode();
    }  	
  	


	@Deprecated
	public String getValues(String sep)
	{
		java.io.StringWriter out = new java.io.StringWriter();
		{
			Object valueO = get__Type();
			String valueS;
			if (valueO != null)
				valueS = valueO.toString();
			else 
				valueS = "";
			valueS = valueS.replaceAll("\r\n"," ").replaceAll("\n"," ").replaceAll("\r"," ");
			valueS = valueS.replaceAll("\t"," ").replaceAll(sep," ");
			out.write(valueS+sep);
		}
		{
			Object valueO = getId();
			String valueS;
			if (valueO != null)
				valueS = valueO.toString();
			else 
				valueS = "";
			valueS = valueS.replaceAll("\r\n"," ").replaceAll("\n"," ").replaceAll("\r"," ");
			valueS = valueS.replaceAll("\t"," ").replaceAll(sep," ");
			out.write(valueS+sep);
		}
		{
			Object valueO = getName();
			String valueS;
			if (valueO != null)
				valueS = valueO.toString();
			else 
				valueS = "";
			valueS = valueS.replaceAll("\r\n"," ").replaceAll("\n"," ").replaceAll("\r"," ");
			valueS = valueS.replaceAll("\t"," ").replaceAll(sep," ");
			out.write(valueS+sep);
		}
		{
			Object valueO = getParent();
			String valueS;
			if (valueO != null)
				valueS = valueO.toString();
			else 
				valueS = "";
			valueS = valueS.replaceAll("\r\n"," ").replaceAll("\n"," ").replaceAll("\r"," ");
			valueS = valueS.replaceAll("\t"," ").replaceAll(sep," ");
			out.write(valueS);
		}
		return out.toString();
	}
	
	@Override
	public TreeEntity create(org.molgenis.db.Tuple tuple) throws Exception
	{
		TreeEntity e = new TreeEntity();
		e.set(tuple);
		return e;
	}
	
//1
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="parent"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<test.fields.TreeEntity> parentTreeEntityCollection = new java.util.ArrayList<test.fields.TreeEntity>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<test.fields.TreeEntity> getParentTreeEntityCollection()
	{
            return parentTreeEntityCollection;
	}

    public void setParentTreeEntityCollection(java.util.Collection<test.fields.TreeEntity> collection)
    {
        for (test.fields.TreeEntity treeEntity : collection) {
            treeEntity.setParent(this);
        }
        parentTreeEntityCollection = collection;
    }	


	
}

