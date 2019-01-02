package cc.oobootcamp.parkinglot;

import cc.oobootcamp.parkinglot.exception.ParkingLotFullException;
import cc.oobootcamp.parkinglot.exception.TicketInvalidException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingManager {
    private List<Parkable> parkables = new ArrayList<>();

    public ParkingManager(Parkable... parkingBoys) {
        this.parkables.addAll(Arrays.asList(parkingBoys));
    }

    public Ticket park(Car car) {
        for (Parkable parkable : parkables) {
            if (!parkable.isFull()) {
                return parkable.park(car);
            }
        }
        throw new ParkingLotFullException();
    }

    public Car pick(Ticket ticket) {
        for (Parkable parkable : parkables) {
            if (parkable.contains(ticket)) {
                return parkable.pick(ticket);
            }
        }
        throw new TicketInvalidException();
    }
}
