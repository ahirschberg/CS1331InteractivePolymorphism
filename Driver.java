import java.util.Scanner;

public class Driver {
    private static Scanner input;
    // Notice we are giving chosenScrambler the type Scrambler here,
    // even though Scrambler is an ABSTRACT class
    private static Scrambler chosenScrambler;
    private static String chosenText;

    /**
     * Allow the user to interact with various Scramblers
     * @param args ignored in this case
     */
    public static void main(String[] args) {
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

        System.out.printf("%s: scramble(\"%s\")\n", chosenScrambler, chosenText);

        // Here we call the scramble method of chosenScrambler, although we
        // don't yet know which scrambler the user is going to select.
        String scrambledText = chosenScrambler.scramble(chosenText);
        System.out.printf("=>  %s", scrambledText);

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

    /**
     * Allows the user to choose a scrambler from the list provided
     */
    private static void chooseScrambler() {
        System.out.println("1: UppercaseScrambler");
        System.out.println("2: BackwardsScrambler");
        String choice = input.nextLine().trim();

        // This is where the polymorphism happens!
        // Even though chosenScrambler is of type Scrambler, we are able
        // to instantiate it via its concrete subclasses!
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




    // IGNORE THE CODE BELOW(unless you are interested) IT HAS NOTHING TO DO WITH
    // CS 1331!!!



    /**
     * Some magic to color the output on Linux, Mac, and probably Git Bash.
     * Sorry CMD.exe you're stuck in the dark ages.
     * Bash on Ubuntu on Windows 10 is really neat though, google it
     * @param cmd some string referring to the coloring mode.
     */
    private static void colorMyTerminal(String cmd) {
        String termInfo = System.getenv("TERM");
        if (termInfo == null || termInfo.equals("")) {
            // If $TERM isn't set, the user's system probably doesn't support
            // our ANSI color codes. Instead we do nothing. :(
            // AKA windows CMD.exe
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
