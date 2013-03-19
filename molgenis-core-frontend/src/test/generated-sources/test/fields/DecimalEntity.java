
/* File:        test/model/DecimalEntity.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.fields;

/**
 * DecimalEntity: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "DecimalEntity"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.fields.db.DecimalEntityEntityListener.class})
public class DecimalEntity extends org.molgenis.db.common.AbstractEntity 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String __TYPE = "__type";
	public final static String ID = "id";
	public final static String NORMALDECIMAL = "normalDecimal";
	public final static String READONLYDECIMAL = "readonlyDecimal";
	public final static String NILLABLEDECIMAL = "nillableDecimal";
	public final static String DEFAULTDECIMAL = "defaultDecimal";
	
	//static methods
	/**
	 * Shorthand for db.query(DecimalEntity.class).
	 */
	public static org.molgenis.db.Query<? extends DecimalEntity> query(org.molgenis.db.Database db)
	{
		return db.query(DecimalEntity.class);
	}
	
	/**
	 * Shorthand for db.find(DecimalEntity.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends DecimalEntity> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(DecimalEntity.class, rules);
	}	
	
	/**
	 * DecimalEntity
	 */
	public static DecimalEntity findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<DecimalEntity> q = db.query(DecimalEntity.class);
		q.eq(DecimalEntity.ID, id);
		java.util.List<DecimalEntity> result = q.find();
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


	//No description provided[type=decimal]
	@javax.persistence.Column(name="normalDecimal", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="normalDecimal")
	
				

	@javax.validation.constraints.NotNull
	private Double normalDecimal =  null;


	//No description provided[type=decimal]
	@javax.persistence.Column(name="readonlyDecimal", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="readonlyDecimal")
	
				

	@javax.validation.constraints.NotNull
	private Double readonlyDecimal =  null;


	//No description provided[type=decimal]
	@javax.persistence.Column(name="nillableDecimal")
	@javax.xml.bind.annotation.XmlElement(name="nillableDecimal")
	
				

	private Double nillableDecimal =  null;


	//No description provided[type=decimal]
	@javax.persistence.Column(name="defaultDecimal", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="defaultDecimal")
	
				

	@javax.validation.constraints.NotNull
	private Double defaultDecimal =  2.0;

	//constructors
	public DecimalEntity()
	{
	
		//options for enum __Type
		__type_options.add(new org.molgenis.db.common.ValueLabel("[DecimalEntity]","[DecimalEntity]"));
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
	 * @return normalDecimal.
	 */
	public Double getNormalDecimal()
	{
		return this.normalDecimal;
	}
	
	@Deprecated
	public Double getNormalDecimal(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param normalDecimal
	 */
	public void setNormalDecimal( Double normalDecimal)
	{
		
		this.normalDecimal = normalDecimal;
	}

	

	/**
	 * Get the No description provided.
	 * @return readonlyDecimal.
	 */
	public Double getReadonlyDecimal()
	{
		return this.readonlyDecimal;
	}
	
	@Deprecated
	public Double getReadonlyDecimal(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param readonlyDecimal
	 */
	public void setReadonlyDecimal( Double readonlyDecimal)
	{
		
		this.readonlyDecimal = readonlyDecimal;
	}

	

	/**
	 * Get the No description provided.
	 * @return nillableDecimal.
	 */
	public Double getNillableDecimal()
	{
		return this.nillableDecimal;
	}
	
	@Deprecated
	public Double getNillableDecimal(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param nillableDecimal
	 */
	public void setNillableDecimal( Double nillableDecimal)
	{
		
		this.nillableDecimal = nillableDecimal;
	}

	

	/**
	 * Get the No description provided.
	 * @return defaultDecimal.
	 */
	public Double getDefaultDecimal()
	{
		return this.defaultDecimal;
	}
	
	@Deprecated
	public Double getDefaultDecimal(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param defaultDecimal
	 */
	public void setDefaultDecimal( Double defaultDecimal)
	{
		
		this.defaultDecimal = defaultDecimal;
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
		if (name.toLowerCase().equals("normaldecimal"))
			return getNormalDecimal();
		if (name.toLowerCase().equals("readonlydecimal"))
			return getReadonlyDecimal();
		if (name.toLowerCase().equals("nillabledecimal"))
			return getNillableDecimal();
		if (name.toLowerCase().equals("defaultdecimal"))
			return getDefaultDecimal();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getNormalDecimal() == null) throw new org.molgenis.db.common.DatabaseException("required field normalDecimal is null");
		if(this.getReadonlyDecimal() == null) throw new org.molgenis.db.common.DatabaseException("required field readonlyDecimal is null");
		if(this.getDefaultDecimal() == null) throw new org.molgenis.db.common.DatabaseException("required field defaultDecimal is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("DecimalEntity___type") != null) this.set__Type(tuple.getString("DecimalEntity___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("DecimalEntity_id") != null) this.setId(tuple.getInt("DecimalEntity_id"));
			//set NormalDecimal
			if( strict || tuple.getDouble("normalDecimal") != null) this.setNormalDecimal(tuple.getDouble("normalDecimal"));
			if( tuple.getDouble("DecimalEntity_normalDecimal") != null) this.setNormalDecimal(tuple.getDouble("DecimalEntity_normalDecimal"));
			//set ReadonlyDecimal
			if( strict || tuple.getDouble("readonlyDecimal") != null) this.setReadonlyDecimal(tuple.getDouble("readonlyDecimal"));
			if( tuple.getDouble("DecimalEntity_readonlyDecimal") != null) this.setReadonlyDecimal(tuple.getDouble("DecimalEntity_readonlyDecimal"));
			//set NillableDecimal
			if( strict || tuple.getDouble("nillableDecimal") != null) this.setNillableDecimal(tuple.getDouble("nillableDecimal"));
			if( tuple.getDouble("DecimalEntity_nillableDecimal") != null) this.setNillableDecimal(tuple.getDouble("DecimalEntity_nillableDecimal"));
			//set DefaultDecimal
			if( strict || tuple.getDouble("defaultDecimal") != null) this.setDefaultDecimal(tuple.getDouble("defaultDecimal"));
			if( tuple.getDouble("DecimalEntity_defaultDecimal") != null) this.setDefaultDecimal(tuple.getDouble("DecimalEntity_defaultDecimal"));
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
		String result = "DecimalEntity(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= "normalDecimal='" + getNormalDecimal()+"' ";	
		result+= "readonlyDecimal='" + getReadonlyDecimal()+"' ";	
		result+= "nillableDecimal='" + getNillableDecimal()+"' ";	
		result+= "defaultDecimal='" + getDefaultDecimal()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of DecimalEntity.
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
			fields.add("normalDecimal");
		}
		{
			fields.add("readonlyDecimal");
		}
		{
			fields.add("nillableDecimal");
		}
		{
			fields.add("defaultDecimal");
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
		+ "normalDecimal" +sep
		+ "readonlyDecimal" +sep
		+ "nillableDecimal" +sep
		+ "defaultDecimal" 
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
		DecimalEntity rhs = (DecimalEntity) obj;
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
			Object valueO = getNormalDecimal();
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
			Object valueO = getReadonlyDecimal();
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
			Object valueO = getNillableDecimal();
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
			Object valueO = getDefaultDecimal();
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
	public DecimalEntity create(org.molgenis.db.Tuple tuple) throws Exception
	{
		DecimalEntity e = new DecimalEntity();
		e.set(tuple);
		return e;
	}
	


	
}

