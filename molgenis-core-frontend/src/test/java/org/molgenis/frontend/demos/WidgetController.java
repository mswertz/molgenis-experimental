//package org.molgenis.frontend.demos;
//
//import org.molgenis.frontend.View;
//import org.molgenis.frontend.views.Form;
//import org.molgenis.frontend.views.VerticalLayout;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import test.test.Person;
//import test.test.forms.PersonView;
//
//@Controller
//@RequestMapping("demos/widget")
//public class WidgetController
//{
//	@RequestMapping("inline")
//	public View<Form> demo1()
//	{
//		return new Form("form2").add(new VerticalLayout().add(ExampleInputFactory.createInputs("demo1")));
//	}
//	
//	@RequestMapping("person")
//	public PersonView demo2()
//	{
//		Person p = new Person();
//		
//		p.setDisplayName("John Doe");
//		//p.setBirthday(Calendar.getInstance().getTime());
//		p.setFirstName("John");
//		p.setLastName("Doe");
//		
//		return new PersonView(p);
//	}
//	
//	@RequestMapping("marshall")
//	public PersonView demo3(Person p)
//	{	
//		return new PersonView(p);
//	}
//}
