package pl.emilfrankiewicz.fighterdatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pl.emilfrankiewicz.dto.UserDetailsDTO;
import pl.emilfrankiewicz.model.User;
import pl.emilfrankiewicz.model.UserDetails;
import pl.emilfrankiewicz.model.UserRole;
import pl.emilfrankiewicz.repository.UserRepository;
import pl.emilfrankiewicz.repository.UserRoleRepository;

@Service
public class UserService {

	private static final String DEFAULT_ROLE = "ROLE_USER";
	private UserRepository userRepository;
	private UserRoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, UserRoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setRoleRepository(UserRoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public void addWithDefaultRole(User user) {
		UserRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
		user.getRoles().add(defaultRole);
		String passwordHash = passwordEncoder.encode(user.getPassword());
		user.setPassword(passwordHash);
		userRepository.save(user);
	}

	public User getUserByNickname(String username) {
		return userRepository.findByNickname(username);
	}

	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void save(User user) {
		userRepository.save(user);
	}

	public User setUserDetails(User user, UserDetailsDTO userToUpdateDTO) {

		UserDetails userDetails = new UserDetails();

		userDetails.setAddress(userToUpdateDTO.getAddress());
		userDetails.setGender(userToUpdateDTO.getGender());
		userDetails.setAge(userToUpdateDTO.getAge());
		userDetails.setFirstName(userToUpdateDTO.getFirstName());
		userDetails.setLastName(userToUpdateDTO.getLastName());

		user.setUserDetails(userDetails);

		return user;
	}

}
