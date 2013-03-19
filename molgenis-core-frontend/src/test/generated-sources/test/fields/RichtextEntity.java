
/* File:        test/model/RichtextEntity.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.fields;

/**
 * RichtextEntity: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "RichtextEntity"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.fields.db.RichtextEntityEntityListener.class})
public class RichtextEntity extends org.molgenis.db.common.AbstractEntity 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String __TYPE = "__type";
	public final static String ID = "id";
	public final static String NORMALTEXT = "normalText";
	public final static String READONLYTEXT = "readonlyText";
	public final static String NILLABLETEXT = "nillableText";
	public final static String DEFAULTTEXT = "defaultText";
	
	//static methods
	/**
	 * Shorthand for db.query(RichtextEntity.class).
	 */
	public static org.molgenis.db.Query<? extends RichtextEntity> query(org.molgenis.db.Database db)
	{
		return db.query(RichtextEntity.class);
	}
	
	/**
	 * Shorthand for db.find(RichtextEntity.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends RichtextEntity> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(RichtextEntity.class, rules);
	}	
	
	/**
	 * RichtextEntity
	 */
	public static RichtextEntity findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<RichtextEntity> q = db.query(RichtextEntity.class);
		q.eq(RichtextEntity.ID, id);
		java.util.List<RichtextEntity> result = q.find();
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


	//No description provided[type=richtext]
	@javax.persistence.Column(name="normalText", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="normalText")
	
				

	@javax.validation.constraints.NotNull
	private String normalText =  null;


	//No description provided[type=richtext]
	@javax.persistence.Column(name="readonlyText", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="readonlyText")
	
				

	@javax.validation.constraints.NotNull
	private String readonlyText =  null;


	//No description provided[type=richtext]
	@javax.persistence.Column(name="nillableText")
	@javax.xml.bind.annotation.XmlElement(name="nillableText")
	
				

	private String nillableText =  null;


	//No description provided[type=richtext]
	@javax.persistence.Column(name="defaultText", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="defaultText")
	
				

	@javax.validation.constraints.NotNull
	private String defaultText =  "1";

	//constructors
	public RichtextEntity()
	{
	
		//options for enum __Type
		__type_options.add(new org.molgenis.db.common.ValueLabel("[RichtextEntity]","[RichtextEntity]"));
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
	 * @return normalText.
	 */
	public String getNormalText()
	{
		return this.normalText;
	}
	
	@Deprecated
	public String getNormalText(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param normalText
	 */
	public void setNormalText( String normalText)
	{
		
		this.normalText = normalText;
	}

	

	/**
	 * Get the No description provided.
	 * @return readonlyText.
	 */
	public String getReadonlyText()
	{
		return this.readonlyText;
	}
	
	@Deprecated
	public String getReadonlyText(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param readonlyText
	 */
	public void setReadonlyText( String readonlyText)
	{
		
		this.readonlyText = readonlyText;
	}

	

	/**
	 * Get the No description provided.
	 * @return nillableText.
	 */
	public String getNillableText()
	{
		return this.nillableText;
	}
	
	@Deprecated
	public String getNillableText(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param nillableText
	 */
	public void setNillableText( String nillableText)
	{
		
		this.nillableText = nillableText;
	}

	

	/**
	 * Get the No description provided.
	 * @return defaultText.
	 */
	public String getDefaultText()
	{
		return this.defaultText;
	}
	
	@Deprecated
	public String getDefaultText(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param defaultText
	 */
	public void setDefaultText( String defaultText)
	{
		
		this.defaultText = defaultText;
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
		if (name.toLowerCase().equals("normaltext"))
			return getNormalText();
		if (name.toLowerCase().equals("readonlytext"))
			return getReadonlyText();
		if (name.toLowerCase().equals("nillabletext"))
			return getNillableText();
		if (name.toLowerCase().equals("defaulttext"))
			return getDefaultText();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getNormalText() == null) throw new org.molgenis.db.common.DatabaseException("required field normalText is null");
		if(this.getReadonlyText() == null) throw new org.molgenis.db.common.DatabaseException("required field readonlyText is null");
		if(this.getDefaultText() == null) throw new org.molgenis.db.common.DatabaseException("required field defaultText is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("RichtextEntity___type") != null) this.set__Type(tuple.getString("RichtextEntity___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("RichtextEntity_id") != null) this.setId(tuple.getInt("RichtextEntity_id"));
			//set NormalText
			if( strict || tuple.getString("normalText") != null) this.setNormalText(tuple.getString("normalText"));
			if( tuple.getString("RichtextEntity_normalText") != null) this.setNormalText(tuple.getString("RichtextEntity_normalText"));
			//set ReadonlyText
			if( strict || tuple.getString("readonlyText") != null) this.setReadonlyText(tuple.getString("readonlyText"));
			if( tuple.getString("RichtextEntity_readonlyText") != null) this.setReadonlyText(tuple.getString("RichtextEntity_readonlyText"));
			//set NillableText
			if( strict || tuple.getString("nillableText") != null) this.setNillableText(tuple.getString("nillableText"));
			if( tuple.getString("RichtextEntity_nillableText") != null) this.setNillableText(tuple.getString("RichtextEntity_nillableText"));
			//set DefaultText
			if( strict || tuple.getString("defaultText") != null) this.setDefaultText(tuple.getString("defaultText"));
			if( tuple.getString("RichtextEntity_defaultText") != null) this.setDefaultText(tuple.getString("RichtextEntity_defaultText"));
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
		String result = "RichtextEntity(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= "normalText='" + getNormalText()+"' ";	
		result+= "readonlyText='" + getReadonlyText()+"' ";	
		result+= "nillableText='" + getNillableText()+"' ";	
		result+= "defaultText='" + getDefaultText()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of RichtextEntity.
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
			fields.add("normalText");
		}
		{
			fields.add("readonlyText");
		}
		{
			fields.add("nillableText");
		}
		{
			fields.add("defaultText");
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
		+ "normalText" +sep
		+ "readonlyText" +sep
		+ "nillableText" +sep
		+ "defaultText" 
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
		RichtextEntity rhs = (RichtextEntity) obj;
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
			Object valueO = getNormalText();
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
			Object valueO = getReadonlyText();
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
			Object valueO = getNillableText();
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
			Object valueO = getDefaultText();
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
	public RichtextEntity create(org.molgenis.db.Tuple tuple) throws Exception
	{
		RichtextEntity e = new RichtextEntity();
		e.set(tuple);
		return e;
	}
	


	
}

