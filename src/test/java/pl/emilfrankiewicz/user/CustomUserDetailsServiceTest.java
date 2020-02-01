package pl.emilfrankiewicz.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.security.core.userdetails.UserDetails;

import pl.emilfrankiewicz.model.User;
import pl.emilfrankiewicz.repository.UserRepository;
import pl.emilfrankiewicz.security.CustomUserDetailsService;

@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsServiceTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	private CustomUserDetailsService customUserDetailsService;

	@Test
	public void loadUserByUsernameShoulReturnCorrectUser() {
		// given
		User user = new User();
		user.setNickname("user1");
		given(userRepository.findByNickname(("user1"))).willReturn(user);

		// when
		UserDetails userToReturn = customUserDetailsService.loadUserByUsername("user1");

		// then
		assertThat(userToReturn.equals(user));
	}

	@Test
	@MockitoSettings(strictness = Strictness.LENIENT)
	public void loadUserByUsernameThrowsExceptionWhenUserIsNull() throws Exception {
		// given
		given(userRepository.findByNickname(("user1"))).willReturn(null);

		// when
		customUserDetailsService.loadUserByUsername("useruser");
	}
}
