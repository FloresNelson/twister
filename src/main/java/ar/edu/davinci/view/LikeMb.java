package ar.edu.davinci.view;

import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.davinci.auth.AuthMb;
import ar.edu.davinci.controller.PostController;
import ar.edu.davinci.controller.UserController;
import ar.edu.davinci.model.Post;
import ar.edu.davinci.model.User;

@Named
public class LikeMb {
	@Inject
	private PostController postCtrl;

	
	@Inject
	private UserController userCtrl;
	
	@Inject
	private AuthMb authMb;

	public void likePost(Post post) {
		if (!existsLike(post)) {
			postCtrl.addLike(post, authMb.getUser());
		} else {
			postCtrl.removeLike(post, authMb.getUser());
		}
	}

	public boolean existsLike(Post post) {
		return postCtrl.existsLike(post, authMb.getUser());
	}

	public int countLikes(Post post) {
		return postCtrl.countLikes(post);
	}
	
	public boolean isFollowingMe(User following){
		return userCtrl.isFollowingMe(following, authMb.getUser());
	}
	
	public void removeFollow(User user){
		userCtrl.removeFollow(user, authMb.getUser());
	}
	
	public void addFollow(User user){
		userCtrl.addFollow(user, authMb.getUser());
	}
	
	
	public void follow(User user){
		if(!alreadyFollowed(user)){
			userCtrl.addFollow(user, authMb.getUser());
		}else{
			userCtrl.removeFollow(user, authMb.getUser());
		}
	}
	
	public boolean alreadyFollowed(User followed){
		return userCtrl.alreadyFollowed(followed, authMb.getUser());		
	}
	
}
