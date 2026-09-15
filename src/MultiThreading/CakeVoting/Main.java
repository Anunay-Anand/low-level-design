package MultiThreading.CakeVoting;

public class Main {
    public static void main(String[] args) {
        Design d1 = new Design(1,"D1");
        // Ch02-Step 5 - Create an object of the VotingRunnable & CountingRunnable for design1
        VotingRunnable votingRunnable = new VotingRunnable(d1);
        CountingRunnable countingRunnable = new CountingRunnable(d1);
        // Ch02-Step 6.1 - Create a new Thread instance, passing in the VotingRunnable object for design1
        Thread votingThread = new Thread(votingRunnable);
        // Ch02-Step 6.2 - Create a new Thread instance, passing in the CountingRunnable object for design1
        Thread countingThread = new Thread(countingRunnable);

        // Ch02-Step 7.1 - Start the voting thread for design1
        votingThread.start();
        // Ch02-Step 7.2 - Start the counting thread for design1
        countingThread.start();

        Design d2 = new Design(2,"D2");
        // Ch02-Step 5 - Create an object of the VotingRunnable & CountingRunnable for design1
        VotingRunnable votingRunnable2 = new VotingRunnable(d2);
        CountingRunnable countingRunnable2 = new CountingRunnable(d2);
        // Ch02-Step 6.1 - Create a new Thread instance, passing in the VotingRunnable object for design1
        Thread votingThread2 = new Thread(votingRunnable2);
        // Ch02-Step 6.2 - Create a new Thread instance, passing in the CountingRunnable object for design1
        Thread countingThread2 = new Thread(countingRunnable2);

        // Ch02-Step 7.1 - Start the voting thread for design1
        votingThread2.start();
        // Ch02-Step 7.2 - Start the counting thread for design1
        countingThread2.start();
        Design d3 = new Design(3,"D3");
        // Ch02-Step 5 - Create an object of the VotingRunnable & CountingRunnable for design3
        VotingRunnable votingRunnable3 = new VotingRunnable(d3);
        CountingRunnable countingRunnable3 = new CountingRunnable(d3);
        // Ch02-Step 6.1 - Create a new Thread instance, passing in the VotingRunnable object for design1
        Thread votingThread3 = new Thread(votingRunnable3);
        // Ch02-Step 6.2 - Create a new Thread instance, passing in the CountingRunnable object for design1
        Thread countingThread3 = new Thread(countingRunnable3);

        // Ch02-Step 7.1 - Start the voting thread for design1
        votingThread3.start();
        // Ch02-Step 7.2 - Start the counting thread for design1
        countingThread3.start();

        // Stop main thread for 30 seconds
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        countingRunnable.doStop = true;
        countingRunnable2.doStop = true;
        countingRunnable3.doStop = true;
        votingRunnable.doStop = true;
        votingRunnable2.doStop = true;
        votingRunnable3.doStop = true;

        System.out.println("Voting has stopped for design " + d1.getName());
        System.out.println("Total votes for " + d1.getName() + ": " + d1.getVotes().size());
        System.out.println("Voting has stopped for design " + d2.getName());
        System.out.println("Total votes for " + d2.getName() + ": " + d2.getVotes().size());
        System.out.println("Voting has stopped for design " + d3.getName());
        System.out.println("Total votes for " + d3.getName() + ": " + d3.getVotes().size());
    }
}
