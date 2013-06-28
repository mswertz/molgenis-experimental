package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;

import org.molgenis.Entity;
import org.springframework.stereotype.Controller;

/**
 * Input for string data. Renders as a <code>textarea</code>.
 */
public class XrefInput extends HtmlInput<XrefInput, String>
{
	String entity;
	String url = "/rs/lookup";

	public <E> XrefInput(String name, String entity)
	{
		super(name);
		this.entity = entity;
		this.add(new Css("/res/css/select2.css"));
		this.add(new Script("/res/js/select2.js"));
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.println(String.format(
				"<input id=\"%s\" type=\"hidden\" class=\"bigdrop\" name=\"%s\" value=\"%s\" width=\"50%%\">",
				getId(), getName(), getValue()));

		String clear = isRequired() ? "" : ", allowClear: true";

		// retrieves from query
		String ajax = String
				.format(", ajax: { url: '%s', dataType: 'json', data: function (term, page) { return { q: term, entity: '%s', page: page};},",
						getUrl(), getEntity());
		ajax += "results: function (data, page) { return {results: data};}}";
		// retrieves from currently selected id
		String load = String
				.format(",   initSelection: function(element, callback) {var id=$(element).val(); if (id!=='') {$.ajax('%s/id', { data: { id : '%s', entity : '%s' }, dataType: 'json'}).done(function(data) { callback(data); });}}",
						getUrl(), getValue(), getEntity());
		out.println(String
				.format("</select><script>$(document).ready(function(){$('#%s').select2({width: 'element', placeholder: '%s', minimumInputLength: 3 %s%s%s})});</script>",
						getId(), getPlaceholder(), ajax, load, clear));
	}

	public XrefInput entity(String entity)
	{
		this.entity = entity;
		return this;
	}

	public String getEntity()
	{
		return entity;
	}

	public XrefInput url(String url)
	{
		this.url = url;
		return this;
	}

	public String getUrl()
	{
		return url;
	}
}
