package JavaOODesign.ParkingLot;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Robert on 5/25/2018.
 */
public enum Type {
    BUS(false, 3);

    //MOTOR,
    //CAR;
    private boolean disabled;
    private int size;

    Type(boolean disabled, int size) {
        this.disabled = disabled;
        this.size = size;
    }
    public boolean isDisabled() {
        return disabled;
    }

    public int size() {
        return size;

    }
}
