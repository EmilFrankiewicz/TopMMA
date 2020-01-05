package pl.emilfrankiewicz.fighterdatabase.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightweight;
import pl.emilfrankiewicz.fighterdatabase.repository.LightweightRepository;

@Service
public class LightweightService {

	private LightweightRepository lightweightRepository;

	@Autowired
	public LightweightService(LightweightRepository lightweightRepository) {
		this.lightweightRepository = lightweightRepository;
	}

	public List<FighterLightweight> getAllLightweightFighter() {
		return lightweightRepository.findAll();
	}

	public FighterLightweight getFighterbyId(Long idFighter) {
		return lightweightRepository.getOne(idFighter);
	}
}
