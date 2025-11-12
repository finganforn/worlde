package wordle;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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

import java.io.IOException;

public class MainFunc {
		
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
		limitSec = 25;
		
		JFrame frame = new JFrame("WordleCheater");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);

		JPanel topPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JLabel ord = new JLabel("Ord");
		JTextField ordBox = new JTextField("         ");
		
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
		
        JButton send = new JButton("Generera ord");
        JButton reset = new JButton("Återställ alfabet");
        JButton shortReset = new JButton("litet alfabet");

        JButton ordiligKnapp = new JButton("lig5");
        JButton ordiligKnapp6 = new JButton("lig6");
		
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
        
        midPanel.add(ordiligKnapp);
        midPanel.add(ordiligKnapp6);
        
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
		
/*		
				List<List<String>> allEWords = null;
		List<List<String>> allSWords = null;
		
		////DEBUG BIG WORD COLLECTOR
		try {
			allEWords = wc.groupWordsByLength("english-words.txt");
			allSWords = wc.groupWordsByLength("svenska-ord.txt");
			for (int i = 0; i < allEWords.size(); i++) {
				System.out.println("english words " + i);
				List<String> thisList = allEWords.get(i);
				if (thisList != null && thisList.size() > 3) {
					for (int j = 0; j < 5; j++) {
						System.out.println(thisList.get(j));
					}
				}
			}
			for (int i = 0; i < allSWords.size(); i++) {
				System.out.println("swedish words " + i);
				List<String> thisList = allSWords.get(i);
				if (thisList != null && thisList.size() > 3) {
					for (int j = 0; j < 5; j++) {
						System.out.println(thisList.get(j));
					}
				}
			}
		}
		catch (IOException ex) {
			
		}*/
			
		
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
				
				boolean english = englishBox.isSelected();
				
				ArrayList<String> customWordList = new ArrayList<String>();
				if (word.length() < 5 || word.length() > 6)
					customWordList = wc.getWordsOfLengthX(english, word.length());
				
				
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
				
				ArrayList<String> ordelRes = new ArrayList<String>();
				ArrayList<String> yellowGens = Wordle.generateQueryWords(word, required, wrongPos, now, (int) (limitSec*0.75));
				if (yellowGens.get(yellowGens.size()-1).equals("")) {
					System.out.println("generator1 timed out");
					yellowGens.remove(yellowGens.size()-1);
				}
				for (String s2 : yellowGens)
					ordelRes.addAll(Wordle.ordel(s2, allowed, required, wrongPos, now, limitSec));
				System.out.println("ordelRes done at " + Wordle.timePassed(now) + "ms");
					
					
				ArrayList<String> allWords = new ArrayList<String>();
				for (int i = 0; i < ordelRes.size(); i++) {
					String curr = ordelRes.get(i);
					if (english) {
						if (word.length() == 6) {
							if (englishWords6.contains(curr) && !allWords.contains(curr)) {
								allWords.add(curr);
							}
						}
						else if (word.length() == 5) {
							if (englishWords.contains(curr) && !allWords.contains(curr)) {
								allWords.add(curr);
							}
						}
						else {
							if (customWordList.contains(curr) && !allWords.contains(curr)) {
								allWords.add(curr);
							}
						}
							
							
							
					}
					else {
						if (word.length() == 6) {
							if (swedishWords6.contains(curr) && !allWords.contains(curr)) {
								allWords.add(curr);
							}
						}
						else if (word.length() == 5) {
							if (swedishWords.contains(curr) && !allWords.contains(curr)) {
								allWords.add(curr);
							}
						}
						else { //varken 5 eller 6
							if (customWordList.contains(curr) && !allWords.contains(curr)) {
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
			

			public void actionPerformed1(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("func2");
			}
        });

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
