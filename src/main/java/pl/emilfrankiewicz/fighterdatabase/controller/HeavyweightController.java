package pl.emilfrankiewicz.fighterdatabase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.emilfrankiewicz.fighterdatabase.model.FighterHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.service.HeavyweightService;

@RestController
public class HeavyweightController {

	private HeavyweightService heavyweightService;

	@Autowired
	public HeavyweightController(HeavyweightService heavyweightService) {
		this.heavyweightService = heavyweightService;
	}

	@RequestMapping(value = "/api/TopMMA/Heavyweight", method = RequestMethod.GET)
	public List<FighterHeavyweight> getAllFightersFromHeavyweight() {
		List<FighterHeavyweight> fightersToGet = heavyweightService.getAllHeavyweightFighter();
		return fightersToGet;
	}

	@RequestMapping(value = "/api/TopMMA/Heavyweight/{fighterId}", method = RequestMethod.GET)
	public FighterHeavyweight getSpecificFighter(@PathVariable("fighterId") Long id) {

		FighterHeavyweight fighterToGet = heavyweightService.getFighterbyId(id);

		return fighterToGet;
	}

}
