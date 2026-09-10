package LLD_Interview_Problems.Hotel_Booking;

import LLD_Interview_Problems.Hotel_Booking.StatusIndicators.PaymentStatus;

public class Payment {
    private final String id;
    private final double amount;
    private PaymentStatus status;

    public Payment(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    // Simulating Payment
    public boolean process() {
        status = PaymentStatus.SUCCESS;
        return true;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
