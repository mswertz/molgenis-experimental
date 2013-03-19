
/* File:        test/model/MrefEntity.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.fields;

/**
 * MrefEntity: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "MrefEntity"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.fields.db.MrefEntityEntityListener.class})
public class MrefEntity extends org.molgenis.db.common.AbstractEntity 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String __TYPE = "__type";
	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String NORMALMREF = "normalMref";
	public final static String NORMALMREF_NORMALVARCHAR = "normalMref_normalVarchar";
	public final static String READONLYMREF = "readonlyMref";
	public final static String READONLYMREF_NORMALVARCHAR = "readonlyMref_normalVarchar";
	public final static String NILLABLEMREF = "nillableMref";
	public final static String NILLABLEMREF_NORMALVARCHAR = "nillableMref_normalVarchar";
	
	//static methods
	/**
	 * Shorthand for db.query(MrefEntity.class).
	 */
	public static org.molgenis.db.Query<? extends MrefEntity> query(org.molgenis.db.Database db)
	{
		return db.query(MrefEntity.class);
	}
	
	/**
	 * Shorthand for db.find(MrefEntity.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends MrefEntity> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(MrefEntity.class, rules);
	}	
	
	/**
	 * MrefEntity
	 */
	public static MrefEntity findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<MrefEntity> q = db.query(MrefEntity.class);
		q.eq(MrefEntity.ID, id);
		java.util.List<MrefEntity> result = q.find();
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


	//At least one normal field is required...[type=string]
	@javax.persistence.Column(name="name", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	@javax.validation.constraints.NotNull
	private String name =  null;


	//No description provided[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="normalMref", insertable=true, updatable=true, nullable=false)
	@javax.persistence.JoinTable(name="MrefEntity_normalMref", 
			joinColumns=@javax.persistence.JoinColumn(name="MrefEntity"), inverseJoinColumns=@javax.persistence.JoinColumn(name="normalMref"))
	
				

	@javax.validation.constraints.NotNull
	private java.util.List<test.fields.VarcharEntity> normalMref = new java.util.ArrayList<test.fields.VarcharEntity>();
	@javax.persistence.Transient
	private java.util.List<Integer> normalMref_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> normalMref_normalVarchar = new java.util.ArrayList<String>();


	//No description provided[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="readonlyMref", insertable=true, updatable=true, nullable=false)
	@javax.persistence.JoinTable(name="MrefEntity_readonlyMref", 
			joinColumns=@javax.persistence.JoinColumn(name="MrefEntity"), inverseJoinColumns=@javax.persistence.JoinColumn(name="readonlyMref"))
	
				

	@javax.validation.constraints.NotNull
	private java.util.List<test.fields.VarcharEntity> readonlyMref = new java.util.ArrayList<test.fields.VarcharEntity>();
	@javax.persistence.Transient
	private java.util.List<Integer> readonlyMref_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> readonlyMref_normalVarchar = new java.util.ArrayList<String>();


	//No description provided[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="nillableMref", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="MrefEntity_nillableMref", 
			joinColumns=@javax.persistence.JoinColumn(name="MrefEntity"), inverseJoinColumns=@javax.persistence.JoinColumn(name="nillableMref"))
	
				

	private java.util.List<test.fields.VarcharEntity> nillableMref = new java.util.ArrayList<test.fields.VarcharEntity>();
	@javax.persistence.Transient
	private java.util.List<Integer> nillableMref_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> nillableMref_normalVarchar = new java.util.ArrayList<String>();

	//constructors
	public MrefEntity()
	{
	
		//options for enum __Type
		__type_options.add(new org.molgenis.db.common.ValueLabel("[MrefEntity]","[MrefEntity]"));
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
	 * Get the At least one normal field is required....
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
	 * Set the At least one normal field is required....
	 * @param name
	 */
	public void setName( String name)
	{
		
		this.name = name;
	}

	

	/**
	 * Get the No description provided.
	 * @return normalMref.
	 */
	public java.util.List<test.fields.VarcharEntity> getNormalMref()
	{
		return this.normalMref;
	}
	
	@Deprecated
	public java.util.List<test.fields.VarcharEntity> getNormalMref(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param normalMref
	 */
	public void setNormalMref( java.util.List<test.fields.VarcharEntity> normalMref)
	{
		
		this.normalMref = normalMref;
	}

	
	public void setNormalMref_Id(Integer ... normalMref)
	{
		this.setNormalMref_Id(java.util.Arrays.asList(normalMref));
	}	
	
	public void setNormalMref(test.fields.VarcharEntity ... normalMref)
	{
		this.setNormalMref(java.util.Arrays.asList(normalMref));
	}	
	
	/**
	 * Set foreign key for field normalMref.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setNormalMref_Id(java.util.List<Integer> normalMref_id)
	{
		this.normalMref_id = normalMref_id;
	}	
	
	public java.util.List<Integer> getNormalMref_Id()
	{
		return normalMref_id;
	}	
	
	/**
	 * Get a pretty label for cross reference NormalMref to <a href="VarcharEntity.html#Id">VarcharEntity.Id</a>.
	 */
	public java.util.List<String> getNormalMref_NormalVarchar()
	{
		return normalMref_normalVarchar;
	}
	
	/**
	 * Update the foreign key NormalMref
	 * This sets normalMref to null until next database transaction.
	 */
	public void setNormalMref_NormalVarchar(java.util.List<String> normalMref_normalVarchar)
	{
		this.normalMref_normalVarchar = normalMref_normalVarchar;
	}		
	

	/**
	 * Get the No description provided.
	 * @return readonlyMref.
	 */
	public java.util.List<test.fields.VarcharEntity> getReadonlyMref()
	{
		return this.readonlyMref;
	}
	
	@Deprecated
	public java.util.List<test.fields.VarcharEntity> getReadonlyMref(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param readonlyMref
	 */
	public void setReadonlyMref( java.util.List<test.fields.VarcharEntity> readonlyMref)
	{
		
		this.readonlyMref = readonlyMref;
	}

	
	public void setReadonlyMref_Id(Integer ... readonlyMref)
	{
		this.setReadonlyMref_Id(java.util.Arrays.asList(readonlyMref));
	}	
	
	public void setReadonlyMref(test.fields.VarcharEntity ... readonlyMref)
	{
		this.setReadonlyMref(java.util.Arrays.asList(readonlyMref));
	}	
	
	/**
	 * Set foreign key for field readonlyMref.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setReadonlyMref_Id(java.util.List<Integer> readonlyMref_id)
	{
		this.readonlyMref_id = readonlyMref_id;
	}	
	
	public java.util.List<Integer> getReadonlyMref_Id()
	{
		return readonlyMref_id;
	}	
	
	/**
	 * Get a pretty label for cross reference ReadonlyMref to <a href="VarcharEntity.html#Id">VarcharEntity.Id</a>.
	 */
	public java.util.List<String> getReadonlyMref_NormalVarchar()
	{
		return readonlyMref_normalVarchar;
	}
	
	/**
	 * Update the foreign key ReadonlyMref
	 * This sets readonlyMref to null until next database transaction.
	 */
	public void setReadonlyMref_NormalVarchar(java.util.List<String> readonlyMref_normalVarchar)
	{
		this.readonlyMref_normalVarchar = readonlyMref_normalVarchar;
	}		
	

	/**
	 * Get the No description provided.
	 * @return nillableMref.
	 */
	public java.util.List<test.fields.VarcharEntity> getNillableMref()
	{
		return this.nillableMref;
	}
	
	@Deprecated
	public java.util.List<test.fields.VarcharEntity> getNillableMref(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param nillableMref
	 */
	public void setNillableMref( java.util.List<test.fields.VarcharEntity> nillableMref)
	{
		
		this.nillableMref = nillableMref;
	}

	
	public void setNillableMref_Id(Integer ... nillableMref)
	{
		this.setNillableMref_Id(java.util.Arrays.asList(nillableMref));
	}	
	
	public void setNillableMref(test.fields.VarcharEntity ... nillableMref)
	{
		this.setNillableMref(java.util.Arrays.asList(nillableMref));
	}	
	
	/**
	 * Set foreign key for field nillableMref.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setNillableMref_Id(java.util.List<Integer> nillableMref_id)
	{
		this.nillableMref_id = nillableMref_id;
	}	
	
	public java.util.List<Integer> getNillableMref_Id()
	{
		return nillableMref_id;
	}	
	
	/**
	 * Get a pretty label for cross reference NillableMref to <a href="VarcharEntity.html#Id">VarcharEntity.Id</a>.
	 */
	public java.util.List<String> getNillableMref_NormalVarchar()
	{
		return nillableMref_normalVarchar;
	}
	
	/**
	 * Update the foreign key NillableMref
	 * This sets nillableMref to null until next database transaction.
	 */
	public void setNillableMref_NormalVarchar(java.util.List<String> nillableMref_normalVarchar)
	{
		this.nillableMref_normalVarchar = nillableMref_normalVarchar;
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
		if (name.toLowerCase().equals("normalmref"))
			return getNormalMref();
		if(name.toLowerCase().equals("normalmref_id"))
			return getNormalMref_Id();
		if(name.toLowerCase().equals("normalmref_normalvarchar"))
			return getNormalMref_NormalVarchar();
		if (name.toLowerCase().equals("readonlymref"))
			return getReadonlyMref();
		if(name.toLowerCase().equals("readonlymref_id"))
			return getReadonlyMref_Id();
		if(name.toLowerCase().equals("readonlymref_normalvarchar"))
			return getReadonlyMref_NormalVarchar();
		if (name.toLowerCase().equals("nillablemref"))
			return getNillableMref();
		if(name.toLowerCase().equals("nillablemref_id"))
			return getNillableMref_Id();
		if(name.toLowerCase().equals("nillablemref_normalvarchar"))
			return getNillableMref_NormalVarchar();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getName() == null) throw new org.molgenis.db.common.DatabaseException("required field name is null");
		if(this.getNormalMref() == null) throw new org.molgenis.db.common.DatabaseException("required field normalMref is null");
		if(this.getReadonlyMref() == null) throw new org.molgenis.db.common.DatabaseException("required field readonlyMref is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("MrefEntity___type") != null) this.set__Type(tuple.getString("MrefEntity___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("MrefEntity_id") != null) this.setId(tuple.getInt("MrefEntity_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("MrefEntity_name") != null) this.setName(tuple.getString("MrefEntity_name"));
			//set NormalMref
			if( tuple.getObject("normalMref")!= null || tuple.getObject("MrefEntity_normalMref")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("normalMref");
				if(tuple.getObject("MrefEntity_normalMref")!= null) mrefs = tuple.getList("MrefEntity_normalMref");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setNormalMref_Id( values );
			}
			//set label normalVarchar for mref field NormalMref	
			if( tuple.getObject("normalMref_normalVarchar")!= null || tuple.getObject("MrefEntity_normalMref_normalVarchar")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("normalMref_normalVarchar");
				if(tuple.getObject("MrefEntity_normalMref_normalVarchar")!= null) mrefs = tuple.getList("MrefEntity_normalMref_normalVarchar");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setNormalMref_NormalVarchar( values );			
			}	
			//set ReadonlyMref
			if( tuple.getObject("readonlyMref")!= null || tuple.getObject("MrefEntity_readonlyMref")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("readonlyMref");
				if(tuple.getObject("MrefEntity_readonlyMref")!= null) mrefs = tuple.getList("MrefEntity_readonlyMref");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setReadonlyMref_Id( values );
			}
			//set label normalVarchar for mref field ReadonlyMref	
			if( tuple.getObject("readonlyMref_normalVarchar")!= null || tuple.getObject("MrefEntity_readonlyMref_normalVarchar")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("readonlyMref_normalVarchar");
				if(tuple.getObject("MrefEntity_readonlyMref_normalVarchar")!= null) mrefs = tuple.getList("MrefEntity_readonlyMref_normalVarchar");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setReadonlyMref_NormalVarchar( values );			
			}	
			//set NillableMref
			if( tuple.getObject("nillableMref")!= null || tuple.getObject("MrefEntity_nillableMref")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("nillableMref");
				if(tuple.getObject("MrefEntity_nillableMref")!= null) mrefs = tuple.getList("MrefEntity_nillableMref");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setNillableMref_Id( values );
			}
			//set label normalVarchar for mref field NillableMref	
			if( tuple.getObject("nillableMref_normalVarchar")!= null || tuple.getObject("MrefEntity_nillableMref_normalVarchar")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("nillableMref_normalVarchar");
				if(tuple.getObject("MrefEntity_nillableMref_normalVarchar")!= null) mrefs = tuple.getList("MrefEntity_nillableMref_normalVarchar");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setNillableMref_NormalVarchar( values );			
			}	
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
		String result = "MrefEntity(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= " normalMref_id='" + getNormalMref_Id()+"' ";	
		result+= " normalMref_normalVarchar='" + getNormalMref_NormalVarchar()+"' ";
		result+= " readonlyMref_id='" + getReadonlyMref_Id()+"' ";	
		result+= " readonlyMref_normalVarchar='" + getReadonlyMref_NormalVarchar()+"' ";
		result+= " nillableMref_id='" + getNillableMref_Id()+"' ";	
		result+= " nillableMref_normalVarchar='" + getNillableMref_NormalVarchar()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of MrefEntity.
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
			fields.add("normalMref_id");
		}
		fields.add("normalMref_normalVarchar");
		{
			fields.add("readonlyMref_id");
		}
		fields.add("readonlyMref_normalVarchar");
		{
			fields.add("nillableMref_id");
		}
		fields.add("nillableMref_normalVarchar");
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
		+ "name" +sep
		+ "normalMref" +sep
		+ "readonlyMref" +sep
		+ "nillableMref" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("normalMref")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("readonlyMref")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("nillableMref")) {
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
		MrefEntity rhs = (MrefEntity) obj;
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
			Object valueO = getNormalMref();
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
			Object valueO = getReadonlyMref();
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
			Object valueO = getNillableMref();
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
	public MrefEntity create(org.molgenis.db.Tuple tuple) throws Exception
	{
		MrefEntity e = new MrefEntity();
		e.set(tuple);
		return e;
	}
	


	
}

