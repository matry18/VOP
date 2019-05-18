package Lektion_03_Text_Analyser;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextAnalyzer {

	private File file;

	public TextAnalyzer(String fileName) {
		file = new File(fileName);
	}

	// Opgave 2A     
	// Parameteren sorted afgør om der skal benyttes et sorteret Set
	//
	public Set<String> findUniqueWords(boolean sorted) {
		Set<String> set = null;
		if (sorted) {
                    set = new TreeSet<>();
                    //System.out.println("Sorted tree set "+set);
			//set =  //initialiser et sorteret Set
		} else {
                    set = new HashSet<>();
                    //System.out.println("Unsorted Hash set "+set);
			//set = // initialiser et usorteret Set
		}
            try {
                Scanner scanner = new Scanner(file);
                // gennemlæs filen et ord ad gangen
                while (scanner.hasNext()) {
                    set.add(clean(scanner.next()));
                }
            } catch (FileNotFoundException ex) {
                System.out.println("No tile found. Sorry try again.");
            }
                
		// kald clean() metoden på hvert ord
		// og tilføj ordet til settet.

		return set;
	}

	// Opgave 2B:   Nearly as Listing 21.9 from Liang
	//
	public Map<String, Integer> countWords(boolean sorted) {
		Map<String, Integer> map = null;
		if (sorted) {
                    map = new TreeMap<>();
                    //System.out.println("Sorted TreeMap" +map);
			//map = // sorteret mappe
		} else {
                    map = new HashMap<>();
                    //System.out.println("Unsorted HashMap"+map);
			//map = // usorteret mappe
		} 
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    String word = clean(scanner.next());
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word)+ 1);
                    } else {
                        map.put(word, 1);
                    }
                    
                }
                // gennemlæs filen et ord ad gangen
                // kald clean() metoden på hvert ord
                // benyt mappen til at tælle forekomsten af hvert ord
            } catch (FileNotFoundException ex) {
                System.out.println("No file found, sorry! Better luck next time.");
            }

		return map;
	}

	// Opgave 2C:     Udvidelse af P15.1
	//
	public Map<Integer, Set<String>> lengtOfWords(boolean sorted) {
		Map<Integer, Set<String>> mapOfSets = null;
		if (sorted) {
			//mapOfSets = // sorteret
                    mapOfSets = new TreeMap<>();
                    //System.out.println("Sorted TreeMap"+mapOfSets);
		} else {
                    mapOfSets = new HashMap<>();
                    //System.out.println("Unsorted HashMap"+mapOfSets);
			//mapOfSets = // usorteret
		}
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                String word = clean(scanner.next());
                if (!mapOfSets.containsKey(word.length())) {
                    mapOfSets.put(word.length(), new TreeSet<>());
                } else {
                mapOfSets.get(word.length()).add(word);
                }
                
                }
                // gennemlæs filen et ord ad gangen
                // kald clean() metoden på hvert ord
                // Indsæt hvert ord i det Set<String> som er værdi til ordlængden som key
                // Hint: nyt Set<String> skal oprettes hver gang en længde opdages første gang.
            } catch (FileNotFoundException ex) {
                System.out.println("File not found!");
            }


		return mapOfSets;

	}

	// Denne metode forsøger at fjerne alt 'snavs' fra en String,
	// så kun bogstaver bevares og store gøres til små
	private String clean(String s) {
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				r = r + c;
			}
		}
		return r.toLowerCase();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TextAnalyzer ta = new TextAnalyzer("alice30.txt");

		// Opgave 2A. Find alle unikke ord i filen
		Set<String> set = ta.findUniqueWords(true);
		System.out.println(set);
		System.out.println("Number of unique words: " + set.size());

		System.out.println("\n------------------------------------------------------------------\n");

		// Opgave 2B. Tæl forekomster af ord
		Map<String, Integer> map = ta.countWords(true);
		System.out.println(map);

		System.out.println("\n------------------------------------------------------------------\n");

		// Opgave 2C. Benyt en mappe til at gruppere ord efter længde
		Map<Integer, Set<String>> map2 = ta.lengtOfWords(true);
		System.out.println(map2);

	}

}
