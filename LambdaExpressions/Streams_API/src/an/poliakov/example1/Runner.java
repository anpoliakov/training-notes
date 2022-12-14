package an.poliakov.example1;

import an.poliakov.example1.funcInterfaces.FuncSummator;
import an.poliakov.example1.funcInterfaces.FunctionalInterfaceOne;

/**
 * Основные сведения об функциональных интерфейсах:
 * -метод в функ интерфейсе должен быть один abstract (может содержать static и default методы)
 * -метод функц интерфейса может возвращать значение и принимать параметры
 * -можно использовать однострочное лямбда выражение и многострочное {} в последнем обязательно использование return
 * -внутри лямбда функции нельзя изменять переменные метода! Только переменные класса!
 * */

public class Runner {
    int val1 = 5; //попробуем изменить в лямбда выражении (успешно)

    public static void main(String[] args) {
        Runner e = new Runner();
        int val2 = 10; //попробуем изменить в лямбда выражении (ошибка)

        //пример параметризированного функционального интерфейса
        FunctionalInterfaceOne <String> fun = str -> System.out.println(str); //описание работы метода интерфейса
        fun.printStr("Вывод строки из метода функционального интерфейса");    //вызов метода и его работа

        //пример многострочной лямбды
        FuncSummator fansum = (a, b) -> {
            //val2 = 7; - изменить переменную метода в лямбде не получится!

            int i = 0;
            int result = 0;
            while (i < 5){
                result += a + b + i;
                i++;
            }
            return result;
        };
        System.out.println(fansum.sum(1,1));
        System.out.println(val2);
    }
}
