
/* File:        test/model/DateEntity.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.fields;

/**
 * DateEntity: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "DateEntity"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.fields.db.DateEntityEntityListener.class})
public class DateEntity extends org.molgenis.db.common.AbstractEntity 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String __TYPE = "__type";
	public final static String ID = "id";
	public final static String NORMALDATE = "normalDate";
	public final static String READONLYDATE = "readonlyDate";
	public final static String NILLABLEDATE = "nillableDate";
	public final static String AUTODATE = "autoDate";
	public final static String DEFAULTDATE = "defaultDate";
	
	//static methods
	/**
	 * Shorthand for db.query(DateEntity.class).
	 */
	public static org.molgenis.db.Query<? extends DateEntity> query(org.molgenis.db.Database db)
	{
		return db.query(DateEntity.class);
	}
	
	/**
	 * Shorthand for db.find(DateEntity.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends DateEntity> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(DateEntity.class, rules);
	}	
	
	/**
	 * DateEntity
	 */
	public static DateEntity findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<DateEntity> q = db.query(DateEntity.class);
		q.eq(DateEntity.ID, id);
		java.util.List<DateEntity> result = q.find();
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


	//No description provided[type=date]
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
	@javax.persistence.Column(name="normalDate", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="normalDate")
	
				

	@javax.validation.constraints.NotNull
	private java.util.Date normalDate =  null;


	//No description provided[type=date]
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
	@javax.persistence.Column(name="readonlyDate", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="readonlyDate")
	
				

	@javax.validation.constraints.NotNull
	private java.util.Date readonlyDate =  null;


	//No description provided[type=date]
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
	@javax.persistence.Column(name="nillableDate")
	@javax.xml.bind.annotation.XmlElement(name="nillableDate")
	
				

	private java.util.Date nillableDate =  null;


	//No description provided[type=date]
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
	@javax.persistence.Column(name="autoDate", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="autoDate")
	
				

	@javax.validation.constraints.NotNull
	private java.util.Date autoDate =  new java.sql.Date(new java.util.Date().getTime());


	//No description provided[type=date]
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
	@javax.persistence.Column(name="defaultDate", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="defaultDate")
	
				

	@javax.validation.constraints.NotNull
	private java.util.Date defaultDate =  java.sql.Date.valueOf("2006-02-25");

	//constructors
	public DateEntity()
	{
	
		//options for enum __Type
		__type_options.add(new org.molgenis.db.common.ValueLabel("[DateEntity]","[DateEntity]"));
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
	 * @return normalDate.
	 */
	public java.util.Date getNormalDate()
	{
		return this.normalDate;
	}
	
	@Deprecated
	public java.util.Date getNormalDate(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param normalDate
	 */
	public void setNormalDate( java.util.Date normalDate)
	{
		
		this.normalDate = normalDate;
	}

	
	/**
	 * Set the No description provided. Automatically converts string into date;
	 * @param normalDate
	 */	
	public void setNormalDate(String datestring) throws java.text.ParseException
	{
		this.setNormalDate(string2date(datestring));
	}	

	/**
	 * Get the No description provided.
	 * @return readonlyDate.
	 */
	public java.util.Date getReadonlyDate()
	{
		return this.readonlyDate;
	}
	
	@Deprecated
	public java.util.Date getReadonlyDate(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param readonlyDate
	 */
	public void setReadonlyDate( java.util.Date readonlyDate)
	{
		
		this.readonlyDate = readonlyDate;
	}

	
	/**
	 * Set the No description provided. Automatically converts string into date;
	 * @param readonlyDate
	 */	
	public void setReadonlyDate(String datestring) throws java.text.ParseException
	{
		this.setReadonlyDate(string2date(datestring));
	}	

	/**
	 * Get the No description provided.
	 * @return nillableDate.
	 */
	public java.util.Date getNillableDate()
	{
		return this.nillableDate;
	}
	
	@Deprecated
	public java.util.Date getNillableDate(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param nillableDate
	 */
	public void setNillableDate( java.util.Date nillableDate)
	{
		
		this.nillableDate = nillableDate;
	}

	
	/**
	 * Set the No description provided. Automatically converts string into date;
	 * @param nillableDate
	 */	
	public void setNillableDate(String datestring) throws java.text.ParseException
	{
		this.setNillableDate(string2date(datestring));
	}	

	/**
	 * Get the No description provided.
	 * @return autoDate.
	 */
	public java.util.Date getAutoDate()
	{
		return this.autoDate;
	}
	
	@Deprecated
	public java.util.Date getAutoDate(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param autoDate
	 */
	public void setAutoDate( java.util.Date autoDate)
	{
		
		this.autoDate = autoDate;
	}

	
	/**
	 * Set the No description provided. Automatically converts string into date;
	 * @param autoDate
	 */	
	public void setAutoDate(String datestring) throws java.text.ParseException
	{
		this.setAutoDate(string2date(datestring));
	}	

	/**
	 * Get the No description provided.
	 * @return defaultDate.
	 */
	public java.util.Date getDefaultDate()
	{
		return this.defaultDate;
	}
	
	@Deprecated
	public java.util.Date getDefaultDate(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param defaultDate
	 */
	public void setDefaultDate( java.util.Date defaultDate)
	{
		
		this.defaultDate = defaultDate;
	}

	
	/**
	 * Set the No description provided. Automatically converts string into date;
	 * @param defaultDate
	 */	
	public void setDefaultDate(String datestring) throws java.text.ParseException
	{
		this.setDefaultDate(string2date(datestring));
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
		if (name.toLowerCase().equals("normaldate"))
			return getNormalDate();
		if (name.toLowerCase().equals("readonlydate"))
			return getReadonlyDate();
		if (name.toLowerCase().equals("nillabledate"))
			return getNillableDate();
		if (name.toLowerCase().equals("autodate"))
			return getAutoDate();
		if (name.toLowerCase().equals("defaultdate"))
			return getDefaultDate();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getNormalDate() == null) throw new org.molgenis.db.common.DatabaseException("required field normalDate is null");
		if(this.getReadonlyDate() == null) throw new org.molgenis.db.common.DatabaseException("required field readonlyDate is null");
		if(this.getAutoDate() == null) throw new org.molgenis.db.common.DatabaseException("required field autoDate is null");
		if(this.getDefaultDate() == null) throw new org.molgenis.db.common.DatabaseException("required field defaultDate is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("DateEntity___type") != null) this.set__Type(tuple.getString("DateEntity___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("DateEntity_id") != null) this.setId(tuple.getInt("DateEntity_id"));
			//set NormalDate
			if( strict || tuple.getDate("normalDate") != null) this.setNormalDate(tuple.getDate("normalDate"));
			if( tuple.getDate("DateEntity_normalDate") != null) this.setNormalDate(tuple.getDate("DateEntity_normalDate"));
			//set ReadonlyDate
			if( strict || tuple.getDate("readonlyDate") != null) this.setReadonlyDate(tuple.getDate("readonlyDate"));
			if( tuple.getDate("DateEntity_readonlyDate") != null) this.setReadonlyDate(tuple.getDate("DateEntity_readonlyDate"));
			//set NillableDate
			if( strict || tuple.getDate("nillableDate") != null) this.setNillableDate(tuple.getDate("nillableDate"));
			if( tuple.getDate("DateEntity_nillableDate") != null) this.setNillableDate(tuple.getDate("DateEntity_nillableDate"));
			//set AutoDate
			if( strict || tuple.getDate("autoDate") != null) this.setAutoDate(tuple.getDate("autoDate"));
			if( tuple.getDate("DateEntity_autoDate") != null) this.setAutoDate(tuple.getDate("DateEntity_autoDate"));
			//set DefaultDate
			if( strict || tuple.getDate("defaultDate") != null) this.setDefaultDate(tuple.getDate("defaultDate"));
			if( tuple.getDate("DateEntity_defaultDate") != null) this.setDefaultDate(tuple.getDate("DateEntity_defaultDate"));
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
		String result = "DateEntity(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= "normalDate='" + getNormalDate()+"' ";	
		result+= "readonlyDate='" + getReadonlyDate()+"' ";	
		result+= "nillableDate='" + getNillableDate()+"' ";	
		result+= "autoDate='" + getAutoDate()+"' ";	
		result+= "defaultDate='" + getDefaultDate()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of DateEntity.
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
			fields.add("normalDate");
		}
		{
			fields.add("readonlyDate");
		}
		{
			fields.add("nillableDate");
		}
		{
			fields.add("autoDate");
		}
		{
			fields.add("defaultDate");
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
		+ "normalDate" +sep
		+ "readonlyDate" +sep
		+ "nillableDate" +sep
		+ "autoDate" +sep
		+ "defaultDate" 
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
		DateEntity rhs = (DateEntity) obj;
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
			Object valueO = getNormalDate();
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
			Object valueO = getReadonlyDate();
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
			Object valueO = getNillableDate();
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
			Object valueO = getAutoDate();
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
			Object valueO = getDefaultDate();
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
	public DateEntity create(org.molgenis.db.Tuple tuple) throws Exception
	{
		DateEntity e = new DateEntity();
		e.set(tuple);
		return e;
	}
	


	
}

