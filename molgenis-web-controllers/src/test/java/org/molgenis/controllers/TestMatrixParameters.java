package org.molgenis.controllers;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.molgenis.views.Html;
import org.molgenis.views.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

@Controller
public class TestMatrixParameters
{
	@RequestMapping("matrix")
	public View<?> test()
	{
		return new Html("hello world");
	}

	@RequestMapping("matrix;{q}")
	public View<?> testq(@PathVariable
	MyValue q)
	{
		return new Html("hello " + q);
	}

	@XmlRootElement
	public class MyValue
	{
		private int page=1;
		private int limit=10;
		private List<String> sort = new ArrayList<String>();
		
		public String toString()
		{
			return String.format("page='%s', sort='%s', limit='%s'", getPage(),getSort(),getLimit());
		}

		public int getPage()
		{
			return page;
		}

		public void setPage(int page)
		{
			this.page = page;
		}

		public int getLimit()
		{
			return limit;
		}

		public void setLimit(int limit)
		{
			this.limit = limit;
		}

		public List<String> getSort()
		{
			return sort;
		}

		public void setSort(List<String> sort)
		{
			this.sort = sort;
		}
		
		
	}

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.registerCustomEditor(MyValue.class, new CategoryEditor());	
	}

	public class CategoryEditor extends PropertyEditorSupport
	{	
		// Converts a String to a Category (when submitting form)
		@Override
		public void setAsText(String text)
		{
			System.out.println(text);
			
			String[] params = text.split(";");
			MyValue v = new MyValue();
			
			for(String param: params)
			{
				String[] p = param.split("=");
				
				if(p.length == 2)
				{
					if("page".equals(p[0])) v.setPage(Integer.parseInt(p[1]));
					if("limit".equals(p[0])) v.setLimit(Integer.parseInt(p[1]));
					if("sort".equals(p[0])) v.setSort(Arrays.asList(p[1].split(",")));

				}
			}
			System.out.println(v);
			//MyValue v = new Gson().fromJson(json, MyValue.class);
			this.setValue(v);
		}

		// Converts a Category to a String (when displaying form)
		@Override
		public String getAsText()
		{
			MyValue c = (MyValue) this.getValue();
			return new Gson().toJson(c);
		}
	}
}
