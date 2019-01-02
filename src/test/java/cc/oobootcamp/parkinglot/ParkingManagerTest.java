package cc.oobootcamp.parkinglot;

import cc.oobootcamp.parkinglot.exception.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingManagerTest {

    @Test
    void should_return_ticket_when_park_given_parking_lot_has_space_and_no_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingManager.park(car);

        assertSame(car, parkingLot.pick(ticket));
    }

    @Test
    void should_throw_exception_when_park_given_parking_lot_is_full_and_no_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());
        ParkingManager parkingManager = new ParkingManager(parkingLot);

        assertThrows(ParkingLotFullException.class, () -> parkingManager.park(new Car()));
    }

    @Test
    void should_park_successfully_when_park_given_parking_boy_managed_parking_lot_has_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new SuperParkingBoy(parkingLot);

        ParkingManager parkingManager = new ParkingManager(parkingBoy);
        Car car = new Car();
        Ticket ticket = parkingManager.park(car);
        assertSame(car, parkingLot.pick(ticket));
    }

    @Test
    void should_park_successfully_when_park_given_second_parking_boy_managed_parking_lot_has_space_and_first_is_full() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());

        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot);
        ParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot2);

        ParkingManager parkingManager = new ParkingManager(superParkingBoy, smartParkingBoy);
        Car car = new Car();
        Ticket ticket = parkingManager.park(car);
        assertSame(car, parkingLot2.pick(ticket));
    }
}
