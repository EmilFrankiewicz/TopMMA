package pl.emilfrankiewicz.fighterdatabase.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.emilfrankiewicz.fighterdatabase.repository.BantamweightRepository;
import pl.emilfrankiewicz.fighterdatabase.repository.FeatherweightRepository;
import pl.emilfrankiewicz.fighterdatabase.repository.FlyweightRepository;
import pl.emilfrankiewicz.fighterdatabase.repository.HeavyweightRepository;
import pl.emilfrankiewicz.fighterdatabase.repository.LightHeavyweightRepository;
import pl.emilfrankiewicz.fighterdatabase.repository.LightweightRepository;
import pl.emilfrankiewicz.fighterdatabase.repository.MiddleweightRepository;
import pl.emilfrankiewicz.fighterdatabase.repository.WelterweightRepository;
import pl.emilfrankiewicz.fighterdatabase.scraping.Bantamweight;
import pl.emilfrankiewicz.fighterdatabase.scraping.Featherweight;
import pl.emilfrankiewicz.fighterdatabase.scraping.Flyweight;
import pl.emilfrankiewicz.fighterdatabase.scraping.Heavyweight;
import pl.emilfrankiewicz.fighterdatabase.scraping.LightHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.scraping.Lightweight;
import pl.emilfrankiewicz.fighterdatabase.scraping.Middleweight;
import pl.emilfrankiewicz.fighterdatabase.scraping.Welterweight;

@Configuration
public class FighterDataBaseService {

	private Heavyweight heavyweight;
	private LightHeavyweight lightHeavyweight;
	private Middleweight middleweight;
	private Welterweight welterweight;
	private Lightweight lightweight;
	private Featherweight featherweight;
	private Bantamweight bantamweight;
	private Flyweight flyweight;

	@Autowired
	private HeavyweightRepository heavyweightRepository;

	@Autowired
	private LightHeavyweightRepository lightHeavyweightRepository;

	@Autowired
	private MiddleweightRepository middleweightRepository;

	@Autowired
	private WelterweightRepository welterweightRepository;

	@Autowired
	private LightweightRepository lightweightRepository;

	@Autowired
	private FeatherweightRepository featherweightRepository;

	@Autowired
	private BantamweightRepository bantamweightRepository;

	@Autowired
	private FlyweightRepository flyweightRepository;

	public FighterDataBaseService() {
		lightHeavyweight = new LightHeavyweight();
		heavyweight = new Heavyweight();
		middleweight = new Middleweight();
		welterweight = new Welterweight();
		lightweight = new Lightweight();
		featherweight = new Featherweight();
		bantamweight = new Bantamweight();
		flyweight = new Flyweight();
	}

	@Bean
	public void runService() throws IOException {

		heavyweightRepository.saveAll(heavyweight.heavyweight());
		lightHeavyweightRepository.saveAll(lightHeavyweight.lightHeavyweight());
		middleweightRepository.saveAll(middleweight.middleweight());
		welterweightRepository.saveAll(welterweight.welterweight());
		lightweightRepository.saveAll(lightweight.lightweight());
		featherweightRepository.saveAll(featherweight.featherweight());
		bantamweightRepository.saveAll(bantamweight.bantamweight());
		flyweightRepository.saveAll(flyweight.flyweight());
	}
}
