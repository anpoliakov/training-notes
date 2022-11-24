package by.anpoliakov.task2;

/*
* Подсчёт гласных букв кроме "Y" в переданном тексте
* */
public class Runner {
    public static void main(String[] args) {
        System.out.println(getCount("abracadabra"));
    }

    //stupid solution
//    private static int getCount(String word) {
//        char [] masVowels = {'a','e','i','o','u'};
//        char[] charsWord = word.trim().toLowerCase().toCharArray();
//        int count = 0;
//
//        if(charsWord.length > 0){
//            for(char c : charsWord){
//                for(char b : masVowels){
//                    if(c == b){
//                        count++;
//                    }
//                }
//            }
//        }
//
//        return count;
//    }

    private static int getCount(String word){
        return word.replaceAll("[^aeiou]","").length();
    }
}
