package ar.edu.davinci.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import ar.edu.davinci.auth.AuthMb;
import ar.edu.davinci.controller.ImageController;
import ar.edu.davinci.controller.UserController;
import ar.edu.davinci.model.Image;
import ar.edu.davinci.model.User;
@Named
@MultipartConfig(location="/tmp",
	fileSizeThreshold=1024*1024, 
	maxFileSize=1024*1024*5,
	maxRequestSize=1024*1024*5*5)
public class ProfileMb {
	
	@Inject
	UserController userController;
	
	@Inject
	ImageController imgController;
	
	@Inject
	private AuthMb authMb;
  
    private Part file;

	private User user = new User();
  
	public String updateProfile(){
		
		if(file != null && file.getSize() > 0){
			try{
				Image img = null;
				if(file.getContentType().startsWith("image/")){
					img = imgController.upload(file);
					User user = authMb.getUser();
					user.setImage(img);
					userController.updateAvatar(user);
				}
				return "index";
			} catch (Exception e){
				e.printStackTrace();
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al cargar la foto.", null);
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}	
		}
		return null;
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
	
}
