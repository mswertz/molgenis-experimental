package org.molgenis.db.generators;

import java.io.File;

import org.molgenis.MolgenisModel;
import org.molgenis.MolgenisOptions;
import org.testng.annotations.Test;

public class TestEntityGen
{
	@Test
	public void test1() throws Exception
	{
		//parse model
		MolgenisModel m = MolgenisModel.parse(new File("src/test/resources/org/molgenis/model/test.xml"));
		
		//relevant options
		MolgenisOptions o = new MolgenisOptions();
		o.output_src = "src/test/generated-sources/";
		
		//generate
		new DataTypeGen().generate(m, o);
	}
}
