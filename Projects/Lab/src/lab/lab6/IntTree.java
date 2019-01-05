package lab.lab6;

import java.util.Scanner;

import project.p3.QuestionNode;

public class IntTree {
    private IntTreeNode root;
    Scanner scanner = new Scanner("file");
    	public String toString() {
    		return toStringHelper(root);
    	}
    	
    	private String toStringHelper(IntTreeNode node) {
		if(node == null) {
			return "empty";
		} 
		else if(node.left == null && node.right == null) {
			return "" + node.data;
		} else {
			return "("+node.data+","+ toStringHelper(node.left) + ","+ toStringHelper(node.right)+")";
		}
    	}
    	
    	public void writeTree() {
    		writeTreeHelper(root);
    	}
    	
    	private void writeTreeHelper(IntTreeNode node) {
    		if(node != null) {
    			if(node.left == null && node.right == null) {
    				System.out.println("0 " + node.data);
    			} else if(node.left == null) {
    				System.out.println("1 " + node.data);

    			} else if(node.right == null) {
    				System.out.println("2 " + node.data);

    			} else {
    				System.out.println("3 " + node.data);
    			}
    			writeTreeHelper(node.left);
        		writeTreeHelper(node.right);
    		}
    	}
    	
    	public void readTree() {
    		readTreeHelper(scanner);
    	}
    	
    	private void readTreeHelper(Scanner value) {
    		IntTreeNode node = null;
    		if(value.hasNextLine()) {
    			String line = value.nextLine();
    			if(line.startsWith("1")) {
    				node = new IntTreeNode();
    			} else {
    				
    			}
    		}
    	}
}
