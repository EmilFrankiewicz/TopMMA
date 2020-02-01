package pl.emilfrankiewicz.fighterdatabase.controller;

import pl.emilfrankiewicz.fighterdatabase.model.FighterHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.repository.HeavyweightRepository;
import pl.emilfrankiewicz.fighterdatabase.service.HeavyweightService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class HeavyweightControllerTest {

	@Mock
	private HeavyweightService heavyweightService;

	private FighterHeavyweight fighterHeavyweight;

	@Mock
	private HeavyweightRepository heavyweightRepository;

	@InjectMocks
	private HeavyweightController heavyweightController;

	private MockMvc mockMvc;

	private static final String API_URL = "/api/TopMMA/Heavyweight";

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(heavyweightController).build();
		fighterHeavyweight = new FighterHeavyweight();
	}

	@Test
	public void getSpecificHeavyweightFighter() throws Exception {

		FighterHeavyweight hw = new FighterHeavyweight();
		hw.setId(2L);
		hw.setName("Stipe");
		hw.setAge("16");
		hw.setAssociation("ATT");
		hw.setCategory("HW");
		hw.setWeight("12");
		hw.setHeight("16");

		fighterHeavyweight.setId(2L);
		fighterHeavyweight.setName("Stipe");
		fighterHeavyweight.setAge("16");
		fighterHeavyweight.setAssociation("ATT");
		fighterHeavyweight.setCategory("HW");
		fighterHeavyweight.setWeight("12");
		fighterHeavyweight.setHeight("16");

		// given
		given(heavyweightRepository.getOne(2L)).willReturn(fighterHeavyweight);

		// when
		when(heavyweightService.getFighterbyId(2L)).thenReturn(hw);

		// then
		assertThat(fighterHeavyweight.equals(hw)).isTrue();
	}

	@Test
	public void getAllHeavyweightFighter() throws Exception {

		List<FighterHeavyweight> list = new ArrayList<>();

		// given
		fighterHeavyweight.setId(2L);
		fighterHeavyweight.setName("Stipe");
		list.add(fighterHeavyweight);
		list = Arrays.asList();
		// when
		MockHttpServletResponse response = mockMvc.perform(get(API_URL).accept(MediaType.APPLICATION_JSON)).andReturn()
				.getResponse();

		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(new ObjectMapper().writeValueAsString(list));
	}

}
