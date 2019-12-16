package pl.emilfrankiewicz.fighterdatabase.scraping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightweight;


public class Lightweight {

	private List<FighterLightweight> listLightweight;

	public Lightweight() {
		listLightweight = new ArrayList<>();
	}

	public List<FighterLightweight> lightweight() throws IOException {

		String url = "https://www.sherdog.com/news/rankings/6/Sherdogs-Official-Mixed-Martial-Arts-Rankings-164999";
		Document document = Jsoup.connect(url).get();
		Elements fighters = document.select("h2 > a[href]");
		for (Element fighter : fighters) {
			FighterLightweight fighterToParse = new FighterLightweight();
			System.out.println(fighter.text());
			String fighterUrl = "https://www.sherdog.com" + fighter.attr("href");
			Document doc = Jsoup.connect(fighterUrl).get();

			Element fighterData = doc.select("span[class=fn]").first();
			fighterToParse.setName(fighterData.text().toString());

			fighterData = doc.select("span[class=item birthday]").first();
			fighterToParse.setAge(fighterData.text().toString());

			fighterData = doc.select("span[class=item weight]").first();
			fighterToParse.setWeight(fighterData.text().toString());

			fighterData = doc.select("span[class=item height]").first();
			fighterToParse.setHeight(fighterData.text().toString());

			fighterData = doc.select("strong[class=title]").first();
			fighterToParse.setCategory(fighterData.text().toString());

			fighterData = doc.select("span[itemprop=name]").first();
			fighterToParse.setAssociation(fighterData.text().toString());

			listLightweight.add(fighterToParse);

			// fighterData = doc.select("div.data").first();
			// System.out.println(fighterData.text());
			System.out.println("---------------");

		}
		return listLightweight;
	}
}