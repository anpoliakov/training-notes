package an.poliakov.example1;

import an.poliakov.example1.funcInterfaces.FuncSummator;
import an.poliakov.example1.funcInterfaces.FunctionalInterfaceOne;

/**
 * Основные сведения об функциональных интерфейсах:
 * -метод в функ интерфейсе должен быть один
 * -метод может возвращать значение, а может и нет
 * -кроме лямбда выражения можно писать лямбда блок в {}
 * -есть НЕтерминальное(возвращает какое то значение) и терминальное (ничего не возвращает) лямбда выражения
 * -внутри лямбда функции нельзя изменять переменные метода! Только переменные класса!
 *
 * */

public class RunnerEx1 {
    int val1 = 5; //попробуем изменить в лямбда выражении (успешно)

    public static void main(String[] args) {
        RunnerEx1 e = new RunnerEx1();
        int val2 = 10; //попробуем изменить в лямбда выражении (ошибка)

        //пример терминальной лямбды
        FunctionalInterfaceOne fun = str -> System.out.println(str);
        fun.printStr("Вывод строки из метода функционального интерфейса");

        //пример нетерминальной лямбды и лямда блока
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
