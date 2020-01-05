package pl.emilfrankiewicz.fighterdatabase.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.emilfrankiewicz.fighterdatabase.model.FighterFeatherweight;
import pl.emilfrankiewicz.fighterdatabase.repository.FeatherweightRepository;

@Service
public class FeatherweightService {

	private FeatherweightRepository featherweightRepository;

	@Autowired
	public FeatherweightService(FeatherweightRepository featherweightRepository) {
		this.featherweightRepository = featherweightRepository;
	}

	public List<FighterFeatherweight> getAllFeatherweightFighter() {
		return featherweightRepository.findAll();
	}

	public FighterFeatherweight getFighterbyId(Long idFighter) {
		return featherweightRepository.getOne(idFighter);
	}
}
