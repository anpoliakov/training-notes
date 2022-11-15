package lesson_9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* Пример работы с классом ReentrantLock - аналог synchronized,
* только с некоторыми особенностями + метод unlock() всегда прописываем в finally блоке!
* так как если в методе выше произойдёт ошибка - lock останется всегда захваченным
* */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TestForThreads test = new TestForThreads();

        Thread td1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.counerThread1();
            }
        });

        Thread td2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.counerThread2();
            }
        });

        td1.start();
        td2.start();

        td1.join();
        td2.join();

        test.showCounter();
    }
}

class TestForThreads{
    private int counter;
    /* Непосредственно сам класс, главные местоды которого: lock() и unlock() */
    private Lock lock = new ReentrantLock();

    public void incNumber(){
        for(int i = 0; i < 10000; i++){
            counter++;
        }
    }

    public void counerThread1(){
        //сколько раз вызовем метод lock(), столько раз должны вызвать метод unlock() в данном потоке - что бы отпустить lock
        lock.lock(); //берёт в пользование монитор
        try {
            incNumber();
        }finally {
            lock.unlock(); //отпускает (другой поток может завладеть)
        }
    }

    public void counerThread2(){
        lock.lock();
        try {
            incNumber();
        }finally {
            lock.unlock();
        }
    }

    public void showCounter(){
        System.out.println("Number = " + counter);
    }
}
