package pl.emilfrankiewicz.fighterdatabase.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.emilfrankiewicz.fighterdatabase.model.FighterWelterweight;
import pl.emilfrankiewicz.fighterdatabase.repository.WelterweightRepository;

@Service
public class WelterweightService {

	private WelterweightRepository welterweightRepository;

	@Autowired
	public WelterweightService(WelterweightRepository welterweightRepository) {
		this.welterweightRepository = welterweightRepository;
	}

	public List<FighterWelterweight> getAllWelterweightFighter() {
		return welterweightRepository.findAll();
	}

	public FighterWelterweight getFighterbyId(Long idFighter) {
		return welterweightRepository.getOne(idFighter);
	}
}
