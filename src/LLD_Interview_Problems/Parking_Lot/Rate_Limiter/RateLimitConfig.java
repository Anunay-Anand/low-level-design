package LLD_Interview_Problems.Parking_Lot.Rate_Limiter;

public class RateLimitConfig {
    private final int capacity;
    private final double refillRate;

    public RateLimitConfig(int capacity, double refillRate) throws IllegalAccessException {
        if(capacity <= 0 || refillRate <= 0) {
          throw new IllegalAccessException("The Capacity and Refill Rate is Invalid!");
        }

        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getRefillRate() {
        return refillRate;
    }
}
