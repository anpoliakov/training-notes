import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestRun {
    private static BlockingQueue queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();
    }

    private static void produce() throws InterruptedException {
        Random random = new Random(100);

        while (true){
            queue.put(random.nextInt());
        }
    }

    private static void consumer() throws InterruptedException {
        while (true){
            Thread.sleep(100);

            System.out.println(queue.take());
            System.out.println("Queue size is " + queue.size());
        }
    }
}