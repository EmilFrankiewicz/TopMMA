package pl.emilfrankiewicz.fighterdatabase.controller;

import java.security.Principal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.emilfrankiewicz.dto.UserDTO;
import pl.emilfrankiewicz.dto.UserDetailsDTO;
import pl.emilfrankiewicz.exceptions.ResourceDoesNotExistException;
import pl.emilfrankiewicz.fighterdatabase.service.UserService;
import pl.emilfrankiewicz.model.User;
import pl.emilfrankiewicz.model.UserDetails;

@RestController
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/users/register", method = RequestMethod.POST)
	public ResponseEntity<User> registerUser(@Valid @RequestBody UserDTO newUserDTO, BindingResult result) {

		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {
				System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		String nickname = newUserDTO.getUsername();
		String password = newUserDTO.getPassword();
		String email = newUserDTO.getEmail();

		if (userService.getUserByNickname(nickname) != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		User newUser = new User();
		newUser.setNickname(nickname);
		newUser.setPassword(password);
		newUser.setEmail(email);
		userService.addWithDefaultRole(newUser);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@RequestMapping(value = "/users/userDetails", method = RequestMethod.POST)
	public ResponseEntity<User> addUserDetails(Principal principal, @Valid @RequestBody UserDetailsDTO userToUpdateDTO,
			BindingResult result) throws ResourceDoesNotExistException {

		String email = principal.getName();

		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {
				System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		User user = new User();
		user = userService.getUserByEmail(email);

		if (user.getUserDetails() != null) {
			throw new ResourceDoesNotExistException("User details already exist.");
		}

		user = userService.setUserDetails(user, userToUpdateDTO);
		userService.save(user);

		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@RequestMapping(value = "/users/userDetails", method = RequestMethod.PUT)
	public ResponseEntity<User> editUserDetails(Principal principal, @Valid @RequestBody UserDetailsDTO userToUpdateDTO,
			BindingResult result) throws ResourceDoesNotExistException {

		String email = principal.getName();

		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {
				System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		User user = new User();
		user = userService.getUserByEmail(email);


		user = userService.setUserDetails(user, userToUpdateDTO);
		userService.save(user);

		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@RequestMapping(value = "/users/userDetails", method = RequestMethod.GET)
	public UserDetails getUserDetails(Principal principal) throws ResourceDoesNotExistException {

		String email = principal.getName();
		User user = userService.getUserByEmail(email);

		UserDetails userDetails = user.getUserDetails();

		if (userDetails == null) {
			throw new ResourceDoesNotExistException("User details not found.");
		}
		return userDetails;
	}
}
