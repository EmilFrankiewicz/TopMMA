package pl.emilfrankiewicz.fighterdatabase.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.emilfrankiewicz.model.Order;
import pl.emilfrankiewicz.model.User;
import pl.emilfrankiewicz.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;

	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public void save(Order order) {
		orderRepository.save(order);
	}

	public Order getUserOneFighter(User user, Long id) {
		return orderRepository.getByIdAndUser(id, user);
	}

	public List<Order> getAllUserFighter(User user) {
		return orderRepository.getAllByUser(user);
	}

	public Boolean deleteUserFavoriteFighter(Long orderId, Long userId) {
		Boolean verification;

		orderRepository.deleteUserFavoriteFighter(orderId, userId);

		verification = !orderRepository.existsById(orderId);
		return verification;
	}

}
