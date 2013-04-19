package org.molgenis.generate;

import java.util.Calendar;

import org.molgenis.backend.Backend;
import org.molgenis.backend.BackendException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import test.test.Address;
import test.test.Person;

@ContextConfiguration("classpath:testApplicationContext.xml")
public class TestAddData extends AbstractTransactionalTestNGSpringContextTests
{
	@Autowired
	Backend db;
	
	@Test @Transactional @Rollback(false)
	public void setup() throws BackendException
	{
		db.remove(db.query(Address.class));
		db.remove(db.query(Person.class));
		
		Person p1 = new Person();
		p1.setDisplayName("John Doe");
		p1.setFirstName("john");
		p1.setLastName("doe");
		p1.setBirthday(Calendar.getInstance().getTime());
		db.add(p1);
		
		Person p2 = new Person();
		p2.setDisplayName("Jane Doe");
		p2.setFirstName("jane");
		p2.setLastName("doe");
		p2.setBirthday(Calendar.getInstance().getTime());
		db.add(p2);
		
		Address a = new Address();
		a.setStreet("blaat");
		a.getPerson().add(p1);
		a.getPerson().add(p2);
		db.add(a);
	}
}
