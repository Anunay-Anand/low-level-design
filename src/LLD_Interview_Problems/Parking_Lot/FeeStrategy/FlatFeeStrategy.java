package LLD_Interview_Problems.Parking_Lot.FeeStrategy;

import LLD_Interview_Problems.Parking_Lot.ParkingTicket;
import LLD_Interview_Problems.Parking_Lot.Vehicle;

public class FlatFeeStrategy implements FeeStrategy {
    @Override
    public double calculateFee(ParkingTicket ticket) {
        Vehicle vehicle = ticket.getVehicle();
        return switch (vehicle.getVehicleType()) {
            case CAR -> 40.00;
            case BIKE -> 20.0;
            case TRUCK -> 100.0;
        };
    }
}
