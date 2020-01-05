package pl.emilfrankiewicz.fighterdatabase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightweight;
import pl.emilfrankiewicz.fighterdatabase.service.LightweightService;

@RestController
public class LightweightController {

	private LightweightService lightweightService;

	@Autowired
	public LightweightController(LightweightService lightweightService) {
		this.lightweightService = lightweightService;
	}

	@RequestMapping(value = "/api/TopMMA/Lightweight", method = RequestMethod.GET)
	public List<FighterLightweight> getAllFightersFromLightweight() {
		List<FighterLightweight> fightersToGet = lightweightService.getAllLightweightFighter();
		return fightersToGet;
	}

	@RequestMapping(value = "/api/TopMMA/Lightweight/{fighterId}", method = RequestMethod.GET)
	public FighterLightweight getSpecificFighter(@PathVariable("fighterId") Long id) {
		FighterLightweight fighterToGet = lightweightService.getFighterbyId(id);
		return fighterToGet;
	}
}
