//package org.molgenis.resources;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.QueryParam;
//
//@Path("parent")
//public class Parent
//{
//	@GET
//	public String test(@QueryParam("world") String world)
//	{
//		return "hello "+world;
//	}
//
//	@Path("child")
//	public Child test2(@QueryParam("world") String world)
//	{
//		return new Child(test(world));
//	}
//	
//	@Path("view")
//	public MyViewable view()
//	{
//		return new MyViewable();
//	}
//}
