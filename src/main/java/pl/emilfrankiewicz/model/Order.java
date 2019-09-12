package pl.emilfrankiewicz.model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "user_orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private long id;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST })
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "order_of_fighter", joinColumns = {
			@JoinColumn(name = "order_id", referencedColumnName = "id_order") }, inverseJoinColumns = {
					@JoinColumn(name = "fighter_id", referencedColumnName = "id_fighter") })
	private Set<Fighter> setOfFighter = new TreeSet<>();

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private User user;

	public Order() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Fighter> getSetOfFighter() {
		return setOfFighter;
	}

	public void setSetOfFighter(Set<Fighter> setOfFighter) {
		this.setOfFighter = setOfFighter;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", setOfFighter=" + setOfFighter + ", user=" + user.getNick() + "]";
	}

}
