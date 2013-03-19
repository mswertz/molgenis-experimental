package org.molgenis;

import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.molgenis.model.FieldModel;
import org.molgenis.model.MolgenisModelException;
import org.molgenis.types.BoolField;
import org.molgenis.types.DateField;
import org.molgenis.types.DatetimeField;
import org.molgenis.types.DecimalField;
import org.molgenis.types.EmailField;
import org.molgenis.types.EnumField;
import org.molgenis.types.FieldType;
import org.molgenis.types.FileField;
import org.molgenis.types.FreemarkerField;
import org.molgenis.types.HyperlinkField;
import org.molgenis.types.ImageField;
import org.molgenis.types.IntField;
import org.molgenis.types.LongField;
import org.molgenis.types.MrefField;
import org.molgenis.types.OnoffField;
import org.molgenis.types.RichtextField;
import org.molgenis.types.StringField;
import org.molgenis.types.TextField;
import org.molgenis.types.UnknownField;
import org.molgenis.types.XrefField;

/**
 * Singleton class that holds all known field types in MOLGENIS. For each
 * FieldType it can be defined how to behave in mysql, java, hsqldb, etc. <br>
 * 
 * @see FieldType interface
 */
public class MolgenisTypes
{
	private static Map<String, FieldType> types = new TreeMap<String, FieldType>();
	private static Logger logger = Logger.getLogger(MolgenisTypes.class);
	private static boolean init = false;

	/** Initialize default field types */
	private static void init()
	{
		if (!init)
		{
			addType(new BoolField());
			addType(new DateField());
			addType(new DatetimeField());
			addType(new DecimalField());
			addType(new EnumField());
			addType(new EmailField());
			addType(new FileField());
			addType(new ImageField());
			addType(new HyperlinkField());
			addType(new LongField());
			addType(new MrefField());
			addType(new OnoffField());
			addType(new StringField());
			addType(new TextField());
			addType(new XrefField());
			addType(new IntField());
			addType(new RichtextField());
			addType(new FreemarkerField());

			init = true;
		}

	}

	public static void addType(FieldType ft)
	{
		types.put(ft.getClass().getSimpleName().toLowerCase(), ft);
	}
	
	public static FieldType getType(String name)
	{
		init();
		try
		{
			return types.get(name + "field").getClass().newInstance();
		}
		catch (final Exception e)
		{
			logger.warn("couldn't get type for name '" + name + "'");
			return new UnknownField();
		}
	}

	public static FieldType get(FieldModel f) throws MolgenisModelException
	{
		init();
		try
		{
			final FieldType ft = f.getType().getClass().newInstance();
			ft.setField(f);
			return ft;
		}
		catch (final Exception e)
		{
			e.printStackTrace();
			throw new MolgenisModelException(e.getMessage());
		}
	}

	public static FieldType getTypeBySqlTypesCode(int sqlCode)
	{
		switch (sqlCode)
		{
			case java.sql.Types.BIGINT:
				return new LongField();

			case java.sql.Types.INTEGER:
			case java.sql.Types.SMALLINT:
			case java.sql.Types.TINYINT:
				return new IntField();

			case java.sql.Types.BOOLEAN:
			case java.sql.Types.BIT:
				return new BoolField();

			case java.sql.Types.DATE:
				return new DateField();

			case java.sql.Types.DECIMAL:
			case java.sql.Types.DOUBLE:
			case java.sql.Types.NUMERIC:
			case java.sql.Types.FLOAT:
			case java.sql.Types.REAL:
				return new DecimalField();

			case java.sql.Types.CHAR:
			case java.sql.Types.VARCHAR:
			case java.sql.Types.NVARCHAR:
			case java.sql.Types.BLOB:
			case java.sql.Types.CLOB:
			case java.sql.Types.LONGVARCHAR:
			case java.sql.Types.VARBINARY:
			case java.sql.Types.LONGNVARCHAR:
				return new StringField();

			case java.sql.Types.TIME:
			case java.sql.Types.TIMESTAMP:
				return new DatetimeField();

			default:
				logger.error("UNKNOWN sql code: " + sqlCode);
				return new UnknownField();
		}
	}
}
