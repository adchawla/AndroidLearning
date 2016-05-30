package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }


    /**
     * Randomly open a gate.
     * @param gates array containing all the gates to randomly opened.
     * @param selectDirection random number generator to generate randomness to the whole operation.
     */
    public void setCorralGates(Gate[] gates,Random selectDirection) {
        for (Gate gate: gates) {
            int randomValue = selectDirection.nextInt(3) - 1;
            gate.open(randomValue);
        }
    }

    /**
     * To check if any of the corral is available for the movement.
     * @param corral array of gates which will be checked for the direction.
     * @return true in case any of the gate is opened with inward direction.
     */
    public boolean anyCorralAvailable(Gate[] corral) {
        for (Gate gate:corral) {
            if (gate.getSwingDirection() == Gate.IN)
                return true;
        }
        return false;
    }

    /**
     * Simulate the movement of snails while connected to corral
     * @param corral array of gates thru which movement of corral will be allowed in or out.
     * @param rand to generate randomness while simulating.
     * @return number of attempts taken to empty out the pasture.
     */
    public int corralSnails(Gate[] corral,Random rand) {
        // initial number of snails in the pasture
        int snailsInPasture = 5;

        // to keep track of the number of attempts taken to reach to the solution.
        int attempts = 0;

        // print the status of each gate.
        for (int i = 0; i < corral.length; ++i) {
            mOut.println("Gate " + i +": " + corral[i].toString() + ".");
        }

        while(snailsInPasture > 0 ) {
            // pick up a random gate for movement.
            int currentGateIndex = rand.nextInt(corral.length);

            // pick up a random number of snails to move through. the number is limited between 1
            // and number of snails available in pasture.
            int currentSnails = rand.nextInt(snailsInPasture) + 1;

            Gate currentGate = corral[currentGateIndex];

            // try the movement only in case currently chosen gate is open.
            if (!currentGate.isLocked()) {
                currentSnails = currentGate.thru(currentSnails);

                //update the count of snails moved thru a gate. it will be positive if gate's
                //swing direction is OUT else it will be -ve.
                snailsInPasture -= currentSnails;
            }

            // print the movement details.
            mOut.println(Math.abs(currentSnails) + " are trying to move through corral "
                + currentGateIndex);

            // increment the attempt count.
            attempts++;
        }

        // print the final status indicating the number of attempts it took to move all the snails
        // out of the pasture.
        mOut.println("It took " + attempts + " attempts to corral all of the snails.");

        return attempts;
    }
}
