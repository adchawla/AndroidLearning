package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * Created by amandeep on 20/05/16.
 */
public class HerdManager {
    private Gate mWestGate;
    private Gate mEastGate;
    private OutputInterface mOut;

    private static final int MAX_ITERATIONS = 10;

    public static final int HERD = 24;

    public HerdManager(OutputInterface out, Gate gate1, Gate gate2) {
        mOut = out;
        mWestGate = gate1;
        mEastGate = gate2;
        mWestGate.open(Gate.IN);
        mEastGate.open(Gate.OUT);
    }

    public void simulateHerd(Random rand) {
        int snailsInsidePen = HERD;
        for (int iteration = 0; iteration < 10; ++iteration) {
            if (snailsInsidePen == HERD ) {
                int snailsToMoveOut = rand.nextInt(snailsInsidePen - 1) + 1;
                snailsInsidePen -= snailsToMoveOut;
            } else {
                int gate = rand.nextInt(2);
                int snailsAddedToPen = 0;
                switch(gate) {
                    case 0:
                        snailsAddedToPen = rand.nextInt(snailsInsidePen - 1) + 1;
                        break;
                    case 1:
                        snailsAddedToPen = -rand.nextInt(HERD - snailsInsidePen - 1) + 1;
                        break;
                }
                snailsInsidePen += snailsAddedToPen;
            }
            mOut.println("There are currently " + snailsInsidePen + " snails in the pen and "
                    + (HERD - snailsInsidePen) + "snails in the pasture");
        }
    }
}
