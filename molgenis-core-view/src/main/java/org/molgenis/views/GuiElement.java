package org.molgenis.views;
//package org.molgenis.frontend.view;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.Vector;
//
//import org.molgenis.io.Record;
//
///**
// * MolgenisView is superclass for building user interfaces as if were a tree.
// * You can use add(GuiElement) to add child elements. Subclasses may limit the
// * types of GuiElement it accepts.
// * 
// * Optionally, components may specify headers. These are merged by the page
// * before rendering.
// */
//public abstract class GuiElement<T extends GuiElement<T>> extends View
//{
//	public static final String ID = "id";
//	public static final String CLASS = "class";
//
//
//	/** The css class of this input. */
//	// private String clazz;
//
//
//
//
//
//
//
//	/** Constructor using id only */
//	public GuiElement(String id)
//	{
//		super("/render.ftl");
//		this.id = id;
//		this.allChildren.put(id, this);
//	}
//
//	@Override
//	public Map<String, Object> getModel()
//	{
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("model", this);
//		return map;
//	}
//
//	public void set(Record params) throws HtmlInputException
//	{
//		this.set(ID, params.get(ID));
//		// this.setClazz(params.getString(CLASS));
//	}
//
//	// PROPERTIES
//
//
//	//
//	// public String getClazz()
//	// {
//	// return this.clazz;
//	// }
//	//
//	// @SuppressWarnings("unchecked")
//	// public T setClazz(String clazz)
//	// {
//	// this.clazz = clazz;
//	// return (T) this;
//	// }
//
//	public GuiElement<?> get(String name)
//	{
//		return allChildren.get(name);
//	}
//
//	public T addAll(List<? extends GuiElement<?>> elements)
//	{
//		return this.add(elements.toArray(new GuiElement<?>[elements.size()]));
//	}
//
//
//
//
//
//
//
//	public final GuiElement<?> getChild(String name)
//	{
//		GuiElement<?> child = allChildren.get(name);
//
//		if (child != null && child.getParent().equals(this))
//		{
//			return child;
//		}
//		else
//		{
//			return null;
//		}
//	}
//
//	/**
//	 * To string converts a GuiElement into a proper html page, including
//	 * headers
//	 */
//	public String toString()
//	{
//		StringWriter out = new StringWriter();
//		try
//		{
//			out.write("<html><head>");
//			for(HtmlHeader header: this.getHtmlHeaders())
//			{
//				out.write(header.toString());
//			}
//			out.write("</head><body>");
//			this.render(new PrintWriter(out));
//			out.write("</body></html>");
//		}
//		catch (IOException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return out.toString();
//	}
//
//
//
//	public abstract void render(PrintWriter out) throws IOException;
//}
