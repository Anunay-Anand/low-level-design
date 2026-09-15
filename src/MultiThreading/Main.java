package MultiThreading;

public class Main {
    public static void main(String[] args) {
        Runnable loop = new MyRunnable();
        Thread myThread = new Thread(loop);

        myThread.start();
    }
}
