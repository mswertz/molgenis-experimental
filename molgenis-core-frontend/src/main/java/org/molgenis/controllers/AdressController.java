package org.molgenis.controllers;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.molgenis.data.BackendException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

import test.test.Address;

/** Renders an input form for an entity */
@Controller
@RequestMapping("/rs/address")
public class AdressController extends EntityController<Address>
{
	@Override
	public Class<Address> getEntityClass()
	{
		return Address.class;
	}

	@RequestMapping("{id}")
	public Address getAddress(Integer id) throws BackendException
	{
		return backend.getById(Address.class, id);
	}
	
	@Transactional
	public String getEditForm(
	Integer id) throws BackendException
	{
		try
		{
			return backend.getById(this.getEntityClass(), id).toString();
		}
		catch (Exception e)
		{
			return "error: " + e.getMessage();
		}
	}
	
	@RequestMapping(value="get", method=RequestMethod.GET)
	public View getAddress(final Address address)
	{
		System.out.println("address: "+address);
		//System.out.println(address);
		return new AbstractView(){

			@Override
			protected void renderMergedOutputModel(Map<String, Object> arg0, HttpServletRequest arg1,
					HttpServletResponse arg2) throws Exception
			{
				arg2.getWriter().print("hello: "+address);
				
			}
			
		};
	}
}
