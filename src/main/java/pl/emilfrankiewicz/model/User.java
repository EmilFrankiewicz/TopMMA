package pl.emilfrankiewicz.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

@Entity
@Transactional
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String firstName;
	private String nick;
	private int age;
	private String email;
	private String password;

    @OneToOne(cascade = {CascadeType.ALL})
	private UserDetails userDetails;

	public User() {
	}

	public User(String name, String nick, int age, String email, String password) {
		this.firstName = name;
		this.nick = nick;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", nick=" + nick + ", age=" + age + ", email=" + email
				+ ", password=" + password + ", userDetails=" + userDetails + "]";
	}

}
