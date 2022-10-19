package example2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Вариант при котором мы можем преедать даже не правельный двухмерный String массив
 * **/
public class RunnerBuf {
    // {{1,2,3},{3},{1,,3}}
    public static void main(String[] args) {
        System.out.println("Введите двухмерный массив:");
        Scanner sc = new Scanner(System.in);
        String consoleData = sc.nextLine();

        if(consoleData.matches("\\{(\\{(\\d*,*){1,3}\\},*){2,}\\}")){
            getInsideMass(consoleData);
        }
    }

    public static String[] getInsideMass(String consoleData){
        String withoutOutsideBraces = consoleData.substring(1, consoleData.length() - 1);
        Pattern pattern = Pattern.compile("\\{(\\d*,*){1,3}\\}");
        Matcher matcher = pattern.matcher(withoutOutsideBraces);

        while (matcher.find()){
            String [] mas = matcher.group().substring(1, matcher.group().length() - 1).split(",");
            System.out.println(matcher.group() + " и его размер = " + mas.length);
        }
        return null;
    }
}
