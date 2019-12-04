package pl.emilfrankiewicz.figterdatabase.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.emilfrankiewicz.figterdatabase.repository.BantamweightRepository;
import pl.emilfrankiewicz.figterdatabase.repository.FeatherweightRepository;
import pl.emilfrankiewicz.figterdatabase.repository.FlyweightRepository;
import pl.emilfrankiewicz.figterdatabase.repository.HeavyweightRepository;
import pl.emilfrankiewicz.figterdatabase.repository.LightHeavyweightRepository;
import pl.emilfrankiewicz.figterdatabase.repository.LightweightRepository;
import pl.emilfrankiewicz.figterdatabase.repository.MiddleweightRepository;
import pl.emilfrankiewicz.figterdatabase.repository.WelterweightRepository;
import pl.emilfrankiewicz.figterdatabase.scraping.Bantamweight;
import pl.emilfrankiewicz.figterdatabase.scraping.Featherweight;
import pl.emilfrankiewicz.figterdatabase.scraping.Flyweight;
import pl.emilfrankiewicz.figterdatabase.scraping.Heavyweight;
import pl.emilfrankiewicz.figterdatabase.scraping.LightHeavyweight;
import pl.emilfrankiewicz.figterdatabase.scraping.Lightweight;
import pl.emilfrankiewicz.figterdatabase.scraping.Middleweight;
import pl.emilfrankiewicz.figterdatabase.scraping.Welterweight;

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
