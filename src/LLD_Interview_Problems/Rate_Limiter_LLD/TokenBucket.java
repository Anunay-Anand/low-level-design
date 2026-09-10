package LLD_Interview_Problems.Rate_Limiter_LLD;

public class TokenBucket {
    private final int capacity;
    private final double refillRate;
    private double tokens;
    private long lastRefillTime;

    public TokenBucket(RateLimitConfig config) {
        this.capacity = config.getCapacity();
        this.refillRate = config.getRefillRate();
        this.tokens = capacity;
        this.lastRefillTime = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        refill();

        if(tokens >= 1) {
            tokens--;
            return true;
        }

        return false;
    }

    public void refill() {
        long now = System.nanoTime();

        double elaspedTime = (now - lastRefillTime)/1000_000_000.0;

        double newTokens = elaspedTime * refillRate;

        tokens = Math.min(capacity, tokens + newTokens);

        lastRefillTime = now;
    }
}
