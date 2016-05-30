package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    
    public static final int IN = 1;
    public static final int OUT = -1;

    private int mSwing;
    private boolean mLocked;

    @Override
    public String toString() {
        String str;
        if (isLocked()) {
            str = new String("This gate is locked");
        } else {
            switch (mSwing) {
                case 0:
                    str = new String("This gate is not locked and swings");
                    str = str.concat(" but the swing is not set properly");
                    break;

                case IN:
                    str = new String("This gate is not locked and swings to enter the pen only");
                    break;

                case OUT:
                    str = new String("This gate is not locked and swings to exit the pen only");
                    break;
                default:
                    str = new String("");
            }
        }
        return str;
    }

    public Gate() {
        mLocked = true;
        mSwing = 0;
    }


    public int getSwingDirection() {
        return mSwing;
    }

    public boolean setSwing(int direction) {
        if (direction == this.IN || direction == this.OUT) {
            this.mSwing = direction;
            return true;
        }
        return false;
    }

    public boolean open(int direction) {
        if (setSwing(direction)) {
            mLocked = false;
            return true;
        }
        return false;
    }

    public void close() {
        mLocked = true;
    }

    public boolean isLocked() {
        return mLocked;
    }

    public int thru(int count) {
        if (isLocked()) {
            return 0;
        } else {
            return mSwing * count;
        }
    }
}
