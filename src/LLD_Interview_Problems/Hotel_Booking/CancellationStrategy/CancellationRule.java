package LLD_Interview_Problems.Hotel_Booking.CancellationStrategy;

import LLD_Interview_Problems.Hotel_Booking.Booking;

public interface CancellationRule {
    boolean canCancel(Booking booking);
    double refundAmount(Booking booking);
}
