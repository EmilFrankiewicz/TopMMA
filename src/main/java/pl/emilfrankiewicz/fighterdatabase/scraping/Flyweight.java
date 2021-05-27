package pl.emilfrankiewicz.fighterdatabase.scraping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.emilfrankiewicz.fighterdatabase.model.FighterFlyweight;

public class Flyweight {

	private List<FighterFlyweight> listFlyweight;

	public Flyweight() {
		listFlyweight = new ArrayList<>();
	}

	public List<FighterFlyweight> flyweight() throws IOException {

		String url = "https://www.sherdog.com/news/rankings/9/Sherdogs-Official-Mixed-Martial-Arts-Rankings-179541";
		Document document = Jsoup.connect(url).userAgent("Mozilla").header("Accept", "text/html")
				.header("Accept-Encoding", "gzip,deflate")
				.header("Accept-Language", "it-IT,en;q=0.8,en-US;q=0.6,de;q=0.4,it;q=0.2,es;q=0.2")
				.header("Connection", "keep-alive").ignoreContentType(true).get();
		Elements fighters = document.select("h2 > a[href]");
		for (Element fighter : fighters) {
			FighterFlyweight fighterToParse = new FighterFlyweight();
			System.out.println(fighter.text());
			String fighterUrl = "https://www.sherdog.com" + fighter.attr("href");
			Document doc = Jsoup.connect(fighterUrl).userAgent("Mozilla").header("Accept", "text/html")
					.header("Accept-Encoding", "gzip,deflate")
					.header("Accept-Language", "it-IT,en;q=0.8,en-US;q=0.6,de;q=0.4,it;q=0.2,es;q=0.2")
					.header("Connection", "keep-alive").ignoreContentType(true).get();

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

			listFlyweight.add(fighterToParse);

			// fighterData = doc.select("div.data").first();
			// System.out.println(fighterData.text());
			System.out.println("---------------");

		}
		return listFlyweight;
	}
}