package org.molgenis.model;

import java.io.File;

import org.molgenis.meta.EntityMetaData;
import org.molgenis.meta.ModuleMetaData;
import org.molgenis.meta.MolgenisMetaData;
import org.molgenis.meta.MetaDataException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MolgenisModelTest
{
	@Test
	public void read() throws MetaDataException
	{
		MolgenisMetaData m = new MolgenisMetaData();
		m.parse(new File(MolgenisModelTest.class.getResource("test.xml").getFile()));
		m.parse(new File(MolgenisModelTest.class.getResource("fields.xml").getFile()));
		m.parse(new File(MolgenisModelTest.class.getResource("inheritance.xml").getFile()));
		m.validate();

		// module
		Assert.assertEquals(m.getModules().size(), 3);

		// module.name
		ModuleMetaData module = m.getModule("org.molgenis.test");
		Assert.assertEquals(m.getModules().get(0).getName(), "org.molgenis.test");
		Assert.assertEquals(module, m.getModules().get(0));

		// module.description
		Assert.assertEquals(module.getDescription(), "test module");

		// entity
		EntityMetaData entity = m.getEntity("VarcharEntity");

		// entity.name
		Assert.assertEquals(entity.getName(), "VarcharEntity");

		// entity.description
		Assert.assertEquals(entity.getDescription(), "Test Varchar");

		// unqiues
		Assert.assertEquals(entity.getAllUniques().size(), 2);

	}
}
