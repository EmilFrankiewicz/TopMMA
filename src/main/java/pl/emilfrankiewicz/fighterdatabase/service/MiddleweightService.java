package pl.emilfrankiewicz.fighterdatabase.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.emilfrankiewicz.fighterdatabase.model.FighterMiddleweight;
import pl.emilfrankiewicz.fighterdatabase.repository.MiddleweightRepository;

@Service
public class MiddleweightService {

	private MiddleweightRepository middleweightRepository;

	@Autowired
	public MiddleweightService(MiddleweightRepository middleweightRepository) {
		this.middleweightRepository = middleweightRepository;
	}

	public List<FighterMiddleweight> getAllMiddleweightFighter() {
		return middleweightRepository.findAll();
	}

	public FighterMiddleweight getFighterbyId(Long idFighter) {
		return middleweightRepository.getOne(idFighter);
	}
}
