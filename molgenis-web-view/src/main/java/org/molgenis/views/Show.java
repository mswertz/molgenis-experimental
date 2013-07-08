package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;

import org.molgenis.Entity;

public class Show extends View<Show>
{
	Entity entity;
	
	public Show(Entity entity)
	{
		this.entity = entity;
		
		//todo: this should be part of the 'theme'
		add(new Css("/res/css/bootstrap.min.css"));
		add(new Script("/res/js/jquery-1.8.1.min.js"));
		add(new Script("/res/js/bootstrap.min.js"));
		add(new Script("/res/js/jquery.validate.js"));
	}
	
	@Override
	public void render(PrintWriter out) throws IOException
	{
		this.renderTemplate(out, "<@show model.getEntity()/>");
	}

	public Entity getEntity()
	{
		return entity;
	}

	public void setEntity(Entity entity)
	{
		this.entity = entity;
	}	
}
