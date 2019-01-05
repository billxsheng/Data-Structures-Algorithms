package project.p3;

import java.io.PrintStream;
import java.util.Scanner;

public class QuestionTree {
	private QuestionNode root;
	private int totalGames = 0;
	private int gamesWon = 0;
	Scanner gameScanner = new Scanner(System.in);
	
	//initial constructor which sets the root to "Jedi" and initializes the tree
	public QuestionTree(Scanner input, PrintStream output) {
		if(input == null || output == null) {
			throw new IllegalArgumentException("Null value passed into constructor.");
		}
		root = new QuestionNode("Jedi");
	}
	
	//play method which runs the recursive playerHelper() method (utilizing public/private pairs)
	public void play() {
		root = playHelper(root);
	}
	
	//save method which runs the recursive saveHelper() method (utilizing public/private pairs)
	public void save(PrintStream output) {
		if(output == null) {
			throw new IllegalArgumentException("Null value passed into method.");
		}
		saveHelper(root, output);
	}
	
	//load method which runs the recursive loadHelper() method (utilizing public/private pairs)
	public void load(Scanner input) {
		if(input == null) {
			throw new IllegalArgumentException("Null value passed into method.");
		}
		root = loadHelper(input);
	}

	//accessor method which returns the number of total games
	public int totalGames() {
		return totalGames;
	}
	
	//accessor method which returns the number of games won by the computer 
	public int gamesWon() {
		return gamesWon;
	}
	
	//Play Helper Method which takes in a QuestionNode and plays a full game of 20 Questions every time the method runs 
	//This method also uses the scanner instance declared above
	private QuestionNode playHelper(QuestionNode node) {
		//if/else block which determines whether the node parameter is an answer node or a question node 
		if(node.left == null && node.right == null) {
			//game suggests an answer 
			System.out.println("Would your object happen to be " + node.data + "?");
			String input = gameScanner.nextLine();
			if(input.startsWith("y") || input.startsWith("Y")) {
				System.out.println("I win!");
				//increments number of total games as well as the number of games the you won
				totalGames++;
				gamesWon++;
			} else if(input.startsWith("n") || input.startsWith("N")) {
				//increments number of total games 
				totalGames++;
				System.out.println("I lose. What is your object?");
				String newItem = gameScanner.nextLine();
				System.out.println("Type a yes/no question to distinguish your item from a " + node.data + ".");
				String newQuestion = gameScanner.nextLine();		
				System.out.println("What is the answer for your object?");
				String input2 = gameScanner.nextLine();
				//if the guess is wrong, this code manipulates the leaf node based on if the question given has a "yes" answer or a "no" answer
				if(input2.startsWith("y") || input2.startsWith("Y")) {
					node.left = new QuestionNode(newItem);
					node.right = new QuestionNode(node.data);
					node.data = newQuestion;
				} else if(input2.startsWith("n") || input2.startsWith("N")) {
					node.left = new QuestionNode(node.data);
					node.right = new QuestionNode(newItem);
					node.data = newQuestion;
				}
			}
		} else {
			//Based on the answer given by the scanner, this code determines whether to recursively run the method with the respective left or right node
			System.out.println(node.data);
			String input3 = gameScanner.nextLine();
			if(input3.startsWith("y") || input3.startsWith("Y")) {
				playHelper(node.left);
			} else if (input3.startsWith("n") || input3.startsWith("N")) {
				playHelper(node.right);
			}
		}
		return root;
	}
	
	//Save Helper Method that takes in a QuestionNode as well as a PrintStream variable and saves the tree onto a text file by preorder traversal
	private void saveHelper(QuestionNode node, PrintStream output) {
		if(node != null) {
			//General architecture for a preorder traversal recursive method
			if(node.left == null && node.right == null) {
				output.println("A:" + node.data);
			} else {
				output.println("Q:" + node.data);
			}
			saveHelper(node.left, output);
			saveHelper(node.right, output);
		}
	}

	//Load Helper Method that takes in a scanner and recursively replaces the current tree with the tree in the file
	private QuestionNode loadHelper(Scanner value) {
		QuestionNode node = null;
		if(value.hasNextLine()) {
			String line = value.nextLine();
			//if/else block which creates new QuestionNode instances after detecting whether or not the line deals with a question node or an answer node
			//it ultimately determines which QuestionNode constructor is being used
			if(line.startsWith("A:")) {
				node = new QuestionNode(line.substring(2));
			} else {
				node = new QuestionNode(line.substring(2), loadHelper(value), loadHelper(value));
			}
		}
		return node;
	}
}
