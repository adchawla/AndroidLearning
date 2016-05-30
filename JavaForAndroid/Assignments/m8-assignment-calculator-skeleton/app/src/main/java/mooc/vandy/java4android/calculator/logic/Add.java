package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Add operation.
 */
public class Add extends BinaryArithmeticOperation {

    public Add(int value1, int value2) {
        super(value1, value2);
    }

    @Override
    protected int getIntResult() {
        return getValue1() + getValue2();
    }
}
