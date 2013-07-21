package org.molgenis.controllers;

import org.molgenis.views.Button;
import org.molgenis.views.Div;
import org.molgenis.views.Form;
import org.molgenis.views.Html;
import org.molgenis.views.StringInput;
import org.molgenis.views.Tabs;
import org.molgenis.views.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("nested-tabs")
public class ContainerTestController
{	
	//default: show only form with below tabs (lazy load)
	@RequestMapping()
	public View<?> get()
	{
		return new Tabs().item("Aap","/nested-tabs/aap").item("Noot", "/nested-tabs/noot");
	}
	
	//some content on an url
	@RequestMapping("aap")
	public View<?> aap()
	{
		return new Div("aap").add(new Html("this is content for aap"), new Button("hello world").url("/nested-tabs/noot/wim").target("aap"));
	}
	
	//some content on an url
	@RequestMapping("noot")
	public View<?> noot()
	{
		return new Tabs().item("Mies","/nested-tabs/noot/mies").item("Wim","/nested-tabs/noot/wim");
	}
	
	@RequestMapping("noot/mies")
	public View<?> mies()
	{
		return new Html("this is content for mies");
	}
	
	@RequestMapping("noot/wim")
	public View<?> wim()
	{
		return new Div(new Html("this is content for wim"),new Form(new StringInput("name").value("world"), new Button("hello?").post("/nested-tabs/form").target("aap")));
	}
	
	@RequestMapping("form")
	public View<?> form(@RequestParam String name)
	{
		return new Div(new Html("Hello "+name));
	}
}
