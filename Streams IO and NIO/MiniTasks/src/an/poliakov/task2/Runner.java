package an.poliakov.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Задание: напишите Java-программу для получения определенных файлов по расширениям из указанной папки
 *
 *
 * **/
public class Runner {
    public static void main(String[] args) {
        ArrayList<String> filesWithExpansion = analyze(getPathInSystem(), getSearchExpansion());
        filesWithExpansion.stream().
                filter(n->n != null).
                forEach(n-> System.out.println(n));
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
    private static ArrayList <String> analyze(File file, String expansion){
        ArrayList <String> listFileWithExpansion = new ArrayList<>();

        String[] list = file.list();
        for(int i = 0; i < list.length; i++){
            if(list[i].endsWith(expansion)){
                listFileWithExpansion.add(list[i]);
            }
        }

        return listFileWithExpansion;
    }
}
