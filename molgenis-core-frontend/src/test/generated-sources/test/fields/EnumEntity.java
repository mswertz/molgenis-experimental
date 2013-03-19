
/* File:        test/model/EnumEntity.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.fields;

/**
 * EnumEntity: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "EnumEntity"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.fields.db.EnumEntityEntityListener.class})
public class EnumEntity extends org.molgenis.db.common.AbstractEntity 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String __TYPE = "__type";
	public final static String ID = "id";
	public final static String NORMALENUM = "normalEnum";
	public final static String READONLYENUM = "readonlyEnum";
	public final static String NILLABLEENUM = "nillableEnum";
	public final static String DEFAULTENUM = "defaultEnum";
	
	//static methods
	/**
	 * Shorthand for db.query(EnumEntity.class).
	 */
	public static org.molgenis.db.Query<? extends EnumEntity> query(org.molgenis.db.Database db)
	{
		return db.query(EnumEntity.class);
	}
	
	/**
	 * Shorthand for db.find(EnumEntity.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends EnumEntity> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(EnumEntity.class, rules);
	}	
	
	/**
	 * EnumEntity
	 */
	public static EnumEntity findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<EnumEntity> q = db.query(EnumEntity.class);
		q.eq(EnumEntity.ID, id);
		java.util.List<EnumEntity> result = q.find();
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


	//No description provided[type=enum]
	@javax.persistence.Column(name="normalEnum", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="normalEnum")
	
				

	@javax.validation.constraints.NotNull
	private String normalEnum =  null;
	@javax.persistence.Transient
	private String normalEnum_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.db.common.ValueLabel> normalEnum_options = new java.util.ArrayList<org.molgenis.db.common.ValueLabel>();


	//No description provided[type=enum]
	@javax.persistence.Column(name="readonlyEnum", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="readonlyEnum")
	
				

	@javax.validation.constraints.NotNull
	private String readonlyEnum =  null;
	@javax.persistence.Transient
	private String readonlyEnum_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.db.common.ValueLabel> readonlyEnum_options = new java.util.ArrayList<org.molgenis.db.common.ValueLabel>();


	//No description provided[type=enum]
	@javax.persistence.Column(name="nillableEnum")
	@javax.xml.bind.annotation.XmlElement(name="nillableEnum")
	
				

	private String nillableEnum =  null;
	@javax.persistence.Transient
	private String nillableEnum_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.db.common.ValueLabel> nillableEnum_options = new java.util.ArrayList<org.molgenis.db.common.ValueLabel>();


	//No description provided[type=enum]
	@javax.persistence.Column(name="defaultEnum", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="defaultEnum")
	
				

	@javax.validation.constraints.NotNull
	private String defaultEnum =  "b";
	@javax.persistence.Transient
	private String defaultEnum_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.db.common.ValueLabel> defaultEnum_options = new java.util.ArrayList<org.molgenis.db.common.ValueLabel>();

	//constructors
	public EnumEntity()
	{
	
		//options for enum __Type
		__type_options.add(new org.molgenis.db.common.ValueLabel("[EnumEntity]","[EnumEntity]"));
		//options for enum NormalEnum
		normalEnum_options.add(new org.molgenis.db.common.ValueLabel("[a","[a"));
		normalEnum_options.add(new org.molgenis.db.common.ValueLabel("b","b"));
		normalEnum_options.add(new org.molgenis.db.common.ValueLabel("c]","c]"));
		//options for enum ReadonlyEnum
		readonlyEnum_options.add(new org.molgenis.db.common.ValueLabel("[a","[a"));
		readonlyEnum_options.add(new org.molgenis.db.common.ValueLabel("b","b"));
		readonlyEnum_options.add(new org.molgenis.db.common.ValueLabel("c]","c]"));
		//options for enum NillableEnum
		nillableEnum_options.add(new org.molgenis.db.common.ValueLabel("[a","[a"));
		nillableEnum_options.add(new org.molgenis.db.common.ValueLabel("b","b"));
		nillableEnum_options.add(new org.molgenis.db.common.ValueLabel("c]","c]"));
		//options for enum DefaultEnum
		defaultEnum_options.add(new org.molgenis.db.common.ValueLabel("[a","[a"));
		defaultEnum_options.add(new org.molgenis.db.common.ValueLabel("b","b"));
		defaultEnum_options.add(new org.molgenis.db.common.ValueLabel("c]","c]"));
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
	 * @return normalEnum.
	 */
	public String getNormalEnum()
	{
		return this.normalEnum;
	}
	
	@Deprecated
	public String getNormalEnum(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param normalEnum
	 */
	public void setNormalEnum( String normalEnum)
	{
		
		this.normalEnum = normalEnum;
	}

	
	/**
	 * Get tha label for enum NormalEnum.
	 */
	public String getNormalEnumLabel()
	{
		return this.normalEnum_label;
	}
	
	/**
	 * NormalEnum is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.db.common.ValueLabel> getNormalEnumOptions()
	{
		return normalEnum_options;
	}	
	

	/**
	 * Get the No description provided.
	 * @return readonlyEnum.
	 */
	public String getReadonlyEnum()
	{
		return this.readonlyEnum;
	}
	
	@Deprecated
	public String getReadonlyEnum(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param readonlyEnum
	 */
	public void setReadonlyEnum( String readonlyEnum)
	{
		
		this.readonlyEnum = readonlyEnum;
	}

	
	/**
	 * Get tha label for enum ReadonlyEnum.
	 */
	public String getReadonlyEnumLabel()
	{
		return this.readonlyEnum_label;
	}
	
	/**
	 * ReadonlyEnum is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.db.common.ValueLabel> getReadonlyEnumOptions()
	{
		return readonlyEnum_options;
	}	
	

	/**
	 * Get the No description provided.
	 * @return nillableEnum.
	 */
	public String getNillableEnum()
	{
		return this.nillableEnum;
	}
	
	@Deprecated
	public String getNillableEnum(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param nillableEnum
	 */
	public void setNillableEnum( String nillableEnum)
	{
		
		this.nillableEnum = nillableEnum;
	}

	
	/**
	 * Get tha label for enum NillableEnum.
	 */
	public String getNillableEnumLabel()
	{
		return this.nillableEnum_label;
	}
	
	/**
	 * NillableEnum is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.db.common.ValueLabel> getNillableEnumOptions()
	{
		return nillableEnum_options;
	}	
	

	/**
	 * Get the No description provided.
	 * @return defaultEnum.
	 */
	public String getDefaultEnum()
	{
		return this.defaultEnum;
	}
	
	@Deprecated
	public String getDefaultEnum(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param defaultEnum
	 */
	public void setDefaultEnum( String defaultEnum)
	{
		
		this.defaultEnum = defaultEnum;
	}

	
	/**
	 * Get tha label for enum DefaultEnum.
	 */
	public String getDefaultEnumLabel()
	{
		return this.defaultEnum_label;
	}
	
	/**
	 * DefaultEnum is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.db.common.ValueLabel> getDefaultEnumOptions()
	{
		return defaultEnum_options;
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
		if (name.toLowerCase().equals("normalenum"))
			return getNormalEnum();
		if(name.toLowerCase().equals("normalenum_label"))
			return getNormalEnumLabel();
		if (name.toLowerCase().equals("readonlyenum"))
			return getReadonlyEnum();
		if(name.toLowerCase().equals("readonlyenum_label"))
			return getReadonlyEnumLabel();
		if (name.toLowerCase().equals("nillableenum"))
			return getNillableEnum();
		if(name.toLowerCase().equals("nillableenum_label"))
			return getNillableEnumLabel();
		if (name.toLowerCase().equals("defaultenum"))
			return getDefaultEnum();
		if(name.toLowerCase().equals("defaultenum_label"))
			return getDefaultEnumLabel();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getNormalEnum() == null) throw new org.molgenis.db.common.DatabaseException("required field normalEnum is null");
		if(this.getReadonlyEnum() == null) throw new org.molgenis.db.common.DatabaseException("required field readonlyEnum is null");
		if(this.getDefaultEnum() == null) throw new org.molgenis.db.common.DatabaseException("required field defaultEnum is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("EnumEntity___type") != null) this.set__Type(tuple.getString("EnumEntity___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("EnumEntity_id") != null) this.setId(tuple.getInt("EnumEntity_id"));
			//set NormalEnum
			if( strict || tuple.getString("normalEnum") != null) this.setNormalEnum(tuple.getString("normalEnum"));
			if( tuple.getString("EnumEntity_normalEnum") != null) this.setNormalEnum(tuple.getString("EnumEntity_normalEnum"));
			//set ReadonlyEnum
			if( strict || tuple.getString("readonlyEnum") != null) this.setReadonlyEnum(tuple.getString("readonlyEnum"));
			if( tuple.getString("EnumEntity_readonlyEnum") != null) this.setReadonlyEnum(tuple.getString("EnumEntity_readonlyEnum"));
			//set NillableEnum
			if( strict || tuple.getString("nillableEnum") != null) this.setNillableEnum(tuple.getString("nillableEnum"));
			if( tuple.getString("EnumEntity_nillableEnum") != null) this.setNillableEnum(tuple.getString("EnumEntity_nillableEnum"));
			//set DefaultEnum
			if( strict || tuple.getString("defaultEnum") != null) this.setDefaultEnum(tuple.getString("defaultEnum"));
			if( tuple.getString("EnumEntity_defaultEnum") != null) this.setDefaultEnum(tuple.getString("EnumEntity_defaultEnum"));
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
		String result = "EnumEntity(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= "normalEnum='" + getNormalEnum()+"' ";	
		result+= "readonlyEnum='" + getReadonlyEnum()+"' ";	
		result+= "nillableEnum='" + getNillableEnum()+"' ";	
		result+= "defaultEnum='" + getDefaultEnum()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of EnumEntity.
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
			fields.add("normalEnum");
		}
		{
			fields.add("readonlyEnum");
		}
		{
			fields.add("nillableEnum");
		}
		{
			fields.add("defaultEnum");
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
		+ "normalEnum" +sep
		+ "readonlyEnum" +sep
		+ "nillableEnum" +sep
		+ "defaultEnum" 
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
		EnumEntity rhs = (EnumEntity) obj;
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
			Object valueO = getNormalEnum();
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
			Object valueO = getReadonlyEnum();
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
			Object valueO = getNillableEnum();
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
			Object valueO = getDefaultEnum();
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
	public EnumEntity create(org.molgenis.db.Tuple tuple) throws Exception
	{
		EnumEntity e = new EnumEntity();
		e.set(tuple);
		return e;
	}
	


	
}

