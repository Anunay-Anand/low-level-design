package LLD_Interview_Problems.Parking_Lot.ParkingStrategy;

import LLD_Interview_Problems.Parking_Lot.ParkingFloor;
import LLD_Interview_Problems.Parking_Lot.ParkingSpot;
import LLD_Interview_Problems.Parking_Lot.Vehicle;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot find(List<ParkingFloor> floors, Vehicle vehicle);
}
