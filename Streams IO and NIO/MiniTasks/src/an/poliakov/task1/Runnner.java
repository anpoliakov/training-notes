package an.poliakov.task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Задача: Вывести на консоль внутреннюю структуру папок, по переданному пути
 * Решение: через Path (чуть труднее) и File (просто)
 *
 * Если необходимо как то работать с тем что внутри директории при помощи Path,
 * используем статический метод Files.walkFileTree()
 * **/
public class Runnner {
    public static void main(String[] args) {
        Path path = getPathInSystem();
        showAllFilesUsePath(path);
        showAllFilesUseFie(path);
    }

    //Получение пути и его обработка
    private static Path getPathInSystem(){
        System.out.println("Введите абсолютный путь, что бы получить всю внутрянку каталога:");
        Scanner scanner = new Scanner(System.in);
        String pathString = scanner.nextLine().trim();
        Path path = Paths.get(pathString).normalize();
        return path;
    }

    //PATH
    private static void showAllFilesUsePath(Path path) {
        System.out.println("--- ВЫВОД при помощи интерфейса Path ---");
        try {
            DirectoryStream <Path> entries = Files.newDirectoryStream(path);
            for(Path p : entries){
                System.out.println(p.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //FILE
    private static void showAllFilesUseFie(Path path) {
        System.out.println("--- ВЫВОД при помощи класса File ---");
        File file = path.toFile();
        String[] list = file.list();
        for(String str : list){
            System.out.println(str);
        }
    }
}
