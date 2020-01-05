package pl.emilfrankiewicz.fighterdatabase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.emilfrankiewicz.fighterdatabase.model.FighterFlyweight;
import pl.emilfrankiewicz.fighterdatabase.service.FlyweightService;

@RestController
public class FlyweightController {

	private FlyweightService flyweightService;

	@Autowired
	public FlyweightController(FlyweightService flyweightService) {
		this.flyweightService = flyweightService;
	}

	@RequestMapping(value = "/api/TopMMA/Flyweight", method = RequestMethod.GET)
	public List<FighterFlyweight> getAllFightersFromFlyweight() {
		List<FighterFlyweight> fightersToGet = flyweightService.getAllFlyweightFighter();
		return fightersToGet;
	}

	@RequestMapping(value = "/api/TopMMA/Flyweight/{fighterId}", method = RequestMethod.GET)
	public FighterFlyweight getSpecificFighter(@PathVariable("fighterId") Long id) {
		FighterFlyweight fighterToGet = flyweightService.getFighterbyId(id);
		return fighterToGet;
	}

}
