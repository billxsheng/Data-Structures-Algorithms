package HomeworkOne;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import HomeworkOne.HomeworkOne;

public class Test {
	public static void main (String args[]) {
		
		ArrayList<Integer> listP1_1 = new ArrayList<Integer>();
		listP1_1.add(4);
		listP1_1.add(1);
		listP1_1.add(2);
		listP1_1.add(3);
		listP1_1.add(1);
		
		ArrayList<String> listP1_2 = new ArrayList<String>();
		listP1_2.add("be");
		listP1_2.add("be");
		listP1_2.add("is");
		listP1_2.add("not");
		listP1_2.add("or");
		listP1_2.add("question");
		listP1_2.add("that");
		listP1_2.add("the");
		listP1_2.add("to");
		listP1_2.add("to");
		
		ArrayList<String> listP1_3 = new ArrayList<String>();
		listP1_3.add("four");
		listP1_3.add("score");
		listP1_3.add("and");
		listP1_3.add("seven");
		listP1_3.add("years");
		listP1_3.add("ago");	
		listP1_3.add("our");	

		Stack<Integer> stackP2_1 = new Stack<Integer>();
		stackP2_1.push(3);
		stackP2_1.push(-5);
		stackP2_1.push(1);
		stackP2_1.push(2);
		stackP2_1.push(-4);
		stackP2_1.push(0);
		
		Queue<Integer> stackP2_2 = new LinkedList<Integer>();
		stackP2_2.add(1);
		stackP2_2.add(8);
		stackP2_2.add(7);
		stackP2_2.add(2);
		stackP2_2.add(9);
		stackP2_2.add(18);
		stackP2_2.add(12);
		stackP2_2.add(0);

		Stack<Integer> stackP2_3 = new Stack<Integer>();
		stackP2_3.push(20);
		stackP2_3.push(20);
		stackP2_3.push(20);
		stackP2_3.push(11);
		stackP2_3.push(8);
		stackP2_3.push(8);
		stackP2_3.push(3);
		System.out.println(HomeworkOne.scaleByK(listP1_1));
		System.out.println(HomeworkOne.removeDuplicates(listP1_2));
		System.out.println(HomeworkOne.clump(listP1_3));
		System.out.println(HomeworkOne.splitStack(stackP2_1));

		HomeworkOne.scaleByK(listP1_1);
		HomeworkOne.removeDuplicates(listP1_2);
		HomeworkOne.clump(listP1_3);
		HomeworkOne.splitStack(stackP2_1);
		HomeworkOne.reverseHalf(stackP2_2);

		System.out.println(HomeworkOne.isSorted(stackP2_3));
	}
}
