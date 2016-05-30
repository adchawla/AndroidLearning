package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mEastGate;

    /**
     * The output Gate object.
     */
    private Gate mWestGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    public static final int HERD = 24;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate eastGate,
                       Gate westGate) {
        mOut = out;

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);

        mWestGate = westGate;
        mWestGate.open(Gate.IN);
    }

    /**
     * Function to simulate the Herd movement.
     * @param rand to add randomness every time in the simulation.
     */

    public void simulateHerd(Random rand) {
        // initially all the snails are inside the pen.
        int snailsInsidePen = HERD;

        // print the initial status.
        mOut.println("There are currently " + snailsInsidePen + " snails in the pen and "
                + (HERD - snailsInsidePen) + " snails in the pasture");

        // start the iterations of a simulation.
        for (int iteration = 0; iteration < MAX_ITERATIONS; ++iteration) {

            int snailsToMoveOut = 0;

            // calculate the snailsToMoveOut of Pen. +ve means to move out, -ve means to move in.
            if (snailsInsidePen == HERD ) { /* all the snails are inside the pen */
                snailsToMoveOut = rand.nextInt(snailsInsidePen) + 1;
            } else if (snailsInsidePen == 0 ) { /* all the snails are open in the pasture */
                snailsToMoveOut = -1 * (rand.nextInt(HERD) + 1);
            } else {
                boolean outGate = rand.nextBoolean();
                if (outGate) {
                    snailsToMoveOut = rand.nextInt(snailsInsidePen) + 1;
                } else {
                    snailsToMoveOut = -(rand.nextInt(HERD - snailsInsidePen) + 1);
                }
            }

            // update the count of snails inside the pen.
            snailsInsidePen -= snailsToMoveOut;

            // print the status after each iteration.
            mOut.println("There are currently " + snailsInsidePen + " snails in the pen and "
                    + (HERD - snailsInsidePen) + " snails in the pasture");
        }
    }

}
