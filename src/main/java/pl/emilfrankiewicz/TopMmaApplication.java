package pl.emilfrankiewicz;

import java.util.HashSet;
import java.util.Set;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.emilfrankiewicz.model.Fighter;
import pl.emilfrankiewicz.model.Order;
import pl.emilfrankiewicz.model.User;
import pl.emilfrankiewicz.model.UserDetails;
import pl.emilfrankiewicz.repository.OrderRepository;
import pl.emilfrankiewicz.repository.UserRepository;

@SpringBootApplication
public class TopMmaApplication {

	public static void main(String[] args) {
		// SpringApplication.run(TopMmaApplication.class, args);

		ConfigurableApplicationContext ctx = SpringApplication.run(TopMmaApplication.class, args);

		UserRepository userRepository = ctx.getBean(UserRepository.class);
		OrderRepository orderRepository = ctx.getBean(OrderRepository.class);
		
		
		UserDetails details1 = new UserDetails("Rondo ONZ", "man", "Fikcyjne", "sumo");
		User user1 = new User("Emil", "user666", 27, "emil@emil.pl", "qwerty12345");
		user1.setUserDetails(details1);
		Order order1 = new Order();
				Fighter fighter1 = new Fighter("Khabib", "Nurmagomedov", "lightweight", 30, "28:0", "Russia",
				"AMERICAN KICKBOXING ACADEMY", "66HF+G8 San Jose, Kalifornia, Stany Zjednoczone");		
		Set<Fighter> setOfFighter = new HashSet<>();
		setOfFighter.add(fighter1);
		order1.setSetOfFighter(setOfFighter);		
		user1.addOrder(order1);	
		orderRepository.save(order1);
			
		
		System.out.println(userRepository.findById(1L));
		userRepository.delete(user1);	
		System.out.println(userRepository.findById(1L));
		ctx.close();
	}
}
