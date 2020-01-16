package pl.emilfrankiewicz;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pl.emilfrankiewicz.fighterdatabase.service.FighterDataBaseService;

@SpringBootApplication
@ComponentScan(basePackageClasses = FighterDataBaseService.class)
@ComponentScan(basePackages = { "pl.emilfrankiewicz.fighterdatabase" })
@ComponentScan(basePackages = { "pl.emilfrankiewicz.security" })
@ComponentScan(basePackages = { "pl.emilfrankiewicz.fighterdatabase.controller" })
public class TopMmaApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(TopMmaApplication.class, args);
	}
}
