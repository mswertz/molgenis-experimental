package org.molgenis.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.molgenis.MolgenisController;
import org.molgenis.Record;
import org.molgenis.io.record.MapRecord;
import org.molgenis.views.Div;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("container")
public class ContainerTestController extends MolgenisController
{

	public Div index()
	{
		return div(href("table", "table"));
	}

	@RequestMapping("table")
	public Div table(@RequestParam("p")
	Integer page)
	{
		if (page == null) page = 1;

		// get the data
		List<Record> data = getData();

		// get the page
		int pageSize = 5;
		int prevPage = Math.max(1, page - 1);
		int nextPage = (int) Math.min(page + 1, Math.ceil(data.size() / pageSize));

		return div(H1("Table:"), table(data.subList((page - 1) * 5, (page * 5))),
				pager().add("?p=" + prevPage, "Prev", prevPage == page).add("?p=" + nextPage, "Next", nextPage == page));
	}

	public List<Record> getData()
	{
		List<Record> result = new ArrayList<Record>();
		for (String code : Locale.getISOCountries())
		{
			Locale locale = new Locale("en", code);
			Record r = new MapRecord();
			r.set("Code", code);
			r.set("Country", locale.getDisplayCountry());
			result.add(r);
		}

		return result;
	}

}
