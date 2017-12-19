package ar.edu.davinci.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import ar.edu.davinci.exception.AuthenticationFailure;
import ar.edu.davinci.model.User;

@Stateless
public class UserController {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(User user) {
		entityManager.persist(user);
	}

	public User byId(int id) {
		return entityManager.find(User.class, id);
	}
	
	public User authenticate(String username,String password) throws AuthenticationFailure {
		try{
			String jpql = "Select u from User u where u.name = :username and u.password = :password";
			TypedQuery<User> q = entityManager.createQuery(jpql, User.class);
			q.setParameter("username", username);
			q.setParameter("password", password);
			return q.getSingleResult();
		} catch (PersistenceException e){
			throw new AuthenticationFailure(e);
		}
	}
	
	public void updateAvatar(User user) {
		entityManager.merge(user);
	}
	
	public List<User> findUsers(String search){
    	String hql = "Select u from User u where u.email LIKE '%" + search + "%' or u.name LIKE '%" + search + "%'";
		TypedQuery<User> q = entityManager.createQuery(hql,User.class);		
        return q.getResultList();
	}
	
	public boolean isFollowingMe(User f, User u){
		boolean following = false;
		User userDB = entityManager.find(User.class, f.getId());
		if(userDB!=null){
			if(userDB.getFollowing()!=null){
				for(User uf : userDB.getFollowing()){
					if(uf.getId() == u.getId()){
						following = true;
						break;
					}
				}
			}	
		}
		return following;
	}

	public boolean alreadyFollowed(User followed, User user){
		boolean existe = false;
		User userDB = entityManager.find(User.class, user.getId());
		Set<User> following = userDB.getFollowing();
		if(following!=null){
			for(User u : following){
				if(u.getId() == followed.getId()){
					existe = true;
					break;
				}
			}
		}
		return existe;
	}
	
	
	public void addFollow(User followed, User user){
		Set<User> following = getFollowing(user);
		if(following==null)
			following = new HashSet<User>();
		following.add(followed);
		user.setFollowing(following);
		entityManager.merge(user);				
	}
	
	public void removeFollow(User followed, User user){
		Set<User> following = getFollowing(user);
		if(following==null){
			following = new HashSet<User>();
		}			
		following.remove(followed);
		user.setFollowing(following);
		entityManager.merge(user);			
	}
	
	public Set<User> getFollowing(User u){
		User userDB = entityManager.find(User.class, u.getId());
		if(userDB.getFollowing()!=null){
			return userDB.getFollowing();
		}else{
			return null;
		}
	}
}
