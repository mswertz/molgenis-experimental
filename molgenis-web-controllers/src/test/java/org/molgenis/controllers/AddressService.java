package org.molgenis.controllers;


import org.molgenis.data.CrudRepository;
import org.molgenis.test.Address;
import org.molgenis.test.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressService extends EntityService<Address>
{
	@Autowired
	AddressRepository repository;
	
	public Class<Address> getEntityClass()
	{
		return Address.class;
	}
	
	public String getLabel()
	{
		return "Address";
	}

	@Override
	public CrudRepository<Address> getRepository()
	{
		return repository;
	}
}
