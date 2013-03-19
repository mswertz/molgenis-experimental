
/* File:        test/model/IntEntity.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.fields;

/**
 * IntEntity: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "IntEntity"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.fields.db.IntEntityEntityListener.class})
public class IntEntity extends org.molgenis.db.common.AbstractEntity 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String __TYPE = "__type";
	public final static String ID = "id";
	public final static String NORMALINT = "normalInt";
	public final static String READONLYINT = "readonlyInt";
	public final static String NILLABLEINT = "nillableInt";
	public final static String DEFAULTINT = "defaultInt";
	
	//static methods
	/**
	 * Shorthand for db.query(IntEntity.class).
	 */
	public static org.molgenis.db.Query<? extends IntEntity> query(org.molgenis.db.Database db)
	{
		return db.query(IntEntity.class);
	}
	
	/**
	 * Shorthand for db.find(IntEntity.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends IntEntity> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(IntEntity.class, rules);
	}	
	
	/**
	 * IntEntity
	 */
	public static IntEntity findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<IntEntity> q = db.query(IntEntity.class);
		q.eq(IntEntity.ID, id);
		java.util.List<IntEntity> result = q.find();
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


	//No description provided[type=int]
	@javax.persistence.Column(name="normalInt", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="normalInt")
	
				

	@javax.validation.constraints.NotNull
	private Integer normalInt =  null;


	//No description provided[type=int]
	@javax.persistence.Column(name="readonlyInt", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="readonlyInt")
	
				

	@javax.validation.constraints.NotNull
	private Integer readonlyInt =  1;


	//No description provided[type=int]
	@javax.persistence.Column(name="nillableInt")
	@javax.xml.bind.annotation.XmlElement(name="nillableInt")
	
				

	private Integer nillableInt =  null;


	//No description provided[type=int]
	@javax.persistence.Column(name="defaultInt", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="defaultInt")
	
				

	@javax.validation.constraints.NotNull
	private Integer defaultInt =  1;

	//constructors
	public IntEntity()
	{
	
		//options for enum __Type
		__type_options.add(new org.molgenis.db.common.ValueLabel("[IntEntity]","[IntEntity]"));
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
	 * @return normalInt.
	 */
	public Integer getNormalInt()
	{
		return this.normalInt;
	}
	
	@Deprecated
	public Integer getNormalInt(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param normalInt
	 */
	public void setNormalInt( Integer normalInt)
	{
		
		this.normalInt = normalInt;
	}

	

	/**
	 * Get the No description provided.
	 * @return readonlyInt.
	 */
	public Integer getReadonlyInt()
	{
		return this.readonlyInt;
	}
	
	@Deprecated
	public Integer getReadonlyInt(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param readonlyInt
	 */
	public void setReadonlyInt( Integer readonlyInt)
	{
		
		this.readonlyInt = readonlyInt;
	}

	

	/**
	 * Get the No description provided.
	 * @return nillableInt.
	 */
	public Integer getNillableInt()
	{
		return this.nillableInt;
	}
	
	@Deprecated
	public Integer getNillableInt(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param nillableInt
	 */
	public void setNillableInt( Integer nillableInt)
	{
		
		this.nillableInt = nillableInt;
	}

	

	/**
	 * Get the No description provided.
	 * @return defaultInt.
	 */
	public Integer getDefaultInt()
	{
		return this.defaultInt;
	}
	
	@Deprecated
	public Integer getDefaultInt(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param defaultInt
	 */
	public void setDefaultInt( Integer defaultInt)
	{
		
		this.defaultInt = defaultInt;
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
		if (name.toLowerCase().equals("normalint"))
			return getNormalInt();
		if (name.toLowerCase().equals("readonlyint"))
			return getReadonlyInt();
		if (name.toLowerCase().equals("nillableint"))
			return getNillableInt();
		if (name.toLowerCase().equals("defaultint"))
			return getDefaultInt();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getNormalInt() == null) throw new org.molgenis.db.common.DatabaseException("required field normalInt is null");
		if(this.getReadonlyInt() == null) throw new org.molgenis.db.common.DatabaseException("required field readonlyInt is null");
		if(this.getDefaultInt() == null) throw new org.molgenis.db.common.DatabaseException("required field defaultInt is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("IntEntity___type") != null) this.set__Type(tuple.getString("IntEntity___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("IntEntity_id") != null) this.setId(tuple.getInt("IntEntity_id"));
			//set NormalInt
			if( strict || tuple.getInt("normalInt") != null) this.setNormalInt(tuple.getInt("normalInt"));
			if( tuple.getInt("IntEntity_normalInt") != null) this.setNormalInt(tuple.getInt("IntEntity_normalInt"));
			//set ReadonlyInt
			if( strict || tuple.getInt("readonlyInt") != null) this.setReadonlyInt(tuple.getInt("readonlyInt"));
			if( tuple.getInt("IntEntity_readonlyInt") != null) this.setReadonlyInt(tuple.getInt("IntEntity_readonlyInt"));
			//set NillableInt
			if( strict || tuple.getInt("nillableInt") != null) this.setNillableInt(tuple.getInt("nillableInt"));
			if( tuple.getInt("IntEntity_nillableInt") != null) this.setNillableInt(tuple.getInt("IntEntity_nillableInt"));
			//set DefaultInt
			if( strict || tuple.getInt("defaultInt") != null) this.setDefaultInt(tuple.getInt("defaultInt"));
			if( tuple.getInt("IntEntity_defaultInt") != null) this.setDefaultInt(tuple.getInt("IntEntity_defaultInt"));
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
		String result = "IntEntity(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= "normalInt='" + getNormalInt()+"' ";	
		result+= "readonlyInt='" + getReadonlyInt()+"' ";	
		result+= "nillableInt='" + getNillableInt()+"' ";	
		result+= "defaultInt='" + getDefaultInt()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of IntEntity.
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
			fields.add("normalInt");
		}
		{
			fields.add("readonlyInt");
		}
		{
			fields.add("nillableInt");
		}
		{
			fields.add("defaultInt");
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
		+ "normalInt" +sep
		+ "readonlyInt" +sep
		+ "nillableInt" +sep
		+ "defaultInt" 
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
		IntEntity rhs = (IntEntity) obj;
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
			Object valueO = getNormalInt();
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
			Object valueO = getReadonlyInt();
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
			Object valueO = getNillableInt();
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
			Object valueO = getDefaultInt();
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
	public IntEntity create(org.molgenis.db.Tuple tuple) throws Exception
	{
		IntEntity e = new IntEntity();
		e.set(tuple);
		return e;
	}
	


	
}

