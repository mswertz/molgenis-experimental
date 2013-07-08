package org.molgenis.controllers;

import org.apache.log4j.Logger;
import org.molgenis.test.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/address")
public class AddressController extends EntityController<Address>
{
	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private AddressService service;

	public AddressService getService()
	{
		return service;
	}

	@Override
	public String getLabel()
	{
		return "Address";
	}

	@Override
	public String getBase()
	{
		return "/address";
	}
}
