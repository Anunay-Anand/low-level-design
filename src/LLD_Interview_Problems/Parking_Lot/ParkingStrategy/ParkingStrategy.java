package LLD_Interview_Problems.Parking_Lot;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot find(List<ParkingFloor> floors, Vehicle vehicle);
}
