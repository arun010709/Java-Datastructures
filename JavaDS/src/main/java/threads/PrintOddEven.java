package threads;

public class PrintOddEven {
    public int counter=1;
    public final int limit=10;

    public void printOdd(){
        synchronized (this){
            while (counter < limit){
                while (counter%2==0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Odd Thread: " + counter);
                counter++;
                notify();
            }
        }

    }
    public void printEven(){
        synchronized (this){
            while (counter <= limit){
                while (counter % 2 != 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Even thread: "+ counter);
                counter++;
                notify();
            }
        }

    }
    public static void main(String[] args) {
        PrintOddEven printOddEven = new PrintOddEven();

        Thread t1 = new Thread(printOddEven::printOdd);
        Thread t2 = new Thread(printOddEven::printEven);

        t1.start();
        t2.start();
    }
}
