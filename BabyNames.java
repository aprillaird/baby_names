// April Laird - Chapter 21

import java.io.IOException;
import java.util.*;

public class BabyNames {
  
	public static void main(String[] args) throws IOException {
		// Create a hash set for boy names and hash set for girl names
		java.util.Set<String> boySet = new java.util.HashSet<>();
		java.util.Set<String> girlSet = new java.util.HashSet<>();
		
		// Create a new scanner and prompt for input
	    Scanner input = new Scanner(System.in);
	    // Use file babynamesranking2001.txt through babynamesranking2010.txt (number is birth year)
	    System.out.println("Enter the file name: ");
	    String fileName = input.next();
    
	try {
		// Create a URL object
		java.net.URL url = new java.net.URL ("http://liveexample.pearsoncmg.com/data/" + fileName);
		// Create a new Scanner object		
		Scanner inputStream = new Scanner(url.openStream());
		// Until the last entry, add first string to boySet, second string to girlSet
		while(inputStream.hasNext()) {
			inputStream.next();
			boySet.add(inputStream.next());
			inputStream.next();
			girlSet.add(inputStream.next());
			inputStream.next();
		}
	}	
	
    // Throw exception if user input forms bad URL	
	catch (java.net.MalformedURLException e) {
      System.out.println("File not found.");
    }
	
	// Use retainAll to compare the hash sets and find common words on both
	boySet.retainAll(girlSet);
	
	// Print out the results
	System.out.println("The unisex names are: ");
	// Print the list of names using forEach method
	boySet.forEach(e -> System.out.println(e));
	
	// Close scanner
	input.close();

  }
}
