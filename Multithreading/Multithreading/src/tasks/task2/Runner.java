package tasks.task2;

import java.io.*;

/* Условие задачи: заданы три целочисленных массива. Записать эти массивы в файлы в паралельних потоках */
public class Runner {
    private static int [] masIntFirst = {1,45,55,2,3,0};
    private static int [] masIntSecond = {1,2,3,4,5,6};
    private static int [] masIntThird = {11,22,33,44,55,66};

    public static void main(String[] args) {
        Thread thFirst = new Thread(new SaveUseThread("firstTxt.txt", masIntFirst, "FirstThread"));
        Thread thSecond = new Thread(new SaveUseThread("secondTxt.txt", masIntSecond, "SecondThread"));
        Thread thThird = new Thread(new SaveUseThread("thirdTxt.txt", masIntThird, "ThirdThread"));

        thFirst.start();
        thSecond.start();
        thThird.start();

        try {
            thFirst.join();
            thSecond.join();
            thThird.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SaveUseThread implements Runnable{
    private String nameFile;
    private int [] saveMas;
    private String nameThread;

    public SaveUseThread(String nameFile, int[] saveMas, String nameThread) {
        this.nameFile = nameFile.replace();
        this.saveMas = saveMas;
        this.nameThread = nameThread;
    }


    @Override
    public void run() {
        System.out.println("Thread: " + nameThread + " starts to work");
        File file = new File("src/tasks/task2/"+nameFile);
        FileOutputStream fos = null;
        PrintStream ps = null;

        try {
            fos = new FileOutputStream(file);
            ps = new PrintStream(fos);
            for (int i : saveMas){
                ps.print(i);
                ps.print(" ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ps.close();
        }

        System.out.println("Thread " + nameThread + " finished!");
    }
}
