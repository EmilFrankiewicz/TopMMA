package pl.emilfrankiewicz.fighterdatabase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.emilfrankiewicz.fighterdatabase.model.FighterBantamweight;
import pl.emilfrankiewicz.fighterdatabase.service.BantamweightService;

@RestController
public class BantamweightController {

	private BantamweightService bantamweightService;

	@Autowired
	public BantamweightController(BantamweightService bantamweightService) {
		this.bantamweightService = bantamweightService;
	}

	@RequestMapping(value = "/api/TopMMA/Bantamweight", method = RequestMethod.GET)
	public List<FighterBantamweight> getAllFightersFromBantamweight() {
		List<FighterBantamweight> fightersToGet = bantamweightService.getAllBantamweightFighter();
		return fightersToGet;
	}

	@RequestMapping(value = "/api/TopMMA/Bantamweight/{fighterId}", method = RequestMethod.GET)
	public FighterBantamweight getSpecificFighter(@PathVariable("fighterId") Long id) {
		FighterBantamweight fighterToGet = bantamweightService.getFighterbyId(id);
		return fighterToGet;
	}
}
