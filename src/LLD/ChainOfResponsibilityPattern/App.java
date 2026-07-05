package LLD.ChainOfResponsibilityPattern;

public class App {
    public static void main(String[] args) {
        // Create handlers
        BaseHandler auth = new AuthHandler();
        BaseHandler authorization = new AuthorizationHandler();
        BaseHandler rateLimit = new RateLimitHandler();
        BaseHandler validation = new ValidationHandler();
        BaseHandler businessLogic = new BusinessLogicHandler();

        // Build the chain
        auth.setNext(authorization);
        authorization.setNext(rateLimit);
        rateLimit.setNext(validation);
        validation.setNext(businessLogic);

        // Send a valid request through the chain
        Request request = new Request("john", "ADMIN", 10, "{ \"data\": \"valid\" }");
        auth.handle(request);

        System.out.println("\n--- Trying an invalid request ---");
        Request badRequest = new Request(null, "USER", 150, "");
        auth.handle(badRequest);
    }
}
