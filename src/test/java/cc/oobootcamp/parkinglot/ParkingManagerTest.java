package cc.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertSame;

class ParkingManagerTest {

    @Test
    void should_return_ticket_when_park_given_parking_lot_has_space_and_no_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(parkingLot));
        Car car = new Car();
        Ticket ticket = parkingManager.park(car);
        assertSame(car, parkingLot.pick(ticket));
    }
}
