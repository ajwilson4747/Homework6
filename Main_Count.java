import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.Set;
import java.util.TreeMap;

public class Main_Count {

	private static ViewLayout myView;

	public static void main(String[] args) throws FileNotFoundException {
		// establish connection with View class and display it
		myView = new ViewLayout();

		// open a file
		File myFile = new File("C:\\Users\\antho\\Desktop\\other-code-sample.txt");
		// create a scanner to read the file
		Scanner myScanner = null;
		// use try and catch to open file and read it

		try {
			// instantiate Scanner object
			myScanner = new Scanner(myFile);
			// count the words
			//countKeyWords(myScanner);
			// instantiate the an arraylist ArrayList<String> list =
			ArrayList<String> mylist = createArrayListMCS(myScanner);
			//parse through the arraylist and place every line in a row ;
			
			  for (int i = 0; i < mylist.size(); i++) { myView.row[0] = mylist.get(i); 
			  myView.model.addRow(myView.row); }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print(" This file can not be found ~ Error");
		} finally {

			if (myScanner != null)
				myScanner.close(); // close the scanner object
		}
	}

	// create ArrayList
	public static ArrayList<String> createArrayListMCS(Scanner myScanner) {

		// TASK 1 : CREATE A STACK TO IDENTIFY MCS
		Stack<String> myStack = new Stack<String>();

		// TASK 2: CREATE VARIABLES TO HOLD THE CURRENT AND PREVIOUS INSTRUCTIONS
		String currentCodeLine = "";
		String previousLine = "";
		int totalSum = 0;
		// TASK 3: CREATE AN ARRAYLIST TO STORE ALL THE MCSs
		ArrayList<String> list = new ArrayList<String>();

			
		
			// TASK 4: SCAN THE CODE LINE BY LINE. PUSH IF { AND POP IF }
		while (myScanner.hasNextLine()) {

			currentCodeLine = myScanner.nextLine();
			currentCodeLine = currentCodeLine.trim();

			// Is it a codeline
			if (currentCodeLine.length() > 0) {
				totalSum += 1;
				// just a regular code line
				if (!currentCodeLine.equals("{") && !currentCodeLine.equals("}"))
					previousLine = currentCodeLine;

				// if { is present
				else if (currentCodeLine.equals("{"))
					myStack.push(previousLine);

				// if } is present
				else
					list.add(0, (String) myStack.pop());
			}
		}
		
		
		myView.row[2] = totalSum;
		myView.model.addRow(myView.row);
		// return the arraylist
		return list;

	}

	// This will count everything FOR NOW
	public static void countKeyWords(Scanner myScanner) {
		String[] keywords = { "public static", "public", "while", "for", "do", "finally", "try", "catch", "private",
				"Integer", "Double", "int", "double", "long", "short" };

		Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));

		Map<String, Integer> keywordTreeMap = new TreeMap<>();

		while (myScanner.hasNext()) {
			String word = myScanner.next();
			if (keywordSet.contains(word)) {
				if (!keywordTreeMap.containsKey(word)) {
					keywordTreeMap.put(word, 1);
				} else {
					int value = keywordTreeMap.get(word);
					value += 1;
					keywordTreeMap.put(word, value);
				}
			}
		}
		keywordTreeMap.forEach((key, value) -> System.out.println(key + "\t" + value));
	}

}
