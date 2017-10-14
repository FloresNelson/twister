package controller;

import javax.ejb.Stateless;

@Stateless
public class MyEJB {
 public String greetings(){
	 return "Hola a todos desde el EJB";
 }
}
