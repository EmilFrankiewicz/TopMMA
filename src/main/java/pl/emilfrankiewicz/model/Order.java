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
import pl.emilfrankiewicz.fighterdatabase.model.FighterHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightHeavyweight;

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

}
