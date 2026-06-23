package threads;

public class EvenOddThreads {
    int counter=1;
    int limit=10;

    private void printOdd(){
        synchronized (this) {
            while (counter < limit) {
                //wait if it's an even thread
                if (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("Odd thread " + counter);
                counter++;
                notify();
            }
        }
    }

    private void printEven(){
        synchronized (this) {
            while (counter <= limit) {
                //wait if it's an odd thread
                if (counter % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("Even thread " + counter);
                counter++;
                notify();
            }
        }
    }

    public static void main(String args[]){
        EvenOddThreads evenOddThreads= new EvenOddThreads();
        Thread t1 = new Thread(evenOddThreads::printEven);
        Thread t2 = new Thread(evenOddThreads::printOdd);

        t1.start();
        t2.start();
    }
}