package pl.emilfrankiewicz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.emilfrankiewicz.model.User;
import pl.emilfrankiewicz.model.UserDetails;
import pl.emilfrankiewicz.repository.UserRepository;

@SpringBootApplication
public class TopMmaApplication {

	public static void main(String[] args) {
		// SpringApplication.run(TopMmaApplication.class, args);

		ConfigurableApplicationContext ctx = SpringApplication.run(TopMmaApplication.class, args);

		UserRepository userRepository = ctx.getBean(UserRepository.class);
		
	
	
		List<String> hobby = new ArrayList<>();
		hobby.add("dancing");
		hobby.add("mma");
		UserDetails details1 = new UserDetails("Rondo ONZ", "man", "Fikcyjne", hobby);
	
		
		User user1 = new User("Emil", "user666", 27, "emil@emil.pl", "qwerty12345");
		user1.setUserDetails(details1);
		
		
		userRepository.save(user1);
		System.out.println(userRepository.findById(1L));
		
		userRepository.delete(user1);
		
		System.out.println(userRepository.findById(1L));
		ctx.close();
	}

}
