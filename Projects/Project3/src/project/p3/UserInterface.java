package project.p3;

import java.util.Scanner;

public class UserInterface {
    /**
     * Waits for the user to answer a yes/no question on the console and returns the user's response
     * as a boolean (true for anything that starts with "y" or "Y").
     */
    public static boolean nextAnswer(Scanner input) {
        String answer = input.nextLine();
        return answer.trim().toLowerCase().startsWith("y");
    }
}
