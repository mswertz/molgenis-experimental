package org.molgenis.views;

import java.util.Map;
import java.util.TreeMap;

import org.molgenis.model.FieldModel;
import org.molgenis.model.types.AutoidField;
import org.molgenis.model.types.BoolField;
import org.molgenis.model.types.DateField;
import org.molgenis.model.types.DatetimeField;
import org.molgenis.model.types.DecimalField;
import org.molgenis.model.types.EmailField;
import org.molgenis.model.types.EnumField;
import org.molgenis.model.types.FieldType;
import org.molgenis.model.types.IntField;
import org.molgenis.model.types.LongField;
import org.molgenis.model.types.MrefField;
import org.molgenis.model.types.RichtextField;
import org.molgenis.model.types.StringField;
import org.molgenis.model.types.TextField;
import org.molgenis.model.types.XrefField;

public class FieldTypeInput
{
	public static Map<String, Class<? extends HtmlInput<?, ?>>> typeMap = null;

	public static HtmlInput<?,?> get(FieldModel field)
	{
		if(typeMap == null) init();
		
		try
		{
			return typeMap.get(field.getType().getClass().getSimpleName()).getDeclaredConstructor(String.class).newInstance(field.getName());
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private static void init()
	{
		typeMap = new TreeMap<String, Class<? extends HtmlInput<?, ?>>>();

		put(AutoidField.class, AutoidInput.class);
		put(StringField.class, StringInput.class);
		put(BoolField.class, BoolInput.class);
		put(DateField.class, DateInput.class);
		put(DatetimeField.class, DatetimeInput.class);
		put(DecimalField.class, DecimalInput.class);
		put(BoolField.class, BoolInput.class);
		put(EmailField.class, EmailInput.class);
		put(EnumField.class, EnumInput.class);
		put(IntField.class, IntInput.class);
		put(LongField.class, LongInput.class);
		put(MrefField.class, MrefInput.class);
		put(RichtextField.class, RichtextInput.class);
		put(BoolField.class, BoolInput.class);
		put(TextField.class, TextInput.class);
		put(XrefField.class, XrefInput.class);
	}

	private static void put(Class<? extends FieldType> key, Class<? extends HtmlInput<?, ?>> value)
	{
		typeMap.put(key.getSimpleName(), value);
	}
}
