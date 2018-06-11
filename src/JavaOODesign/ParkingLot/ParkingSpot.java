package JavaOODesign.ParkingLot;

/**
 * Created by Robert on 5/25/2018.
 */
public class ParkingSpot {
    Type type;
    Vehicle cur;
    ParkingSpot(Type type) {
        this.type = type;
        cur = null;
    }

    boolean canPark(Vehicle v) {
        return cur == null && this.type == v.type;
    }

    synchronized boolean goPark(Vehicle v) {
        if (canPark(v)) {
            cur = v;
            return true;
        }
        return false;
    }

    Vehicle leavePark() {
        Vehicle vToLeave = cur;
        cur = null;
        return vToLeave;
    }
}
