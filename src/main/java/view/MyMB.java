package view;

import javax.inject.Inject;
import javax.inject.Named;

import controller.MyEJB;

@Named
public class MyMB {
@Inject
MyEJB ejb;

public String getMessage(){
	return "El EJB dice: " + ejb.greetings();
}
}
