package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide extends BinaryArithmeticOperation {

    private final static String DIVIDE_BY_ZERO_VALIDATION_ERROR =
            new String("Division operation can't be performed with denominator as zero");

    public Divide(int value1, int value2) {
        super(value1, value2);
    }

    @Override
    public boolean validate() {
        if (getValue2() != 0)
            return true;
        return false;
    }

    @Override
    public String getValidationErrorString() {
        if (getValue2() == 0)
            return DIVIDE_BY_ZERO_VALIDATION_ERROR;
        return null;
    }

    @Override
    public String getResult() {
        String result = super.getResult();
        int mod = getValue1() % getValue2();
        if (mod != 0) {
            result = result.concat(" R: " + mod);
        }
        return result;
    }

    @Override
    protected int getIntResult() {
        return getValue1()/getValue2();
    }
}
