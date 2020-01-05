package pl.emilfrankiewicz.fighterdatabase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightHeavyweight;
import pl.emilfrankiewicz.fighterdatabase.service.LightHeavyweightService;

@RestController
public class LightHeavyweightController {

	private LightHeavyweightService lightHeavyweightService;

	@Autowired
	public LightHeavyweightController(LightHeavyweightService lightHeavyweightService) {
		this.lightHeavyweightService = lightHeavyweightService;
	}

	@RequestMapping(value = "/api/TopMMA/LightHeavyweight", method = RequestMethod.GET)
	public List<FighterLightHeavyweight> getAllFightersFromLightHeavyweight() {
		List<FighterLightHeavyweight> fightersToGet = lightHeavyweightService.getAllLightHeavyweightFighter();
		return fightersToGet;
	}

	@RequestMapping(value = "/api/TopMMA/LightHeavyweight/{fighterId}", method = RequestMethod.GET)
	public FighterLightHeavyweight getSpecificFighter(@PathVariable("fighterId") Long id) {

		FighterLightHeavyweight fighterToGet = lightHeavyweightService.getFighterbyId(id);

		return fighterToGet;
	}

}
