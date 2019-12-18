package pl.emilfrankiewicz.fighterdatabase.controller;

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
import pl.emilfrankiewicz.fighterdatabase.service.UserService;
import pl.emilfrankiewicz.model.User;

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
}
