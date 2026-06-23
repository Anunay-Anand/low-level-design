package LLD.AdapterPattern;

public class Client {
    public static void main(String[] args) {
        // Modern Processor
        CustomPaymentProcessor processor = new CustomPaymentProcessor();
        CheckoutService checkoutService = new CheckoutService(processor);
        checkoutService.checkout(20, "USD");

        // Legacy gateway through adapter
        System.out.println("\n--- Using Legacy Gateway via Adapter ---");
        LegacyGateway legacy = new LegacyGateway();
        LegacyGatewayAdapter legacyProcessor = new LegacyGatewayAdapter(legacy);
        CheckoutService checkoutServiceNew = new CheckoutService(processor);
        checkoutServiceNew.checkout(30, "EU");
    }
}
