package LLD_Interview_Problems.Hotel_Booking;

import LLD_Interview_Problems.Hotel_Booking.StatusIndicators.BookingStatus;
import LLD_Interview_Problems.Hotel_Booking.StatusIndicators.PaymentStatus;

import java.time.LocalDate;

public class Booking {
    private final String id;
    private final Room room;
    private final Guest guest;
    private final LocalDate checkIn;
    private final LocalDate checkOut;

    private final double amount;
    private BookingStatus status;

    public Booking(String id, Room room, Guest guest, LocalDate checkIn,
                   LocalDate checkOut, double amount, BookingStatus status) {
        this.id = id;
        this.room = room;
        this.guest = guest;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.amount = amount;
        this.status = status;
    }

    public boolean overlap(LocalDate start, LocalDate end) {
        return checkIn.isBefore(start) && checkOut.isBefore(end);
    }

    public double getAmount () {
        return amount;
    }

    public void cancelBooking() {
        this.status = BookingStatus.CANCELLED;
    }

    public boolean isActive() {
        return status == BookingStatus.CONFIRMED;
    }

    public Room getRoom() {
        return room;
    }
}
