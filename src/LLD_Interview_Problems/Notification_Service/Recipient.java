package LLD_Interview_Problems.Notification_Service;

public class Recipient {
    private String userId;
    private ChannelType channelType;
    private String destination;

    public Recipient(
            String userId,
            ChannelType channelType,
            String destination) {

        this.userId = userId;
        this.channelType = channelType;
        this.destination = destination;
    }

    public boolean isValid() {
        return userId != null
                && channelType != null
                && destination != null;
    }

    public String getUserId() {
        return userId;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public String getDestination() {
        return destination;
    }

}
