package portfolio;

public class Portfolio2Counter {

	// First thread counts from 1 to 20
    public static void countUp() {
        System.out.println("Thread 1: Counting up");

        for (int i = 1; i <= 20; i++) {
            System.out.println(i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("Thread 1 finished.");
    }

    // Second thread counts from 20 down to 0
    public static void countDown() {
        System.out.println("Thread 2: Counting down");

        for (int i = 20; i >= 0; i--) {
            System.out.println(i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("Thread 2 finished.");
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(
            Portfolio2Counter::countUp
        );

        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        Thread thread2 = new Thread(
            Portfolio2Counter::countDown
        );

        thread2.start();

        try {
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println("Both threads have finished.");
    }
}