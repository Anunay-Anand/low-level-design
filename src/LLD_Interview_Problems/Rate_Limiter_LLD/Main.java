package LLD_Interview_Problems.Rate_Limiter_LLD;

public class Main {
    public static void main(String args[]) throws IllegalAccessException, InterruptedException {
        RateLimitConfig config = new RateLimitConfig(3, 1);
        RateLimiter rateLimiter = new RateLimiter(config);

        String client_id = "123";

        System.out.println(rateLimiter.isAllowed(client_id));

        System.out.println(
                rateLimiter.isAllowed(client_id)
        );

        System.out.println(
                rateLimiter.isAllowed(client_id)
        );

        // Fourth request should fail.
        System.out.println(
                rateLimiter.isAllowed(client_id)
        );

        // Wait for one token to refill.
        Thread.sleep(1100);

        System.out.println(
                rateLimiter.isAllowed(client_id)
        );
    }
}
