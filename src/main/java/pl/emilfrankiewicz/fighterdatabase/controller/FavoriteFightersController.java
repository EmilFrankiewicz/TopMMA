package pl.emilfrankiewicz.fighterdatabase.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.emilfrankiewicz.exceptions.ResourceDoesNotExistException;
import pl.emilfrankiewicz.fighterdatabase.model.FighterHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.service.HeavyweightService;
import pl.emilfrankiewicz.fighterdatabase.service.LightHeavyweightService;
import pl.emilfrankiewicz.fighterdatabase.service.OrderService;
import pl.emilfrankiewicz.fighterdatabase.service.UserService;
import pl.emilfrankiewicz.model.Order;
import pl.emilfrankiewicz.model.User;

@RestController
public class FavoriteFightersController {

	private HeavyweightService heavyweightService;
	private UserService userService;
	private OrderService orderService;
	private LightHeavyweightService lightHeavyweightService;

	@Autowired
	public FavoriteFightersController(HeavyweightService heavyweightService, UserService userService,
			OrderService orderService, LightHeavyweightService lightHeavyweightService) {
		this.heavyweightService = heavyweightService;
		this.userService = userService;
		this.orderService = orderService;
		this.lightHeavyweightService = lightHeavyweightService;
	}

	@RequestMapping(value = "/api/TopMMA/favorite/Heavyweight/{fighterId}", method = RequestMethod.POST)
	public ResponseEntity<Order> addHeavyweightFighterToFavoriteList(Principal principal,
			@PathVariable("fighterId") Long id) {

		String email = principal.getName();

		FighterHeavyweight fighterH = heavyweightService.getFighterbyId(id);
		Order order = new Order();
		List<FighterHeavyweight> setOfFighter = new ArrayList<>();

		fighterH = heavyweightService.getFighterbyId(id);
		User user = userService.getUserByEmail(email);

		setOfFighter.add(fighterH);
		order.setListOfFighterHeavyweight(setOfFighter);
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		user.addOrder(order);
		// user.setOrders(orders);
		orderService.save(order);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@RequestMapping(value = "/api/TopMMA/favorite/LightHeavyweight/{fighterId}", method = RequestMethod.POST)
	public ResponseEntity<Order> addLightHeavyweightFighterToFavoriteList(Principal principal,
			@PathVariable("fighterId") Long id) {

		String email = principal.getName();

		FighterLightHeavyweight fighterH = lightHeavyweightService.getFighterbyId(id);
		Order order = new Order();
		List<FighterLightHeavyweight> setOfFighter = new ArrayList<>();

		fighterH = lightHeavyweightService.getFighterbyId(id);
		User user = userService.getUserByEmail(email);

		setOfFighter.add(fighterH);
		order.setListOfFighterLightHeavyweight(setOfFighter);
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		user.addOrder(order);
		// user.setOrders(orders);
		orderService.save(order);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	// wywal to wszystko z kontrolera bo siara xd
	// i to ma byc response entity

	@RequestMapping(value = "/api/TopMMA/favorite/{fighterId}", method = RequestMethod.GET)
	public Order getUserOneFavoriteFighter(Principal principal, @PathVariable("fighterId") Long id)
			throws ResourceDoesNotExistException {

		String email = principal.getName();
		User user = userService.getUserByEmail(email);

		Order orders = orderService.getUserOneFighter(user, id);

		if (orders == null) {
			throw new ResourceDoesNotExistException("List of favories fighter is empty.");
		}

		return orders;
	}

	@RequestMapping(value = "/api/TopMMA/favorite/", method = RequestMethod.GET)
	public List<Order> getUserAllFavoriteFigthers(Principal principal) throws ResourceDoesNotExistException {

		String email = principal.getName();
		User user = userService.getUserByEmail(email);

		List<Order> orders = orderService.getAllUserFighter(user);

		if (orders == null) {
			throw new ResourceDoesNotExistException("List of favories fighter is empty.");
		}

		return orders;
	}

	@RequestMapping(value = "/api/TopMMA/favorite/{fighterId}", method = RequestMethod.DELETE)
	public ResponseEntity<Order> deleteFighterOrders(Principal principal, @PathVariable("fighterId") Long id)
			throws ResourceDoesNotExistException {

		String email = principal.getName();
		User user = userService.getUserByEmail(email);

		Order orders = orderService.getUserOneFighter(user, id);

		if (orders == null) {
			throw new ResourceDoesNotExistException("List of given ID not found");
		}

		orderService.deleteUserFavoriteFighter(id, user.getId());
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}