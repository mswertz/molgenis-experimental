package org.molgenis.meta.utils;
//package org.molgenis.meta;
//
//import java.io.ByteArrayOutputStream;
//import java.io.FileInputStream;
//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//
//import org.apache.commons.dbcp.BasicDataSource;
//import org.apache.log4j.Logger;
//import org.molgenis.MolgenisOptions;
//import org.molgenis.data.Tuple;
//import org.molgenis.data.tuple.ResultSetTuple;
//import org.molgenis.meta.model.EntityModel;
//import org.molgenis.meta.model.FieldModel;
//import org.molgenis.meta.model.FieldModel.Type;
//import org.molgenis.meta.model.UniqueModel;
//
///**
// * java.sql.Types public static final int ARRAY 2003 public static final int
// * BIGINT -5 public static final int BINARY -2 public static final int BIT -7
// * public static final int BLOB 2004 public static final int BOOLEAN 16 public
// * static final int CHAR 1 public static final int CLOB 2005 public static final
// * int DATALINK 70 public static final int DATE 91 public static final int
// * DECIMAL 3 public static final int DISTINCT 2001 public static final int
// * DOUBLE 8 public static final int FLOAT 6 public static final int INTEGER 4
// * public static final int JAVA_OBJECT 2000 public static final int LONGNVARCHAR
// * -16 public static final int LONGVARBINARY -4 public static final int
// * LONGVARCHAR -1 public static final int NCHAR -15 public static final int
// * NCLOB 2011 public static final int NULL 0 public static final int NUMERIC 2
// * public static final int NVARCHAR -9 public static final int OTHER 1111 public
// * static final int REAL 7 public static final int REF 2006 public static final
// * int ROWID -8 public static final int SMALLINT 5 public static final int
// * SQLXML 2009 public static final int STRUCT 2002 public static final int TIME
// * 92 public static final int TIMESTAMP 93 public static final int TINYINT -6
// * public static final int VARBINARY -3 public static final int VARCHAR 12
// * 
// * @author Morris Swertz
// * 
// */
//public class JDBCModelExtractor
//{
//	public static transient final Logger logger = Logger.getLogger("JDBCModelExtractor");
//
//	public static void main(String[] args) throws Exception
//	{
//		Properties props = new Properties();
//		props.load(new FileInputStream("molgenis.properties"));
//		extractXml(props);
//	}
//	
//	public static String extractXml(MolgenisOptions options)
//	{
//		try
//		{
//			return toString(extractModel(options));
//		}
//		catch (JAXBException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	public static Model extractModel(MolgenisOptions options)
//	{
//		BasicDataSource data_src = new BasicDataSource();
//
//		data_src = new BasicDataSource();
//		data_src.setDriverClassName(options.db_driver.trim());
//		data_src.setUsername(options.db_user.trim());
//		data_src.setPassword(options.db_password.trim());
//		data_src.setUrl(options.db_uri.trim());
//
//		return extractModel(data_src);
//	}
//
//	public static String extractXml(Properties p)
//	{
//		try
//		{
//			return toString(extractModel(p));
//		}
//		catch (JAXBException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
//	
//	public static Model extractModel(Properties p)
//	{
//		BasicDataSource data_src = new BasicDataSource();
//
//		data_src = new BasicDataSource();
//		data_src.setDriverClassName(p.getProperty("db_driver").trim());
//		data_src.setUsername(p.getProperty("db_user").trim());
//		data_src.setPassword(p.getProperty("db_password").trim());
//		data_src.setUrl(p.getProperty("db_uri").trim());
//
//		return extractModel(data_src);
//
//	}
//
//	private static String extractXml(BasicDataSource data_src)
//	{
//		try
//		{
//			return toString(extractModel(data_src));
//		}
//		catch (JAXBException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
//	
//	public static Model extractModel(BasicDataSource data_src)
//	{
//		Model m = new Model();
//
//		try
//		{
//			// check conection
//			data_src.getConnection();
//
//			String url = data_src.getUrl();
//			int start = url.lastIndexOf("/") + 1;
//			int end = url.indexOf("?") == -1 ? url.length() : url.indexOf("?");
//
//			String SCHEMA_NAME = url.substring(start, end);
//			logger.debug("trying to extract: " + SCHEMA_NAME);
//
//			Connection conn = data_src.getConnection();
//			DatabaseMetaData md = conn.getMetaData();
//
//			// ResultSet rs = md.getSchemas();
//			// logger.debug("schema's:");
//			// logResultSet(rs);
//
//			// rs = md.getCatalogs();
//			// logger.debug("catalogs:");
//			// logResultSet(rs);
//
//			m.setName(SCHEMA_NAME);
//
//			ResultSet rs = md.getTables(SCHEMA_NAME, null, null, new String[]
//			{ "TABLE" });
//
//			Tuple tableInfo = new ResultSetTuple(rs);
//			while (rs.next())
//			{
//				logger.debug("TABLE: " + tableInfo);
//
//				EntityModel e = new EntityModel();
//				e.setName(tableInfo.getString("TABLE_NAME"));
//				m.getEntities().add(e);
//
//				// ADD THE COLUMNS
//				ResultSet rsCol = md.getColumns(SCHEMA_NAME, null, tableInfo.getString("TABLE_NAME"), null);
//				while (rsCol.next())
//				{
//					Tuple fieldInfo = new ResultSetTuple(rsCol);
//					logger.debug("COLUMN: " + fieldInfo);
//
//					FieldModel f = new FieldModel();
//					f.setName(fieldInfo.getString("COLUMN_NAME"));
//					f.setType(FieldModel.Type.getType(fieldInfo.getInt("DATA_TYPE")));
//					f.setDefaultValue(fieldInfo.getString("COLUMN_DEF"));
//
//					if (md.getDatabaseProductName().toLowerCase().contains("mysql"))
//					{
//						// accomodate mysql CURRENT_TIMESTAMP
//						if ("CURRENT_TIMESTAMP".equals(f.getDefaultValue())
//								&& (f.getType().equals(FieldModel.Type.DATETIME) || f.getType().equals(FieldModel.Type.DATE)))
//						{
//							f.setDefaultValue(null);
//							f.setAuto(true);
//						}
//
//						// accomodate mysql text/string fields +
//						// nillable="false" -> mysql ignore not null and so
//						// should we!
//					}
//
//					if (fieldInfo.getString("REMARKS") != null && !"".equals(fieldInfo.getString("REMARKS").trim())) f
//							.setDescription(fieldInfo.getString("REMARKS"));
//					if (fieldInfo.getBool("NULLABLE")) f.setNillable(true);
//
//					// auto increment?
//					if (f.getType().equals(FieldModel.Type.INT))
//					{
//						if (fieldInfo.getObject("IS_AUTOINCREMENT") != null) f.setAuto(fieldInfo
//								.getBool("IS_AUTOINCREMENT"));
//					}
//
//					if (f.getType().equals(FieldModel.Type.STRING) || f.getType().equals(FieldModel.Type.CHAR))
//					{
//						if (fieldInfo.getInt("COLUMN_SIZE") > 255)
//						{
//							f.setType(FieldModel.Type.TEXT);
//							f.setLength(fieldInfo.getInt("COLUMN_SIZE"));
//						}
//						else
//						{
//							if(fieldInfo.getInt("COLUMN_SIZE") != 255) f.setLength(fieldInfo.getInt("COLUMN_SIZE"));
//							f.setType(null); //defaults to string
//						}
//					}
//
//					ResultSet rsXref = md.getImportedKeys(SCHEMA_NAME, null, tableInfo.getString("TABLE_NAME"));
//					while (rsXref.next())
//					{
//						Tuple xrefInfo = new ResultSetTuple(rsXref);
//						if (xrefInfo.getString("FKCOLUMN_NAME").equals(fieldInfo.getString("COLUMN_NAME")))
//						{
//							f.setType(FieldModel.Type.XREF_SINGLE);
//							// problem: PKTABLE_NAME is lowercase, need to be
//							// corrected later?
//							f.setXrefField(xrefInfo.getString("PKTABLE_NAME") + "."
//									+ xrefInfo.getString("PKCOLUMN_NAME"));
//						}
//					}
//
//					e.getFields().add(f);
//				}
//
//				// GET AUTO INCREMENT
//
//				// mysql workaround
//				Statement stmt = null;
//				try
//				{
//					String sql = "select * from " + e.getName() + " where 1=0";
//					stmt = conn.createStatement();
//
//					ResultSet autoincRs = stmt.executeQuery(sql);
//					ResultSetMetaData rowMeta = autoincRs.getMetaData();
//					for (int i = 1; i <= rowMeta.getColumnCount(); i++)
//					{
//						if (rowMeta.isAutoIncrement(i))
//						{
//							e.getFields().get(i - 1).setAuto(true);
//						}
//					}
//				}
//				catch (Exception exc)
//				{
//					logger.error("didn't retrieve autoinc/sequence: " + exc.getMessage());
//					// e.printStackTrace();
//				}
//				finally
//				{
//					stmt.close();
//				}
//
//				// ADD UNIQUE CONTRAINTS
//				ResultSet rsIndex = md.getIndexInfo(SCHEMA_NAME, null, tableInfo.getString("TABLE_NAME"), true, false);
//				// indexed list of uniques
//				Map<String, List<String>> uniques = new LinkedHashMap<String, List<String>>();
//				while (rsIndex.next())
//				{
//					Tuple index = new ResultSetTuple(rsIndex);
//					logger.debug("UNIQUE: " + index);
//
//					// TABLE_CAT='molgenistest' TABLE_SCHEM='null'
//					// TABLE_NAME='boolentity' NON_UNIQUE='false'
//					// INDEX_QUALIFIER='' INDEX_NAME='PRIMARY' TYPE='3'
//					// ORDINAL_POSITION='1' COLUMN_NAME='id' ASC_OR_DESC='A'
//					// CARDINALITY='0' PAGES='0' FILTER_CONDITION='null'
//					if (uniques.get(index.getString("INDEX_NAME")) == null) uniques.put(index.getString("INDEX_NAME"),
//							new ArrayList<String>());
//					uniques.get(index.getString("INDEX_NAME")).add(index.getString("COLUMN_NAME"));
//				}
//				for (List<String> index : uniques.values())
//				{
//					if (index.size() == 1)
//					{
//						e.getField(index.get(0)).setUnique(true);
//					}
//					else
//					{
//						String fields = "";
//						for (String field_name : index)
//						{
//							fields += "," + field_name;
//						}
//						UniqueModel u = new UniqueModel();
//						u.setFields(fields.substring(1));
//						e.getUniques().add(u);
//					}
//
//				}
//
//				// FIND type="autoid"
//				for (FieldModel f : e.getFields())
//				{
//					if (f.getAuto() != null && f.getAuto() && f.getType().equals(Type.INT) && f.getUnique() != null
//							&& f.getUnique())
//					{
//						f.setType(FieldModel.Type.AUTOID);
//						f.setAuto(null);
//						f.setUnique(null);
//					}
//				}
//			}
//
//			// GUESS type="xref"
//			// normally they should be defined as foreign key but sometimes
//			// designers leave this out
//			// rule: if the field name is the same and one is autoid,
//			// then other fields having the same name are likely to be xref to
//			// the autoid
//			for (EntityModel e : m.getEntities())
//			{
//				for (FieldModel f : e.getFields())
//				{
//					if (FieldModel.Type.AUTOID.equals(f.getType()))
//					{
//						for (EntityModel otherE : m.getEntities())
//						{
//							for (FieldModel otherF : otherE.getFields())
//							{
//								// assume xref if
//								// name == name
//								// otherF.type == int
//								if (otherF.getName().equals(f.getName()) && otherF.getType().equals(FieldModel.Type.INT))
//								{
//									logger.debug("Guessed that " + otherE.getName() + "." + otherF.getName()
//											+ " references " + e.getName() + "." + f.getName());
//									otherF.setType(FieldModel.Type.XREF_SINGLE);
//									// otherF.setXrefEntity(;
//									otherF.setXrefField(e.getName() + "." + f.getName());
//								}
//							}
//						}
//					}
//
//				}
//			}
//
//			// GUESS the xref labels
//			// guess the xreflabel as being the non-autoid field that is unique
//			// and not null
//			// rule: if there is another unique field in the referenced table
//			// then that probably is usable as label
//			for (EntityModel e : m.getEntities())
//			{
//				for (FieldModel f : e.getFields())
//				{
//					if (FieldModel.Type.XREF_SINGLE.equals(f.getType()))
//					{
//						String xrefEntityName = f.getXrefField().substring(0, f.getXrefField().indexOf("."));
//						String xrefFieldName = f.getXrefField().substring(f.getXrefField().indexOf(".") + 1);
//						// reset the xref entity to the uppercase version
//						f.setXrefField(m.getEntity(xrefEntityName).getName() + "." + xrefFieldName);
//
//						for (FieldModel labelField : m.getEntity(xrefEntityName).getFields())
//						{
//							// find the other unique, nillable="false" field, if
//							// any
//							if (!labelField.getName().equals(xrefFieldName)
//									&& Boolean.TRUE.equals(labelField.getUnique())
//									&& Boolean.FALSE.equals(labelField.getNillable()))
//							{
//								logger.debug("guessed label " + e.getName() + "." + labelField.getName());
//								f.setXrefLabel(labelField.getName());
//							}
//						}
//					}
//				}
//			}
//
//			// GUESS the inheritance relationship
//			// rule: if there is a foreign key that is unique itself it is
//			// probably inheriting...
//			// action: change to inheritance and remove the xref field
//			for (EntityModel e : m.getEntities())
//			{
//				List<FieldModel> toBeRemoved = new ArrayList<FieldModel>();
//				for (FieldModel f : e.getFields())
//				{
//					if (FieldModel.Type.XREF_SINGLE.equals(f.getType()) && Boolean.TRUE.equals(f.getUnique()))
//					{
//						String entityName = f.getXrefField().substring(0, f.getXrefField().indexOf("."));
//						e.setExtends(entityName);
//						toBeRemoved.add(f);
//					}
//				}
//				for (FieldModel f : toBeRemoved)
//				{
//					e.getFields().remove(f);
//				}
//			}
//
//			// TODO GUESS the type="mref"
//			// rule: any entity that is not a subclass and that has maximum two xref fields and autoid field
//			// should be a mref
//			List<EntityModel> toBeRemoved = new ArrayList<EntityModel>();
//			for (EntityModel e : m.getEntities()) if("".equals(e.getExtends()))
//			{
//
//				if (e.getFields().size() <= 3)
//				{
//					int xrefs = 0;
//					String idField = null;
//					// the column refering to 'localEntity'
//					String localIdField = null;
//					// the localEntiy
//					String localEntity = null;
//					// the column referring to 'remoteEntity'
//					String localEntityField = null;
//					// the column the localIdField is referning to
//					String remoteIdField = null;
//					// the column remoteEntity
//					String remoteEntity = null;
//					// the column the remoteIdField is referring to
//					String remoteEntityField = null;
//
//					for (FieldModel f : e.getFields())
//					{
//						if (FieldModel.Type.AUTOID.equals(f.getType()))
//						{
//							idField = f.getName();
//						}
//						else if (FieldModel.Type.XREF_SINGLE.equals(f.getType()))
//						{
//							xrefs++;
//							if (xrefs == 1)
//							{
//								localIdField = f.getName();
//								// localEntityField is just the idField of the
//								// localEntity
//								localEntity = f.getXrefField().substring(0, f.getXrefField().indexOf("."));
//								localEntityField = f.getXrefField().substring(f.getXrefField().indexOf(".") + 1);
//							}
//							else
//							{
//								remoteIdField = f.getName();
//								// should be the id field of the remote entity
//								remoteEntity = f.getXrefField().substring(0, f.getXrefField().indexOf("."));
//								remoteEntityField = f.getXrefField().substring(f.getXrefField().indexOf(".") + 1);
//							}
//						}
//					}
//
//					// if valid mref, drop this entity and add mref fields to
//					// the other entities. 
//					if (xrefs == 2 && (e.getFields().size() == 2 || idField != null))
//					{
//						// add mref on 'local' end
//						EntityModel localContainer = m.getEntity(localEntity);
//						FieldModel localField = new FieldModel();
//						if (localContainer.getField(e.getName()) == null)
//						{
//							localField.setName(e.getName());
//						}
//						
//						localField.setType(FieldModel.Type.XREF_MULTIPLE);
//						localField.setXrefField(remoteEntity + "." + remoteEntityField);
//						localField.setMrefName(e.getName());
//						localField.setMrefLocalid(localIdField);
//						localField.setMrefRemoteid(remoteIdField);
//						localContainer.getFields().add(localField);
//
//						// add mref to remote end
//						EntityModel remoteContainer = m.getEntity(remoteEntity);
//						FieldModel remoteField = new FieldModel();
//						remoteField.setType(FieldModel.Type.XREF_MULTIPLE);
//						remoteField.setXrefField(localEntity + "." + localEntityField);
//						remoteField.setMrefName(e.getName());
//						// don't need to add local id as it is refering back
//						remoteField.setMrefLocalid(remoteIdField);
//						remoteField.setMrefRemoteid(localIdField);
//						
//						if (remoteContainer.getField(e.getName()) == null)
//						{
//							remoteField.setName(e.getName());
//						}
//						else
//						{
//							throw new RuntimeException("MREF creation failed: there is already a field "+remoteContainer.getName()+"."+e.getName());
//						}
//						
//						remoteContainer.getFields().add(remoteField);
//
//						// remove the link table as separate entity
//						toBeRemoved.add(e);
//						logger.debug("guessed mref " + e.getName());
//					}
//				}
//			}
//			m.getEntities().removeAll(toBeRemoved);
//
//			// logger.info(MolgenisLanguage.summarize(m));
//			logger.info(toString(m));
//			return m;
//		}
//		catch (Exception e)
//		{
//			logger.error(e);
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	private static String toString(Model model) throws JAXBException
//	{
//		// save to xml (FIXME: now print only)
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		JAXBContext jaxbContext = JAXBContext.newInstance("org.molgenis.model.jaxb");
//		Marshaller marshaller = jaxbContext.createMarshaller();
//		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
//		marshaller.marshal(model, out);
//		return out.toString().trim();
//	}
//}
