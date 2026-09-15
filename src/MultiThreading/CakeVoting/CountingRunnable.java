package MultiThreading.CakeVoting;

import java.util.List;

/**
 * Contains code that represents the counting process.
 * It will keep counting the number of votes each cake design is getting.
 */

public class CountingRunnable implements Runnable { // Ch02-Step 3 - Implement class by the Runnable interface

    private Design d;
    public volatile boolean doStop = false; // Will be used in chapter 3 challenge

    public CountingRunnable(Design d) {
        this.d = d;
    }

    // Ch02-Step 4 - Override the run() method
    @Override
    public void run() {
        while(!doStop) {
            List<Long> votes = d.getVotes();
            System.out.println("The current vote count is - " + votes.size());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
