package pl.emilfrankiewicz.fighterdatabase.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.emilfrankiewicz.fighterdatabase.model.FighterBantamweight;
import pl.emilfrankiewicz.fighterdatabase.repository.BantamweightRepository;

@Service
public class BantamweightService {

	private BantamweightRepository bantamweightRepository;

	@Autowired
	public BantamweightService(BantamweightRepository bantamweightRepository) {
		this.bantamweightRepository = bantamweightRepository;
	}

	public List<FighterBantamweight> getAllBantamweightFighter() {
		return bantamweightRepository.findAll();
	}

	public FighterBantamweight getFighterbyId(Long idFighter) {
		return bantamweightRepository.getOne(idFighter);
	}
}
