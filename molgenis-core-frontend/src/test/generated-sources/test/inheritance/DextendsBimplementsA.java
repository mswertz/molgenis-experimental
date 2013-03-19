
/* File:        test/model/DextendsBimplementsA.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.inheritance;

/**
 * DextendsBimplementsA: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "DextendsBimplementsA"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.inheritance.db.DextendsBimplementsAEntityListener.class})
public class DextendsBimplementsA extends test.inheritance.BimplementsA 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String FIELDD = "fieldD";
	
	//static methods
	/**
	 * Shorthand for db.query(DextendsBimplementsA.class).
	 */
	public static org.molgenis.db.Query<? extends DextendsBimplementsA> query(org.molgenis.db.Database db)
	{
		return db.query(DextendsBimplementsA.class);
	}
	
	/**
	 * Shorthand for db.find(DextendsBimplementsA.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends DextendsBimplementsA> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(DextendsBimplementsA.class, rules);
	}	
	
	/**
	 * CimplementsA
	 */
	public static DextendsBimplementsA findByFieldA(org.molgenis.db.Database db, String fieldA) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<DextendsBimplementsA> q = db.query(DextendsBimplementsA.class);
		q.eq(DextendsBimplementsA.FIELDA, fieldA);
		java.util.List<DextendsBimplementsA> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * BimplementsA
	 */
	public static DextendsBimplementsA findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<DextendsBimplementsA> q = db.query(DextendsBimplementsA.class);
		q.eq(DextendsBimplementsA.ID, id);
		java.util.List<DextendsBimplementsA> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//No description provided[type=string]
	@javax.persistence.Column(name="fieldD", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="fieldD")
	
				

	@javax.validation.constraints.NotNull
	private String fieldD =  null;

	//constructors
	public DextendsBimplementsA()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the No description provided.
	 * @return fieldD.
	 */
	public String getFieldD()
	{
		return this.fieldD;
	}
	
	@Deprecated
	public String getFieldD(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param fieldD
	 */
	public void setFieldD( String fieldD)
	{
		
		this.fieldD = fieldD;
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
		if (name.toLowerCase().equals("fieldb"))
			return getFieldB();
		if (name.toLowerCase().equals("issuetype"))
			return getIssueType();
		if (name.toLowerCase().equals("fieldd"))
			return getFieldD();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getFieldA() == null) throw new org.molgenis.db.common.DatabaseException("required field fieldA is null");
		if(this.getFieldB() == null) throw new org.molgenis.db.common.DatabaseException("required field fieldB is null");
		if(this.getIssueType() == null) throw new org.molgenis.db.common.DatabaseException("required field issueType is null");
		if(this.getFieldD() == null) throw new org.molgenis.db.common.DatabaseException("required field fieldD is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("DextendsBimplementsA___type") != null) this.set__Type(tuple.getString("DextendsBimplementsA___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("DextendsBimplementsA_id") != null) this.setId(tuple.getInt("DextendsBimplementsA_id"));
			//set FieldA
			if( strict || tuple.getString("fieldA") != null) this.setFieldA(tuple.getString("fieldA"));
			if( tuple.getString("DextendsBimplementsA_fieldA") != null) this.setFieldA(tuple.getString("DextendsBimplementsA_fieldA"));
			//set FieldB
			if( strict || tuple.getString("fieldB") != null) this.setFieldB(tuple.getString("fieldB"));
			if( tuple.getString("DextendsBimplementsA_fieldB") != null) this.setFieldB(tuple.getString("DextendsBimplementsA_fieldB"));
			//set IssueType
			if( strict || tuple.getString("IssueType") != null) this.setIssueType(tuple.getString("IssueType"));
			if( tuple.getString("DextendsBimplementsA_IssueType") != null) this.setIssueType(tuple.getString("DextendsBimplementsA_IssueType"));
			//set FieldD
			if( strict || tuple.getString("fieldD") != null) this.setFieldD(tuple.getString("fieldD"));
			if( tuple.getString("DextendsBimplementsA_fieldD") != null) this.setFieldD(tuple.getString("DextendsBimplementsA_fieldD"));
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
		String result = "DextendsBimplementsA(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= "fieldA='" + getFieldA()+"' ";	
		result+= "fieldB='" + getFieldB()+"' ";	
		result+= "issueType='" + getIssueType()+"' ";	
		result+= "fieldD='" + getFieldD()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of DextendsBimplementsA.
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
			fields.add("fieldB");
		}
		{
			fields.add("issueType");
		}
		{
			fields.add("fieldD");
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
		+ "fieldB" +sep
		+ "issueType" +sep
		+ "fieldD" 
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
		DextendsBimplementsA rhs = (DextendsBimplementsA) obj;
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
			Object valueO = getFieldB();
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
			Object valueO = getIssueType();
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
			Object valueO = getFieldD();
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
	public DextendsBimplementsA create(org.molgenis.db.Tuple tuple) throws Exception
	{
		DextendsBimplementsA e = new DextendsBimplementsA();
		e.set(tuple);
		return e;
	}
	


	
}

