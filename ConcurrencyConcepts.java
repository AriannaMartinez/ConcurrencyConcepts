package cscAM;

public class ConcurrencyConcepts {
    public static void main(String[] args) {
        Thread threadOne = new Thread(() -> {        // module 5
            for (int i = 1; i <= 20; i++) {
                System.out.println("Thread-1: " + i);
                try {
                    Thread.sleep(500);               // basic delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadTwo = new Thread(() -> {
            try {
                threadOne.join();                    // the join will make it so that it waits for Thread-1 to finish.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 20; i >= 0; i--) {
                System.out.println("Thread-2: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadOne.setName("Thread-1");
        threadTwo.setName("Thread-2");

        threadOne.start();
        threadTwo.start();
    }
}