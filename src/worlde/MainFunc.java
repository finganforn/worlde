package worlde;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFunc {
	
	static String swedishAlphabet = "QWERTYUIOPÅASDFGHJKLÖÄZXCVBNM";
	static String englishAlphabet = "QWERTYUIOPASDFGHJKLZXCVBNM";
	static String swedishShortcut = "QWRUSDFHJÄZXCB";
	static String englishShortcut = "QGJZXVB chuf";
	static String ordlig = "QWTYGHJZV fläck";
	static String ordlig6 = "QWYÅDHÖZXVB ";
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
		for (int i = 0; i < 20; i++) {
			int r = random.nextInt(50) + 1;
			//System.out.println("r: "+ r);
			double r2 = r;
			r2 = r2/10;
			System.out.println(r2 + " inverted : " + invert(r2));
		}
		
		
		*/
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
		JTextField ordBox = new JTextField("ENIGA");
        JLabel letters = new JLabel("Bokstäver");
        JTextField letterBox = new JTextField("QWERTYUIOPÅASDFGHJKLÖÄZXCVBNM");
        JLabel position = new JLabel("WrongPlace");
        JTextField positionBox = new JTextField("DELETE");
        JLabel wildCardLabel = new JLabel("somewhere");
        JTextField wildCardBox = new JTextField("DELETE");
        
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
	            	swedishWords.add((s+"A"));
	            	swedishWords.add((s+"E"));
	            	
	            	/*swedishWords6.add((s+"EN"));
	            	swedishWords6.add((s+"ER"));
	            	swedishWords6.add((s+"AR"));
	            	swedishWords6.add((s+"AN"));
	            	swedishWords6.add((s+"ET"));
	            	swedishWords6.add((s+"AT"));
	            	swedishWords6.add((s+"OR"));*/
	            }
	            if (s.length() == 3) {
	            	swedishWords.add((s+"EN"));
	            	swedishWords.add((s+"ER"));
	            	swedishWords.add((s+"AR"));
	            	swedishWords.add((s+"AN"));
	            	swedishWords.add((s+"ET"));
	            	swedishWords.add((s+"AT"));
	            	swedishWords.add((s+"OR"));
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
        topPanel.add(wildCardLabel);
        topPanel.add(wildCardBox);
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
				String wildcards = wildCardBox.getText().toUpperCase();
				String positions = positionBox.getText().toUpperCase();
				ArrayList<Character> allowed = new ArrayList<Character>();
				ArrayList<Character> required = new ArrayList<Character>();
				ArrayList<Integer> wrongPos = new ArrayList<Integer>();
				ArrayList<Character> wildCards = new ArrayList<Character>();
				//System.out.println(word + " " + letters + " " + positions);
				for (int i = 0; i < letters.length(); i++)   {
					char c = letters.charAt(i);
					if (Character.isLetter(c))
						allowed.add(letters.charAt(i));
				}
				for (int i = 0; i < wildcards.length(); i++) {
					char c = wildcards.charAt(i);
					if (Character.isLetter(c))
						wildCards.add(wildcards.charAt(i));
						
				}
				String[] posSplit = positions.split(" ");

				if (posSplit[0].length() > 1) {
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
				int solutions = solutionsCount(word, allowed, required, wildCards);
				System.out.println(solutions + " possible words");
				if (solutions > 300000)
					JOptionPane.showMessageDialog(null, "too many solutions ("+ solutions + ")");	
				
				else {
					ArrayList<String> ordelRes = Wordle.ordel(word, allowed, required, wrongPos, wildCards);
					
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


	ArrayList<Character> allowed = new ArrayList<Character>();
	allowed.add('Q'); 
	allowed.add('W');
	//allowed.add('E'); 
	//allowed.add('R');
	//allowed.add('T');
	allowed.add('Y');
	allowed.add('U');
	//allowed.add('I');
	//allowed.add('O');
	allowed.add('P');
	//allowed.add('Å');
	//allowed.add('A');
	//allowed.add('S');
	//allowed.add('D');
	//allowed.add('F');
	//allowed.add('G');
	//allowed.add('H');
	allowed.add('J');
	//allowed.add('K');
	//allowed.add('L');
	//allowed.add('Ö');
	//allowed.add('Ä');
	allowed.add('Z');
	allowed.add('X');
	allowed.add('C');
	allowed.add('V');
	//allowed.add('B');
	//allowed.add('N');
	allowed.add('M');
	ArrayList<Character> required = new ArrayList<Character>();
	ArrayList<Integer> requiredNonIndices = new ArrayList<Integer>();
	



	required.add('U');
	requiredNonIndices.add(2);

	required.add('U');
	requiredNonIndices.add(3);

	required.add('N');
	requiredNonIndices.add(4);


	


	String availableLetters = "";
	String currentWord = "";
	ArrayList<String> wrongPlacements = new ArrayList<String>();
		
	
	//ArrayList<String> ordel = Wordle.ordel("   CH", allowed, required, (ArrayList<Integer>) requiredNonIndices);
	
	//for (int i = 0; i < ordel.size(); i++)
		//System.out.println(ordel.get(i));
	}
	
	private static int solutionsCount(String word, ArrayList<Character> allowedChars, ArrayList<Character> requiredChars, ArrayList<Character> wildcards) {
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
		for (Character c : wildcards) {
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
