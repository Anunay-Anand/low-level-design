package LLD_Interview_Problems.Notification_Service.NotificationChannels;

import LLD_Interview_Problems.Notification_Service.Notification;
import LLD_Interview_Problems.Notification_Service.Recipient;

public interface NotificationChannel {
    public boolean send(Notification notification, Recipient recipient);
}
