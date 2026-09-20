package MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class StepThreeSolution {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Write code for the Task 03 solution here
        CompletableFuture<Integer> squareOfSum = CompletableFuture.supplyAsync(() -> {
            try {
                return new SumOfEvenTask().call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).thenCompose(result -> CompletableFuture.supplyAsync(() -> {
            return result * result;
        }));

        System.out.println("Sum of even numbers squared: " + squareOfSum.get());
    }
}
