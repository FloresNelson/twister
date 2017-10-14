package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
@Singleton
public class DB {
	
	private List<User> user = new ArrayList<>();
	
	public DB() {
		user.add(new User(1,"usuario1@mail.com","UsuarioUno","user1pass"));
		user.add(new User(2,"usuario2@mail.com","UsuarioDos","user2pass"));
		user.add(new User(1,"usuario3@mail.com","UsuarioTres","user3pass"));
	}

	public List<User> getUser() {
		return user;
	}

}
