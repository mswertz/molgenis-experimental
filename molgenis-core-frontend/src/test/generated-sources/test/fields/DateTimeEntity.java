
/* File:        test/model/DateTimeEntity.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.fields;

/**
 * DateTimeEntity: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "DateTimeEntity"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.fields.db.DateTimeEntityEntityListener.class})
public class DateTimeEntity extends org.molgenis.db.common.AbstractEntity 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String __TYPE = "__type";
	public final static String ID = "id";
	public final static String NORMALDATETIME = "normalDateTime";
	public final static String READONLYDATETIME = "readonlyDateTime";
	public final static String NILLABLEDATETIME = "nillableDateTime";
	public final static String AUTODATETIME = "autoDateTime";
	public final static String DEFAULTDATETIME = "defaultDateTime";
	
	//static methods
	/**
	 * Shorthand for db.query(DateTimeEntity.class).
	 */
	public static org.molgenis.db.Query<? extends DateTimeEntity> query(org.molgenis.db.Database db)
	{
		return db.query(DateTimeEntity.class);
	}
	
	/**
	 * Shorthand for db.find(DateTimeEntity.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends DateTimeEntity> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(DateTimeEntity.class, rules);
	}	
	
	/**
	 * DateTimeEntity
	 */
	public static DateTimeEntity findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<DateTimeEntity> q = db.query(DateTimeEntity.class);
		q.eq(DateTimeEntity.ID, id);
		java.util.List<DateTimeEntity> result = q.find();
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


	//No description provided[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="normalDateTime", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="normalDateTime")
	
				

	@javax.validation.constraints.NotNull
	private java.util.Date normalDateTime =  null;


	//No description provided[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="readonlyDateTime", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="readonlyDateTime")
	
				

	@javax.validation.constraints.NotNull
	private java.util.Date readonlyDateTime =  null;


	//No description provided[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="nillableDateTime")
	@javax.xml.bind.annotation.XmlElement(name="nillableDateTime")
	
				

	private java.util.Date nillableDateTime =  null;


	//No description provided[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="autoDateTime", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="autoDateTime")
	
				

	@javax.validation.constraints.NotNull
	private java.util.Date autoDateTime =  new java.sql.Date(new java.util.Date().getTime());


	//No description provided[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="defaultDateTime", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="defaultDateTime")
	
				

	@javax.validation.constraints.NotNull
	private java.util.Date defaultDateTime =  java.sql.Timestamp.valueOf("2006-02-25 19:20:19");

	//constructors
	public DateTimeEntity()
	{
	
		//options for enum __Type
		__type_options.add(new org.molgenis.db.common.ValueLabel("[DateTimeEntity]","[DateTimeEntity]"));
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
	 * @return normalDateTime.
	 */
	public java.util.Date getNormalDateTime()
	{
		return this.normalDateTime;
	}
	
	@Deprecated
	public java.util.Date getNormalDateTime(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param normalDateTime
	 */
	public void setNormalDateTime( java.util.Date normalDateTime)
	{
		
		this.normalDateTime = normalDateTime;
	}

	

	/**
	 * Get the No description provided.
	 * @return readonlyDateTime.
	 */
	public java.util.Date getReadonlyDateTime()
	{
		return this.readonlyDateTime;
	}
	
	@Deprecated
	public java.util.Date getReadonlyDateTime(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param readonlyDateTime
	 */
	public void setReadonlyDateTime( java.util.Date readonlyDateTime)
	{
		
		this.readonlyDateTime = readonlyDateTime;
	}

	

	/**
	 * Get the No description provided.
	 * @return nillableDateTime.
	 */
	public java.util.Date getNillableDateTime()
	{
		return this.nillableDateTime;
	}
	
	@Deprecated
	public java.util.Date getNillableDateTime(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param nillableDateTime
	 */
	public void setNillableDateTime( java.util.Date nillableDateTime)
	{
		
		this.nillableDateTime = nillableDateTime;
	}

	

	/**
	 * Get the No description provided.
	 * @return autoDateTime.
	 */
	public java.util.Date getAutoDateTime()
	{
		return this.autoDateTime;
	}
	
	@Deprecated
	public java.util.Date getAutoDateTime(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param autoDateTime
	 */
	public void setAutoDateTime( java.util.Date autoDateTime)
	{
		
		this.autoDateTime = autoDateTime;
	}

	

	/**
	 * Get the No description provided.
	 * @return defaultDateTime.
	 */
	public java.util.Date getDefaultDateTime()
	{
		return this.defaultDateTime;
	}
	
	@Deprecated
	public java.util.Date getDefaultDateTime(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param defaultDateTime
	 */
	public void setDefaultDateTime( java.util.Date defaultDateTime)
	{
		
		this.defaultDateTime = defaultDateTime;
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
		if (name.toLowerCase().equals("normaldatetime"))
			return getNormalDateTime();
		if (name.toLowerCase().equals("readonlydatetime"))
			return getReadonlyDateTime();
		if (name.toLowerCase().equals("nillabledatetime"))
			return getNillableDateTime();
		if (name.toLowerCase().equals("autodatetime"))
			return getAutoDateTime();
		if (name.toLowerCase().equals("defaultdatetime"))
			return getDefaultDateTime();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getNormalDateTime() == null) throw new org.molgenis.db.common.DatabaseException("required field normalDateTime is null");
		if(this.getReadonlyDateTime() == null) throw new org.molgenis.db.common.DatabaseException("required field readonlyDateTime is null");
		if(this.getAutoDateTime() == null) throw new org.molgenis.db.common.DatabaseException("required field autoDateTime is null");
		if(this.getDefaultDateTime() == null) throw new org.molgenis.db.common.DatabaseException("required field defaultDateTime is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("DateTimeEntity___type") != null) this.set__Type(tuple.getString("DateTimeEntity___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("DateTimeEntity_id") != null) this.setId(tuple.getInt("DateTimeEntity_id"));
			//set NormalDateTime
			if( strict || tuple.getTimestamp("normalDateTime") != null) this.setNormalDateTime(tuple.getTimestamp("normalDateTime"));
			if( tuple.getTimestamp("DateTimeEntity_normalDateTime") != null) this.setNormalDateTime(tuple.getTimestamp("DateTimeEntity_normalDateTime"));
			//set ReadonlyDateTime
			if( strict || tuple.getTimestamp("readonlyDateTime") != null) this.setReadonlyDateTime(tuple.getTimestamp("readonlyDateTime"));
			if( tuple.getTimestamp("DateTimeEntity_readonlyDateTime") != null) this.setReadonlyDateTime(tuple.getTimestamp("DateTimeEntity_readonlyDateTime"));
			//set NillableDateTime
			if( strict || tuple.getTimestamp("nillableDateTime") != null) this.setNillableDateTime(tuple.getTimestamp("nillableDateTime"));
			if( tuple.getTimestamp("DateTimeEntity_nillableDateTime") != null) this.setNillableDateTime(tuple.getTimestamp("DateTimeEntity_nillableDateTime"));
			//set AutoDateTime
			if( strict || tuple.getTimestamp("autoDateTime") != null) this.setAutoDateTime(tuple.getTimestamp("autoDateTime"));
			if( tuple.getTimestamp("DateTimeEntity_autoDateTime") != null) this.setAutoDateTime(tuple.getTimestamp("DateTimeEntity_autoDateTime"));
			//set DefaultDateTime
			if( strict || tuple.getTimestamp("defaultDateTime") != null) this.setDefaultDateTime(tuple.getTimestamp("defaultDateTime"));
			if( tuple.getTimestamp("DateTimeEntity_defaultDateTime") != null) this.setDefaultDateTime(tuple.getTimestamp("DateTimeEntity_defaultDateTime"));
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
		String result = "DateTimeEntity(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= "normalDateTime='" + (getNormalDateTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getNormalDateTime()))+"' ";
		result+= "normalDateTime='" + (getNormalDateTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getNormalDateTime()))+"' ";		
		result+= "readonlyDateTime='" + (getReadonlyDateTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getReadonlyDateTime()))+"' ";
		result+= "readonlyDateTime='" + (getReadonlyDateTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getReadonlyDateTime()))+"' ";		
		result+= "nillableDateTime='" + (getNillableDateTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getNillableDateTime()))+"' ";
		result+= "nillableDateTime='" + (getNillableDateTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getNillableDateTime()))+"' ";		
		result+= "autoDateTime='" + (getAutoDateTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getAutoDateTime()))+"' ";
		result+= "autoDateTime='" + (getAutoDateTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getAutoDateTime()))+"' ";		
		result+= "defaultDateTime='" + (getDefaultDateTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getDefaultDateTime()))+"'";
		result+= "defaultDateTime='" + (getDefaultDateTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getDefaultDateTime()))+"'";		
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of DateTimeEntity.
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
			fields.add("normalDateTime");
		}
		{
			fields.add("readonlyDateTime");
		}
		{
			fields.add("nillableDateTime");
		}
		{
			fields.add("autoDateTime");
		}
		{
			fields.add("defaultDateTime");
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
		+ "normalDateTime" +sep
		+ "readonlyDateTime" +sep
		+ "nillableDateTime" +sep
		+ "autoDateTime" +sep
		+ "defaultDateTime" 
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
		DateTimeEntity rhs = (DateTimeEntity) obj;
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
			Object valueO = getNormalDateTime();
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
			Object valueO = getReadonlyDateTime();
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
			Object valueO = getNillableDateTime();
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
			Object valueO = getAutoDateTime();
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
			Object valueO = getDefaultDateTime();
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
	public DateTimeEntity create(org.molgenis.db.Tuple tuple) throws Exception
	{
		DateTimeEntity e = new DateTimeEntity();
		e.set(tuple);
		return e;
	}
	


	
}

