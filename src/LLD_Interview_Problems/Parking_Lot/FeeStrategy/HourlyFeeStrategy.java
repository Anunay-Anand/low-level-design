package LLD_Interview_Problems.Parking_Lot.FeeStrategy;

import LLD_Interview_Problems.Parking_Lot.ParkingTicket;

import java.time.Duration;

public class HourlyFeeStrategy implements FeeStrategy {
    @Override
    public double calculateFee(ParkingTicket ticket) {

        long minutes = Duration.between(
                ticket.getEntryTime(),
                ticket.getExitTime()
        ).toMinutes();

        long hours = Math.max(1, (minutes + 59) / 60);

        return hours * 20.0;
    }
}
