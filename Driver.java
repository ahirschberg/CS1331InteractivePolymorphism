import java.util.Scanner;

public class Driver {
    private static Scanner input;
    private static Scrambler chosenScrambler;
    private static String chosenText;

    /**
     * Allow the user to interact with various Scramblers
     * @param args ignored in this case
     */
    public static void main(String args) {
        input = new Scanner(System.in);

        while (true) {
            displayVariables();
            if (chosenScrambler != null && chosenText != null) {
                showScramblerOutput();
            }
            displayOptions();
            String choice = input.nextLine().trim();

            if (choice.equals("c"))
                chooseScrambler();
            else if (choice.equals("e"))
                chooseText();
            else
                System.out.println("Enter a valid option");
        }
    }

    /**
     * Allows the user to choose a scrambler from the list provided
     */
    private static void chooseScrambler() {
        System.out.println("1: UppercaseScrambler");
        System.out.println("2: BackwardsScrambler");
        String choice = input.nextLine().trim();
        if (choice.equals("1")) {
            chosenScrambler = new UppercaseScrambler();
        } else {
            chosenScrambler = new BackwardsScrambler();
        }
    }

    /**
     * Allows the user to choose some text to scramble
     */
    private static void chooseText() {
        System.out.print("Type some text here ~> ");
        chosenText = input.nextLine();
    }

    /**
     * Displays the text and scrambler for the user to see
     */
    private static void displayVariables() {
        System.out.println("\n\n\n\n\n\n");
        System.out.printf("chosenScrambler:\t%s\n", chosenScrambler);
        System.out.printf("chosenText:\t\t%s\n", chosenText);
    }

    /**
     * Displays the output of chosenScrambler.scramble()
     * It might even be a different color, depending on your OS specifics!
     */
    private static void showScramblerOutput() {
        System.out.println("Scrambler output:");
        colorMyTerminal("bold and brave");
        System.out.printf("%s(\"%s\") = \"%s\"\n", chosenScrambler, chosenText,
                chosenScrambler.scramble(chosenText));
        colorMyTerminal("reset");
    }

    /**
     * Display the various options the user can select
     */
    private static void displayOptions() {
        System.out.println("\n==========Options==========");
        System.out.println("(c)hoose a scrambler to use");
        System.out.println("(e)nter some text to scramble");
        System.out.print("\nWhat do you want to do? ~> ");
    }




    // IGNORE THE CODE BELOW(unless you are interested) IT HAS NOTHING TO DO WITH
    // CS 1331!!!








    /**
     * Some evil magic to color the output on Linux, Mac, and Git Bash.
     * Sorry CMD.exe you're stuck in the past.
     * Bash on Ubuntu on Windows 10 is really neat though, google it
     * @param cmd some string referring to the coloring mode.
     */
    private static void colorMyTerminal(String cmd) {
        if (System.getenv("TERM").equals("")) {
            // If $TERM isn't set, the user's system probably doesn't support 
            // our ANSI color codes. Instead we do nothing. :(
            return;
        } else {
            switch (cmd) {
                case "bold and brave": // colors the output in *nix terminals
                    System.out.print("\u001B[1;31m");
                    break;
                case "reset": // uncolors the output in *nix terminals
                    System.out.print("\u001B[0m");
                    break;
            }
        }
    }
}
