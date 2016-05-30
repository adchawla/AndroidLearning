package mooc.vandy.java4android.calculator.logic;

import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic 
       implements LogicInterface {
    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;

    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out){
        mOut = out;
    }

    /**
     * Perform the @a operation on @a argumentOne and @a argumentTwo.
     */
    public void process(int argumentOne,
                        int argumentTwo,
                        int operation){
        IBinaryArithmeticOperation binaryArithmeticOperation =
                BinaryArithmeticOperationCreator.CreateInstance(argumentOne, argumentTwo, operation);
        if (!binaryArithmeticOperation.validate()) {
            mOut.print("Error: " + binaryArithmeticOperation.getValidationErrorString());
        } else {
            mOut.print(binaryArithmeticOperation.getResult());
        }

    }
}
