package mooc.vandy.java4android.calculator.logic;

/**
 * Created by amandeep on 25/05/16.
 */

/**
 * This BinaryArithmeticOperationCreator utility class provides static helper method to create
 * various binary arithmetic operation interface instances
 */
public final class BinaryArithmeticOperationCreator {
    /**
     * Private constructor for a utility class
     */
    private BinaryArithmeticOperationCreator() {}

    public final static int ADD_OPERATION = 1;
    public final static int SUB_OPERATION = 2;
    public final static int MUL_OPERATION = 3;
    public final static int DIV_OPERATION = 4;

    public static IBinaryArithmeticOperation CreateInstance(int value1, int value2, int operation) {
        IBinaryArithmeticOperation binaryArithmeticOperation = null;
        switch(operation) {
            case SUB_OPERATION:
                binaryArithmeticOperation = new Subtract(value1, value2);
                break;

            case MUL_OPERATION:
                binaryArithmeticOperation = new Multiply(value1, value2);
                break;

            case DIV_OPERATION:
                binaryArithmeticOperation = new Divide(value1, value2);
                break;

            case ADD_OPERATION:
            default:
                binaryArithmeticOperation = new Add(value1, value2);
                break;
        }
        return binaryArithmeticOperation;
    }
}
