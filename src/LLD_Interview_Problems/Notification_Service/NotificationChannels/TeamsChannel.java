package LLD_Interview_Problems.Notification_Service.NotificationChannels;

import LLD_Interview_Problems.Notification_Service.Notification;
import LLD_Interview_Problems.Notification_Service.Recipient;

public class TeamsChannel implements NotificationChannel {

    @Override
    public boolean send(Notification notification, Recipient recipient) {

            System.out.println(
                    "Sending Teams notification to: "
                            + recipient.getDestination());

            System.out.println(
                    "Message: " + notification.getMessage());

            // Actual Teams API call would be made here.
            return true;
    }
}
