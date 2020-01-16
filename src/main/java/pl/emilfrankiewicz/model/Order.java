package pl.emilfrankiewicz.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

import pl.emilfrankiewicz.fighterdatabase.model.FighterBantamweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterFeatherweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterFlyweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterMiddleweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterWelterweight;

@Entity
@Table(name = "user_orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private long id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fighter_heavyweight_id", referencedColumnName = "id_order")
	private List<FighterHeavyweight> listOfFighterHeavyweight = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fighter_lightheavyweight_id", referencedColumnName = "id_order")
	private List<FighterLightHeavyweight> listOfFighterLightHeavyweight = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fighter_middleweight_id", referencedColumnName = "id_order")
	private List<FighterMiddleweight> listOfFighterMiddleweight = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fighter_welterweight_id", referencedColumnName = "id_order")
	private List<FighterWelterweight> listOfFighterWelterweight = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fighter_lightweight_id", referencedColumnName = "id_order")
	private List<FighterLightweight> listOfFighterLightweight = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fighter_featherweight_id", referencedColumnName = "id_order")
	private List<FighterFeatherweight> listOfFighterFeatherweight = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fighter_bantamweight_id", referencedColumnName = "id_order")
	private List<FighterBantamweight> listOfFighterBantamweight = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fighter_flyweight_id", referencedColumnName = "id_order")
	private List<FighterFlyweight> listOfFighterFlyweight = new ArrayList<>();

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	public Order() {
	}

	public void addFighterHeavyweight(FighterHeavyweight fighterHeavyweight) {
		this.listOfFighterHeavyweight.add(fighterHeavyweight);
	}

	public void addFighterLightHeavyweight(FighterLightHeavyweight fighterLightHeavyweight) {
		this.listOfFighterLightHeavyweight.add(fighterLightHeavyweight);
	}

	public void addFighterMiddleweight(FighterMiddleweight fighterMiddleweight) {
		this.listOfFighterMiddleweight.add(fighterMiddleweight);
	}

	public void addFighterWelterweight(FighterWelterweight fighterWelterweight) {
		this.listOfFighterWelterweight.add(fighterWelterweight);
	}

	public void addFighterLightweight(FighterLightweight fighterLightweight) {
		this.listOfFighterLightweight.add(fighterLightweight);
	}

	public void addFighterFeatherweight(FighterFeatherweight fighterFeatherweight) {
		this.listOfFighterFeatherweight.add(fighterFeatherweight);
	}

	public void addFighterBantamweight(FighterBantamweight fighterBantamweight) {
		this.listOfFighterBantamweight.add(fighterBantamweight);
	}

	public void addFighterFlyweight(FighterFlyweight fighterFlyweight) {
		this.listOfFighterFlyweight.add(fighterFlyweight);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<FighterHeavyweight> getListOfFighterHeavyweight() {
		return listOfFighterHeavyweight;
	}

	public void setListOfFighterHeavyweight(List<FighterHeavyweight> listOfFighterHeavyweight) {
		this.listOfFighterHeavyweight = listOfFighterHeavyweight;
	}

	public List<FighterLightHeavyweight> getListOfFighterLightHeavyweight() {
		return listOfFighterLightHeavyweight;
	}

	public void setListOfFighterLightHeavyweight(List<FighterLightHeavyweight> listOfFighterLightHeavyweight) {
		this.listOfFighterLightHeavyweight = listOfFighterLightHeavyweight;
	}

	public List<FighterMiddleweight> getListOfFighterMiddleweight() {
		return listOfFighterMiddleweight;
	}

	public void setListOfFighterMiddleweight(List<FighterMiddleweight> listOfFighterMiddleweight) {
		this.listOfFighterMiddleweight = listOfFighterMiddleweight;
	}

	public List<FighterWelterweight> getListOfFighterWelterweight() {
		return listOfFighterWelterweight;
	}

	public void setListOfFighterWelterweight(List<FighterWelterweight> listOfFighterWelterweight) {
		this.listOfFighterWelterweight = listOfFighterWelterweight;
	}

	public List<FighterLightweight> getListOfFighterLightweight() {
		return listOfFighterLightweight;
	}

	public void setListOfFighterLightweight(List<FighterLightweight> listOfFighterLightweight) {
		this.listOfFighterLightweight = listOfFighterLightweight;
	}

	public List<FighterFeatherweight> getListOfFighterFeatherweight() {
		return listOfFighterFeatherweight;
	}

	public void setListOfFighterFeatherweight(List<FighterFeatherweight> listOfFighterFeatherweight) {
		this.listOfFighterFeatherweight = listOfFighterFeatherweight;
	}

	public List<FighterBantamweight> getListOfFighterBantamweight() {
		return listOfFighterBantamweight;
	}

	public void setListOfFighterBantamweight(List<FighterBantamweight> listOfFighterBantamweight) {
		this.listOfFighterBantamweight = listOfFighterBantamweight;
	}

	public List<FighterFlyweight> getListOfFighterFlyweight() {
		return listOfFighterFlyweight;
	}

	public void setListOfFighterFlyweight(List<FighterFlyweight> listOfFighterFlyweight) {
		this.listOfFighterFlyweight = listOfFighterFlyweight;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", listOfFighterHeavyweight=" + listOfFighterHeavyweight
				+ ", listOfFighterLightHeavyweight=" + listOfFighterLightHeavyweight + ", listOfFighterMiddleweight="
				+ listOfFighterMiddleweight + ", listOfFighterWelterweight=" + listOfFighterWelterweight
				+ ", listOfFighterLightweight=" + listOfFighterLightweight + ", listOfFighterFeatherweight="
				+ listOfFighterFeatherweight + ", listOfFighterBantamweight=" + listOfFighterBantamweight
				+ ", listOfFighterFlyweight=" + listOfFighterFlyweight + "]";
	}

}
