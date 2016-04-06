package org.beer.app;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.beer.app.converter.ConvertFile;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestBeerAppLocal {

	private static final String ELASTICSEARCH = "elasticsearch";
	private static final String RAM_DIR = "ramDirectory";
	private String dataStorage = RAM_DIR;

	private static DataStorageClient dataStorageClient;

	public void startDataStorageClient() {
		if (ELASTICSEARCH.equals(this.dataStorage)) {
			dataStorageClient = ElasticsearchClient.getInstance();
		} else if (RAM_DIR.equals(this.dataStorage)) {
			dataStorageClient = RamDirectoryClient.getInstance();
		}
		dataStorageClient.start();
	}

	public void stopDataStorageClient() {
		dataStorageClient.stop();
	}

	@Test
	public void testRamDirectoryClient()
			throws BeerValidationException, JsonParseException, JsonMappingException, IOException {
		startDataStorageClient();
		String response = dataStorageClient.getAutoSuggestions("name", "To Øl");
		printAutoSuggestionsToConsole(response);
		stopDataStorageClient();
	}

	@Test
	public void testStartBeerApp() {
		BeerApp app = new BeerApp();
		app.start();
	}

	@Test
	public void testConvertFile2013() {
		String inputFile = "src/main/resources/beers2013_v2.txt";
		String outputFile = "src/main/resources/beers2013_converted.txt";
		ConvertFile.convert(inputFile, outputFile);
	}

	@Test
	public void testConvertFile2016() {
		String inputFile = "src/main/resources/beers2016_v2.txt";
		String outputFile = "src/main/resources/beers2016_converted.txt";
		ConvertFile.convert(inputFile, outputFile);
	}

	@Test
	public void testConvertFileTcbw2016() {
		String inputFile = "src/main/resources/beersTcbw2016_v2.txt";
		String outputFile = "src/main/resources/beersTcbw2016_converted.txt";
		ConvertFile.convert(inputFile, outputFile);
	}

	@Test
	public void testGenerateBackupFile() {
		testConvertFile2013();
		testConvertFile2016();
		String inputFile2013 = "src/main/resources/beers2013_converted.txt";
		String inputFile2016 = "src/main/resources/beers2016_converted.txt";
		String inputFileTcbw2016 = "src/main/resources/beersTcbw2016_converted.txt";
		String outputFile = "src/main/resources/beers2008-2016.txt";
		generateBackup(inputFile2013, inputFile2016, inputFileTcbw2016, outputFile);
	}

	@Test
	public void testCreateBeerRatings() {
		String inputFile = "src/main/resources/beers_converted_2.txt";
		List<BeerRating> brList = BeerRatingFileReader.readBeerRatingsFromFile(inputFile);
		verifyNumberOfCreatedBeerRatings(inputFile, brList);
	}

	@Test
	public void testAddBeerRatingsToEs() throws JsonProcessingException {
		this.dataStorage = ELASTICSEARCH;
		startDataStorageClient();
		String inputFile = "src/main/resources/beers_converted_2.txt";
		List<BeerRating> brList = BeerRatingFileReader.readBeerRatingsFromFile(inputFile);
		for (BeerRating br : brList) {
			dataStorageClient.createBeerRating(br);
		}
		stopDataStorageClient();
	}

	@Test
	public void testGetBeerRatingsFromEs() throws BeerValidationException {
		this.dataStorage = ELASTICSEARCH;
		startDataStorageClient();
		List<BeerRating> brList = dataStorageClient.getBeerRatings("name", "Svaneke Skøre Elg");
		for (BeerRating br : brList) {
			System.out.println("Beer rating from ES:\n" + br.toString());
		}
		stopDataStorageClient();
	}

	private static void printAutoSuggestionsToConsole(String response)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<AutoSuggestion> autoSuggestionList = mapper.readValue(response,
				mapper.getTypeFactory().constructCollectionType(List.class, AutoSuggestion.class));
		for (AutoSuggestion as : autoSuggestionList) {
			System.out.println(as.toString());
		}
	}

	private static void verifyNumberOfCreatedBeerRatings(String inputFile, List<BeerRating> brList) {
		assertEquals(getNumberOfLines(inputFile), brList.size());

	}

	private static int getNumberOfLines(String inputFile) {
		List<String> lines = BeerRatingFileReader.readFile(inputFile);
		BeerRatingFileReader.removeCommentLines(lines);
		return lines.size();
	}

	private static void generateBackup(String inputFile2013, String inputFile2016, String inputFileTcbw2016,
			String outputFile) {
		List<String> lines2013 = BeerRatingFileReader.readFile(inputFile2013);
		List<String> lines2016 = BeerRatingFileReader.readFile(inputFile2016);
		List<String> linesTcbw2016 = BeerRatingFileReader.readFile(inputFileTcbw2016);
		List<String> lines = new ArrayList<>();
		lines.addAll(lines2013);
		lines.addAll(lines2016);
		lines.addAll(linesTcbw2016);
		BeerRatingFileWriter.writeFile(outputFile, lines);
	}

}
