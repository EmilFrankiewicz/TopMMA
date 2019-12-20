package pl.emilfrankiewicz.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserDetailsDTO {

	@Length(min = 6)
	private String address;

	@NotNull
	private String gender;

	@Min(12)
	private int age;

	@Length(min = 2, max = 15)
	private String firstName;

	@Length(min = 2, max = 15)
	private String lastName;

	public UserDetailsDTO() {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
