
/* File:        test/model/FileEntity.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.fields;

/**
 * FileEntity: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "FileEntity"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.fields.db.FileEntityEntityListener.class})
public class FileEntity extends org.molgenis.db.common.AbstractEntity 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String __TYPE = "__type";
	public final static String ID = "id";
	public final static String NORMALFILE = "normalFile";
	public final static String READONLYFILE = "readonlyFile";
	public final static String NILLABLEFILE = "nillableFile";
	
	//static methods
	/**
	 * Shorthand for db.query(FileEntity.class).
	 */
	public static org.molgenis.db.Query<? extends FileEntity> query(org.molgenis.db.Database db)
	{
		return db.query(FileEntity.class);
	}
	
	/**
	 * Shorthand for db.find(FileEntity.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends FileEntity> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(FileEntity.class, rules);
	}	
	
	/**
	 * FileEntity
	 */
	public static FileEntity findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<FileEntity> q = db.query(FileEntity.class);
		q.eq(FileEntity.ID, id);
		java.util.List<FileEntity> result = q.find();
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


	//No description provided[type=file]
	@javax.persistence.Column(name="normalFile", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="normalFile")
	
				

	@javax.validation.constraints.NotNull
	private String normalFile =  null;
	@javax.persistence.Lob
	private java.io.File normalFile_file = null;


	//No description provided[type=file]
	@javax.persistence.Column(name="readonlyFile", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="readonlyFile")
	
				

	@javax.validation.constraints.NotNull
	private String readonlyFile =  null;
	@javax.persistence.Lob
	private java.io.File readonlyFile_file = null;


	//No description provided[type=file]
	@javax.persistence.Column(name="nillableFile")
	@javax.xml.bind.annotation.XmlElement(name="nillableFile")
	
				

	private String nillableFile =  null;
	@javax.persistence.Lob
	private java.io.File nillableFile_file = null;

	//constructors
	public FileEntity()
	{
	
		//options for enum __Type
		__type_options.add(new org.molgenis.db.common.ValueLabel("[FileEntity]","[FileEntity]"));
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
	 * @return normalFile.
	 */
	public String getNormalFile()
	{
		return this.normalFile;
	}
	
	@Deprecated
	public String getNormalFile(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param normalFile
	 */
	public void setNormalFile( String normalFile)
	{
		
		this.normalFile = normalFile;
	}

	
	/**
	 * getNormalFile() is a textual pointer to a file. getNormalFileAttachedFile() can be used to retrieve the full paht to this file.
	 */
	public java.io.File getNormalFileAttachedFile()
	{
		return normalFile_file;
	}
	
	/**
	 * NormalFile is a pointer to a file. Use setNormalFileAttachedFile() to attach this file so it can be 
	 * retrieved using getNormalFileAttachedFile().
	 */
	public void setNormalFileAttachedFile(java.io.File file)
	{
		normalFile_file = file;
	}

	/**
	 * Get the No description provided.
	 * @return readonlyFile.
	 */
	public String getReadonlyFile()
	{
		return this.readonlyFile;
	}
	
	@Deprecated
	public String getReadonlyFile(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param readonlyFile
	 */
	public void setReadonlyFile( String readonlyFile)
	{
		
		this.readonlyFile = readonlyFile;
	}

	
	/**
	 * getReadonlyFile() is a textual pointer to a file. getReadonlyFileAttachedFile() can be used to retrieve the full paht to this file.
	 */
	public java.io.File getReadonlyFileAttachedFile()
	{
		return readonlyFile_file;
	}
	
	/**
	 * ReadonlyFile is a pointer to a file. Use setReadonlyFileAttachedFile() to attach this file so it can be 
	 * retrieved using getReadonlyFileAttachedFile().
	 */
	public void setReadonlyFileAttachedFile(java.io.File file)
	{
		readonlyFile_file = file;
	}

	/**
	 * Get the No description provided.
	 * @return nillableFile.
	 */
	public String getNillableFile()
	{
		return this.nillableFile;
	}
	
	@Deprecated
	public String getNillableFile(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param nillableFile
	 */
	public void setNillableFile( String nillableFile)
	{
		
		this.nillableFile = nillableFile;
	}

	
	/**
	 * getNillableFile() is a textual pointer to a file. getNillableFileAttachedFile() can be used to retrieve the full paht to this file.
	 */
	public java.io.File getNillableFileAttachedFile()
	{
		return nillableFile_file;
	}
	
	/**
	 * NillableFile is a pointer to a file. Use setNillableFileAttachedFile() to attach this file so it can be 
	 * retrieved using getNillableFileAttachedFile().
	 */
	public void setNillableFileAttachedFile(java.io.File file)
	{
		nillableFile_file = file;
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
		if (name.toLowerCase().equals("normalfile"))
			return getNormalFile();
		if (name.toLowerCase().equals("readonlyfile"))
			return getReadonlyFile();
		if (name.toLowerCase().equals("nillablefile"))
			return getNillableFile();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getNormalFile() == null) throw new org.molgenis.db.common.DatabaseException("required field normalFile is null");
		if(this.getReadonlyFile() == null) throw new org.molgenis.db.common.DatabaseException("required field readonlyFile is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("FileEntity___type") != null) this.set__Type(tuple.getString("FileEntity___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("FileEntity_id") != null) this.setId(tuple.getInt("FileEntity_id"));
			//set NormalFile
			if( strict || tuple.getString("normalFile") != null) this.setNormalFile(tuple.getString("normalFile"));
			if( tuple.getString("FileEntity_normalFile") != null) this.setNormalFile(tuple.getString("FileEntity_normalFile"));
			this.setNormalFileAttachedFile(tuple.getFile("filefor_normalFile"));
			if(tuple.getFile("filefor_FileEntity_normalFile") != null) this.setNormalFileAttachedFile(tuple.getFile("filefor_FileEntity_normalFile"));
			//set ReadonlyFile
			if( strict || tuple.getString("readonlyFile") != null) this.setReadonlyFile(tuple.getString("readonlyFile"));
			if( tuple.getString("FileEntity_readonlyFile") != null) this.setReadonlyFile(tuple.getString("FileEntity_readonlyFile"));
			this.setReadonlyFileAttachedFile(tuple.getFile("filefor_readonlyFile"));
			if(tuple.getFile("filefor_FileEntity_readonlyFile") != null) this.setReadonlyFileAttachedFile(tuple.getFile("filefor_FileEntity_readonlyFile"));
			//set NillableFile
			if( strict || tuple.getString("nillableFile") != null) this.setNillableFile(tuple.getString("nillableFile"));
			if( tuple.getString("FileEntity_nillableFile") != null) this.setNillableFile(tuple.getString("FileEntity_nillableFile"));
			this.setNillableFileAttachedFile(tuple.getFile("filefor_nillableFile"));
			if(tuple.getFile("filefor_FileEntity_nillableFile") != null) this.setNillableFileAttachedFile(tuple.getFile("filefor_FileEntity_nillableFile"));
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
		String result = "FileEntity(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= "normalFile='" + getNormalFile()+"' ";	
		result+= "readonlyFile='" + getReadonlyFile()+"' ";	
		result+= "nillableFile='" + getNillableFile()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of FileEntity.
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
			fields.add("normalFile");
		}
		{
			fields.add("readonlyFile");
		}
		{
			fields.add("nillableFile");
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
		+ "normalFile" +sep
		+ "readonlyFile" +sep
		+ "nillableFile" 
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
		FileEntity rhs = (FileEntity) obj;
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
			Object valueO = getNormalFile();
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
			Object valueO = getReadonlyFile();
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
			Object valueO = getNillableFile();
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
	public FileEntity create(org.molgenis.db.Tuple tuple) throws Exception
	{
		FileEntity e = new FileEntity();
		e.set(tuple);
		return e;
	}
	


	
}

