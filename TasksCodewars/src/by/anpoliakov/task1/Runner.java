package by.anpoliakov.task1;

import java.util.Arrays;

/*
* Задача по определению анаграммы двух слов поданных на вход
* */
public class Runner {
    public static void main(String[] args) {
        System.out.println(isAnagram("apple","pale"));
        System.out.println(isAnagram("foefet", "toffee"));
    }

    private static boolean isAnagram(String test, String original) {
        char[] charsWord1 = test.trim().toLowerCase().toCharArray();
        char[] charsWord2 = original.trim().toLowerCase().toCharArray();

        if(test.length() != original.length()){
            return false;
        }

        Arrays.sort(charsWord1);
        Arrays.sort(charsWord2);

        return Arrays.equals(charsWord1,charsWord2);
    }
}
