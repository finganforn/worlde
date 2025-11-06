package wordle;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
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
	
	//QWYFK�ZXCVM  e3 r1 e4 r5 hittade ej maerke!
	
	static String swedishAlphabet = "QWERTYUIOPÅASDFGHJKLÖÄZXCVBNM";
	static String englishAlphabet = "QWERTYUIOPASDFGHJKLZXCVBNM";
	static String swedishShortcut = "QWRUSDFHJÖÄZXCB";
	static String englishShortcut = "QWYFGHJKZXV build";
	static String ordlig = "QWYFHJKÖÄZXCVM påbud";
	static String ordlig6 = "QWYÅDHÖZXVB";
	static String swedishFile = "doesnt matter";
	static String englishFile = "doesnt matter";
	static int limitSec;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean wackyLocalization = false;

		
		//ArrayList<Integer> nums = new ArrayList<Integer>();
		//nums.add(15); nums.add(6); nums.add(7); nums.add(4); nums.add(2);
		//operationsGame(nums, 59);
		
		limitSec = 4;
		
		
		
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
        JLabel secondsLimitText = new JLabel("Sekunder tilllåtna");
        JTextField secondsLimitBox = new JTextField("    ");
        
        JCheckBox englishBox = new JCheckBox("engelska");
        
		WordCollector wc = new WordCollector();
        ArrayList<String> swedishWords = wc.swedish5();
        ArrayList<String> swedishWords6 = wc.swedish6();
        ArrayList<String> englishWords = wc.english5();
		ArrayList<String> englishWords6 = wc.english6();
		
		System.out.println("swedish 5words: " + swedishWords.size());
		System.out.println("swedish 6words: " + swedishWords6.size());
		System.out.println("english 5words: " + englishWords.size());
		System.out.println("english 6words: " + englishWords6.size());
		
        
        
        



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
        topPanel.add(secondsLimitText);
        topPanel.add(secondsLimitBox);
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
				System.out.println("----------------------START------------------------");
				System.out.println("---------------------------------------------------");
				boolean ranOutOfTime = false;
				String limitSecStr = secondsLimitBox.getText();
				try {
					limitSec = Integer.parseInt(limitSecStr);
				}
				
				
				catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				LocalTime now = LocalTime.now();
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
						num = num.replaceAll( "[^\\d]", "" );
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
				
				//avbryt om f�r m�nga alternativ
				int solutions = solutionsCount(word, allowed, required);
				System.out.println(solutions + " possible words");
				int superWayTooMany = 2000000000;
				int wayTooMany = 300000000;
				int somewhatTooMany = 30000000;
				int fewTooMany = 3000000;
				
				if (false) {}/* 
				if (solutions > superWayTooMany)
					JOptionPane.showMessageDialog(null, "too many solutions ("+ solutions + ")");	
				else if (solutions > wayTooMany && required.size() < 1)
					JOptionPane.showMessageDialog(null, "too many solutions ("+ solutions + ")");
				else if (solutions > somewhatTooMany && required.size() < 2)
					JOptionPane.showMessageDialog(null, "too many solutions ("+ solutions + ")");	
				else if (solutions > fewTooMany && required.size() < 3)
					JOptionPane.showMessageDialog(null, "too many solutions ("+ solutions + ")");	
				*/
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
						
						
						//TODO TIMER FÖR DENNA FUNKTIONEN
						
						ArrayList<String> yellowGens = Wordle.generateQueryWords(word, required, wrongPos, now, (int) (limitSec*0.75));
						if (yellowGens.get(yellowGens.size()-1).equals("")) {
						
							System.out.println("generator1 timed out");
							yellowGens.remove(yellowGens.size()-1);
							
						}
						for (String s2 : yellowGens)
							ordelRes.addAll(Wordle.ordel(s2, allowed, required, wrongPos, now, limitSec));
						System.out.println("ordelRes done at " + Wordle.timePassed(now) + "ms");
					}	
					else 
						ordelRes = Wordle.ordel(word, allowed, required, wrongPos, now, limitSec);
					
					ArrayList<String> allWords = new ArrayList<String>();
					for (int i = 0; i < ordelRes.size(); i++) {
						
										
						String curr = ordelRes.get(i);
						if (englishBox.isSelected()) {
							if (englishWords.contains(curr) && !allWords.contains(curr)) {
								//System.out.println(ordelRes.get(i));
									allWords.add(curr);
							}
							
						}
						else {
							if (word.length() == 6) {
								if (swedishWords6.contains(curr) && !allWords.contains(curr)) {
									//System.out.println(ordelRes.get(i));
									allWords.add(curr);
								}
							}
							else {
							
								if (swedishWords.contains(curr) && !allWords.contains(curr)) {
									//System.out.println(ordelRes.get(i));
									allWords.add(curr);
								}
							}
						}
						
						
						
					
					}
					int timeMs = Wordle.timePassed(now);
					String resStr = "";
					for (int i = 0; i < allWords.size(); i++) {
							resStr += allWords.get(i) + " ";
							if (i % 15 == 0 && i != 0)
								resStr += "\n";
							
					}
					
					String message = "" + timeMs + "ms " + (timeMs/1000 > limitSec ? "TOO LONG! " : "");
					System.out.println("full func took " + Wordle.timePassed(now) + "ms");
					JOptionPane.showMessageDialog(null, message+"\n"+ resStr);	
					
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
