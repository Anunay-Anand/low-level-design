package LLD_Interview_Problems.Notification_Service;

import java.util.Map;

public class DomainEvent {
    private String id;
    private String tenantId;
    private String userId;
    private String destination;
    private EventType type;
    private ChannelType channelType;
    Map<String, String> payload;

    public DomainEvent(String id, String tenantId, String userId, String destination, EventType type, ChannelType channelType, Map<String, String> payload) {
        this.id = id;
        this.tenantId = tenantId;
        this.userId = userId;
        this.type = type;
        this.destination = destination;
        this.channelType = channelType;
        this.payload = payload;
    }

    boolean validate() {
        return tenantId != null
                && userId != null
                && type != null
                && payload != null
                && id != null;
    }

    public String getId() {
        return id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getUserId() {
        return userId;
    }

    public EventType getType() {
        return type;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public String getDestination() {
        return destination;
    }

    public ChannelType getChannelType() {
        return channelType;
    }
}
