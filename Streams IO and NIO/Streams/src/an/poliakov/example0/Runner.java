package an.poliakov.example0;

import java.io.*;

/**
 * Работа с байтовыми потоками при помощи класса FileInputStream
 * **/
public class Runner {
    public static void main(String[] args) {
        /** СЧИТЫВАНИЕ БАЙТОВ ИЗ ПОТОКА **/
        File file = new File("src/an/poliakov/filesForTests/basicFile.txt");
        InputStream fis = null;

        try {
            fis = new FileInputStream(file);
            int myByte;

            /** считываем в переменную int - но значение всёравно будет byte
             *  так как работаем с байтовым потоком, кодировка руских символов
             *  будет отображаться не верно, по это при работе с текстом испоьзуем
             *  символьные потоки
             * **/
            while ((myByte = fis.read()) != -1){
                System.out.print((char) myByte);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // не забываем закрыть поток
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        /** ЗАПИСЬ БАЙТОВ В ПОТОК **/
        File fileOutput = new File("src/an/poliakov/filesForTests/fileOutput.txt");
        String str = "Записываемый текст в файл. The text is writing in a file";
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(fileOutput);
            fos.write(str.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
