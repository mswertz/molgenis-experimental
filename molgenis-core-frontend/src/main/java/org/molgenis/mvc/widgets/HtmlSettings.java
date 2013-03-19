package org.molgenis.mvc.widgets;

import org.molgenis.mvc.ui.render.LinkoutRenderDecorator;
import org.molgenis.mvc.ui.render.RenderDecorator;

public class HtmlSettings
{	
	//public static UiToolkit uiToolkit = UiToolkit.ORIGINAL;
	public static RenderDecorator defaultRenderDecorator = new LinkoutRenderDecorator();
	
	//FIXME: define new MolgenisOption with default 'true'
	public static boolean showDescription = true;
}
