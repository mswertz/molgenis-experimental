package org.molgenis.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class XrefTestController extends AbstractXrefController
{
	@Override
	public List<XrefResult> find(String entity,	String q)
	{
		List<XrefResult> result = new ArrayList<XrefResult>();

		Map<String, String> data = getData();
		for (String key : data.keySet())
		{
			if (data.get(key).toLowerCase().startsWith(q.toLowerCase()))
			{
				result.add(new XrefResult(key, data.get(key)));
			}
			// max 10
			if (result.size() > 10) break;
		}

		return result;
	}

	@Override
	public XrefResult get(String entity, String id)
	{
		System.out.println("receive: " + id);

		Map<String, String> data = getData();
		if (data.get(id) != null)
		{
			return new XrefResult(id, data.get(id));
		}
		return null;
	}

	@Override
	public 
	List<XrefResult> get(String entity,	String[] ids)
	{
		System.out.println("receive: " + ids);

		List<XrefResult> result = new ArrayList<XrefResult>();
		Map<String, String> data = getData();
		for (String id : ids)
		{
			System.out.println("mref:" + id);
			if (data.get(id) != null)
			{
				result.add(new XrefResult(id, data.get(id)));
			}
		}
		return result;
	}

	private Map<String, String> getData()
	{
		// example data: countries
		Map<String, String> data = new LinkedHashMap<String, String>();
		for (String code : Locale.getISOCountries())
		{
			Locale locale = new Locale("en", code);
			data.put(code, locale.getDisplayCountry());
		}
		return data;
	}
}
