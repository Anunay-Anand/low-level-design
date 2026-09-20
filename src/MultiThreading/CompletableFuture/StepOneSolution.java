package MultiThreading.CompletableFuture;

import MultiThreading.FutureObject.TimeConsumingTask;

import java.util.concurrent.*;

public class StepOneSolution {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Write code for the Task 01 solution here
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long startTime = System.nanoTime();

        // Place your solution code here
        Future<Integer> sumOfEven = executorService.submit(new SumOfEvenTask());
        Future<Integer> sumOfSquares = executorService.submit(new SumOfSquaresTask());

        while (!sumOfEven.isDone() && !sumOfSquares.isDone()) {
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.printf("The sum of even is %d \n", sumOfEven.get());
        System.out.printf("The square sum is %d \n", sumOfSquares.get());

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Both tasks finished in " + (elapsedTime/1000000)/1000 + " seconds");

        // Don't forget to shut down the executor service once you are done
        executorService.shutdown();
    }
}
