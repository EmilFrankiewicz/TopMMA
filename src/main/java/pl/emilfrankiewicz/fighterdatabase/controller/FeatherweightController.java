package pl.emilfrankiewicz.fighterdatabase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.emilfrankiewicz.fighterdatabase.model.FighterFeatherweight;
import pl.emilfrankiewicz.fighterdatabase.service.FeatherweightService;

@RestController
public class FeatherweightController {

	private FeatherweightService featherweightService;

	@Autowired
	public FeatherweightController(FeatherweightService featherweightService) {
		this.featherweightService = featherweightService;
	}

	@RequestMapping(value = "/api/TopMMA/Featherweight", method = RequestMethod.GET)
	public List<FighterFeatherweight> getAllFightersFromFeatherweight() {
		List<FighterFeatherweight> fightersToGet = featherweightService.getAllFeatherweightFighter();
		return fightersToGet;
	}

	@RequestMapping(value = "/api/TopMMA/Featherweight/{fighterId}", method = RequestMethod.GET)
	public FighterFeatherweight getSpecificFighter(@PathVariable("fighterId") Long id) {
		FighterFeatherweight fighterToGet = featherweightService.getFighterbyId(id);
		return fighterToGet;
	}
}
