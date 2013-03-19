package org.molgenis.generate;

import java.io.File;

import org.molgenis.MolgenisModel;
import org.molgenis.MolgenisOptions;
import org.molgenis.generate.doc.DotDocGen;
import org.molgenis.generate.doc.ObjectModelDocGen;
import org.testng.annotations.Test;

public class TestObjectModelDocGen
{
	@Test
	public void test1() throws Exception
	{
		//parse model
		MolgenisModel m = MolgenisModel.parse(new File("src/test/resources/org/molgenis/model/test.xml"));
		
		//relevant options
		MolgenisOptions o = new MolgenisOptions();
		o.output_doc = "src/test/site";
		
		//generate
		new DotDocGen().generate(m, o);
		new ObjectModelDocGen().generate(m, o);
	}
}
