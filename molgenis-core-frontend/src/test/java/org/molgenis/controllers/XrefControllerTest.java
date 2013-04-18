package org.molgenis.controllers;

import org.molgenis.backend.Backend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import test.test.Person;

@ContextConfiguration("classpath:testApplicationContext.xml")
public class XrefControllerTest extends AbstractTransactionalTestNGSpringContextTests
{
	@Autowired
	Backend db;
	@Test @Transactional
	public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
//		XrefController controller = new XrefController();
//		
//		controller.findXref("test.test.Person", "blaat");
		
		for(Person p: db.query(Person.class).like("DisplayName", "John"))
		{
			System.out.println(p);
		}
	}
}
