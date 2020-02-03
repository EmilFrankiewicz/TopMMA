package pl.emilfrankiewicz.fighterdatabase.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import java.security.Principal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.emilfrankiewicz.fighterdatabase.model.FighterHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.service.AddingToFavoritesService;
import pl.emilfrankiewicz.fighterdatabase.service.HeavyweightService;
import pl.emilfrankiewicz.fighterdatabase.service.MailService;
import pl.emilfrankiewicz.fighterdatabase.service.UserService;
import pl.emilfrankiewicz.model.Order;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FavoriteFightersControllerTest {

	private MockMvc mockMvc;

	@Mock
	private HeavyweightService heavyweightService;

	@Mock
	private MailService mailService;

	@Mock
	private UserService userService;

	@InjectMocks
	private FavoriteFightersController favoriteFightersController;

	@Mock
	private AddingToFavoritesService addingToFavoritesService;

	@Mock
	private Principal principal;

	private static final String API_URL = "/api/TopMMA/favorite/Heavyweight/";

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(favoriteFightersController).build();
	}

	@Test
	public void fighterHeavyweightCanBeAddedWhenFighterHeavyweightExist() throws Exception {

		// given
		FighterHeavyweight fighterHeavyweight = new FighterHeavyweight();
		fighterHeavyweight.setId(2L);
		fighterHeavyweight.setName("Stipe");

		given(principal.getName()).willReturn("user123");
		given(heavyweightService.getFighterbyId(2L)).willReturn(fighterHeavyweight);

		Order order = new Order();

		order.addFighterHeavyweight(fighterHeavyweight);

		// when
		MockHttpServletResponse response = mockMvc.perform(post(API_URL + "2").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(order)).accept(MediaType.APPLICATION_JSON)
				.principal(principal)).andReturn().getResponse();

		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
	}

	@Test
	public void fighterHeavyweightCannotBeAddedWhenFighterHeavyweightNotExist() throws Exception {

		// given
		FighterHeavyweight fighterHeavyweight = new FighterHeavyweight();
		fighterHeavyweight.setId(3L);
		fighterHeavyweight.setName("Stipe");

		given(principal.getName()).willReturn("user123");
		given(heavyweightService.getFighterbyId(3L)).willReturn(fighterHeavyweight);

		Order order = new Order();

		order.addFighterHeavyweight(fighterHeavyweight);

		// when
		MockHttpServletResponse response = mockMvc.perform(post(API_URL + "20").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(order)).accept(MediaType.APPLICATION_JSON)
				.principal(principal)).andReturn().getResponse();

		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
	}

}
