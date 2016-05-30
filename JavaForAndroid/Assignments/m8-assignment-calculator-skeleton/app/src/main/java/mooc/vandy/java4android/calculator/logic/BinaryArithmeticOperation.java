package mooc.vandy.java4android.calculator.logic;

/**
 * Created by amandeep on 25/05/16.
 */

/**
 * Abstract class which implements IBinaryArithmeticOperation interface.
 */
public abstract class BinaryArithmeticOperation implements IBinaryArithmeticOperation {

    private int mValue1;
    private int mValue2;

    public BinaryArithmeticOperation(int value1, int value2) {
        mValue1 = value1;
        mValue2 = value2;
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public String getValidationErrorString() {
        return null;
    }

    @Override
    public String getResult() {
        if (validate()) {
            return new Integer(getIntResult()).toString();
        }
        return null;
    }

    protected abstract int getIntResult();

    public final int getValue1() {
        return mValue1;
    }

    public final void setValue1(int mValue1) {
        this.mValue1 = mValue1;
    }

    public final int getValue2() {
        return mValue2;
    }

    public final void setValue2(int mValue2) {
        this.mValue2 = mValue2;
    }

}
