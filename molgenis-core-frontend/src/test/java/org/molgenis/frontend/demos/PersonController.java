//package org.molgenis.frontend.demos;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//
//import org.molgenis.frontend.View;
//import org.molgenis.frontend.views.Button;
//import org.molgenis.frontend.views.Danger;
//import org.molgenis.frontend.views.Success;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import test.test.Person;
//import test.test.forms.PersonView;
//
//@Controller
//@RequestMapping("person")
//public class PersonController
//{
//	@Autowired
//	PersonService db;
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * org.molgenis.frontend.demos.PersonControllerInterface#newView(java.lang
//	 * .String)
//	 */
//	@RequestMapping("new")
//	public PersonView newView(@RequestParam(value = "back", required = false)
//	String back)
//	{
//		PersonView pv = new PersonView(new Person());
//		pv.add(new Button("save").post("add"));
//
//		// back to previous screen, if provided
//		if (back == null) back = "new";
//		pv.add(new Button("cancel").setUrl(back));
//
//		return pv;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * org.molgenis.frontend.demos.PersonControllerInterface#addView(test.test
//	 * .Person)
//	 */
//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public View addView(Person p)
//	{
//		try
//		{
//			db.save(p);
//			return new Success("added succes");
//		}
//		catch (ConstraintViolationException e)
//		{
//			e.printStackTrace();
//			View v = new View("main");
//			String error = "Error: ";
//			for(ConstraintViolation cv: e.getConstraintViolations())
//			{
//				error += cv.getPropertyPath() +" "+cv.getMessage()+"<br/>";
//			}
//			v.add(new Danger(error));
//			v.add(new PersonView(p));
//			return v;
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			View v = new View("main");
//			v.add(new Danger("Error: " + e.getMessage()));
//			v.add(new PersonView(p));
//			return v;
//		}
//		// return success message or
//	}
//}
