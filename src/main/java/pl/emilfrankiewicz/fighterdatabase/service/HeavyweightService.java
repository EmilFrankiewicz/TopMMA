package pl.emilfrankiewicz.fighterdatabase.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.emilfrankiewicz.fighterdatabase.model.FighterHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.repository.HeavyweightRepository;

@Service
public class HeavyweightService {

	private HeavyweightRepository heavyweightRepository;

	@Autowired
	public HeavyweightService(HeavyweightRepository heavyweightRepository) {
		this.heavyweightRepository = heavyweightRepository;
	}

	public List<FighterHeavyweight> getAllHeavyweightFighter() {
		return heavyweightRepository.findAll();
	}

	public FighterHeavyweight getFighterbyId(Long idFighter) {
		return heavyweightRepository.getOne(idFighter);
	}
}
