package MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class StepTwoSolution {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Write code for the Task 02 solution here
        CompletableFuture<String> binaryString = CompletableFuture.supplyAsync(() -> {
            try {
                return new SumOfEvenTask().call();
            } catch (Exception e) {
                throw new CompletionException(e); // Wrap checked exception for CompletableFuture
            }
        }).thenApply(Integer::toBinaryString);

        System.out.println("The sum of even in binary " + binaryString.get());
    }
}
