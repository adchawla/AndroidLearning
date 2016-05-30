package mooc.vandy.java4android.calculator.logic;

/**
 * Created by amandeep on 25/05/16.
 */
public interface IBinaryArithmeticOperation {
    /**
     * Validate the input values
     * @return boolean value: true in case the values are valid else return false.
     */
    public boolean validate();

    /**
     * Return a user friendly validation error message.
     * @return String value: return a user friendly error message in case operands are not valid;
     * else it will return null.
     */
    public String getValidationErrorString();

    /**
     * Return the result of the arithmetic operation as a string.
     * @return String value: return the result of the arithmetic operation as string in case
     * operands are valid; else return null
     */
    public String getResult();
}
