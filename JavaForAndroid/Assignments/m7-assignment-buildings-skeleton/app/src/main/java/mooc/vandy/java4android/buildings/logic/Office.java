package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office 
       extends Building {

    private String mBusinessName;
    private int mParkingSpaces;

    private static int sTotalOffices = 0;

    public Office(int length, int width, int lotLength, int lotWidth) {
        this(length, width, lotLength, lotWidth, null, 0);
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        this(length, width, lotLength, lotWidth, businessName, 0);
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName,
             int parkingSpaces)
    {
        super(length, width, lotLength, lotWidth);
        setBusinessName(businessName);
        setParkingSpaces(parkingSpaces);
        sTotalOffices++;
    }

    public String getBusinessName() {
        return mBusinessName;
    }

    public int getParkingSpaces() {
        return mParkingSpaces;
    }

    public void setBusinessName(String businessName) {
        mBusinessName = businessName;
    }

    public void setParkingSpaces(int parkingSpaces) {
        mParkingSpaces = parkingSpaces;
    }

    public String toString() {
        String description = new String("Business: ");
        description = description.concat( mBusinessName != null ? mBusinessName : "unoccupied" );
        if (getParkingSpaces() > 0 ) {
            description = description.concat("; has " + getParkingSpaces() + " parking spaces" );
        }
        description = description.concat(" (total offices: " + sTotalOffices + ")");
        return description;
    }

    public boolean equals(Object obj) {
        if (obj instanceof  Office ) {
            Office office = (Office) obj;
            if ( calcBuildingArea() == office.calcBuildingArea() &&
                    getParkingSpaces() == office.getParkingSpaces() ) {
                return true;
            }
        }
        return false;
    }
    
}
