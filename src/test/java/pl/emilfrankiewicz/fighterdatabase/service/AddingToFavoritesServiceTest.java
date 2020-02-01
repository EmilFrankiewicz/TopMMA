package pl.emilfrankiewicz.fighterdatabase.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.quality.Strictness;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import pl.emilfrankiewicz.fighterdatabase.model.FighterHeavyweight;
import pl.emilfrankiewicz.model.Order;
import pl.emilfrankiewicz.repository.OrderRepository;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AddingToFavoritesServiceTest {

	@Mock
	private AddingToFavoritesService addingToFavoritesService;
	@Mock
	private OrderRepository orderRepository;

	@Mock
	private HeavyweightService heavyweightService;

	@Test
	public void addHeavyweightFighterToFavoriteListShouldReturnTrue() {

		String userIdentification = "user12345";
		Long id = 1L;

		FighterHeavyweight fighterHeavyweight = new FighterHeavyweight();
		fighterHeavyweight.setId(2L);
		fighterHeavyweight.setName("Stipe");
		fighterHeavyweight.setAge("16");
		fighterHeavyweight.setAssociation("ATT");
		fighterHeavyweight.setCategory("HW");
		fighterHeavyweight.setWeight("12");
		fighterHeavyweight.setHeight("16");

		Order order = new Order();
		order.addFighterHeavyweight(fighterHeavyweight);

		// Given
		given(orderRepository.save(order)).willReturn(order);

		// When
		addingToFavoritesService.addHeavyweightFighterToFavoriteList(id, userIdentification);

		// Then
		assertThat(order.getListOfFighterHeavyweight()).isNotEmpty();
	}
}
