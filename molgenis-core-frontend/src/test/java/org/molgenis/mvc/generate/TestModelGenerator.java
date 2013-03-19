package org.molgenis.mvc.generate;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.molgenis.MolgenisModel;
import org.molgenis.MolgenisOptions;
import org.molgenis.generate.data.JpaEntityGenerator;
import org.molgenis.generate.data.JpaPersistenceGenerator;
import org.molgenis.model.MolgenisModelException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestModelGenerator
{
	MolgenisModel model;

	public static void main(String[] args) throws Exception
	{
		TestModelGenerator t = new TestModelGenerator();
		t.setup();
		t.test1();
	}

	@BeforeClass
	public void setup() throws MolgenisModelException, IOException
	{
		FileUtils.deleteDirectory(new File("target/generated-sources/test/java"));
		model = MolgenisModel.parse(new File(TestModelGenerator.class.getResource("test.xml").getFile()));
	}

	@Test
	public void test1() throws Exception
	{
		MolgenisOptions options = new MolgenisOptions();
		options.output_src = "target/generated-sources/test/java";

		new JpaPersistenceGenerator().generate(model, options);
		new JpaEntityGenerator().generate(model, options);

	}
}
