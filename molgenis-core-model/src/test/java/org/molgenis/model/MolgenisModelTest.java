package org.molgenis.model;

import java.io.File;

import org.molgenis.MolgenisModel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MolgenisModelTest
{
	@Test
	public void read() throws MolgenisModelException
	{
		MolgenisModel m = MolgenisModel.parse(new File(MolgenisModelTest.class.getResource("test.xml").getFile()));
		
		Assert.assertEquals(m.getName(),"test");
		
		//label
		Assert.assertEquals(m.getLabel(), "test");
		
		//module
		Assert.assertEquals(m.getModules().size(),3);
		
		//module.name
		ModuleModel module = m.getModule("fields");
		Assert.assertEquals(m.getModules().get(0).getName(), "fields");
		Assert.assertEquals(module, m.getModules().get(0));
		
		//module.description
		Assert.assertEquals(module.getDescription(), "Test fields");
		
		//entity
		EntityModel entity = m.getEntity("VarcharEntity");
		
		//entity.name
		Assert.assertEquals(entity.getName(), "VarcharEntity");
		
		//entity.description
		Assert.assertEquals(entity.getDescription(), "Test Varchar");
		
		//unqiues
		Assert.assertEquals(entity.getAllUniques().size(), 2);
		
		
	}
}
