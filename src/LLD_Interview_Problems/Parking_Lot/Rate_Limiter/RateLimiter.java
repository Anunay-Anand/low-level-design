package LLD_Interview_Problems.Parking_Lot.Rate_Limiter;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    private final RateLimitConfig config;
    private final Map<String, TokenBucket> buckets;

    public RateLimiter(RateLimitConfig config) {
        this.config = config;
        this.buckets = new HashMap<>();
    }

    public boolean isAllowed(String clientId) throws IllegalAccessException {
        if(clientId == null || clientId.isBlank()) {
            throw new IllegalAccessException("Client Id cannot be empty");
        }

        TokenBucket bucket = buckets.get(clientId);

        if(bucket == null) {
            bucket = new TokenBucket(config);

            buckets.put(clientId, bucket);
        }

        return bucket.allowRequest();
    }
}
