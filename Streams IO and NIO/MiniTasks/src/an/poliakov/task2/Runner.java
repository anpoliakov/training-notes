package an.poliakov.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Задание: напишите Java-программу для получения определенных файлов по расширениям из указанной директории
 * а так же выведите размер в байтах/килобайтах/мегабайтах!
 *
 *
 * **/
public class Runner {
    public static void main(String[] args) {
        ArrayList<File> filesWithExpansion = analyze(getPathInSystem(), getSearchExpansion());
        filesWithExpansion.stream().
                filter(n->n != null).
                forEach(n-> System.out.println(
                        "Name file: " + n.getName() + " [" + n.length() + " -byte][" + (n.length()/1024) + " -kb][" + (n.length()/(1024*1024)) + " -mb]"
                ));
    }

    //Получение из консоли пути для поиска
    private static File getPathInSystem(){
        System.out.println("Введите абсолютный путь, что бы получить всю внутрянку каталога:");
        Scanner scanner = new Scanner(System.in);
        String pathString = scanner.nextLine().trim();
        File file = new File(pathString);
        return file;
    }

    //Получение из консоли искомого расширения и его обработка
    private static String getSearchExpansion(){
        System.out.println("Введите искомое расшерение: ");
        Scanner scanner = new Scanner(System.in);
        String expansion = scanner.nextLine().trim();
        return expansion.toLowerCase().trim();
    }

    //Поиск в директории файлов с нужным расширением
    private static ArrayList <File> analyze(File file, String expansion){
        ArrayList <File> listFileWithExpansion = new ArrayList<>();

        File[] files = file.listFiles();
        for(int i = 0; i < files.length; i++){
            if(files[i].getName().endsWith(expansion)){
                listFileWithExpansion.add(files[i]);
            }
        }

        return listFileWithExpansion;
    }
}
