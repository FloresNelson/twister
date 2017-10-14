package controller;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.DB;
import model.User;

@Stateless
public class UserController {
	
	@EJB
	DB db;
	
	public List<User> getAll(){
		return db.getUser();
	}
	public void addPerson(User u){
		db.getUser().add(u);
	}
	
}
