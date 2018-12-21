package cc.oobootcamp.parkinglot;

import cc.oobootcamp.parkinglot.exception.ParkingLotFullException;
import cc.oobootcamp.parkinglot.exception.TicketInvalidException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public SmartParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    public Ticket park(Car car) {
        return parkingLots.stream()
                .max(Comparator.comparingInt(ParkingLot::availableSpace))
                .filter(parkingLot1 -> !parkingLot1.isFull())
                .orElseThrow(ParkingLotFullException::new).park(car);
    }

    public Car pick(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.contains(ticket)) {
                return parkingLot.pick(ticket);
            }
        }
        throw new TicketInvalidException();
    }
}
