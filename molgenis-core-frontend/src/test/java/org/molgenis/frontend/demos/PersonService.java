package org.molgenis.frontend.demos;

import org.molgenis.backend.BackendException;
import org.molgenis.backend.jpa.JpaBackend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.test.Person;

@Service
public class PersonService
{
	@Autowired
	JpaBackend db;

	@Transactional
	public void save(Person p) throws BackendException
	{
		db.add(p);
	}

}
