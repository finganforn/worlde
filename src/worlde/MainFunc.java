package worlde;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFunc {
	
	//USDFHJ v1 n2 t5 e1 teven
	
	static String swedishAlphabet = "QWERTYUIOPÅASDFGHJKLÖÄZXCVBNM";
	static String englishAlphabet = "QWERTYUIOPASDFGHJKLZXCVBNM";
	static String swedishShortcut = "QWRUSDFHJÄZXCB";
	static String englishShortcut = "QWYFGHJKZXV build";
	static String ordlig = "QWYFHJKÖÄZXCVM påbud";
	static String ordlig6 = "QWYÅDHÖZXVB";
	static String swedishFile = "doesnt matter";
	static String englishFile = "doesnt matter";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		Random random = new Random();
		int startP = random.nextInt(10000);
		//startP = 1950;
		for (int i = startP; i < startP+100; i++) {
			Stack<Integer> st = fac(i);
			String s2 = "" + i + " = " + st.get(0);
			for (int j = 1; j < st.size(); j++) {
				s2 = s2 + " * " + st.get(j);
			}
			
		}
		*/
		
		
		//ArrayList<Integer> nums = new ArrayList<Integer>();
		//nums.add(15); nums.add(6); nums.add(7); nums.add(4); nums.add(2);
		//operationsGame(nums, 59);
		
		
		
		File directory = new File("./");
		String fileP = directory.getAbsolutePath();
		fileP = fileP.substring(0, fileP.length()-1);
		   //System.out.println(fileP);
		swedishFile = fileP + "svenska-ord.txt";
		englishFile = fileP + "english-words.txt";
		
		JFrame frame = new JFrame("WordleCheater");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);

		JPanel topPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JLabel ord = new JLabel("Ord");
		JTextField ordBox = new JTextField("         ");
		
		//ordBox.setText("");
		
        JLabel letters = new JLabel("Bokstäver");
        JTextField letterBox = new JTextField("QWERTYUIOPÅASDFGHJKLÖÄZXCVBNM");
        JLabel position = new JLabel("WrongPlace");
        JTextField positionBox = new JTextField("            ");
        
        JCheckBox englishBox = new JCheckBox("engelska");
        
        ArrayList<String> swedishWords = new ArrayList<String>();
        ArrayList<String> swedishWords6 = new ArrayList<String>();
        ArrayList<String> englishWords = new ArrayList<String>();
        ArrayList<String> ordligWords5 = new ArrayList<String>();
        Scanner sc;
        try {
			sc = new Scanner(new File(swedishFile));
			while(sc.hasNext()){
				
	            String s = sc.next().toUpperCase();
	         
	            s = s.replace("Ã¥", "Å");
	            s= s.replace("Ã¤", "Ä");
	            s = s.replace("Ã¶", "Ö");
	            if (s.length() == 6)
	            	swedishWords6.add(s);
	            if (s.length() == 5) {
	            	swedishWords.add(s);
	            	ordligWords5.add(s);
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
	            	
	            	/*swedishWords6.add((s+"EN"));
	            	swedishWords6.add((s+"ER"));
	            	swedishWords6.add((s+"AR"));
	            	swedishWords6.add((s+"AN"));
	            	swedishWords6.add((s+"ET"));
	            	swedishWords6.add((s+"AT"));
	            	swedishWords6.add((s+"OR"));*/
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
			sc = new Scanner(new File(englishFile));
			while(sc.hasNext()){
				
	            String s = sc.next();
	            if (s.length() == 5)
	            	englishWords.add(s.toUpperCase());
	            if (s.length() == 4) {
	            	englishWords.add((s+"s").toUpperCase());
	            }
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
            //.....
        



        JButton send = new JButton("Generera ord");
        JButton reset = new JButton("Återställ alfabet");
        JButton shortReset = new JButton("litet alfabet");
        //JButton semantle = new JButton("sem");
        JButton ordiligKnapp = new JButton("lig5");
        JButton ordiligKnapp6 = new JButton("lig6");

        //JButton reset = new JButton("Reset");
        topPanel.add(ord);
        topPanel.add(ordBox);
        topPanel.add(position);
        topPanel.add(positionBox);
        midPanel.add(letters);
        midPanel.add(letterBox);
        midPanel.add(englishBox);
        midPanel.add(reset);
        midPanel.add(shortReset);
        //midPanel.add(semantle);
        midPanel.add(ordiligKnapp);
        midPanel.add(ordiligKnapp6);
        //midPanel.add(publishAdvice);
        //midPanel.add(everythingBox);
        JPanel sendPanel = new JPanel();
        
        sendPanel.add(send);
        
        JPanel progressInfoPanel = new JPanel();


        bottomPanel.add(BorderLayout.NORTH, sendPanel);
        bottomPanel.add(BorderLayout.SOUTH, progressInfoPanel);

        // Text Area at the Center

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, topPanel);
        frame.getContentPane().add(BorderLayout.CENTER, midPanel);        
        frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
        frame.setVisible(true);
        

        reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				boolean english = englishBox.isSelected();
				letterBox.setText(english ? englishAlphabet : swedishAlphabet);
			}
        	
        });
        
        
        
        shortReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				boolean english = englishBox.isSelected();
				letterBox.setText(english ? englishShortcut : swedishShortcut);
			}
        	
        });
        ordiligKnapp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				letterBox.setText(ordlig);
			}
        	
        });
        ordiligKnapp6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				letterBox.setText(ordlig6);
			}
        	
        });
        
        send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				String word = ordBox.getText().toUpperCase();
				
				String letters = letterBox.getText().toUpperCase();
				String positions = positionBox.getText().toUpperCase();
				ArrayList<Character> allowed = new ArrayList<Character>();
				ArrayList<Character> required = new ArrayList<Character>();
				ArrayList<Integer> wrongPos = new ArrayList<Integer>();
				//System.out.println(word + " " + letters + " " + positions);
				for (int i = 0; i < letters.length(); i++)   {
					char c = letters.charAt(i);
					if (Character.isLetter(c))
						allowed.add(letters.charAt(i));
				}

				
				String[] posSplit = positions.split(" ");

				if (posSplit.length > 0 && posSplit[0].length() > 1) {
				for (int i = 0; i < posSplit.length; i++) {				
						
						String num = posSplit[i].substring(1);
						try {
						int iNum = Integer.parseInt(num);
						char let = posSplit[i].charAt(0);
						if (iNum > 0) {
							required.add(let);
							//wrongPos.add(iNum); ENKLARE INDEX
							wrongPos.add(iNum-1);
						}
						}
						catch (NumberFormatException ex) {
							System.out.println("ignoring " + posSplit[i]);
						}
					}
				}
				
				//avbryt om för många alternativ
				int solutions = solutionsCount(word, allowed, required);
				System.out.println(solutions + " possible words");
				int superWayTooMany = 300000000;
				int wayTooMany = 30000000;
				int somewhatTooMany = 3000000;
				int fewTooMany = 300000;
				//update numbers when solution uses new wordList version!
				if (solutions > superWayTooMany)
					JOptionPane.showMessageDialog(null, "too many solutions ("+ solutions + ")");	
				else if (solutions > wayTooMany && required.size() < 1)
					JOptionPane.showMessageDialog(null, "too many solutions ("+ solutions + ")");
				else if (solutions > somewhatTooMany && required.size() < 2)
					JOptionPane.showMessageDialog(null, "too many solutions ("+ solutions + ")");	
				else if (solutions > fewTooMany && required.size() < 3)
					JOptionPane.showMessageDialog(null, "too many solutions ("+ solutions + ")");	
				
				else {
					
					//FLAWED FUNCTION
					//ArrayList<String> yellowGens = Wordle.generateQueryWords(word, required, wrongPos);					
					//
					
					ArrayList<String> ordelRes = new ArrayList<String>();
					//if (solutions > somewhatTooMany) {
					if (solutions > 5) { //wgatever
						
						//JOptionPane.showMessageDialog(null, "experimental func!");	
						
						
						//pick one of the wrongpos
						/*char wc = required.get(0);
						int wp = wrongPos.get(0);
						
						ArrayList<String> altWords = new ArrayList<String>();
						for (int i = 0; i < word.length(); i++) {
							char[] ca = word.toCharArray();
							if (i != wp && ca[i] == ' ') {
								ca[i] = wc;
								String tWord = new String(ca);
								ArrayList<String> ordelRes2 = Wordle.ordel(tWord, allowed, required, wrongPos);
							ordelRes.addAll(ordelRes2); }
							
						}*/
						ArrayList<String> yellowGens = Wordle.generateQueryWords(word, required, wrongPos);	
						for (String s2 : yellowGens)
							ordelRes.addAll(Wordle.ordel(s2, allowed, required, wrongPos));
					}
					else 
						ordelRes = Wordle.ordel(word, allowed, required, wrongPos);
					
					String allWords = "";
					for (int i = 0; i < ordelRes.size(); i++) {
						
						if (englishBox.isSelected()) {
							if (englishWords.contains(ordelRes.get(i))) {
								System.out.println(ordelRes.get(i));
								allWords += ordelRes.get(i) + " ";
							}
							
						}
						else {
							if (word.length() == 6) {
								if (swedishWords6.contains(ordelRes.get(i))) {
									System.out.println(ordelRes.get(i));
									allWords += ordelRes.get(i) + " ";
								}
							}
							else {
							
								if (swedishWords.contains(ordelRes.get(i))) {
									System.out.println(ordelRes.get(i));
									allWords += ordelRes.get(i) + " ";
								}
							}
						}
						
					
					}
					JOptionPane.showMessageDialog(null, allWords);	
				}
				
			}
			

			public void actionPerformed1(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("func2");
			}
        });



	


	}
	
	private static int solutionsCount(String word, ArrayList<Character> allowedChars, ArrayList<Character> requiredChars) {
		int empty = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == ' ')
				empty++;
		}
		ArrayList<Character> allLetters = new ArrayList<Character>();
		
		
		for (Character c : allowedChars) {
			if (!allLetters.contains(c))
				allLetters.add(c);
		}
		for (Character c : requiredChars) {
			if (!allLetters.contains(c))
				allLetters.add(c);
		}
		
		
		
		int solutions = (int) Math.pow(allowedChars.size(), empty);
		return solutions;
	}
	
	private static boolean prim(int tal) {
		if (tal < 2)
			return false;
		for (int i = 2; i < (tal/2)+1; i++) {
			if (tal % i == 0)
				return false;
		}
		return true;
	}
	
	private static double invert(double x) {
		return 1/x;
	}
	
	
	private static Stack<Integer> fac(int tal) {
		Stack<Integer> res = new Stack<Integer>();
		
		res.add(tal);
		boolean done = false;
		
		while (!done) {
			System.out.print(facStackToString(res));
			if (res.size() > 0)
				System.out.print(" = ");
			int last = res.pop();
			if (last < 2) {
				res.add(last);
				System.out.println();
				return res;
			}
			if (prim(last)) {
				res.add(last);
				System.out.println();
				return res;
			}
			int low = lowestDiv(last);
			res.add(low);
			res.add(last / low);
		}
		
		System.out.println();
		return res;
		
	}
	private static String facStackToString(Stack<Integer> st) {
		String res = "";
		Stack<Integer> newStack = new Stack<Integer>();
		while (!st.empty())
			newStack.add(st.pop());
		while (!newStack.empty()) {
			int re = newStack.pop();
			st.add(re);
			res += re + " * ";
		}
			
		if (res.contains(" "))
			res = res.substring(0, res.length()-2);
		return res;
	}
	private static int lowestDiv(int tal) {
		int res = -1;
		if (prim(tal))
			return 1;
		for (int i = 2; i < (tal/2)+1; i++) {
			if (tal % i == 0)
				return i;
		}
		return -1;
	}
	

}
