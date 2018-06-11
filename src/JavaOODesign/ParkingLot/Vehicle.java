package JavaOODesign.ParkingLot;

/**
 * Created by Robert on 5/25/2018.
 */
//import lombok.Data;

import java.util.UUID;

//@Data
public abstract class Vehicle {
    protected String vin = UUID.randomUUID().toString();
    protected Type type;
}
