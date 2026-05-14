package threads;

public class EvenOddThreads {
    private int counter = 1;
    private final int limit = 10;

    // Method for the Odd thread
    public void printOdd() {
        synchronized (this) {
            while (counter < limit) {
                while (counter % 2 == 0) { // Wait if the counter is even
                    try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
                }
                System.out.println("Odd Thread: " + counter);
                counter++;
                notify(); // Wake up the Even thread
            }
        }
    }

    // Method for the Even thread
    public void printEven() {
        synchronized (this) {
            while (counter <= limit) {
                while (counter % 2 != 0) { // Wait if the counter is odd
                    try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
                }
                System.out.println("Even Thread: " + counter);
                counter++;
                notify(); // Wake up the Odd thread
            }
        }
    }

    public static void main(String[] args) {
        EvenOddThreads resource = new EvenOddThreads();

        Thread t1 = new Thread(resource::printOdd);
        Thread t2 = new Thread(resource::printEven);

        t1.start();
        t2.start();
    }
}