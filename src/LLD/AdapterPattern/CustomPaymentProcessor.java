package LLD.AdapterPattern;

public class CustomPaymentProcessor implements PaymentProcessor {

    private String transactionId;
    private boolean paymentSuccesful;

    public void processPayment(double amount, String currency) {
        System.out.println("Custom payment Processor " + amount + " " + currency);
        transactionId = "TXN_" + System.currentTimeMillis();
        paymentSuccesful = true;
        System.out.println("Custom Payment Processor : Success : Transaction ID " + transactionId);
    };

    public boolean isPaymentSuccessful() {
        return paymentSuccesful;
    };

    public String getTransactionId() {
        return transactionId;
    };
}
