package cc.oobootcamp.parkinglot;

import cc.oobootcamp.parkinglot.exception.ParkingLotFullException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingManager {
    private List<ParkingLot> parkingLots = new ArrayList<>();
    private List<ParkingBoy> parkingBoys = new ArrayList<>();

    public ParkingManager(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    public ParkingManager(ParkingBoy... parkingBoys) {
        this.parkingBoys.addAll(Arrays.asList(parkingBoys));
    }

    public Ticket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return parkingLot.park(car);
            }
        }
        for (ParkingBoy parkingBoy : parkingBoys) {
            if (!parkingBoy.isFull()) {
                return parkingBoy.park(car);
            }
        }
        throw new ParkingLotFullException();
    }

    public Car pick(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.contains(ticket)) {
                return parkingLot.pick(ticket);
            }
        }

        for (ParkingBoy parkingBoy : parkingBoys) {
            if (parkingBoy.contains(ticket)) {
                return parkingBoy.pick(ticket);
            }
        }
        return null;
    }
}
