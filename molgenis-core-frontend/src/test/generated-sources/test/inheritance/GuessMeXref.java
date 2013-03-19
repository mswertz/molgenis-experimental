
/* File:        test/model/GuessMeXref.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.inheritance;

/**
 * GuessMeXref: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "GuessMeXref"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.inheritance.db.GuessMeXrefEntityListener.class})
public class GuessMeXref extends org.molgenis.db.common.AbstractEntity 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String __TYPE = "__type";
	public final static String GUESSMEXREFID = "guessMeXrefId";
	public final static String GUESSMEID = "guessMeId";
	
	//static methods
	/**
	 * Shorthand for db.query(GuessMeXref.class).
	 */
	public static org.molgenis.db.Query<? extends GuessMeXref> query(org.molgenis.db.Database db)
	{
		return db.query(GuessMeXref.class);
	}
	
	/**
	 * Shorthand for db.find(GuessMeXref.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends GuessMeXref> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(GuessMeXref.class, rules);
	}	
	
	/**
	 * GuessMeXref
	 */
	public static GuessMeXref findByGuessMeXrefId(org.molgenis.db.Database db, Integer guessMeXrefId) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<GuessMeXref> q = db.query(GuessMeXref.class);
		q.eq(GuessMeXref.GUESSMEXREFID, guessMeXrefId);
		java.util.List<GuessMeXref> result = q.find();
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
    @javax.persistence.Column(name="guessMeXrefId", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="guessMeXrefId")
	
	//@javax.validation.constraints.NotNull
	private Integer guessMeXrefId =  null;


	//No description provided[type=int]
	@javax.persistence.Column(name="guessMeId", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="guessMeId")
	
				

	@javax.validation.constraints.NotNull
	private Integer guessMeId =  null;

	//constructors
	public GuessMeXref()
	{
	
		//options for enum __Type
		__type_options.add(new org.molgenis.db.common.ValueLabel("[GuessMeXref]","[GuessMeXref]"));
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
	 * @return guessMeXrefId.
	 */
	public Integer getGuessMeXrefId()
	{
		return this.guessMeXrefId;
	}
	
	
	/**
	 * Set the No description provided.
	 * @param guessMeXrefId
	 */
	public void setGuessMeXrefId( Integer guessMeXrefId)
	{
		this.guessMeXrefId = guessMeXrefId;
	}

	

	/**
	 * Get the No description provided.
	 * @return guessMeId.
	 */
	public Integer getGuessMeId()
	{
		return this.guessMeId;
	}
	
	@Deprecated
	public Integer getGuessMeId(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param guessMeId
	 */
	public void setGuessMeId( Integer guessMeId)
	{
		
		this.guessMeId = guessMeId;
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
		if (name.toLowerCase().equals("guessmexrefid"))
			return getGuessMeXrefId();
		if (name.toLowerCase().equals("guessmeid"))
			return getGuessMeId();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getGuessMeXrefId() == null) throw new org.molgenis.db.common.DatabaseException("required field guessMeXrefId is null");
		if(this.getGuessMeId() == null) throw new org.molgenis.db.common.DatabaseException("required field guessMeId is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("GuessMeXref___type") != null) this.set__Type(tuple.getString("GuessMeXref___type"));
			//set GuessMeXrefId
			if( strict || tuple.getInt("guessMeXrefId") != null) this.setGuessMeXrefId(tuple.getInt("guessMeXrefId"));
			if( tuple.getInt("GuessMeXref_guessMeXrefId") != null) this.setGuessMeXrefId(tuple.getInt("GuessMeXref_guessMeXrefId"));
			//set GuessMeId
			if( strict || tuple.getInt("guessMeId") != null) this.setGuessMeId(tuple.getInt("guessMeId"));
			if( tuple.getInt("GuessMeXref_guessMeId") != null) this.setGuessMeId(tuple.getInt("GuessMeXref_guessMeId"));
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
		String result = "GuessMeXref(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "guessMeXrefId='" + getGuessMeXrefId()+"' ";	
		result+= "guessMeId='" + getGuessMeId()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of GuessMeXref.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		{
			fields.add("__type");
		}
		if(!skipAutoIds)
		{
			fields.add("guessMeXrefId");
		}
		{
			fields.add("guessMeId");
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
		return "guessMeXrefId";
	}
	

	
	@Override
	public java.util.List<String> getLabelFields()
	{
		java.util.List<String> result = new java.util.ArrayList<String>();
		result.add("guessMeXrefId");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "__type" +sep
		+ "guessMeXrefId" +sep
		+ "guessMeId" 
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
		GuessMeXref rhs = (GuessMeXref) obj;
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
			Object valueO = getGuessMeXrefId();
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
			Object valueO = getGuessMeId();
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
	public GuessMeXref create(org.molgenis.db.Tuple tuple) throws Exception
	{
		GuessMeXref e = new GuessMeXref();
		e.set(tuple);
		return e;
	}
	


	
}

