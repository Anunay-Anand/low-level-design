package MultiThreading.CakeVoting;

import java.util.List;

/**
 * Contains code that represents the voting process.
 * It will keep track of what cake designs are getting votes.
 */

public class VotingRunnable implements Runnable { // Ch02-Step 1 - Implement class by the Runnable interface

    private Design d;
    public volatile boolean doStop = false; // Will be used in chapter 3 challenge

    public VotingRunnable(Design d) {
        this.d = d;
    }

    // Ch02-Step 2 - Override the run() method
    @Override
    public void run() {
        while(!doStop) {
            List<Long> votes = d.getVotes();
            votes.add(1L);
            System.out.println("Voting going on for design " + d.getName());

            Double sleepFor = Math.random() * 1000;

            try {
                Thread.sleep(sleepFor.longValue());
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
