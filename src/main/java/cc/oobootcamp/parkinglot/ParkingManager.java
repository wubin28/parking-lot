package cc.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingManager(List<ParkingLot> parkingLots) {
        this.parkingLots.addAll(parkingLots);
    }

    public Ticket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return parkingLot.park(car);
            }
        }
        return null;
    }
}
