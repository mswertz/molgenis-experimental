
/* File:        test/model/CextendsA.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.inheritance;

/**
 * CextendsA: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "CextendsA"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.inheritance.db.CextendsAEntityListener.class})
public class CextendsA extends test.inheritance.ClassA 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String FIELDC = "fieldC";
	
	//static methods
	/**
	 * Shorthand for db.query(CextendsA.class).
	 */
	public static org.molgenis.db.Query<? extends CextendsA> query(org.molgenis.db.Database db)
	{
		return db.query(CextendsA.class);
	}
	
	/**
	 * Shorthand for db.find(CextendsA.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends CextendsA> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(CextendsA.class, rules);
	}	
	
	/**
	 * ClassA
	 */
	public static CextendsA findByFieldA(org.molgenis.db.Database db, String fieldA) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<CextendsA> q = db.query(CextendsA.class);
		q.eq(CextendsA.FIELDA, fieldA);
		java.util.List<CextendsA> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * ClassA
	 */
	public static CextendsA findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<CextendsA> q = db.query(CextendsA.class);
		q.eq(CextendsA.ID, id);
		java.util.List<CextendsA> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//No description provided[type=string]
	@javax.persistence.Column(name="fieldC", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="fieldC")
	
				

	@javax.validation.constraints.NotNull
	private String fieldC =  null;

	//constructors
	public CextendsA()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the No description provided.
	 * @return fieldC.
	 */
	public String getFieldC()
	{
		return this.fieldC;
	}
	
	@Deprecated
	public String getFieldC(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param fieldC
	 */
	public void setFieldC( String fieldC)
	{
		
		this.fieldC = fieldC;
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
		if (name.toLowerCase().equals("fielda"))
			return getFieldA();
		if (name.toLowerCase().equals("fieldc"))
			return getFieldC();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getFieldA() == null) throw new org.molgenis.db.common.DatabaseException("required field fieldA is null");
		if(this.getFieldC() == null) throw new org.molgenis.db.common.DatabaseException("required field fieldC is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("CextendsA___type") != null) this.set__Type(tuple.getString("CextendsA___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("CextendsA_id") != null) this.setId(tuple.getInt("CextendsA_id"));
			//set FieldA
			if( strict || tuple.getString("fieldA") != null) this.setFieldA(tuple.getString("fieldA"));
			if( tuple.getString("CextendsA_fieldA") != null) this.setFieldA(tuple.getString("CextendsA_fieldA"));
			//set FieldC
			if( strict || tuple.getString("fieldC") != null) this.setFieldC(tuple.getString("fieldC"));
			if( tuple.getString("CextendsA_fieldC") != null) this.setFieldC(tuple.getString("CextendsA_fieldC"));
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
		String result = "CextendsA(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= "fieldA='" + getFieldA()+"' ";	
		result+= "fieldC='" + getFieldC()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of CextendsA.
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
			fields.add("fieldA");
		}
		{
			fields.add("fieldC");
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
		return "vALUE WAS NULL";
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
		+ "fieldA" +sep
		+ "fieldC" 
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
		CextendsA rhs = (CextendsA) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
             	.appendSuper(super.equals(obj))
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
             	.appendSuper(super.hashCode())
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
			Object valueO = getFieldA();
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
			Object valueO = getFieldC();
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
	public CextendsA create(org.molgenis.db.Tuple tuple) throws Exception
	{
		CextendsA e = new CextendsA();
		e.set(tuple);
		return e;
	}
	


	
}

