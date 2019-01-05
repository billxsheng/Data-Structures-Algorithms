//Bill Sheng
//MSCI 240 Fall 2018 Instructor: Dr.Mark Hancock
//20720680
//October 3, 2018
//Assignment 3 (Homework 1)

package HomeworkOne;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HomeworkOne {
	
	//-----------------//
	//PROBLEM 1
	//-----------------//
//	public static void scaleByK(ArrayList<Integer> list) {
//		ArrayList<Integer> scaledList = new ArrayList<Integer>();
//		for(int removeCounter = 0; removeCounter < list.size(); removeCounter++) {
//			if(list.get(removeCounter) <= 0) {
//				list.remove(removeCounter);
//			}
//		}
//		for(int listIndex = 0; listIndex < list.size(); listIndex++) {
//			for(int listIndexCount = 0; listIndexCount < list.get(listIndex); listIndexCount++) {
//				scaledList.add(list.get(listIndex));
//			}
//		}
//		list = scaledList;
//	}
	
	public static ArrayList<Integer> scaleByK(ArrayList<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) > 0) {
				for(int j = 0; j < list.get(i); j++) {
					list.add(i + j, list.get(i));
				}
			}
			i += list.get(i);
		}
		return list;
	}
		
//	public static void removeDuplicates(ArrayList<String> list) {
//		ArrayList<String> parsedList = new ArrayList<String>();
//		for(String listString: list) {
//			if(!parsedList.contains(listString)) {
//				parsedList.add(listString);
//			}
//		}
//		list = parsedList;
//	}
	
	public static ArrayList<String> removeDuplicates(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if(list.size() == i + 1) {
				
			} else if(list.get(i) == list.get(i + 1)) {
				list.remove(i);
			}
		}
		return list;
	}
		
//	public static ArrayList<String> clump(ArrayList<String> list) {
//		ArrayList<String> clumpList = new ArrayList<String>();
//		for(int listIndex = 0; listIndex < list.size(); listIndex++) {
//			if(listIndex % 2 == 0) {
//				if(list.size() <= listIndex + 1) {
//					clumpList.add(list.get(listIndex));
//				} else {
//					clumpList.add("(" + list.get(listIndex) + " " + list.get(listIndex + 1) + ")") ;
//				}
//			}
//		}
//		list = clumpList;
//		return list;
//	}
	
	public static ArrayList<String> clump(ArrayList<String> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.size() == i + 1 && list.size() % 2 == 1) {
				
			} else if(list.size() != i + 1) {
				list.add(i, "(" + list.get(i) +" " + list.get(i + 1) + ")");
				list.remove(i + 1);
				i++;
			}
		}
		return list;
	}

	
	//-----------------//
	//PROBLEM 2
	//-----------------//
	
//	public static void splitStack(Stack<Integer> stack) {
//		Queue<Integer> auxillary = new LinkedList<Integer>();
//		int negativeNumbers = 0;
//		int initialSize = stack.size();	
//		for(int stackCounter = 0; stackCounter < initialSize; stackCounter++) {
//			if(stack.peek() < 0) {
//				negativeNumbers++;
//			}
//			auxillary.add(stack.pop());
//		}
//		while(!auxillary.isEmpty()) {
//			if(auxillary.peek() < 0) {
//				stack.push(auxillary.remove());
//			} else if(auxillary.peek() >= 0 && stack.size() == negativeNumbers) {
//				for(int negCounter = 0; negCounter < (initialSize - negativeNumbers); negCounter++) {
//					stack.push(auxillary.remove());
//				}
//			} else if(auxillary.peek() >= 0) {
//				auxillary.add(auxillary.remove());
//			}
//		}
//	}
	public static Stack<Integer> splitStack(Stack<Integer> stack) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int num = 0;
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
			num++;
		}
		for(int i = 0; i < num; i++) {
			if(queue.peek() < 0) {
				stack.push(queue.remove());
			} else {
				queue.add(queue.remove());
			}
		}
		while(!queue.isEmpty()) {
			stack.push(queue.remove());
		}
		return stack;
	}

	public static void reverseHalf(Queue<Integer> queue) {
			Stack<Integer> auxillary = new Stack<Integer>();
			int initialSize = queue.size();
			for(int divideCounter = 0; divideCounter < initialSize; divideCounter++) {
				if(divideCounter % 2 == 1) {
					auxillary.push(queue.remove());
				} else {
					queue.add(queue.remove());
				}
			}
			for(int combineCounter = 0; combineCounter < initialSize; combineCounter++) {
				if(combineCounter % 2 == 1) {
					queue.add(auxillary.pop());
				} else {
					queue.add(queue.remove());
				}
			}
	}
	
	public static boolean isSorted(Stack<Integer> stack) {
		boolean isSorted = true;
		Stack<Integer> auxillary = new Stack<Integer>();
		int initialSize = stack.size();
		for(int stackCounter = 0; stackCounter < initialSize-1; stackCounter++) {
			auxillary.add(stack.pop());
			if(stack.peek() < auxillary.peek()) {
				isSorted = false;
			}
		}
		for(int restoreCounter = 0; restoreCounter < initialSize-1; restoreCounter++) {
			stack.push(auxillary.pop());
		}
		return isSorted;
	}
}





