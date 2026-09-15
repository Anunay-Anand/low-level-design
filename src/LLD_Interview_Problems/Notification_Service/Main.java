package LLD_Interview_Problems.Notification_Service;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> payload = new HashMap<>();
        payload.put("requestId", "REQ-101");
        payload.put("employeeName", "Anunay");

        DomainEvent event = new DomainEvent(
                "TIME_OFF_REQUESTED",
                "TENANT-001",
                "TEAMS",
                "USER-101",
                EventType.TIME_OFF_REQUESTED,
                ChannelType.TEAMS_CHANNEL,
                payload);

        NotificationService service =
                new NotificationService();

        service.processEvent(event);
    }
}
