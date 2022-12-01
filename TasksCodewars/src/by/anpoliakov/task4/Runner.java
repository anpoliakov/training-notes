package by.anpoliakov.task4;

import java.util.Arrays;

/*
* You get an array of numbers, return the sum of all of the positives ones.
* Note: if there is nothing to sum, the sum is default to 0.
* */
public class Runner {
    public static void main(String[] args) {
        int [] mas = {2,5,-1,8};
        System.out.println(sumArr(mas));
    }

    public static int sumArr(int [] arr){
        return Arrays.stream(arr).filter(i -> i > 0).sum();
    }
}
