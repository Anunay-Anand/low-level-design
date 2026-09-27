package MultiThreading.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(() -> {
            System.out.println("Thread being used by executor service " + Thread.currentThread().getName());
            System.out.println("This is a runnable for executor service");
        });

        executorService.shutdown();
    }
}
