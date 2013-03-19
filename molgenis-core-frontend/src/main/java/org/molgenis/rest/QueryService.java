//package org.molgenis.rest;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//import org.molgenis.data.Backend;
//import org.molgenis.data.BackendException;
//import org.molgenis.data.Query;
//import org.molgenis.data.Record;
//import org.molgenis.model.FieldModel;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * Uses: <li>jax-rs <li>
// * 
// * @author mswertz
// * 
// */
//
//@Path("query")
//@Produces(MediaType.APPLICATION_JSON)
//public class QueryService
//{
//	@Autowired
//	Backend db;
//	
//	@GET
//	public List<String> getSets()
//	{
//		return db.getCollections();
//	}
//
//	@GET
//	@Path("{set}")
//	public List<Map<String, String>> getList(@PathParam("set")
//	String set) throws BackendException 
//	{
//		//System.out.println(Version.convertToString());
//		
//		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
//
//		// obviously, we should have default limits/offsets here
//		Query<? extends Record> q = db.query(set);
//		if (q == null) return result;
//
//		// defaults
//		q.limit(100);
//		q.offset(0);
//
//		// get filters, if any
////		for (QueryRule r : rules)
////		{
////			q.addRule(r);
////		}
//
//		for (Record rc : db.query(set))
//		{
//			Map<String, String> m = new LinkedHashMap<String, String>();
//			for (FieldModel f : rc.getModel().getFields())
//			{
//				Object value = rc.get(f.getName());
//				if (value != null) m.put(f.getName(), value.toString());
//				else m.put(f.getName(), null);
//			}
//			result.add(m);
//		}
//
//		return result;
//	}
//
//	@GET
//	@Path("{set}/{id}")
//	public Map<String, String> getRecord(@PathParam("set")
//	String set, @PathParam("id")
//	Integer id) throws BackendException 
//	{
//		Map<String, String> result = new LinkedHashMap<String, String>();
//
//		// obviously, we should have default limits/offsets here
//		// TODO: each tupletable should also have row ids (which are the
//		// ObservationId?)
//		for (Record rc : db.query(set).eq("id", id))
//		{
//			for (FieldModel f : rc.getModel().getFields())
//			{
//				Object value = rc.get(f.getName());
//				if (value != null) result.put(f.getName(), value.toString());
//				else result.put(f.getName(), null);
//			}
//		}
//		return result;
//	}
//
//	@GET
//	@Path("{set}/add")
//	public void add()
//	{
//
//	}
//}
