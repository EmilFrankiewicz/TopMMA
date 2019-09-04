package pl.emilfrankiewicz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity
@Transactional
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String address;
	private String gender;
	private String lastName;
	
	@ElementCollection
	private List<String> hobby = new ArrayList<>();

	public UserDetails() {
	}

	public UserDetails(String address, String gender, String lastName, List<String> hobby) {
		this.address = address;
		this.gender = gender;
		this.lastName = lastName;
		this.hobby = hobby;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", address=" + address + ", gender=" + gender + ", lastName=" + lastName
				+ "]";
	}

}
