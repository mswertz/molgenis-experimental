package org.molgenis.controllers;

import java.util.List;

import org.molgenis.controllers.XrefTestController.XrefResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public abstract class AbstractXrefController
{
	@RequestMapping(value = "/lookup")
	public abstract @ResponseBody
	List<XrefResult> find(
			@RequestParam("entity")
			String entity,
			@RequestParam("q")
			String q);
	
	@RequestMapping(value = "/lookup/id")
	public abstract @ResponseBody
	XrefResult get(
			@RequestParam("entity")
			String entity,
			@RequestParam("id")
			String id);
	
	@RequestMapping(value = "/lookup/ids")
	public abstract @ResponseBody
	List<XrefResult> get(
			@RequestParam("entity")
			String entity,
			@RequestParam("ids")
			String[] ids);
}
