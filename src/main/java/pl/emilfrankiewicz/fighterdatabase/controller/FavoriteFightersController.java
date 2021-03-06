package pl.emilfrankiewicz.fighterdatabase.controller;

import java.security.Principal;
import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.emilfrankiewicz.dto.MailDTO;
import pl.emilfrankiewicz.exceptions.ResourceDoesNotExistException;
import pl.emilfrankiewicz.fighterdatabase.model.FighterBantamweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterFeatherweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterFlyweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterMiddleweight;
import pl.emilfrankiewicz.fighterdatabase.model.FighterWelterweight;
import pl.emilfrankiewicz.fighterdatabase.service.AddingToFavoritesService;
import pl.emilfrankiewicz.fighterdatabase.service.BantamweightService;
import pl.emilfrankiewicz.fighterdatabase.service.FeatherweightService;
import pl.emilfrankiewicz.fighterdatabase.service.FlyweightService;
import pl.emilfrankiewicz.fighterdatabase.service.HeavyweightService;
import pl.emilfrankiewicz.fighterdatabase.service.LightHeavyweightService;
import pl.emilfrankiewicz.fighterdatabase.service.LightweightService;
import pl.emilfrankiewicz.fighterdatabase.service.MailService;
import pl.emilfrankiewicz.fighterdatabase.service.MiddleweightService;
import pl.emilfrankiewicz.fighterdatabase.service.OrderService;
import pl.emilfrankiewicz.fighterdatabase.service.UserService;
import pl.emilfrankiewicz.fighterdatabase.service.WelterweightService;
import pl.emilfrankiewicz.model.Mail;
import pl.emilfrankiewicz.model.Order;
import pl.emilfrankiewicz.model.User;

@RestController
public class FavoriteFightersController {

	private HeavyweightService heavyweightService;
	private UserService userService;
	private OrderService orderService;
	private LightHeavyweightService lightHeavyweightService;
	private AddingToFavoritesService addingToFavoritesService;
	private MiddleweightService middleweightService;
	private WelterweightService welterweightService;
	private LightweightService lightweightService;
	private FeatherweightService featherweightService;
	private BantamweightService bantamweightService;
	private FlyweightService flyweightService;
	private MailService mailService;

	@Autowired
	public FavoriteFightersController(HeavyweightService heavyweightService, UserService userService,
			OrderService orderService, LightHeavyweightService lightHeavyweightService,
			AddingToFavoritesService addingToFavoritesService, MiddleweightService middleweightService,
			WelterweightService welterweightService, LightweightService lightweightService,
			FeatherweightService featherweightService, BantamweightService bantamweightService,
			FlyweightService flyweightService, MailService mailService) {
		this.heavyweightService = heavyweightService;
		this.userService = userService;
		this.orderService = orderService;
		this.lightHeavyweightService = lightHeavyweightService;
		this.addingToFavoritesService = addingToFavoritesService;
		this.middleweightService = middleweightService;
		this.welterweightService = welterweightService;
		this.lightweightService = lightweightService;
		this.featherweightService = featherweightService;
		this.bantamweightService = bantamweightService;
		this.flyweightService = flyweightService;
		this.mailService = mailService;
	}

	@RequestMapping(value = "/api/TopMMA/favorite/Heavyweight/{fighterId}", method = RequestMethod.POST)
	public ResponseEntity<Order> addHeavyweightFighterToFavoriteList(Principal principal,
			@PathVariable("fighterId") Long id) throws ResourceDoesNotExistException {

		String email = principal.getName();

		FighterHeavyweight fighterToGet = heavyweightService.getFighterbyId(id);

		if (fighterToGet == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		addingToFavoritesService.addHeavyweightFighterToFavoriteList(id, email);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@RequestMapping(value = "/api/TopMMA/favorite/LightHeavyweight/{fighterId}", method = RequestMethod.POST)
	public ResponseEntity<Order> addLightHeavyweightFighterToFavoriteList(Principal principal,
			@PathVariable("fighterId") Long id) throws ResourceDoesNotExistException {

		String email = principal.getName();

		FighterLightHeavyweight fighterToGet = lightHeavyweightService.getFighterbyId(id);

		if (fighterToGet == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		addingToFavoritesService.addLightHeavyweightFighterToFavoriteList(id, email);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@RequestMapping(value = "/api/TopMMA/favorite/Middleweight/{fighterId}", method = RequestMethod.POST)
	public ResponseEntity<Order> addMiddleweightFighterToFavoriteList(Principal principal,
			@PathVariable("fighterId") Long id) throws ResourceDoesNotExistException {

		String email = principal.getName();

		FighterMiddleweight fighterToGet = middleweightService.getFighterbyId(id);

		if (fighterToGet == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		addingToFavoritesService.addMiddleweightFighterToFavoriteList(id, email);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@RequestMapping(value = "/api/TopMMA/favorite/Welterweight/{fighterId}", method = RequestMethod.POST)
	public ResponseEntity<Order> addWelterweightFighterToFavoriteList(Principal principal,
			@PathVariable("fighterId") Long id) throws ResourceDoesNotExistException {

		String email = principal.getName();

		FighterWelterweight fighterToGet = welterweightService.getFighterbyId(id);

		if (fighterToGet == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		addingToFavoritesService.addWelterweightFighterToFavoriteList(id, email);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@RequestMapping(value = "/api/TopMMA/favorite/Lightweight/{fighterId}", method = RequestMethod.POST)
	public ResponseEntity<Order> addLightweightFighterToFavoriteList(Principal principal,
			@PathVariable("fighterId") Long id) throws ResourceDoesNotExistException {

		String email = principal.getName();

		FighterLightweight fighterToGet = lightweightService.getFighterbyId(id);

		if (fighterToGet == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		addingToFavoritesService.addLightweightFighterToFavoriteList(id, email);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@RequestMapping(value = "/api/TopMMA/favorite/Featherweight/{fighterId}", method = RequestMethod.POST)
	public ResponseEntity<Order> addFeatherweightFighterToFavoriteList(Principal principal,
			@PathVariable("fighterId") Long id) throws ResourceDoesNotExistException {

		String email = principal.getName();

		FighterFeatherweight fighterToGet = featherweightService.getFighterbyId(id);

		if (fighterToGet == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		addingToFavoritesService.addFeatherweightFighterToFavoriteList(id, email);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@RequestMapping(value = "/api/TopMMA/favorite/Bantamweight/{fighterId}", method = RequestMethod.POST)
	public ResponseEntity<Order> addBantamweightFighterToFavoriteList(Principal principal,
			@PathVariable("fighterId") Long id) throws ResourceDoesNotExistException {

		String email = principal.getName();

		FighterBantamweight fighterToGet = bantamweightService.getFighterbyId(id);

		if (fighterToGet == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		addingToFavoritesService.addBantamweightFighterToFavoriteList(id, email);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@RequestMapping(value = "/api/TopMMA/favorite/Flyweight/{fighterId}", method = RequestMethod.POST)
	public ResponseEntity<Order> addFlyweightFighterToFavoriteList(Principal principal,
			@PathVariable("fighterId") Long id) throws ResourceDoesNotExistException {

		String email = principal.getName();

		FighterFlyweight fighterToGet = flyweightService.getFighterbyId(id);

		if (fighterToGet == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		addingToFavoritesService.addFlyweightFighterToFavoriteList(id, email);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

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

	@RequestMapping(value = "/api/TopMMA/email/", method = RequestMethod.GET)
	public ResponseEntity<Mail> sendFavoriteToEmail(Principal principal, @Valid @RequestBody MailDTO mailDTO,
			BindingResult result) throws ResourceDoesNotExistException, MessagingException {

		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {
				System.out.println(error.getObjectName() + " " + error.getDefaultMessage());

			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		String email = principal.getName();
		User user = userService.getUserByEmail(email);

		List<Order> orders = orderService.getAllUserFighter(user);

		if (orders == null) {
			throw new ResourceDoesNotExistException("List of favories fighter is empty.");
		}

		Mail mail = new Mail();
		mail.setFrom(mailDTO.getFrom());
		mail.setTo(mailDTO.getTo());
		mail.setSubject(mailDTO.getSubject());
		mail.setContent(orders.toString());
		mailService.sendMail(mail);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}