package ar.edu.davinci.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;

import ar.edu.davinci.controller.ImageController;
import ar.edu.davinci.controller.UserController;
import ar.edu.davinci.model.Image;
import ar.edu.davinci.model.User;

@Named
@MultipartConfig(location="/tmp",
fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5,
maxRequestSize=1024*1024*5*5)

public class RegistrationMb {
	
	@Inject
	private UserController userCntr;
	
	@Inject
	ImageController imageCntr;
	
	private User user = new User();
	
	private Part file;
	
	@NotNull
	private String confirmPass;
	
	public String register(){
		try {
			if(!confirmPass.equals(user.getPassword())){
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseñas no coinciden", null);
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return null;
			}
			if(file != null && file.getSize() > 0){
				try{
					Image img = null;
					if(file.getContentType().startsWith("image/")){
						img = imageCntr.upload(file);
						user.setImage(img);
					}
				} catch (Exception e){
					e.printStackTrace();
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"No se pudo cargar la foto, reintente.", null);
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}	
			}
			userCntr.create(user);
			user = null;
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró el usuario", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "login?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error interno", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
	
	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
	
}
