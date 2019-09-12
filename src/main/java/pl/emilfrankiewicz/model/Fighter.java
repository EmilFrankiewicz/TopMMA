package pl.emilfrankiewicz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fighters")
public class Fighter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fighter")
	private long id;

	private String firstName;

	private String lastName;

	private String division;

	private int age;

	private String statistic;

	private String nationality;

	private String clubName;

	private String clubLocalization;

	public Fighter() {
	}

	public Fighter(String firstName, String lastName, String division, int age, String statistic, String nationality,
			String clubName, String clubLocalization) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.division = division;
		this.age = age;
		this.statistic = statistic;
		this.nationality = nationality;
		this.clubName = clubName;
		this.clubLocalization = clubLocalization;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStatistic() {
		return statistic;
	}

	public void setStatistic(String statistic) {
		this.statistic = statistic;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubLocalization() {
		return clubLocalization;
	}

	public void setClubLocalization(String clubLocalization) {
		this.clubLocalization = clubLocalization;
	}

	@Override
	public String toString() {
		return "Fighter [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", division=" + division
				+ ", age=" + age + ", statistic=" + statistic + ", nationality=" + nationality + ", clubName="
				+ clubName + ", clubLocalization=" + clubLocalization + "]";
	}

}
