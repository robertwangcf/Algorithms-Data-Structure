package JavaOODesign.ParkingLot;

/**
 * Created by Robert on 5/25/2018.
 */
public class ParkingLevel {
    ParkingSpot[] parkingSpotsForMotor;
    ParkingSpot[] parkingSpotsForCar;
    ParkingSpot[] parkingSpotsForBus;
    private final int floor;
    int size;

    public ParkingLevel(int floor, int capacityMotor, int capacityCar, int capacityBus) {
        this.floor = floor;
        size = 0;
        parkingSpotsForMotor = new ParkingSpot[capacityMotor];
        parkingSpotsForCar = new ParkingSpot[capacityCar];
        parkingSpotsForBus = new ParkingSpot[capacityBus];
    }

    boolean canPark(Vehicle v) {
        if (v.type == Type.BUS) {
            for (ParkingSpot spot : parkingSpotsForBus) {
                if (spot.canPark(v)) {
                    return true;
                }
            }
        }
        return false;
    }

    synchronized boolean goPark(Vehicle v) {
        if (!canPark(v)) {
            return false;
        }
        //TODO: check type
        for (ParkingSpot spot : parkingSpotsForBus) {
            if (spot.canPark(v)) {
                spot.goPark(v);
                return true;
            }
            size++;
        }
        return false;
    }

    boolean hasCapacity() {
        return size < this.parkingSpotsForMotor.length;
    }
}
