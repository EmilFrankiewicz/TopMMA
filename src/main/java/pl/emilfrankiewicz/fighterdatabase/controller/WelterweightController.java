package pl.emilfrankiewicz.fighterdatabase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.emilfrankiewicz.fighterdatabase.model.FighterWelterweight;
import pl.emilfrankiewicz.fighterdatabase.service.WelterweightService;

@RestController
public class WelterweightController {

	private WelterweightService welterweightService;

	@Autowired
	public WelterweightController(WelterweightService welterweightService) {
		this.welterweightService = welterweightService;
	}

	@RequestMapping(value = "/api/TopMMA/Welterweight", method = RequestMethod.GET)
	public List<FighterWelterweight> getAllFightersFromWelterweight() {
		List<FighterWelterweight> fightersToGet = welterweightService.getAllWelterweightFighter();
		return fightersToGet;
	}

	@RequestMapping(value = "/api/TopMMA/Welterweight/{fighterId}", method = RequestMethod.GET)
	public FighterWelterweight getSpecificFighter(@PathVariable("fighterId") Long id) {
		FighterWelterweight fighterToGet = welterweightService.getFighterbyId(id);
		return fighterToGet;
	}
}
