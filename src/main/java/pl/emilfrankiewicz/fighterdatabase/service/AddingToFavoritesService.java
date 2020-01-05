package pl.emilfrankiewicz.fighterdatabase.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.emilfrankiewicz.fighterdatabase.model.FighterBantamweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterFeatherweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterFlyweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterMiddleweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterWelterweight;
import pl.emilfrankiewicz.model.Order;
import pl.emilfrankiewicz.model.User;

@Service
public class AddingToFavoritesService {

	private OrderService orderService;
	private UserService userService;
	private HeavyweightService heavyweightService;
	private LightHeavyweightService lightHeavyweightService;
	private MiddleweightService middleweightService;
	private WelterweightService welterweightService;
	private LightweightService lightweightghtService;
	private FeatherweightService featherweightService;
	private BantamweightService bantamweightService;
	private FlyweightService flyweightService;

	@Autowired
	public AddingToFavoritesService(OrderService orderService, UserService userService,
			HeavyweightService heavyweightService, LightHeavyweightService lightHeavyweightService,
			MiddleweightService middleweightService, WelterweightService welterweightService,
			LightweightService lightweightghtService, FeatherweightService featherweightService,
			BantamweightService bantamweightService, FlyweightService flyweightService) {
		this.orderService = orderService;
		this.userService = userService;
		this.heavyweightService = heavyweightService;
		this.lightHeavyweightService = lightHeavyweightService;
		this.middleweightService = middleweightService;
		this.welterweightService = welterweightService;
		this.lightweightghtService = lightweightghtService;
		this.featherweightService = featherweightService;
		this.bantamweightService = bantamweightService;
		this.flyweightService = flyweightService;
	}

	public void addHeavyweightFighterToFavoriteList(Long id, String userIdentification) {

		FighterHeavyweight fighterToAdd = heavyweightService.getFighterbyId(id);
		Order order = new Order();
		List<FighterHeavyweight> setOfFighter = new ArrayList<>();
		fighterToAdd = heavyweightService.getFighterbyId(id);
		User user = userService.getUserByEmail(userIdentification);
		setOfFighter.add(fighterToAdd);
		order.setListOfFighterHeavyweight(setOfFighter);
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		user.addOrder(order);
		orderService.save(order);
	}

	public void addLightHeavyweightFighterToFavoriteList(Long id, String userIdentification) {

		FighterLightHeavyweight fighterToAdd = lightHeavyweightService.getFighterbyId(id);
		Order order = new Order();
		List<FighterLightHeavyweight> setOfFighter = new ArrayList<>();
		fighterToAdd = lightHeavyweightService.getFighterbyId(id);
		User user = userService.getUserByEmail(userIdentification);
		setOfFighter.add(fighterToAdd);
		order.setListOfFighterLightHeavyweight(setOfFighter);
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		user.addOrder(order);
		orderService.save(order);
	}

	public void addMiddleweightFighterToFavoriteList(Long id, String userIdentification) {

		FighterMiddleweight fighterToAdd = middleweightService.getFighterbyId(id);
		Order order = new Order();
		List<FighterMiddleweight> setOfFighter = new ArrayList<>();
		fighterToAdd = middleweightService.getFighterbyId(id);
		User user = userService.getUserByEmail(userIdentification);
		setOfFighter.add(fighterToAdd);
		order.setListOfFighterMiddleweight(setOfFighter);
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		user.addOrder(order);
		orderService.save(order);
	}

	public void addWelterweightFighterToFavoriteList(Long id, String userIdentification) {

		FighterWelterweight fighterToAdd = welterweightService.getFighterbyId(id);
		Order order = new Order();
		List<FighterWelterweight> setOfFighter = new ArrayList<>();
		fighterToAdd = welterweightService.getFighterbyId(id);
		User user = userService.getUserByEmail(userIdentification);
		setOfFighter.add(fighterToAdd);
		order.setListOfFighterWelterweight(setOfFighter);
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		user.addOrder(order);
		orderService.save(order);
	}

	public void addLightweightFighterToFavoriteList(Long id, String userIdentification) {

		FighterLightweight fighterToAdd = lightweightghtService.getFighterbyId(id);
		Order order = new Order();
		List<FighterLightweight> setOfFighter = new ArrayList<>();
		fighterToAdd = lightweightghtService.getFighterbyId(id);
		User user = userService.getUserByEmail(userIdentification);
		setOfFighter.add(fighterToAdd);
		order.setListOfFighterLightweight(setOfFighter);
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		user.addOrder(order);
		orderService.save(order);
	}

	public void addFeatherweightFighterToFavoriteList(Long id, String userIdentification) {

		FighterFeatherweight fighterToAdd = featherweightService.getFighterbyId(id);
		Order order = new Order();
		List<FighterFeatherweight> setOfFighter = new ArrayList<>();
		fighterToAdd = featherweightService.getFighterbyId(id);
		User user = userService.getUserByEmail(userIdentification);
		setOfFighter.add(fighterToAdd);
		order.setListOfFighterFeatherweight(setOfFighter);
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		user.addOrder(order);
		orderService.save(order);
	}

	public void addBantamweightFighterToFavoriteList(Long id, String userIdentification) {

		FighterBantamweight fighterToAdd = bantamweightService.getFighterbyId(id);
		Order order = new Order();
		List<FighterBantamweight> setOfFighter = new ArrayList<>();
		fighterToAdd = bantamweightService.getFighterbyId(id);
		User user = userService.getUserByEmail(userIdentification);
		setOfFighter.add(fighterToAdd);
		order.setListOfFighterBantamweight(setOfFighter);
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		user.addOrder(order);
		orderService.save(order);
	}

	public void addFlyweightFighterToFavoriteList(Long id, String userIdentification) {

		FighterFlyweight fighterToAdd = flyweightService.getFighterbyId(id);
		Order order = new Order();
		List<FighterFlyweight> setOfFighter = new ArrayList<>();
		fighterToAdd = flyweightService.getFighterbyId(id);
		User user = userService.getUserByEmail(userIdentification);
		setOfFighter.add(fighterToAdd);
		order.setListOfFighterFlyweight(setOfFighter);
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		user.addOrder(order);
		orderService.save(order);
	}

}
