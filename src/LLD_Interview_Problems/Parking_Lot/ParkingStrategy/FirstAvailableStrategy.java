package LLD_Interview_Problems.Parking_Lot.ParkingStrategy;

import LLD_Interview_Problems.Parking_Lot.ParkingFloor;
import LLD_Interview_Problems.Parking_Lot.ParkingSpot;
import LLD_Interview_Problems.Parking_Lot.Vehicle;

import java.util.List;

public class FirstAvailableStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot find(List<ParkingFloor> floors, Vehicle vehicle) {
        for(ParkingFloor floor: floors) {
           for (ParkingSpot parkingSpot: floor.getSpots()) {
               if (parkingSpot.canFit(vehicle)) {
                   return parkingSpot;
               }
           }
        }
        return null;
    }
}
