package HomeworkFour;

import java.util.Stack;

public class HomeworkFour {
	public static void writeBinary(int input) {
		if(input < 0) {
			System.out.print('-');
			input *= -1;
		} 		
		if(input == 0) {
			return;
		} else {
			writeBinary(input / 2);
			if(input % 2 == 1) {
				System.out.print(1);
			} else if (input % 2 == 0) {
				System.out.print(0);
			}
		}
	}
	
	public static void writeChars(int input) {
		if(input < 1) {
	        throw new IllegalArgumentException();
		} else if(input == 1) {
			System.out.print("*");
		} else if(input == 2) {
			System.out.print("**");
		} else {
			System.out.print("<");
			writeChars(input - 2);
			System.out.print(">");
		}
	}
}
