package MultiThreading.Executors;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;


public class NumberMagic {
    static int number = 0;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner myObj = new Scanner(System.in);
        boolean flag;

        do {
            System.out.print("Enter an integer number: ");
            try {
                number = Integer.parseInt(myObj.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Not a valid integer");
                flag = true;
            }
        } while(flag);

        /* Write code here to create the 3 tasks:
            1. calculating the square root
            2. calculating the factorial, of the given number
            3.represent the number in binary form
            and execute them using an executor service
            Hint: you've seen 4 task execution methods during demos.
                  Decide which task execution method is suitable in this case. */

        ExecutorService mathExecutorService = Executors.newFixedThreadPool(3);
        int binaryForm;

        Callable<Double> findSqrt = () -> {
          double sqrt = Math.sqrt(number);
          return sqrt;
        };

        Callable<BigInteger> findFactorial = () -> {
            BigInteger fact = BigInteger.ONE;
            for(int i=2; i<=number; i++) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }
            return fact;
        };

        Callable<String> showBinary = () -> {
            String binary = Integer.toBinaryString(number);
            return binary;
        };

        Future<Double> sqrt = mathExecutorService.submit(findSqrt);
        Future<BigInteger> fact = mathExecutorService.submit(findFactorial);
        Future<String> binary = mathExecutorService.submit(showBinary);

        List<Future<?>> myFutures = Arrays.asList(sqrt, fact, binary);

        for (Future<?> future : myFutures) {
            try {
                System.out.println("Answer -> " + future.get());
            } catch (InterruptedException e) {
                // Restore interrupted state
                Thread.currentThread().interrupt();
                System.err.println("Task was interrupted");
            } catch (ExecutionException e) {
                System.err.println("Task threw an exception: " + e.getCause());
            }
        }

        mathExecutorService.shutdown();
    }
}
