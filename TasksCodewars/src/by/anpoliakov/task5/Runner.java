package by.anpoliakov.task5;

import java.util.Arrays;
import java.util.Collections;

/*
* Given a random non-negative number, you have to return the digits of this number within an array in reverse order.
* */
public class Runner {
    public static void main(String[] args) {
        Arrays.stream(digitize(567890)).forEach(a -> System.out.print(a));
    }

    public static int[] digitize(long n) {
        String string = String.valueOf(n);
        String[] stringChars = string.split("");
        int [] arr = new int[stringChars.length];

        for(int i = 0; i < stringChars.length; i++){
            arr[i] = Integer.valueOf(stringChars[stringChars.length-1-i]);
        }
        Collections.reverse(Arrays.asList(arr));

        return arr;
    }

}
