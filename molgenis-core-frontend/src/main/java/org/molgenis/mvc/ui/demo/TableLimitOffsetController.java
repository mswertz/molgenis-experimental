//package org.molgenis.test.core;
//
//import org.molgenis.core.Controller;
//import org.molgenis.core.Request;
//import org.molgenis.core.View;
//import org.molgenis.core.view.GuiView;
//import org.molgenis.view.widgets.Danger;
//import org.molgenis.view.widgets.H1;
//import org.molgenis.view.widgets.Pager;
//import org.molgenis.view.widgets.Table;
//
///** Controller used to list entities */
//public class TableLimitOffsetController extends Controller
//{
//	Integer maxLimit = 10;
//
//	public TableLimitOffsetController(String path)
//	{
//		super(path);
//		// TODO Auto-generated constructor stub
//	}
//
//	// path name/show?id=x&limit=1 shows object with name + optional next items
//	public View show(Request request)
//	{
//		try
//		{
//			// position relative to ID
//			Integer id = request.getInt("id");
//
//			Integer limit = request.getInt("limit");
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
//			return new GuiView().add(new H1("Testing table")).add(pager).add(view);
//		}
//		catch (Exception e)
//		{
//			return new GuiView().add(new Danger(e.getMessage()));
//		}
//	}
//
//	@Override
//	public View index(Request request)
//	{
//		return show(request);
//	}
//}
