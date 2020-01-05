package pl.emilfrankiewicz.fighterdatabase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.emilfrankiewicz.fighterdatabase.model.FighterMiddleweight;
import pl.emilfrankiewicz.fighterdatabase.service.MiddleweightService;

@RestController
public class MiddleweightController {

	private MiddleweightService middleweightService;

	@Autowired
	public MiddleweightController(MiddleweightService middleweightService) {
		this.middleweightService = middleweightService;
	}

	@RequestMapping(value = "/api/TopMMA/Middleweight", method = RequestMethod.GET)
	public List<FighterMiddleweight> getAllFightersFromMiddleweight() {
		List<FighterMiddleweight> fightersToGet = middleweightService.getAllMiddleweightFighter();
		return fightersToGet;
	}

	@RequestMapping(value = "/api/TopMMA/Middleweight/{fighterId}", method = RequestMethod.GET)
	public FighterMiddleweight getSpecificFighter(@PathVariable("fighterId") Long id) {
		FighterMiddleweight fighterToGet = middleweightService.getFighterbyId(id);
		return fighterToGet;
	}
}
