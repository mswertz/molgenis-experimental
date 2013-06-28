package org.molgenis.controllers;


import org.molgenis.test.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressService extends EntityService<Address>
{
	public Class<Address> getEntityClass()
	{
		return Address.class;
	}
	
	public String getLabel()
	{
		return "Address";
	}
}
