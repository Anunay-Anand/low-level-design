package LLD.FactoryPattern;

// Concrete Product
public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("You have an Email Notification " + message);
    }
}
