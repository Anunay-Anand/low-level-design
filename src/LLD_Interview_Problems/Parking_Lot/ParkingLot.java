package LLD_Interview_Problems.Parking_Lot;

import LLD_Interview_Problems.Parking_Lot.FeeStrategy.FeeStrategy;
import LLD_Interview_Problems.Parking_Lot.ParkingStrategy.ParkingStrategy;

import java.util.*;

class ParkingLot {

    private final List<ParkingFloor> floors = new ArrayList<>();
    private final Map<String, ParkingTicket> activeTickets =
            new HashMap<>();

    private final ParkingStrategy parkingStrategy;
    private final FeeStrategy feeStrategy;

    public ParkingLot(
            ParkingStrategy parkingStrategy,
            FeeStrategy feeStrategy
    ) {
        this.parkingStrategy = parkingStrategy;
        this.feeStrategy = feeStrategy;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) throws IllegalAccessException {

        ParkingSpot spot =
                parkingStrategy.find(floors, vehicle);

        if (spot == null) {
            throw new IllegalStateException("No parking spot available");
        }

        spot.park(vehicle);

        String ticketId = UUID.randomUUID().toString();

        ParkingTicket ticket =
                new ParkingTicket(ticketId, vehicle, spot);

        activeTickets.put(ticketId, ticket);

        return ticket;
    }

    public double unparkVehicle(String ticketId) throws IllegalAccessException {

        ParkingTicket ticket = activeTickets.remove(ticketId);

        if (ticket == null) {
            throw new IllegalArgumentException(
                    "Invalid ticket"
            );
        }

        ticket.closeTicket();

        double fee = feeStrategy.calculateFee(ticket);

        ticket.getSpot().unPark();

        return fee;
    }
}
