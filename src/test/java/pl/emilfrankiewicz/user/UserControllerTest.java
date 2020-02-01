package pl.emilfrankiewicz.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import java.security.Principal;
import org.mockito.quality.Strictness;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.emilfrankiewicz.dto.UserDTO;
import pl.emilfrankiewicz.dto.UserDetailsDTO;
import pl.emilfrankiewicz.fighterdatabase.controller.UserController;
import pl.emilfrankiewicz.fighterdatabase.service.UserService;
import pl.emilfrankiewicz.model.User;
import pl.emilfrankiewicz.model.UserDetails;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

public class UserControllerTest {

	private MockMvc mockMvc;

	private static final String API_URL = "/users/userDetails";

	@InjectMocks
	private UserController userController;

	private UserDTO userDTO;

	@Mock
	private UserService userService;

	private UserDetailsDTO userDetailsDTO;

	@Mock
	private Principal principal;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		userDTO = new UserDTO();
		userDetailsDTO = new UserDetailsDTO();
	}

	@Test
	public void userCanBeRegisteredWhenUsernamePasswordEmailIsCorrect() throws JsonProcessingException, Exception {

		// Given
		userDTO.setUsername("user12345");
		userDTO.setPassword("qwerty12345");
		userDTO.setEmail("test@test.pl");

		// When
		MockHttpServletResponse response = mockMvc
				.perform(post("/users/register").contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(userDTO)).accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();

		// Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
	}

	@Test
	public void userCannotBeRegisteredWhenEmailIsIncorrect() throws JsonProcessingException, Exception {

		// Given
		userDTO.setUsername("user12345");
		userDTO.setPassword("qwerty12345");
		userDTO.setEmail("testtest.pl");

		// When
		MockHttpServletResponse response = mockMvc
				.perform(post("/users/register").contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(userDTO)).accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();

		// Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}

	@Test
	public void userDetailsCanBeAddedToUser() throws JsonProcessingException, Exception {

		// Given
		userDetailsDTO.setFirstName("Emil");
		userDetailsDTO.setAddress("New York");
		userDetailsDTO.setGender("Man");
		userDetailsDTO.setLastName("Cool");
		userDetailsDTO.setAge(15);

		given(principal.getName()).willReturn("user123");

		// When
		MockHttpServletResponse response = mockMvc.perform(put(API_URL).principal(principal)
				.contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(userDetailsDTO))
				.accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

		// Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
	}

	@Test
	public void userDetailsCannotBeSavedWhenGenderIsNull() throws JsonProcessingException, Exception {

		// Given
		userDetailsDTO.setFirstName("Emil");
		userDetailsDTO.setAddress("New York");
		userDetailsDTO.setGender(null);
		userDetailsDTO.setLastName("Cool");
		userDetailsDTO.setAge(15);

		given(principal.getName()).willReturn("user123");

		// When
		MockHttpServletResponse response = mockMvc.perform(put(API_URL).principal(principal)
				.contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(userDetailsDTO))
				.accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

		// Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}

	@Test
	public void userDetailsCanBeEdit() throws JsonProcessingException, Exception {

		// Given
		userDetailsDTO.setFirstName("NewEmil");
		userDetailsDTO.setAddress("NewNew York");
		userDetailsDTO.setGender("NewMan");
		userDetailsDTO.setLastName("NewCool");
		userDetailsDTO.setAge(25);

		given(principal.getName()).willReturn("user123");

		// When
		MockHttpServletResponse response = mockMvc.perform(put(API_URL).principal(principal)
				.contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(userDetailsDTO))
				.accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

		// Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
	}

	@Test
	public void getUserDetails() throws JsonProcessingException, Exception {
		// Given
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName("Emil");
		userDetails.setAddress("New York");
		userDetails.setGender("Man");
		userDetails.setLastName("Cool");
		userDetails.setAge(15);

		User user = new User();
		user.setUserDetails(userDetails);

		// when
		when(userService.getUserByEmail("user123")).thenReturn(user);

		// then
		assertThat(userDetails).isEqualTo(user.getUserDetails());
	}

}
