import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class input_manually {

	public void input_Manual_Data() throws IOException {

		Map<String, String> map = new TreeMap<>();

		String key;
		String value;
		String input = "";
		boolean repeat = true;

		Scanner scan1 = new Scanner(System.in);
		int userChoice = 0;
		loop: while (true) {
			System.out.println("\n1. Input data \n2. Read Data \n3. Play Game \n4. Original Study Guide Game \n5. End");
			userChoice = scan1.nextInt();
			switch (userChoice) {
			case 1:
				Scanner scan2 = new Scanner(System.in);
				// while loop to fill Map with user input & write to file
				while (repeat) {
					System.out.println("\tEnter key for map: ");
					key = scan2.nextLine();
					System.out.println("\tEnter value for map: ");
					value = scan2.nextLine();
					map.put(key, value);
					System.out.println("\tContinue? (yes/no): ");
					input = scan2.nextLine();

					if ("yes".equals(input))
						repeat = true; // continue loop
					else
						repeat = false; // break infinite while loop

				}

				// write Map data to file
				BufferedWriter bf = null;
				try {
					// relative path of the file is written to the same directory as application
					bf = new BufferedWriter(new FileWriter("MapOutPut.txt"));
					// iterate map entries
					for (Map.Entry<String, String> entry : map.entrySet()) {
						bf.write(entry.getKey() + " : " + entry.getValue());
						bf.newLine();
					}
					bf.flush();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {

					try {
						bf.close();
					} catch (Exception e) {
					}
				}
				break;
			case 2:
				try {
					BufferedReader reader = new BufferedReader(new FileReader("MapOutPut.txt"));
					String line;
					while ((line = reader.readLine()) != null) {
						System.out.println(line);
					}
					reader.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					Map<String, String> map2 = new TreeMap<>();
					BufferedReader reader2 = new BufferedReader(new FileReader("MapOutPut.txt"));
					String line2;
					while ((line2 = reader2.readLine()) != null) {
						String[] parts = line2.split(" : ", 2);
						if (parts.length >= 2) {
							String key2 = parts[0];
							String value2 = parts[1];
							map2.put(key2, value2);

						} else {
							System.out.println("ignoring line: " + line2);
						} // end if else
					} // end while loop

					List<Map.Entry<String, String>> entries = new ArrayList<>(map2.entrySet());
					Collections.shuffle(entries);
					Scanner scan3 = new Scanner(System.in);
					String input2 = "";
					int counter = 0;
					// for each loop iterates through the value set of the Tree
					for (Map.Entry<String, String> entry : entries) {
						// print out each value at random
						System.out.println("\tQuestion: " + entry.getValue());
						// System.out.println(entry.getKey()); // uncomment to show key for testing
						System.out.println("\tEnter the correct Key: ");
						input2 = scan3.nextLine();
						if (entry.getKey().equalsIgnoreCase(input2)) {
							System.out.println("\tCorrect!");
							counter++;
						} else {
							System.out.println("\tNot Correct...");
						} // end if else
					} // end of for each

					System.out.println("\tYour score: " + counter);
					// this is an arbitrary condition which can be changed per user specifications
					if (counter >= entries.size() - 2) { 
						System.out.println("\tGreat job! You know your stuff!");
					} else {
						System.out.println("\tLooks like you need more practice...");
					} // end else if
					reader2.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} // end try catch
				break;
			case 4:
				Original_Study_Guide ogsg = new Original_Study_Guide();
				ogsg.OGStudyGuide();
				break;
			case 5:
				System.out.println("\tEnd of Practice...");
				break loop;
			default:
				System.out.println("\tnot an option...");
				break;
			}
		}
	}
}
