package example1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {

        /*  Спец. символы:
            \\d (одина цифра)
            \\w (одна буква)

            Если используем их, не как спец символы - то должны поставить \\ перед ними:
            + (1 или более)
            * (0 или более)
            ? (0 или 1 символ - который идёт до этого знака, может быть - а может не быть)

            (x|y|z) - когда задаём так -> то "один из символов" множества x y z
            [a-zA-Z] - все буквы английского алфовита
            [0-9] - все возможные цифры
            [^abc] - отрицание,хотим все символы кроме abc - пример: [^a-c]
            . - любой символ

            {2} - два символа ДО   \\d{2}
            {2,} - два или более символов  \\d{2,}
            {2,4} - от 2 до 4 символов \\d{2,4}

         */

        System.out.println("Первая проверка:");
        String s1 = "-709";
        String s1_1 = "7099";
        System.out.println(s1.matches("(\\+|\\-)?\\d{4}"));
        System.out.println(s1_1.matches("(\\+|\\-)?\\d{4}"));

        System.out.println("\nРазделение str по регулярному выражению:");
        String s7 = "Привет2gСегодня77ggТы7Огонь";
        String [] masStr = s7.split("\\d{1,2}\\w{0,2}");
        System.out.println("Split: " + Arrays.toString(masStr));

        System.out.println("\nЗамена символов:");
        String string1 =  "Hello everywhere my friends";
        String string2 =  "Hello3345everywhere345my345friends";

        String string1new = string1.replace(" ","."); //метод принимает только строку
        String string2new = string2.replaceAll("\\d+","."); //метод принимает регулярное выражение (описание что заменить - патерном)
        String string3new = string2.replaceFirst("\\d+","-"); //заменяет первое встречное совподение
        System.out.println(string1new);
        System.out.println(string2new);
        System.out.println(string3new);

        System.out.println("\nПоиск по патерну с использованием Pattern и Matcher");
        String text = "привет мир 2343а andrew@gmail.com рыба селёдка и не рыба селёдка 322dfghg дом202 и адресс artem@mail.ru";
        Pattern pattern = Pattern.compile("\\w+@(gmail|mail).(com|ru)"); //паттерн по которому будет вестись поиск
        Matcher matcher = pattern.matcher(text); //на созданном паттерне вызываем метод и передаём текст для анализа

        while (matcher.find()){ //если в тексте найдено совподение
            System.out.println(matcher.group()); //то выводим первую группу (можно вывести всё,просто не указывая параметры)
        }
    }
}
