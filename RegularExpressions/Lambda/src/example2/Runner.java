package example2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Разбор переданной строки двухмерного массива
 *
 * **/
public class Runner {
    private static int[][] map;

    public static void main(String[] args) {
        String str = "{{1,4,5},{2,3,1},{4,4,4},{2,1,1},{4,4,4}}";
        List <String[]> allRows = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\{(\\d+,*)+\\}");
        Matcher matcher = pattern.matcher(str);

        //узнаю кол-во строк в массиве
        while (matcher.find()){
            String row = matcher.group();
            row = row.substring(1,row.length() - 1);
            String[] columns = row.split(",");
            allRows.add(columns);
        }

        map = new int[allRows.size()][allRows.get(0).length];

        //заполняем двухмерный массив
        for (int n = 0; n < allRows.size(); n++){
            String[] columns = allRows.get(n);

            for (int m = 0; m < allRows.get(0).length; m++){
                map[n][m] = Integer.parseInt(columns[m]);
            }
        }

        System.out.println("Двухмерный массив: ");
        for (int n = 0; n < allRows.size(); n++){
            for (int m = 0; m < allRows.get(0).length; m++){
                System.out.print(map[n][m]);
            }
            System.out.println("");
        }
    }
}
