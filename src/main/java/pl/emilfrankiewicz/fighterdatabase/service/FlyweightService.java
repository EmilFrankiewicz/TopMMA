package pl.emilfrankiewicz.fighterdatabase.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.emilfrankiewicz.fighterdatabase.model.FighterFlyweight;
import pl.emilfrankiewicz.fighterdatabase.repository.FlyweightRepository;

@Service
public class FlyweightService {

	private FlyweightRepository flyweightRepository;

	@Autowired
	public FlyweightService(FlyweightRepository flyweightRepository) {
		this.flyweightRepository = flyweightRepository;
	}

	public List<FighterFlyweight> getAllFlyweightFighter() {
		return flyweightRepository.findAll();
	}

	public FighterFlyweight getFighterbyId(Long idFighter) {
		return flyweightRepository.getOne(idFighter);
	}
}
