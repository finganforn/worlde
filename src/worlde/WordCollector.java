package wordle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.io.FileReader;
import java.io.BufferedReader;



public class WordCollector {
	
	static String swedishFile = "doesnt matter";
	static String englishFile = "doesnt matter";
	
	public WordCollector() {
		
		
		File directory = new File("./");
		String fileP = directory.getAbsolutePath();
		fileP = fileP.substring(0, fileP.length()-1);
		   //System.out.println(fileP);
		swedishFile = fileP + "svenska-ord.txt";
		englishFile = fileP + "english-words.txt";
	}
	
	public static ArrayList<String> swedish5() {
		
		ArrayList<String> swedishWords = new ArrayList<String>();
		
        try {
			Scanner sc = new Scanner(new File(swedishFile));
			while(sc.hasNext()){
				
	            String s = sc.next().toUpperCase();
	            
	            if (s.length() == 5) {
	            	swedishWords.add(s);
	            	//ordligWords5.add(s);
	            	//swedishWords6.add((s+"A"));
	            	//swedishWords6.add((s+"E"));
	            	
	            }
	            if (s.length() == 4) {
	            	if (Wordle.isConsonant(s.charAt(3)))
	            	{
	            		//System.out.println(s + "ends with consonant " + s.charAt(3) + " , add " + s + "A");
	            		swedishWords.add((s+"A"));
	            		swedishWords.add((s+"E"));
	            	}
	            	else {
	            		//System.out.println(s + "ends with vowel " + s.charAt(3) + " , add " + s + "N");
	            		swedishWords.add((s+"N"));
	            	}
	            }
	            if (s.length() == 3 && Wordle.isConsonant(s.charAt(2))) {
	            	swedishWords.add((s+"EN"));
	            	swedishWords.add((s+"ER"));
	            	swedishWords.add((s+"AR"));
	            	swedishWords.add((s+"AN"));
	            	swedishWords.add((s+"ET"));
	            	swedishWords.add((s+"AT"));
	            }
	            
				}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
            //.....
			
		
		
		
		return swedishWords;
	}
	public static ArrayList<String> swedish6() {
		
		ArrayList<String> words = new ArrayList<String>();
		
		
        try {
			Scanner sc = new Scanner(new File(swedishFile));
			while(sc.hasNext()){
				
	            String s = sc.next().toUpperCase();
	            
	            if (s.length() == 6) {
	            	words.add(s);
	            	//ordligWords5.add(s);
	            	//swedishWords6.add((s+"A"));
	            	//swedishWords6.add((s+"E"));
	            	
	            }
	            if (s.length() == 5) {
	            	if (Wordle.isConsonant(s.charAt(4)))
	            	{
	            		//System.out.println(s + "ends with consonant " + s.charAt(3) + " , add " + s + "A");
	            		words.add((s+"A"));
	            		words.add((s+"E"));
	            	}
	            	else {
	            		//System.out.println(s + "ends with vowel " + s.charAt(3) + " , add " + s + "N");
	            		words.add((s+"N"));
	            	}
	            }
	            if (s.length() == 4 && Wordle.isConsonant(s.charAt(3))) {
	            	words.add((s+"EN"));
	            	words.add((s+"ER"));
	            	words.add((s+"AR"));
	            	words.add((s+"AN"));
	            	words.add((s+"ET"));
	            	words.add((s+"AT"));
	            }
	            
				}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return words;
	}
	
	public static ArrayList<String> english5() {
		
		ArrayList<String> words = new ArrayList<String>();
		
		try {
		Scanner sc = new Scanner(new File(englishFile));
			while(sc.hasNext()){
				
	            String s = sc.next();
	            if (s.length() == 5)
	            	words.add(s.toUpperCase());
	            if (s.length() == 4) {
	            	words.add((s+"s").toUpperCase());
	            }
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return words;
	}
	public static ArrayList<String> english6() {
		
		ArrayList<String> words = new ArrayList<String>();
		try {
		Scanner sc = new Scanner(new File(englishFile));
			while(sc.hasNext()){
				
	            String s = sc.next();
	            if (s.length() == 6)
	            	words.add(s.toUpperCase());
	            if (s.length() == 5) {
	            	words.add((s+"s").toUpperCase());
	            }
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return words;
	}
	
	public static List<List<String>> groupWordsByLength(String filePath) throws IOException {
        // Map to hold lists of words keyed by their length
        Map<Integer, List<String>> lengthMap = new HashMap<>();

        // Read the file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split line into words using whitespace
                String[] words = line.trim().split("\\s+");
                for (String word : words) {
                    int length = word.length();
                    lengthMap.computeIfAbsent(length, k -> new ArrayList<>()).add(word.toUpperCase());
                }
            }
        }

        // Convert map values to a list of lists
        List<List<String>> groupedWords = new ArrayList<>(lengthMap.values());

        // Optional: sort by word length
        groupedWords.sort(Comparator.comparingInt(list -> list.get(0).length()));

        return groupedWords;
    }
	public static ArrayList<String> getWordsOfLengthX(boolean english, int length) {
		ArrayList<String> words = new ArrayList<String>();
		try {
			Scanner sc;
			if (english) sc= new Scanner(new File(englishFile));
			else sc= new Scanner(new File(swedishFile));
			while(sc.hasNext()){
				
	            String s = sc.next();
	            if (s.length() == length)
	            	words.add(s.toUpperCase());
	            if (s.length() == length-1) {
						if (english) {
							words.add((s+"s").toUpperCase());
						
					}
				}
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return words;
	}
	
	
	
	
	
}