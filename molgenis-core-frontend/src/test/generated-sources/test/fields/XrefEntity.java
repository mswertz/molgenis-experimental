
/* File:        test/model/XrefEntity.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.fields;

/**
 * XrefEntity: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "XrefEntity"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.fields.db.XrefEntityEntityListener.class})
public class XrefEntity extends org.molgenis.db.common.AbstractEntity 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String __TYPE = "__type";
	public final static String ID = "id";
	public final static String NORMALXREF = "normalXref";
	public final static String NORMALXREF_NORMALVARCHAR = "normalXref_normalVarchar";
	public final static String READONLYXREF = "readonlyXref";
	public final static String READONLYXREF_NORMALVARCHAR = "readonlyXref_normalVarchar";
	public final static String NILLABLEXREF = "nillableXref";
	public final static String NILLABLEXREF_NORMALVARCHAR = "nillableXref_normalVarchar";
	
	//static methods
	/**
	 * Shorthand for db.query(XrefEntity.class).
	 */
	public static org.molgenis.db.Query<? extends XrefEntity> query(org.molgenis.db.Database db)
	{
		return db.query(XrefEntity.class);
	}
	
	/**
	 * Shorthand for db.find(XrefEntity.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends XrefEntity> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(XrefEntity.class, rules);
	}	
	
	/**
	 * XrefEntity
	 */
	public static XrefEntity findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<XrefEntity> q = db.query(XrefEntity.class);
		q.eq(XrefEntity.ID, id);
		java.util.List<XrefEntity> result = q.find();
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


	//No description provided[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="normalXref", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private test.fields.VarcharEntity normalXref = null;
	@javax.persistence.Transient
	private Integer normalXref_id = null;	
	
	@javax.persistence.Transient
	private String normalXref_normalVarchar = null;						



	//No description provided[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="readonlyXref", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private test.fields.VarcharEntity readonlyXref = null;
	@javax.persistence.Transient
	private Integer readonlyXref_id = null;	
	
	@javax.persistence.Transient
	private String readonlyXref_normalVarchar = null;						



	//No description provided[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="nillableXref")   	
	
				

	private test.fields.OtherVarcharEntity nillableXref = null;
	@javax.persistence.Transient
	private Integer nillableXref_id = null;	
	
	@javax.persistence.Transient
	private String nillableXref_normalVarchar = null;						


	//constructors
	public XrefEntity()
	{
	
		//options for enum __Type
		__type_options.add(new org.molgenis.db.common.ValueLabel("[XrefEntity]","[XrefEntity]"));
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
	 * @return normalXref.
	 */
	public test.fields.VarcharEntity getNormalXref()
	{
		return this.normalXref;
	}
	
	@Deprecated
	public test.fields.VarcharEntity getNormalXref(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param normalXref
	 */
	public void setNormalXref( test.fields.VarcharEntity normalXref)
	{
		
		this.normalXref = normalXref;
	}

	
	
	/**
	 * Set foreign key for field normalXref.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setNormalXref_Id(Integer normalXref_id)
	{
		this.normalXref_id = normalXref_id;
	}	

	public void setNormalXref(Integer normalXref_id)
	{
		this.normalXref_id = normalXref_id;
	}
	
	public Integer getNormalXref_Id()
	{
		
		if(normalXref != null) 
		{
			return normalXref.getId();
		}
		else
		{
			return normalXref_id;
		}
	}	
	 
	/**
	 * Get a pretty label normalVarchar for cross reference NormalXref to VarcharEntity.Id.
	 */
	public String getNormalXref_NormalVarchar()
	{		
		//FIXME should we auto-load based on getNormalXref()?	
		if(normalXref != null) {
			return normalXref.getNormalVarchar();
		} else {
			return normalXref_normalVarchar;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference NormalXref to <a href="VarcharEntity.html#Id">VarcharEntity.Id</a>.
	 * Implies setNormalXref(null) until save
	 */
	public void setNormalXref_NormalVarchar(String normalXref_normalVarchar)
	{
		this.normalXref_normalVarchar = normalXref_normalVarchar;
	}		
	 
	

	/**
	 * Get the No description provided.
	 * @return readonlyXref.
	 */
	public test.fields.VarcharEntity getReadonlyXref()
	{
		return this.readonlyXref;
	}
	
	@Deprecated
	public test.fields.VarcharEntity getReadonlyXref(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param readonlyXref
	 */
	public void setReadonlyXref( test.fields.VarcharEntity readonlyXref)
	{
		
		this.readonlyXref = readonlyXref;
	}

	
	
	/**
	 * Set foreign key for field readonlyXref.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setReadonlyXref_Id(Integer readonlyXref_id)
	{
		this.readonlyXref_id = readonlyXref_id;
	}	

	public void setReadonlyXref(Integer readonlyXref_id)
	{
		this.readonlyXref_id = readonlyXref_id;
	}
	
	public Integer getReadonlyXref_Id()
	{
		
		if(readonlyXref != null) 
		{
			return readonlyXref.getId();
		}
		else
		{
			return readonlyXref_id;
		}
	}	
	 
	/**
	 * Get a pretty label normalVarchar for cross reference ReadonlyXref to VarcharEntity.Id.
	 */
	public String getReadonlyXref_NormalVarchar()
	{		
		//FIXME should we auto-load based on getReadonlyXref()?	
		if(readonlyXref != null) {
			return readonlyXref.getNormalVarchar();
		} else {
			return readonlyXref_normalVarchar;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference ReadonlyXref to <a href="VarcharEntity.html#Id">VarcharEntity.Id</a>.
	 * Implies setReadonlyXref(null) until save
	 */
	public void setReadonlyXref_NormalVarchar(String readonlyXref_normalVarchar)
	{
		this.readonlyXref_normalVarchar = readonlyXref_normalVarchar;
	}		
	 
	

	/**
	 * Get the No description provided.
	 * @return nillableXref.
	 */
	public test.fields.OtherVarcharEntity getNillableXref()
	{
		return this.nillableXref;
	}
	
	@Deprecated
	public test.fields.OtherVarcharEntity getNillableXref(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param nillableXref
	 */
	public void setNillableXref( test.fields.OtherVarcharEntity nillableXref)
	{
		
		this.nillableXref = nillableXref;
	}

	
	
	/**
	 * Set foreign key for field nillableXref.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setNillableXref_Id(Integer nillableXref_id)
	{
		this.nillableXref_id = nillableXref_id;
	}	

	public void setNillableXref(Integer nillableXref_id)
	{
		this.nillableXref_id = nillableXref_id;
	}
	
	public Integer getNillableXref_Id()
	{
		
		if(nillableXref != null) 
		{
			return nillableXref.getId();
		}
		else
		{
			return nillableXref_id;
		}
	}	
	 
	/**
	 * Get a pretty label normalVarchar for cross reference NillableXref to OtherVarcharEntity.Id.
	 */
	public String getNillableXref_NormalVarchar()
	{		
		//FIXME should we auto-load based on getNillableXref()?	
		if(nillableXref != null) {
			return nillableXref.getNormalVarchar();
		} else {
			return nillableXref_normalVarchar;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference NillableXref to <a href="OtherVarcharEntity.html#Id">OtherVarcharEntity.Id</a>.
	 * Implies setNillableXref(null) until save
	 */
	public void setNillableXref_NormalVarchar(String nillableXref_normalVarchar)
	{
		this.nillableXref_normalVarchar = nillableXref_normalVarchar;
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
		if (name.toLowerCase().equals("normalxref"))
			return getNormalXref();
		if(name.toLowerCase().equals("normalxref_id"))
			return getNormalXref_Id();
		if(name.toLowerCase().equals("normalxref_normalvarchar"))
			return getNormalXref_NormalVarchar();
		if (name.toLowerCase().equals("readonlyxref"))
			return getReadonlyXref();
		if(name.toLowerCase().equals("readonlyxref_id"))
			return getReadonlyXref_Id();
		if(name.toLowerCase().equals("readonlyxref_normalvarchar"))
			return getReadonlyXref_NormalVarchar();
		if (name.toLowerCase().equals("nillablexref"))
			return getNillableXref();
		if(name.toLowerCase().equals("nillablexref_id"))
			return getNillableXref_Id();
		if(name.toLowerCase().equals("nillablexref_normalvarchar"))
			return getNillableXref_NormalVarchar();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getNormalXref() == null) throw new org.molgenis.db.common.DatabaseException("required field normalXref is null");
		if(this.getReadonlyXref() == null) throw new org.molgenis.db.common.DatabaseException("required field readonlyXref is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("XrefEntity___type") != null) this.set__Type(tuple.getString("XrefEntity___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("XrefEntity_id") != null) this.setId(tuple.getInt("XrefEntity_id"));
			//set NormalXref
			if( strict || tuple.getInt("normalXref_id") != null) this.setNormalXref(tuple.getInt("normalXref_id"));
			if( tuple.getInt("XrefEntity_normalXref_id") != null) this.setNormalXref(tuple.getInt("XrefEntity_normalXref_id"));
			//alias of xref
			if( tuple.getObject("normalXref") != null) this.setNormalXref(tuple.getInt("normalXref"));
			if( tuple.getObject("XrefEntity_normalXref") != null) this.setNormalXref(tuple.getInt("XrefEntity_normalXref"));
			//set label for field NormalXref
			if( strict || tuple.getObject("normalXref_normalVarchar") != null) this.setNormalXref_NormalVarchar(tuple.getString("normalXref_normalVarchar"));			
			if( tuple.getObject("XrefEntity_normalXref_FieldModel(entity=VarcharEntity, name=normalVarchar, type=varchar[127], auto=false, nillable=false, readonly=false, unique=true, default=null)") != null ) this.setNormalXref_NormalVarchar(tuple.getString("XrefEntity_normalXref_normalVarchar"));		
			//set ReadonlyXref
			if( strict || tuple.getInt("readonlyXref_id") != null) this.setReadonlyXref(tuple.getInt("readonlyXref_id"));
			if( tuple.getInt("XrefEntity_readonlyXref_id") != null) this.setReadonlyXref(tuple.getInt("XrefEntity_readonlyXref_id"));
			//alias of xref
			if( tuple.getObject("readonlyXref") != null) this.setReadonlyXref(tuple.getInt("readonlyXref"));
			if( tuple.getObject("XrefEntity_readonlyXref") != null) this.setReadonlyXref(tuple.getInt("XrefEntity_readonlyXref"));
			//set label for field ReadonlyXref
			if( strict || tuple.getObject("readonlyXref_normalVarchar") != null) this.setReadonlyXref_NormalVarchar(tuple.getString("readonlyXref_normalVarchar"));			
			if( tuple.getObject("XrefEntity_readonlyXref_FieldModel(entity=VarcharEntity, name=normalVarchar, type=varchar[127], auto=false, nillable=false, readonly=false, unique=true, default=null)") != null ) this.setReadonlyXref_NormalVarchar(tuple.getString("XrefEntity_readonlyXref_normalVarchar"));		
			//set NillableXref
			if( strict || tuple.getInt("nillableXref_id") != null) this.setNillableXref(tuple.getInt("nillableXref_id"));
			if( tuple.getInt("XrefEntity_nillableXref_id") != null) this.setNillableXref(tuple.getInt("XrefEntity_nillableXref_id"));
			//alias of xref
			if( tuple.getObject("nillableXref") != null) this.setNillableXref(tuple.getInt("nillableXref"));
			if( tuple.getObject("XrefEntity_nillableXref") != null) this.setNillableXref(tuple.getInt("XrefEntity_nillableXref"));
			//set label for field NillableXref
			if( strict || tuple.getObject("nillableXref_normalVarchar") != null) this.setNillableXref_NormalVarchar(tuple.getString("nillableXref_normalVarchar"));			
			if( tuple.getObject("XrefEntity_nillableXref_FieldModel(entity=OtherVarcharEntity, name=normalVarchar, type=varchar[127], auto=false, nillable=false, readonly=false, unique=true, default=null)") != null ) this.setNillableXref_NormalVarchar(tuple.getString("XrefEntity_nillableXref_normalVarchar"));		
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
		String result = "XrefEntity(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= " normalXref_id='" + getNormalXref_Id()+"' ";	
		result+= " normalXref_normalVarchar='" + getNormalXref_NormalVarchar()+"' ";
		result+= " readonlyXref_id='" + getReadonlyXref_Id()+"' ";	
		result+= " readonlyXref_normalVarchar='" + getReadonlyXref_NormalVarchar()+"' ";
		result+= " nillableXref_id='" + getNillableXref_Id()+"' ";	
		result+= " nillableXref_normalVarchar='" + getNillableXref_NormalVarchar()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of XrefEntity.
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
			fields.add("normalXref_id");
		}
		fields.add("normalXref_normalVarchar");
		{
			fields.add("readonlyXref_id");
		}
		fields.add("readonlyXref_normalVarchar");
		{
			fields.add("nillableXref_id");
		}
		fields.add("nillableXref_normalVarchar");
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
		+ "normalXref" +sep
		+ "readonlyXref" +sep
		+ "nillableXref" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("normalXref")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("readonlyXref")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("nillableXref")) {
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
		XrefEntity rhs = (XrefEntity) obj;
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
			Object valueO = getNormalXref();
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
			Object valueO = getReadonlyXref();
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
			Object valueO = getNillableXref();
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
	public XrefEntity create(org.molgenis.db.Tuple tuple) throws Exception
	{
		XrefEntity e = new XrefEntity();
		e.set(tuple);
		return e;
	}
	


	
}

