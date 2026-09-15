package LLD_Interview_Problems.Hotel_Booking;

import LLD_Interview_Problems.Hotel_Booking.CancellationStrategy.CancellationRule;
import LLD_Interview_Problems.Hotel_Booking.PricingStrategy.PricingStrategy;
import LLD_Interview_Problems.Hotel_Booking.StatusIndicators.BookingStatus;
import LLD_Interview_Problems.Hotel_Booking.StatusIndicators.PaymentStatus;
import LLD_Interview_Problems.Hotel_Booking.StatusIndicators.RoomType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Hotel {
    private final String id;
    private final String name;
    private final List<Room> rooms;
    private final List<Booking> bookings;

    private final PricingStrategy pricingStrategy;
    private final CancellationRule cancellationRule;


    public Hotel(String id, String name, List<Room> rooms, List<Booking> bookings, PricingStrategy pricingStrategy, CancellationRule cancellationRule) {
        this.id = id;
        this.name = name;
        this.rooms = rooms;
        this.bookings = bookings;
        this.pricingStrategy = pricingStrategy;
        this.cancellationRule = cancellationRule;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getAvailableRooms(RoomType type, LocalDate checkIn, LocalDate checkOut) {
        List<Room> availableRoom = new ArrayList<>();

        for(Room room: rooms) {
            if(room.getType() != type) continue;

            if(!room.isAvailable()) continue;

            if(isRoomAvailable(room, checkIn, checkOut)) {
                availableRoom.add(room);
            }
        }

        return availableRoom;
    }

    public boolean isRoomAvailable(Room room, LocalDate checkIn, LocalDate checkOut) {
        for (Booking booking: bookings) {
            if (booking.isActive()
                    && booking.overlap(checkIn, checkOut) && booking.getRoom() == room) {
               return false;
            }
        }
        return true;
    }

    public Booking bookRoom(String bookingId, Guest guest, Room room, LocalDate checkIn, LocalDate checkOut) throws IllegalAccessException {
        if (!isRoomAvailable(room, checkIn, checkOut)) {
           throw new IllegalArgumentException("Room is not available");
        }

        double price = pricingStrategy.calculateAmount(room, checkIn, checkOut);

        Payment payment = new Payment(UUID.randomUUID().toString(), price);

        if(!payment.process()) {
            payment.setStatus(PaymentStatus.FAILED);
            throw new IllegalStateException("Payment failed");
        }

        Booking booking = new Booking(UUID.randomUUID().toString(), room, guest, checkIn, checkOut, price, BookingStatus.CONFIRMED);

        bookings.add(booking);

        return booking;
    }

    public void cancelBooking(Booking booking) {

        if (!cancellationRule.canCancel(booking)) {
            throw new IllegalStateException(
                    "Cancellation not allowed");
        }

        double refund =
                cancellationRule.refundAmount(booking);

        booking.cancelBooking();

        System.out.println(
                "Refund: " + refund);
    }
}
