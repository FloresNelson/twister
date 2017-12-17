package ar.edu.davinci.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;


@Entity
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   
    @NotNull
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
                 message="{invalid.email}")
    private String email; 
    
    @NotNull
    @Size(min=4,max=15, message = "El username debe tener entre 4 y 15 caracteres.")
	private String name;
    
    @NotNull
    @Size(min=6,max=255)
    private String password;

    @ManyToOne(fetch=FetchType.EAGER)
    private Image image;
    
 public User(){
    	
    }
		
	public User(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
	}
	
	public User(int ID, String email, String name, String password) {
		super();
		this.id = ID;
		this.email = email;
		this.name = name;
		this.password = password;
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}

