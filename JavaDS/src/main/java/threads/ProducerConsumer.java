package threads;

import java.util.LinkedList;

public class ProducerConsumer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private final int CAPACITY = 5;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                // 1. Wait if buffer is full
                while (buffer.size() == CAPACITY) {
                    wait();
                }

                System.out.println("Producer produced: " + value);
                buffer.add(value++);

                // 2. Notify the consumer that there is data
                notify();

                Thread.sleep(1000); // Simulating time taken to produce
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                // 1. Wait if buffer is empty
                while (buffer.size() == 0) {
                    wait();
                }

                int val = buffer.removeFirst();
                System.out.println("Consumer consumed: " + val);

                // 2. Notify the producer that there is space
                notify();

                Thread.sleep(1000); // Simulating time taken to consume
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread t1 = new Thread(() -> {
            try { pc.produce(); } catch (InterruptedException e) {}
        });

        Thread t2 = new Thread(() -> {
            try { pc.consume(); } catch (InterruptedException e) {}
        });

        t1.start();
        t2.start();
    }
}