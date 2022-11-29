package tasks.task4;

/*
* Статусы потоков, во время работы
* */
public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    synchronized (lock){
                        lock.notifyAll();
                        lock.wait();
                    }
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        });

        System.out.println(thread.getState());
        synchronized (lock){
            thread.start();
            System.out.println(thread.getState());
            lock.wait();
            System.out.println(thread.getState());
            lock.notifyAll();
            System.out.println(thread.getState());
        }
    }
}
