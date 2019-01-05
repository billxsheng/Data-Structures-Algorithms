package project.p3;
// CSE 143, Winter 2009, Marty Stepp

// Homework 7: 20 Questions
//
// To use the jGRASP debugger with this program, set a breakpoint
// and once the execution breaks, open 'this' or 'tq' on the left,
// then look at its variable 'tree'.  That's your QuestionTree.
// Drag your 'tree' over to the right to see a visualization of it.
//
// (Your QuestionTree is constructed by this file on line 30.
// The overall loop to play games is around line 68.)

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/** A basic text user interface for the 20 questions game. */
public class QuestionMain {
    private static final String PLAY_AGAIN_MESSAGE = "Challenge me again?";
    private static final String SAVE_MESSAGE = "Shall I remember these games?";
    private static final String LOAD_MESSAGE = "Shall I recall our previous games?";
    private static final String SAVE_LOAD_FILENAME_MESSAGE = "What is the file name?";
    private static final String STATUS_MESSAGE = "Games played: %d\nI won: %d";
    private static final String BANNER_MESSAGE = "Think of an item, and I will guess it.";

    public static void main(String[] args) {
        QuestionMain tq = new QuestionMain();
        tq.run();
    }

    // fields
    private Scanner input = new Scanner(System.in);
    private PrintStream output = System.out;
    private QuestionTree tree;

    /** Constructs a text user interface and its question tree. */
    public QuestionMain() {
        tree = new QuestionTree(input, output);
    }

    // private helper for overall game(s) loop
    private void run() {
        output.println("Welcome to the game of 20 Questions!");
        load();

        // "Think of an item, and I will guess it in N tries."
        output.println("\n" + BANNER_MESSAGE);

        do {
            // play one complete game
            output.println(); // blank line between games
            tree.play();
            output.print(PLAY_AGAIN_MESSAGE);
        } while (UserInterface.nextAnswer(input)); // prompt to play again

        // print overall stats
        // Games played: N ... I have won: M
        output.println("\n" + String.format(STATUS_MESSAGE, tree.totalGames(), tree.gamesWon()));
        save();
    }

    // common code for asking the user whether they want to save or load
    private void load() {
        output.print(LOAD_MESSAGE);
        if (UserInterface.nextAnswer(input)) {
            output.print(SAVE_LOAD_FILENAME_MESSAGE);
            String filename = input.nextLine();
            try {
                Scanner in = new Scanner(new File(filename));
                tree.load(in);
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // common code for asking the user whether they want to save or load
    private void save() {
        output.print(SAVE_MESSAGE);
        if (UserInterface.nextAnswer(input)) {
            output.print(SAVE_LOAD_FILENAME_MESSAGE);
            String filename = input.nextLine();
            try {
                PrintStream out = new PrintStream(new File(filename));
                tree.save(out);
                out.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
