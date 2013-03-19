//package org.molgenis.mvc.demo;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//import org.molgenis.controllers.EntityController;
//
//@Path("demo")
//@Produces(MediaType.APPLICATION_JSON)
//public class DemoEntityController extends EntityController<DemoEntity>
//{
//	@Override
//	public DemoEntity get(Integer id)
//	{
//		DemoEntity e = new DemoEntity();
//		e.setName("test");
//		return e;
//	}
//	
//
//	@Override
//	@Path("{id}")
//	@GET
//	public DemoEntity getById(@PathParam("id")
//	Integer id)
//	{
//		return get(id);
//	}
//	
//
//}
