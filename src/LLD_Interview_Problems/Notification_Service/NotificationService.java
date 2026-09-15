package LLD_Interview_Problems.Notification_Service;

import LLD_Interview_Problems.Notification_Service.NotificationChannels.NotificationChannel;
import LLD_Interview_Problems.Notification_Service.NotificationChannels.TeamsChannel;

import java.util.HashMap;
import java.util.Map;

class NotificationService {

    private final Map<ChannelType, NotificationChannel> channels
            = new HashMap<>();

    public NotificationService() {
        channels.put(ChannelType.TEAMS_CHANNEL, new TeamsChannel());
    }

    public void processEvent(DomainEvent event) {
        if (!event.validate()) {
            throw new IllegalArgumentException("Invalid event");
        }

        Recipient recipient = resolveRecipient(event);

        if (!recipient.isValid()) {
            throw new IllegalArgumentException("Invalid recipient");
        }

        Notification notification = createNotification(event);

        NotificationChannel channel =
                channels.get(recipient.getChannelType());

        if (channel == null) {
            notification.MarkFailed();
            throw new IllegalArgumentException(
                    "Unsupported notification channel");
        }

        boolean sent = channel.send(notification, recipient);

        if (sent) {
            notification.MarkSent();
        } else {
            notification.MarkFailed();
        }

        System.out.println(
                "Notification status: "
                        + notification.getMessage());
    }

    private Recipient resolveRecipient(DomainEvent event) {
        /*
         * In production, recipient information could be fetched
         * from a user directory or database.
         */
        return new Recipient(
                event.getUserId(),
                event.getChannelType(),
                event.getDestination());
    }

    private Notification createNotification(DomainEvent event) {
        String message;

        if ("TIME_OFF_REQUESTED".equals(event.getType().toString())) {
            message = "A time-off request was submitted.";
        } else if ("SHIFT_SWAP_REQUESTED".equals(event.getType().toString())) {
            message = "A shift-swap request was submitted.";
        } else {
            message = "A new workforce event occurred.";
        }

        return new Notification(
                event.getId(),
                message);
    }
}