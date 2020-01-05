package pl.emilfrankiewicz.fighterdatabase.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.repository.LightHeavyweightRepository;

@Service
public class LightHeavyweightService {

	private LightHeavyweightRepository lightHeavyweightRepository;

	@Autowired
	public LightHeavyweightService(LightHeavyweightRepository lightHeavyweightRepository) {
		this.lightHeavyweightRepository = lightHeavyweightRepository;
	}

	public List<FighterLightHeavyweight> getAllLightHeavyweightFighter() {
		return lightHeavyweightRepository.findAll();
	}

	public FighterLightHeavyweight getFighterbyId(Long idFighter) {
		return lightHeavyweightRepository.getOne(idFighter);
	}
}
