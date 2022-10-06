package an.poliakov.task3;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * RandomAccessFile - класс позволяющий произвольно перемещаться по файлу (записывать и
 * считывать с любого места). При помощи метода seek(кл-во байт).
 *
 * Задача: написать свой собственный фильтр для вывода заданного формата файла
 * Решение: пишем свой класс фильтр и implements FileFilter
 *
 * **/
public class Runner {
    public static void main(String[] args) {
        File file = new File("src/an/poliakov");

        List<Integer> list = new ArrayList<>();
        Integer max = Collections.max(list);

        //вывод ВСЕГО по указанному пути
        String[] allList = file.list();
        System.out.println("Весь список:");
        for(String s : allList){
            System.out.println(s);
        }

        //вывод файлов с УКАЗАННЫМИ расширениями (собственно сам ФИЛЬТР)
        File[] fileOfFilter = file.listFiles(new MyFilter(new String[]{"txt","mms"}));
        System.out.println("\nОтсортированный список:");
        for(File f : fileOfFilter){
            System.out.println(f.getName());
        }
    }
}
