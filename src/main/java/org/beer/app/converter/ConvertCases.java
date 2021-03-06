package org.beer.app.converter;

public final class ConvertCases {

	private ConvertCases() {
	}

	public static String convertToUpperCase(String line) {
		String formattedLine;
		StringBuilder sb = new StringBuilder();
		formattedLine = line.replaceAll("pirkkala", "Pirkkala");
		formattedLine = formattedLine.replaceAll("ruovesi", "Ruovesi");
		formattedLine = formattedLine.replaceAll("konttori", "Konttori");
		formattedLine = formattedLine.replaceAll("tuulensuu", "Tuulensuu");
		formattedLine = formattedLine.replaceAll("kahdet kasvot", "Kahdet Kasvot");
		formattedLine = formattedLine.replaceAll("Kahdet kasvot", "Kahdet Kasvot");
		formattedLine = formattedLine.replaceAll("nordic", "Nordic");
		formattedLine = formattedLine.replaceAll("ukkometso", "Ukkometso");
		formattedLine = formattedLine.replaceAll("haras", "Haras");
		formattedLine = formattedLine.replaceAll("apina", "Apina");
		formattedLine = formattedLine.replaceAll("koivistonkylä", "Koivistonkylä");
		formattedLine = formattedLine.replaceAll("partola", "Pirkkala");
		formattedLine = formattedLine.replaceAll("lielahti", "Lielahti");
		formattedLine = formattedLine.replaceAll("linnainmaa", "Linnainmaa");
		formattedLine = formattedLine.replaceAll("ylöjärvi", "Ylöjärvi");
		formattedLine = formattedLine.replaceAll("kittys", "Kitty's Public House");
		formattedLine = formattedLine.replaceAll("bruuveri", "Bruuveri");
		formattedLine = formattedLine.replaceAll("kittys", "Kitty's Public House");
		formattedLine = formattedLine.replaceAll("plevna", "Plevna");
		formattedLine = formattedLine.replaceAll("stadin", "Stadin");
		formattedLine = formattedLine.replaceAll("mikkeller", "Mikkeller");
		formattedLine = formattedLine.replaceAll("brewdog", "BrewDog");
		formattedLine = formattedLine.replaceAll("Brewdog", "BrewDog");
		formattedLine = formattedLine.replaceAll("de molen", "De Molen");
		formattedLine = formattedLine.replaceAll("De molen", "De Molen");
		formattedLine = formattedLine.replaceAll("to ol", "To Øl");
		formattedLine = formattedLine.replaceAll("to öl", "To Øl");
		formattedLine = formattedLine.replaceAll("To öl", "To Øl");
		formattedLine = formattedLine.replaceAll("To Öl", "To Øl");
		formattedLine = formattedLine.replaceAll("lervig", "Lervig");
		formattedLine = formattedLine.replaceAll("nogne o", "Nøgne Ø");
		formattedLine = formattedLine.replaceAll("nögne ö", "Nøgne Ø");
		formattedLine = formattedLine.replaceAll("Nogne o", "Nøgne Ø");
		formattedLine = formattedLine.replaceAll("Nögne ö", "Nøgne Ø");
		formattedLine = formattedLine.replaceAll("Nogne O", "Nøgne Ø");
		formattedLine = formattedLine.replaceAll("Nögne Ö", "Nøgne Ø");
		formattedLine = formattedLine.replaceAll("nogne", "Nøgne Ø");
		formattedLine = formattedLine.replaceAll("Nogne", "Nøgne Ø");
		formattedLine = formattedLine.replaceAll("Nögne", "Nøgne Ø");
		formattedLine = formattedLine.replaceAll("hiisi", "Hiisi");
		formattedLine = formattedLine.replaceAll("draft", "Draft");
		formattedLine = formattedLine.replaceAll("ccccc", "CCCCC");
		formattedLine = formattedLine.replaceAll("alko", "Alko");
		formattedLine = formattedLine.replaceAll("hopping brewster", "Hopping Brewsters");
		formattedLine = formattedLine.replaceAll("hopping brewsters", "Hopping Brewsters");
		formattedLine = formattedLine.replaceAll("Hopping Brewster", "Hopping Brewsters");
		formattedLine = formattedLine.replaceAll("Hopping brewster", "Hopping Brewsters");
		formattedLine = formattedLine.replaceAll("Hopping brewsters", "Hopping Brewsters");
		formattedLine = formattedLine.replaceAll("hoppin brewster", "Hopping Brewsters");
		formattedLine = formattedLine.replaceAll("hoppin brewsters", "Hopping Brewsters");
		formattedLine = formattedLine.replaceAll("Hoppin Brewster", "Hopping Brewsters");
		formattedLine = formattedLine.replaceAll("Hoppin brewster", "Hopping Brewsters");
		formattedLine = formattedLine.replaceAll("Hoppin brewsters", "Hopping Brewsters");
		formattedLine = formattedLine.replaceAll("Hoppin Brewsters", "Hopping Brewsters");
		formattedLine = formattedLine.replaceAll("tommyknocker", "Tommyknocker");
		formattedLine = formattedLine.replaceAll(" ipa ", " IPA ");
		formattedLine = formattedLine.replaceAll(" ipa. ", " IPA. ");
		formattedLine = formattedLine.replaceAll(" ipa, ", " IPA. ");
		formattedLine = formattedLine.replaceAll(" dipa, ", " DIPA. ");
		formattedLine = formattedLine.replaceAll(" iipa, ", " IIPA. ");
		formattedLine = formattedLine.replaceAll("beer hunters", "Beer Hunters");
		formattedLine = formattedLine.replaceAll("mufloni", "Mufloni");
		sb.append(formattedLine);
		return sb.toString();
	}
}
