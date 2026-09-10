package LLD_Interview_Problems.Parking_Lot;

public class ParkingSpot {
    private final int spotId;
    private final SpotType type;
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber, SpotType type) {
        this.spotId = spotNumber;
        this.type = type;
    }

    int getSpotNumber() {
        return spotId;
    }

    SpotType getType() {
        return type;
    }

    public boolean isOccupied() {
        return vehicle == null;
    }

    public boolean canFit(Vehicle vehicle) {
        if(isOccupied()) return false;

        return switch(vehicle.getVehicleType()) {
            case BIKE -> type == SpotType.BIKE ||
                         type == SpotType.CAR ||
                         type == SpotType.LARGE;
            case CAR -> type == SpotType.CAR ||
                        type == SpotType.LARGE;
            case TRUCK -> type == SpotType.LARGE;
        };
    }

    public void park(Vehicle vehicle) throws IllegalAccessException {
        if(isOccupied()) throw new IllegalAccessException("Parking Spot is Occupied");
        if(canFit(vehicle)) throw new IllegalAccessException("Vehicle cannot fit in Spot");
        this.vehicle = vehicle;
    }

    public void unPark() throws IllegalAccessException {
        if(!isOccupied()) throw new IllegalAccessException("No Vehicle Parked");
        this.vehicle = null;
    }
}