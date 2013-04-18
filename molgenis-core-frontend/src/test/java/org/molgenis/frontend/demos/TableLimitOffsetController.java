//package org.molgenis.frontend.demos;
//
//import org.junit.runner.Request;
//import org.molgenis.frontend.views.Danger;
//import org.molgenis.frontend.views.H1;
//import org.molgenis.frontend.views.Pager;
//import org.molgenis.frontend.views.Table;
//import org.molgenis.frontend.views.View;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///** Controller used to list entities */
//@Controller
//@RequestMapping("demo/table")
//public class TableLimitOffsetController
//{
//	Integer maxLimit = 10;
//
//	// path name/show?id=x&limit=1 shows object with name + optional next items
//	public View show(Request request)
//	{
//		try
//		{
//			// position relative to ID
//			Integer id = 1;//request.getInt("id");
//
//			Integer limit = 10; //request.getInt("limit");
//			if (limit == null || limit > maxLimit) limit = 10;
//
//			Integer offset = request.getInt("offset");
//			if (offset == null) offset = 0;
//
//			// retrieve data
//			TupleTable source = MemoryTableFactory.create(51, 10);
//			source.setLimit(limit);
//			source.setOffset(offset > source.getCount() ? (int) Math.floor(source.getCount() / limit) : offset);
//
//			// create table view
//			Table view = new Table("mytable").add(source);
//			
//			//create previous and next buttons
//			Integer count = source.getCount();
//			
//			Pager pager = new Pager();
//			Long maxOffset = Math.round(Math.floor(count/limit)) * limit;
//			if(maxOffset >= count) maxOffset = maxOffset - limit;
//			if(offset > 0) pager.first("?limit="+limit);
//			if(offset > 0) pager.prev("?limit="+limit+"&offset="+Math.max(0, offset - limit));
//			if(offset < maxOffset) pager.next("?limit="+limit+"&offset="+Math.min(maxOffset, offset + limit));
//			if(offset < maxOffset) pager.last("?limit="+limit+"&offset="+maxOffset);
//			pager.message("Record "+(offset + 1)+"-"+(offset + limit)+" of "+count);
//
//			// assemble and return
//			return new View().add(new H1("Testing table")).add(pager).add(view);
//		}
//		catch (Exception e)
//		{
//			return new View().add(new Danger(e.getMessage()));
//		}
//	}
//
//}
