package LLD_Interview_Problems.Hotel_Booking.PricingStrategy;

import LLD_Interview_Problems.Hotel_Booking.Room;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BasePricing implements PricingStrategy {
    @Override
    public double calculateAmount(Room room, LocalDate checkIn, LocalDate checkOut) throws IllegalAccessException {
        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);

        double pricingPerNight;

        switch (room.getType()) {
            case SINGLE -> pricingPerNight = 2000;
            case DOUBLE -> pricingPerNight = 4000;
            case SUITE -> pricingPerNight = 100000;
            default -> throw new IllegalAccessException("Room type not correct");
        }

        return nights * pricingPerNight;
    }
}
