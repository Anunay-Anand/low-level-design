package LLD.AdapterPattern;

public class LegacyGatewayAdapter implements PaymentProcessor {

    private final LegacyGateway legacyGateway;
    private long currentRef;

    public LegacyGatewayAdapter(LegacyGateway legacyGateway) {
        this.legacyGateway = legacyGateway;
    }

    public void processPayment(double amount, String currency) {
        System.out.println("Adapter: Translating processPayment() for " + amount + " " + currency);
        legacyGateway.executeTransaction(amount, currency);
        currentRef = legacyGateway.getReferenceNumber(); // Store for later use
    };

    public boolean isPaymentSuccessful() {
        return legacyGateway.checkStatus(currentRef);
    };

    public String getTransactionId() {
        return "TXN_ID" + currentRef;
    };
}
