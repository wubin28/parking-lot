package cc.oobootcamp.parkinglot;

import java.util.Comparator;

public class SuperParkingBoy extends ParkingBoy {

    public SuperParkingBoy(ParkingLot... parkingLot) {
        super(parkingLot);
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot parkingLot = parkingLots.stream()
                .max(Comparator.comparingDouble(ParkingLot::vacancyRate)).get();

        return parkingLot.park(car);
    }

}
