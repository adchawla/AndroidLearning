package mooc.vandy.java4android.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage 
       extends House {

    private boolean mSecondFloor;

    public Cottage(int dimension, int lotLength, int lotWidth) {
        this(dimension, lotLength, lotWidth, null, false);
    }

    public Cottage(int dimension, int lotLength, int lotWidth, String owner, boolean secondFloor) {
        super(dimension, dimension, lotLength, lotWidth, owner);
        mSecondFloor = secondFloor;
    }

    public boolean hasSecondFloor() {
        return mSecondFloor;
    }

    @Override
    public String toString() {
        String superValue = super.toString();
        if (mSecondFloor) {
            superValue = superValue.concat("; is a two story cottage");
        } else {
            superValue = superValue.concat("; is a cottage");
        }
        return superValue;
    }
    
}

