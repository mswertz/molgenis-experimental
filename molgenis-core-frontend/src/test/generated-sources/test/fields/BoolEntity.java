
/* File:        test/model/BoolEntity.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.fields;

/**
 * BoolEntity: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "BoolEntity"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.fields.db.BoolEntityEntityListener.class})
public class BoolEntity extends org.molgenis.db.common.AbstractEntity 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String __TYPE = "__type";
	public final static String ID = "id";
	public final static String NORMALBOOL = "normalBool";
	public final static String READONLYBOOL = "readonlyBool";
	public final static String NILLABLEBOOL = "nillableBool";
	public final static String DEFAULTBOOL = "defaultBool";
	
	//static methods
	/**
	 * Shorthand for db.query(BoolEntity.class).
	 */
	public static org.molgenis.db.Query<? extends BoolEntity> query(org.molgenis.db.Database db)
	{
		return db.query(BoolEntity.class);
	}
	
	/**
	 * Shorthand for db.find(BoolEntity.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends BoolEntity> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(BoolEntity.class, rules);
	}	
	
	/**
	 * BoolEntity
	 */
	public static BoolEntity findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<BoolEntity> q = db.query(BoolEntity.class);
		q.eq(BoolEntity.ID, id);
		java.util.List<BoolEntity> result = q.find();
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


	//No description provided[type=bool]
	@javax.persistence.Column(name="normalBool", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="normalBool")
	
				

	@javax.validation.constraints.NotNull
	private Boolean normalBool =  null;


	//No description provided[type=bool]
	@javax.persistence.Column(name="readonlyBool", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="readonlyBool")
	
				

	@javax.validation.constraints.NotNull
	private Boolean readonlyBool =  null;


	//No description provided[type=bool]
	@javax.persistence.Column(name="nillableBool")
	@javax.xml.bind.annotation.XmlElement(name="nillableBool")
	
				

	private Boolean nillableBool =  null;


	//No description provided[type=bool]
	@javax.persistence.Column(name="defaultBool", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="defaultBool")
	
				

	@javax.validation.constraints.NotNull
	private Boolean defaultBool =  true;

	//constructors
	public BoolEntity()
	{
	
		//options for enum __Type
		__type_options.add(new org.molgenis.db.common.ValueLabel("[BoolEntity]","[BoolEntity]"));
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
	 * @return normalBool.
	 */
	public Boolean getNormalBool()
	{
		return this.normalBool;
	}
	
	@Deprecated
	public Boolean getNormalBool(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param normalBool
	 */
	public void setNormalBool( Boolean normalBool)
	{
		
		this.normalBool = normalBool;
	}

	

	/**
	 * Get the No description provided.
	 * @return readonlyBool.
	 */
	public Boolean getReadonlyBool()
	{
		return this.readonlyBool;
	}
	
	@Deprecated
	public Boolean getReadonlyBool(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param readonlyBool
	 */
	public void setReadonlyBool( Boolean readonlyBool)
	{
		
		this.readonlyBool = readonlyBool;
	}

	

	/**
	 * Get the No description provided.
	 * @return nillableBool.
	 */
	public Boolean getNillableBool()
	{
		return this.nillableBool;
	}
	
	@Deprecated
	public Boolean getNillableBool(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param nillableBool
	 */
	public void setNillableBool( Boolean nillableBool)
	{
		
		this.nillableBool = nillableBool;
	}

	

	/**
	 * Get the No description provided.
	 * @return defaultBool.
	 */
	public Boolean getDefaultBool()
	{
		return this.defaultBool;
	}
	
	@Deprecated
	public Boolean getDefaultBool(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param defaultBool
	 */
	public void setDefaultBool( Boolean defaultBool)
	{
		
		this.defaultBool = defaultBool;
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
		if (name.toLowerCase().equals("normalbool"))
			return getNormalBool();
		if (name.toLowerCase().equals("readonlybool"))
			return getReadonlyBool();
		if (name.toLowerCase().equals("nillablebool"))
			return getNillableBool();
		if (name.toLowerCase().equals("defaultbool"))
			return getDefaultBool();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getNormalBool() == null) throw new org.molgenis.db.common.DatabaseException("required field normalBool is null");
		if(this.getReadonlyBool() == null) throw new org.molgenis.db.common.DatabaseException("required field readonlyBool is null");
		if(this.getDefaultBool() == null) throw new org.molgenis.db.common.DatabaseException("required field defaultBool is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("BoolEntity___type") != null) this.set__Type(tuple.getString("BoolEntity___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("BoolEntity_id") != null) this.setId(tuple.getInt("BoolEntity_id"));
			//set NormalBool
			if( strict || tuple.getBoolean("normalBool") != null) this.setNormalBool(tuple.getBoolean("normalBool"));
			if( tuple.getBoolean("BoolEntity_normalBool") != null) this.setNormalBool(tuple.getBoolean("BoolEntity_normalBool"));
			//set ReadonlyBool
			if( strict || tuple.getBoolean("readonlyBool") != null) this.setReadonlyBool(tuple.getBoolean("readonlyBool"));
			if( tuple.getBoolean("BoolEntity_readonlyBool") != null) this.setReadonlyBool(tuple.getBoolean("BoolEntity_readonlyBool"));
			//set NillableBool
			if( strict || tuple.getBoolean("nillableBool") != null) this.setNillableBool(tuple.getBoolean("nillableBool"));
			if( tuple.getBoolean("BoolEntity_nillableBool") != null) this.setNillableBool(tuple.getBoolean("BoolEntity_nillableBool"));
			//set DefaultBool
			if( strict || tuple.getBoolean("defaultBool") != null) this.setDefaultBool(tuple.getBoolean("defaultBool"));
			if( tuple.getBoolean("BoolEntity_defaultBool") != null) this.setDefaultBool(tuple.getBoolean("BoolEntity_defaultBool"));
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
		String result = "BoolEntity(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= "normalBool='" + getNormalBool()+"' ";	
		result+= "readonlyBool='" + getReadonlyBool()+"' ";	
		result+= "nillableBool='" + getNillableBool()+"' ";	
		result+= "defaultBool='" + getDefaultBool()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of BoolEntity.
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
			fields.add("normalBool");
		}
		{
			fields.add("readonlyBool");
		}
		{
			fields.add("nillableBool");
		}
		{
			fields.add("defaultBool");
		}
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
		result.add("id");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "__type" +sep
		+ "id" +sep
		+ "normalBool" +sep
		+ "readonlyBool" +sep
		+ "nillableBool" +sep
		+ "defaultBool" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        
        return null;
    }	

	@Override
	public boolean equals(Object obj) {
   		if (obj == null) { return false; }
   		if (obj == this) { return true; }
   		if (obj.getClass() != getClass()) {
     		return false;
   		}
		BoolEntity rhs = (BoolEntity) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
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
			Object valueO = getNormalBool();
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
			Object valueO = getReadonlyBool();
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
			Object valueO = getNillableBool();
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
			Object valueO = getDefaultBool();
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
	public BoolEntity create(org.molgenis.db.Tuple tuple) throws Exception
	{
		BoolEntity e = new BoolEntity();
		e.set(tuple);
		return e;
	}
	


	
}

