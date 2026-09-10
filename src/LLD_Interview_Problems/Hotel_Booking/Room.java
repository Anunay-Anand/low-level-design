package LLD_Interview_Problems.Hotel_Booking;

import LLD_Interview_Problems.Hotel_Booking.StatusIndicators.RoomStatus;
import LLD_Interview_Problems.Hotel_Booking.StatusIndicators.RoomType;

import static LLD_Interview_Problems.Hotel_Booking.StatusIndicators.RoomStatus.AVAILABLE;

public class Room {
    private final int id;
    private final RoomType type;
    private RoomStatus status;

    public Room(int id, RoomType type, RoomStatus status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public boolean isAvailable() {
        return status == RoomStatus.AVAILABLE;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public RoomType getType() {
        return type;
    }
}
