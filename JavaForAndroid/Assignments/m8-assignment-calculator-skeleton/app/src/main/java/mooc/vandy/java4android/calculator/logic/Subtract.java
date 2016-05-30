package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Subtract operation.
 */
public class Subtract extends BinaryArithmeticOperation {

    public Subtract(int value1, int value2) {
        super(value1, value2);
    }

    @Override
    protected int getIntResult() {
        return getValue1() - getValue2();
    }
}
