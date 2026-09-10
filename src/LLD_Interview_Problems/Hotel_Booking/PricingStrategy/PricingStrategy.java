package LLD_Interview_Problems.Hotel_Booking.PricingStrategy;

import LLD_Interview_Problems.Hotel_Booking.Room;

import java.time.LocalDate;

public interface PricingStrategy {
    double calculateAmount(Room room, LocalDate checkIn, LocalDate checkOut) throws IllegalAccessException;
}
