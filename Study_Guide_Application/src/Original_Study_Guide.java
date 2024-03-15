
/*
 * This program is to act as a study guide application which will hold the questions and answers 
 * in a Map data structure which stores items in "key/value" pairs. 
 * 
 * The program will ask the user a given question at random and prompt them for input of the answer,
 * which should be case insensitive. 
 * 
 * Every time the user gets an answer correct the "counter" will keep track of their number of 
 * correct questions, returning their score at the end with a good or bad rating. 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Original_Study_Guide {
	public void OGStudyGuide() {
		Scanner scan = new Scanner(System.in);
		Map<String, String> mymap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		mymap.put("Cambrian", "Multi-celled vertebrate and invertebrate animals dominated the world's ocean.");
		mymap.put("Ordovician","Time when the earliest arthropods and vertebrates expand their presence in the world's oceans.");
		mymap.put("Silurian","Colonization of dry land by the frist terrestrial invertebrates, and the evolution of jawed fish.");
		mymap.put("Devonian", "First tetrapods climbed out of the primordial seas.");
		mymap.put("Carboniferous", "Massive swamps that cooked over tens of millions of years into today's vast reserves of coal and natural gas.");
		mymap.put("Permian", "The greatest mass extinction of the last 500 million years.");
		mymap.put("Triassic", "First age of the Dinosaurs.");
		mymap.put("Jurassic", "Second age of the Dinosaurs.");
		mymap.put("Cretaceous", "Third age of the Dinosaurs.");
		mymap.put("Paleogene", "A crucial interval in the evolution of mammals, birds, and reptiles.");
		mymap.put("Neogene", "Life on Earth adapted to new ecological niches opened up by global cooling.");
		mymap.put("Quaternary", "Current time period.");

		List<Map.Entry<String, String>> entries = new ArrayList<>(mymap.entrySet());
		Collections.shuffle(entries);
		String input = "";
		int counter = 0;

		for (Map.Entry<String, String> entry : entries) {
			// print out each value at random
			System.out.println("\tQuestion: " + entry.getValue());
			// System.out.println(entry.getKey()); // uncomment to see key for testing
			System.out.println("\tEnter the correct Epoch: ");
			input = scan.nextLine();
			if (entry.getKey().equalsIgnoreCase(input)) {
				System.out.println("\tCorrect!");
				counter++;
			} else {
				System.out.println("\tNot Correct...");
			} // end if else
		} // end of for each

		System.out.println("\tYour score: " + counter);
		if (counter >= 10) {
			System.out.println("\tGreat job! You know your stuff!");
		} else {
			System.out.println("\tLooks like you need more practice...");
		} // end else if
	}
}
