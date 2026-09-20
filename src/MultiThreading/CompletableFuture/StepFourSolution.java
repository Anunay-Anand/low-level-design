package MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class StepFourSolution {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Write code for the Task 04 solution here
        CompletableFuture<Integer> futureResult = CompletableFuture.supplyAsync(() -> {
            try {
                return new SumOfEvenTask().call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                return new SumOfSquaresTask().call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }), Integer::sum);

        System.out.printf("The result is %d", futureResult.get());
    }
}
