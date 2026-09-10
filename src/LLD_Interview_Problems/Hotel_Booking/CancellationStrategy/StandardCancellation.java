package LLD_Interview_Problems.Hotel_Booking.CancellationStrategy;

import LLD_Interview_Problems.Hotel_Booking.Booking;

public class StandardCancellation implements CancellationRule {

    @Override
    public boolean canCancel(Booking booking) {
        return true;
    }

    @Override
    public double refundAmount(Booking booking) {
        return booking.getAmount();
    }
}
