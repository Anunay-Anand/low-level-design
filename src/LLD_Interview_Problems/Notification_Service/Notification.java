package LLD_Interview_Problems.Notification_Service;

import java.time.Instant;
import java.util.UUID;

public class Notification {
    private final String notificationId;
    private final String eventId;
    private final String message;
    private final Instant createdAt;

    private NotificationStatus status;

    public Notification(
            String eventId,
            String message) {

        this.notificationId = UUID.randomUUID().toString();
        this.eventId = eventId;
        this.message = message;
        this.createdAt = Instant.now();
        this.status = NotificationStatus.CREATED;
    }

    public String getMessage() {
        return message;
    }

    public void MarkSent() {
        this.status = NotificationStatus.SENT;
    }

    public void MarkFailed() {
        this.status = NotificationStatus.FAILED;
    }

    public NotificationStatus getStatus() {
        return status;
    }
}
