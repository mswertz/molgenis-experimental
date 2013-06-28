package org.molgenis.views;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Creates an alert box.
 * 
 * @param <E>
 */
public class Alert<E extends Alert<E>> extends Container<E> {
	public enum Type {
		error, warning, success, info
	};

	private Type type = Type.warning;

	public Alert(String message, Type type) {
		super(message);
		if (message == null)
			throw new NullPointerException("Cannot create new Alert(null)");
		this.type = type;
	}

	@Override
	public void render(PrintWriter out) throws IOException {
		this.renderTemplate(out, String.format("<@alert \"%s\">%s</@alert>", getType(), getContents()));
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
