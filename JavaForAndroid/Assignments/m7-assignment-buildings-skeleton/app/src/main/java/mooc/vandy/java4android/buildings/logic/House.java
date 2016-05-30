package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House 
       extends Building {

    private String mOwner;
    private boolean mPool;

    public House(int length, int width, int lotLength, int lotWidth) {
        this(length, width, lotLength, lotWidth, null, false);
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner) {
        this(length, width, lotLength, lotWidth, owner, false);
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool) {
        super(length, width, lotLength, lotWidth);
        setOwner(owner);
        setPool(pool);
    }

    public String getOwner() {
        return mOwner;
    }

    public boolean hasPool() {
        return mPool;
    }

    public void setOwner(String owner) {
        mOwner = owner;
    }

    public void setPool(boolean pool) {
        mPool = pool;
    }

    public String toString() {
        String description = new String("Owner: ");
        description = description.concat( mOwner != null ? mOwner : "n/a" );
        if (hasPool() ) {
            description = description.concat("; has a pool");
        }
        if (calcLotArea() > 2 * calcBuildingArea() ) {
            description = description.concat("; has a big open space");
        }
        return description;
    }

    public boolean equals(Object obj) {
        if (obj instanceof  House) {
            House house = (House) obj;
            if ( this.calcBuildingArea() == house.calcBuildingArea() &&
                    this.hasPool() == house.hasPool() ) {
                return true;
            }
        }
        return false;
    }
    
}
