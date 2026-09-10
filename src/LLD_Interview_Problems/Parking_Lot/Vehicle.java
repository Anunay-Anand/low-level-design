package LLD_Interview_Problems.Parking_Lot;

public class Vehicle {
    private final String licenceNumber;
    private final VehicleType type;

    public Vehicle(String licenceNumber, VehicleType type) {
        this.licenceNumber = licenceNumber;
        this.type = type;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public VehicleType getVehicleType() {
        return type;
    }
}
