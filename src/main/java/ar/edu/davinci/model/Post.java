package ar.edu.davinci.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Post {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull
    @Size(min=2,max=255)
    private String content;

    @NotNull
    @ManyToOne
    private User user;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private Image image;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToMany(cascade = { 
    	    CascadeType.PERSIST, 
    	    CascadeType.MERGE
    	})
    	@JoinTable(name = "post_likes",
    	    joinColumns = @JoinColumn(name = "post_id"),
    	    inverseJoinColumns = @JoinColumn(name = "user_id")
    	)
    	private Set<User> usersLikes = new HashSet<>();
	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", user=" + user + ", image=" + image + ", date=" + date
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public void addLike(User user){
		this.usersLikes.add(user);
		user.getPostsLikes().add(this);
	}
	
	public void removeLike(User user){
		this.usersLikes.remove(user);
		user.getPostsLikes().remove(this);
	}

	public Set<User> getUsersLikes() {
		return usersLikes;
	}

	public void setUsersLikes(Set<User> usersLikes) {
		this.usersLikes = usersLikes;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        return id > 0 && id == (((Post) o).id);
    }
 
    @Override
    public int hashCode() {
        return 31;
    }
}
