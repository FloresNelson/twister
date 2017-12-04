package ar.edu.davinci.view;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.enterprise.context.SessionScoped;
import ar.edu.davinci.auth.AuthMb;
import ar.edu.davinci.controller.UserController;
import ar.edu.davinci.exception.AuthenticationFailure;
import ar.edu.davinci.model.User;

@Named
public class LoginMb implements Serializable {
	
	@Inject
	private AuthMb authMb;

	@Inject
	private UserController userController;
	
	private User user = new User();
	private User currentUser;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	
	
	public boolean isLogged(){
		return currentUser != null;
	}
	
	public String login(){
		try {
			User user = userController.authenticate(username, password);
			authMb.setUser(user);
			return "home?faces-redirect=true";
		} catch (AuthenticationFailure e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}
	
	public String logout(){
		authMb.setUser(null);
		return "home?faces-redirect=true";
	}
	
	public User getCurrentUser(){
		return currentUser;
	}
	
	public void setCurrentUser(User user){
		this.currentUser = user;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
