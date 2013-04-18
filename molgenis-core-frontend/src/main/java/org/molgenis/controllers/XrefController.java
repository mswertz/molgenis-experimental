//package org.molgenis.controllers;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import org.molgenis.backend.Backend;
//import org.molgenis.backend.IdentifiableRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class XrefController
//{
//	@Autowired
//	Backend db;
//
//	public XrefController()
//	{
//	}
//
//	/**
//	 * Using URL parameters to get entity name and query filter.
//	 * 
//	 * E.g. /xref?entity=test.Person&q=John
//	 * 
//	 * @param entity
//	 * @param q
//	 * @return
//	 * @throws ClassNotFoundException
//	 * @throws InstantiationException
//	 * @throws IllegalAccessException
//	 */
//	@RequestMapping(value = "/xref",  method = RequestMethod.GET, produces="application/json")
//	public @ResponseBody Map<String,String> findXref(
//			@RequestParam("entity")
//			String entity,
//			@RequestParam("q")
//			String q) throws ClassNotFoundException, InstantiationException, IllegalAccessException
//	{
//		Map<String,String> result = new LinkedHashMap<String,String>();
//
//		@SuppressWarnings("unchecked")
//		Class<? extends IdentifiableRecord> klass = (Class<? extends IdentifiableRecord>) Class.forName(entity);
//		String label = klass.newInstance().getModel().getXrefLabel();
//		
//		for (IdentifiableRecord r : db.query(klass).like(label, q).limit(25))
//		{
//			result.put(r.getIdValue().toString(), r.getLabelValue());
//		}
//
//		return result;
//	}
//}
