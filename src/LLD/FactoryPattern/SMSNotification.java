package LLD.FactoryPattern;

// Concrete Product
public class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("This message is coming from SMS Notification " + message);
    }

}
