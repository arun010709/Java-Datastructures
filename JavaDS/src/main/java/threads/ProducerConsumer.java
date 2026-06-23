package threads;

import java.util.LinkedList;

public class ProducerConsumer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private final int CAPACITY = 5;

    private void produce() {
        int value = 0;
        while (true) {
            synchronized (this) {
                // 1. Wait if buffer is full
                while (buffer.size() == CAPACITY) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("Producer produced: " + value);
                buffer.add(value++);

                // 2. Notify the consumer that there is data
                notify();
            }

            try {
                Thread.sleep(1000); // Simulating time taken to produce
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }

    private void consume() {
        while (true) {
            synchronized (this) {
                // 1. Wait if buffer is empty
                while (buffer.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                int val = buffer.removeFirst();
                System.out.println("Consumer consumed: " + val);

                // 2. Notify the producer that there is space
                notify();
            }

            try {
                Thread.sleep(1000); // Simulating time taken to consume
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread producerThread = new Thread(producerConsumer::produce);

        Thread consumerThread = new Thread(producerConsumer::consume);

        producerThread.start();
        consumerThread.start();
    }
}