package worlde;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wordle {
	


public static ArrayList<String> ordel(String word, ArrayList<Character> allowed, ArrayList<Character> required, ArrayList<Integer> indices) {
		
		for (int i = 0; i < required.size(); i++) {
			if (!allowed.contains(required.get(i)))
				allowed.add(required.get(i));
		}
		
		for(int i = 0; i<word.length(); i++) {

		      // access each character
		      char a = word.charAt(i);
		      if (!allowed.contains(a) && Character.isLetter(a))
		    	  allowed.add(a);
		    }
		
		ArrayList<String> res = new ArrayList<String>();
		
		
		
		
		
		ArrayList<String> allStrings0 = ordel2(word, allowed);
		ArrayList<String> allStrings = new ArrayList<String>();
		
			allStrings = allStrings0;
		
		
		int generated = 0;
		for (int i = 0; i < allStrings.size(); i++) {
			generated++;
			String s = allStrings.get(i);
			
			
			
			if (required.size() < 1) {
				if (!res.contains(s))
					res.add(s);
				}
			else 
			{
				boolean containsKeyLetters = true;
				for (int j = 0; j < required.size(); j++) {
					int ind = s.indexOf(required.get(j));
					if (ind == -1)
						containsKeyLetters = false;
				}
				
				
				try {
				//MainFunc.rawPrint("compare " + s.charAt(indices.get(0)) + required.get(0));
					
					if (s.charAt(indices.get(0)) == required.get(0)) 
						containsKeyLetters = false;
					
					
					if (required.size() > 1) {
						//MainFunc.rawPrint("compare " + s.charAt(indices.get(1)) + required.get(1));
						if (s.charAt(indices.get(1)) == required.get(1))
							containsKeyLetters = false;
					}
					
					if (required.size() > 2) {
						//MainFunc.rawPrint("compare " + s.charAt(indices.get(2)) + required.get(2));
						if (s.charAt(indices.get(2)) == required.get(2))
							containsKeyLetters = false;
					}
					
					if (required.size() > 3) {
						if (s.charAt(indices.get(3)) == required.get(3))
							containsKeyLetters = false;
					}
					if (required.size() > 4) {
						if (s.charAt(indices.get(4)) == required.get(4))
							containsKeyLetters = false;
					}
					if (required.size() > 5) {
						if (s.charAt(indices.get(5)) == required.get(5))
							containsKeyLetters = false;
					}
					if (required.size() > 6) {
						if (s.charAt(indices.get(6)) == required.get(6))
							containsKeyLetters = false;
					}
					if (required.size() > 7) {
						if (s.charAt(indices.get(7)) == required.get(7))
							containsKeyLetters = false;
					}
				}
				catch (StringIndexOutOfBoundsException ex)  {
					System.out.println("failed experiment");
				}
				
				if (containsKeyLetters) {
					if (!res.contains(s))
						res.add(s);
				}
			}
			
			
					
			
		}
		
		
		
		System.out.println("current word: " + word);
		System.out.println("allowed : " + allowed);
		System.out.println("required : " + required);
		System.out.println("generated " + generated + ", " + res.size() + " viable ones");		
		
		
		
		
		return res;
	
	}
public static ArrayList<String> ordel2(String word, ArrayList<Character> allowed) {
	ArrayList<String> res = new ArrayList<String>();
	ArrayList<String> res2  = new ArrayList<String>();
	
	int empty = 0;
	for (int i = 0; i < word.length(); i++) {
		if (word.charAt(i) == ' ')
			empty++;
	}
	
	
	
	int letters = allowed.size();
	
	//int ind = s.indexOf(" ");
	//&& res.get(i).indexOf(" ") != -1
	
	for (int i = 0; i < allowed.size(); i++) {
		String s = word.replaceFirst(" ", allowed.get(i).toString());
		res.add(s);
	}
	if (noSpace(res))
		return res;
	for (int i = 0; i < res.size(); i++) {
		for (int j = 0; j < letters; j++) {
			String s = res.get(i).replaceFirst(" ", allowed.get(j).toString());
			res2.add(s);
		}
	}
	if (noSpace(res2))
		return res2;
	res.clear();
	for (int i = 0; i < res2.size(); i++) {
		for (int j = 0; j < letters; j++) {
			String s = res2.get(i).replaceFirst(" ", allowed.get(j).toString());
			res.add(s);
		}
	}
	if (noSpace(res))
		return res;
	res2.clear();
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < letters; j++) {
				String s = res.get(i).replaceFirst(" ", allowed.get(j).toString());
				res2.add(s);
		}
	}
	if (noSpace(res2))
		return res2;
	res.clear();
	for (int i = 0; i < res2.size() && res2.get(i).indexOf(" ") != -1; i++) {
		for (int j = 0; j < letters; j++) {
			String s = res2.get(i).replaceFirst(" ", allowed.get(j).toString());
			res.add(s);
		}
	}
	
	return res;
	}
	private static boolean noSpace(ArrayList<String> l) {
		return l.get(0).indexOf(" ") == -1;
	}
	
	
	public static double similarity(String s1, String s2) {
	    String longer = s1, shorter = s2;
	    if (s1.length() < s2.length()) { // longer should always have greater length
	      longer = s2; shorter = s1;
	    }
	    int longerLength = longer.length();
	    if (longerLength == 0) { return 1.0; /* both strings are zero length */ }
	    /* // If you have Apache Commons Text, you can use it to calculate the edit distance:
	    LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
	    return (longerLength - levenshteinDistance.apply(longer, shorter)) / (double) longerLength; */
	    return (longerLength - editDistance(longer, shorter)) / (double) longerLength;

	  }
	
	 public static int editDistance(String s1, String s2) {
		    s1 = s1.toLowerCase();
		    s2 = s2.toLowerCase();

		    int[] costs = new int[s2.length() + 1];
		    for (int i = 0; i <= s1.length(); i++) {
		      int lastValue = i;
		      for (int j = 0; j <= s2.length(); j++) {
		        if (i == 0)
		          costs[j] = j;
		        else {
		          if (j > 0) {
		            int newValue = costs[j - 1];
		            if (s1.charAt(i - 1) != s2.charAt(j - 1))
		              newValue = Math.min(Math.min(newValue, lastValue),
		                  costs[j]) + 1;
		            costs[j - 1] = lastValue;
		            lastValue = newValue;
		          }
		        }
		      }
		      if (i > 0)
		        costs[s2.length()] = lastValue;
		    }
		    return costs[s2.length()];
		  }
	 public static boolean isConsonant(char a) {
		 if (a == 'a' ||
				 a == 'A' ||
				 a == 'e' ||
				 a == 'E' ||
				 a == 'i' ||
				 a == 'I' ||
				 a == 'O' ||
				 a == 'o' ||
				 a == 'U' ||
				 a == 'u' ||
				 a == 'Å' ||
				 a == 'å' ||
				 a == 'Ä' ||
				 a == 'ä' ||
				 a == 'Ö' ||
				 a == 'ö' ||
				 a == 'Y' ||
				 a == 'y'
				 
				 )
			 return false;
		 return true;
	 }
	 
	 public static ArrayList<String> generateQueryWords (String word, ArrayList<Character> required, ArrayList<Integer> indices) {
		 
		 //TODO
		 
		 //MULTI YELLOWS
		 //
		 ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		 res.add(new ArrayList<String>());
		 ArrayList<Character> remainingWrongs = new ArrayList<Character>();
		 ArrayList<Integer> remainingWrongPos = new ArrayList<Integer>();
		 remainingWrongs.addAll(required);
		 res.get(0).add(word);
		 remainingWrongPos.addAll(indices);
		 int depth = 0;
		 
			while (remainingWrongs.size() > 0) {
				ArrayList<String> thisGen = new ArrayList<String>();
				res.add(new ArrayList<String>());
				for (String s : res.get(depth)) {
					if (remainingWrongs.size() == 0)
						break;
					char wc = remainingWrongs.get(0);
					int wp = remainingWrongPos.get(0);
					//remainingWrongs.remove(0);
					//remainingWrongPos.remove(0);
					
					
					for (int i = 0; i < s.length(); i++) {
						char[] ca = s.toCharArray();
						if (i != wp && ca[i] == ' ' && s.toUpperCase().indexOf(wc) == -1) {
							ca[i] = wc;
							String tWord = new String(ca);
							thisGen.add(tWord); }
						
					}
					for (String s2 : thisGen) {
						if (!res.get(res.size()-1).contains(s2))
							res.get(res.size()-1).add(s2);
					}
					
				}
				if (res.get(res.size()-1).size() == 0)
					res.get(res.size()-1).addAll(res.get(res.size()-2));
				depth++;
				//
				remainingWrongs.remove(0);
				//
				remainingWrongPos.remove(0);
				
			}
				//pick one of the wrongpos
					
			return res.get(res.size()-1);
	 }
	
}
