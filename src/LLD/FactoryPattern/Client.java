package LLD.FactoryPattern;

public class Client {

    public static void main(String[] args) {
        NotificationFactory factory = new EmailNotificationFactory();
        Notification notification = factory.createNotification();

        notification.send("message");
    }

}
