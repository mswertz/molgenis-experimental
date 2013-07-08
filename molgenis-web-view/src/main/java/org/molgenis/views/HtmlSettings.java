package org.molgenis.views;

import org.molgenis.views.render.LinkoutRenderDecorator;
import org.molgenis.views.render.RenderDecorator;

public class HtmlSettings
{	
	//public static UiToolkit uiToolkit = UiToolkit.ORIGINAL;
	public static RenderDecorator defaultRenderDecorator = new LinkoutRenderDecorator();
	
	//FIXME: define new MolgenisOption with default 'true'
	public static boolean showDescription = true;
}
