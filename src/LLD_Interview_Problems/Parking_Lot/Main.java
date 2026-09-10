package LLD_Interview_Problems.Parking_Lot;

import LLD_Interview_Problems.Parking_Lot.FeeStrategy.HourlyFeeStrategy;
import LLD_Interview_Problems.Parking_Lot.ParkingStrategy.FirstAvailableStrategy;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        ParkingLot parkingLot =
                new ParkingLot(
                        new FirstAvailableStrategy(),
                        new HourlyFeeStrategy()
                );

        ParkingFloor floor1 = new ParkingFloor(1);

        floor1.addSpot(
                new ParkingSpot(1, SpotType.BIKE)
        );

        floor1.addSpot(
                new ParkingSpot(2, SpotType.CAR)
        );

        floor1.addSpot(
                new ParkingSpot(3, SpotType.LARGE)
        );

        parkingLot.addFloor(floor1);

        Vehicle car =
                new Vehicle(
                        "DL01AB1234",
                        VehicleType.CAR
                );

        ParkingTicket ticket =
                parkingLot.parkVehicle(car);

        System.out.println(
                "Ticket: " + ticket.getTicketId()
        );

        double fee =
                parkingLot.unparkVehicle(
                        ticket.getTicketId()
                );

        System.out.println(
                "Fee: " + fee
        );
    }
}
