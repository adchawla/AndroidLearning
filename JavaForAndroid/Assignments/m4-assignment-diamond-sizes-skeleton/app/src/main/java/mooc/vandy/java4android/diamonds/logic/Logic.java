package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        // Characters to be used within the staring character and ending character in the ASCII art.
        char[] innerCharsToUse = {'=', '-'};

        // Character to be used as starting character in each line of ASCII art.
        char[] startingChars = {'/', '<', '\\'};

        // Character to be used as ending character in each line of ASCII art.
        char[] endingChars = {'\\', '>', '/'};


        // Print the frame's top line
        printStartAndEndLine(size);

        int charIndex = -1;

        for(int i = 0; i < 2 * size - 1; ++i ) {

            // calculate the number of spaces required for the line.
            int nSpaces = Math.abs(size - i - 1);
            int nInnerChars = (size - nSpaces - 1) * 2;

            // set the index to be used to pick up the correct starting and ending character.
            if ( i < size - 1 ) {
                charIndex = 0;
            } else if ( i == size - 1 ) {
                charIndex = 1;
            } else {
                charIndex = 2;
            }

            printLine(nSpaces, startingChars[charIndex], endingChars[charIndex],
                    innerCharsToUse[i%2], nInnerChars);

        }

        // Print the frame's bottom line
        printStartAndEndLine(size);
    }

    private void printStartAndEndLine(int size) {
        mOut.print("+");
        printChar('-', 2 * size );
        mOut.println("+");
    }

    private void printSpaces(int nSpaces) {
        printChar(' ', nSpaces);
    }


    private void printChar( char charToPrint, int count ) {
        for ( int i = 0; i < count; ++i ) {
            mOut.print(charToPrint);
        }
    }

    private void printLine( int nSpaces, char startingCharacter, char endingCharacter,
                            char enclosedCharacter, int nCountofEnclosedCharacter )
    {
        // print the start of the frame line
        mOut.print('|');

        // print the starting spaces
        printSpaces(nSpaces);

        // print the starting character
        mOut.print(startingCharacter);

        // print the inner characters alternatively switching the characters.
        printChar(enclosedCharacter, nCountofEnclosedCharacter);

        // print the ending character
        mOut.print(endingCharacter);

        // print the end spaces
        printSpaces(nSpaces);

        // print the end of the frame line
        mOut.println("|");
    }
   
}
