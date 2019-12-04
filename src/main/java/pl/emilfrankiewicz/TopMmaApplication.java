package pl.emilfrankiewicz;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import pl.emilfrankiewicz.figterdatabase.service.FighterDataBaseService;

@SpringBootApplication
@ComponentScan(basePackageClasses = FighterDataBaseService.class)
public class TopMmaApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(TopMmaApplication.class, args);
	}
}
