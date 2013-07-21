package org.molgenis.controllers;

import org.molgenis.MolgenisController;
import org.molgenis.views.Div;
import org.molgenis.views.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test/dialog/")
public class DialogsTestController extends MolgenisController {
	@RequestMapping()
	public Div index() {
		return div(H1("Choose dialog:"), href("alert", "alert"), br());
	}

	@RequestMapping("alert")
	public View<?> alert() {
		return div(H1("Examples of alerts:"), warn("This is an warning"), info("This is info"),
				error("This is an error"), success("This is success"));
	}
}
