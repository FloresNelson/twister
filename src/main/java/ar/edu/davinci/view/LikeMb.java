package ar.edu.davinci.view;

import javax.inject.Inject;

import ar.edu.davinci.auth.AuthMb;
import ar.edu.davinci.controller.PostController;
import ar.edu.davinci.model.Post;

public class LikeMb {
	@Inject
	private PostController postCtrl;

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

}
