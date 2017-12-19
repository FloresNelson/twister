package ar.edu.davinci.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ar.edu.davinci.model.Image;
import ar.edu.davinci.model.Post;
import ar.edu.davinci.model.User;

@Stateless
public class PostController {

	@PersistenceContext
	private EntityManager entityManager;

	public void addPost(User user, String content, Image img) {
		Post p = new Post();
		p.setDate(new Date());
		p.setContent(content);
		p.setUser(user);
		p.setImage(img);
		entityManager.persist(p);
	}

	public List<Post> all(int from, int max) {
		TypedQuery<Post> q = entityManager.createQuery("Select p from Post p order by p.date desc", Post.class);
		q.setFirstResult(from);
		q.setMaxResults(max);
		return q.getResultList();
	}

	public List<Post> from(User user, int from, int max) {
		TypedQuery<Post> q = entityManager.createQuery("Select p from Post p where p.user = :user order by p.date desc",
				Post.class);
		q.setParameter("user", user);
		q.setFirstResult(from);
		q.setMaxResults(max);
		return q.getResultList();
	}

	public Post byId(int id) {
		return entityManager.find(Post.class, id);
	}

	public void addLike(Post p, User u) {
		System.out.println("Llegue al like!");
		Set<User> likes = getLikes(p);
		if (likes == null)
			likes = new HashSet<User>();
		likes.add(u);
		p.setUsersLikes(likes);
		entityManager.merge(p);
	}

	public void removeLike(Post p, User u) {
		Set<User> likes = getLikes(p);
		if (likes == null) {
			likes = new HashSet<User>();
		}
		likes.remove(u);
		p.setUsersLikes(likes);
		entityManager.merge(p);
	}

	public int countLikes(Post p) {
		int cantidad = 0;
		Post postDB = entityManager.find(Post.class, p.getId());
		if (postDB.getUsersLikes() != null)
			cantidad = postDB.getUsersLikes().size();
		return cantidad;
	}

	private Set<User> getLikes(Post p) {
		Post postDB = entityManager.find(Post.class, p.getId());
		if (postDB.getUsersLikes() != null) {
			return postDB.getUsersLikes();
		} else {
			return null;
		}

	}

	public boolean existsLike(Post post, User user) {
		boolean existe = false;
		Post postDB = entityManager.find(Post.class, post.getId());
		Set<User> likes = postDB.getUsersLikes();
		if (likes != null) {
			for (User u : likes) {
				if (u.getId() == user.getId()) {
					existe = true;
					break;
				}
			}
		}
		return existe;
	}
}
