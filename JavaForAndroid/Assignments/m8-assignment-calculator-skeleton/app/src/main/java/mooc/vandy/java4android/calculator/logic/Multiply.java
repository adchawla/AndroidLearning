package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply extends BinaryArithmeticOperation {

    public Multiply(int value1, int value2) {
        super(value1, value2);
    }

    @Override
    protected int getIntResult() {
        return getValue1() * getValue2();
    }

}
