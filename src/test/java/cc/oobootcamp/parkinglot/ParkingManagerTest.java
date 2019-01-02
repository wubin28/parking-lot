package cc.oobootcamp.parkinglot;

import cc.oobootcamp.parkinglot.exception.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingManagerTest {

    @Test
    void should_return_ticket_when_park_given_parking_lot_has_space_and_no_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(parkingLot));
        Car car = new Car();
        Ticket ticket = parkingManager.park(car);
        assertSame(car, parkingLot.pick(ticket));
    }

    @Test
    void should_throw_exception_when_park_given_parking_lot_is_full_and_no_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(parkingLot));

        assertThrows(ParkingLotFullException.class, () -> parkingManager.park(new Car()));
    }
}
