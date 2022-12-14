package tasks.task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
  1.Есть транспортные корабли, которые подплывают к туннели и далее плывут к причалам для погрузки разного рода товара.

  2.Они проходят через узкий туннель где одновременно могут находиться только 5 кораблей. Под словом “подплывают к туннели”
       имеется ввиду то, что корабли должны откуда-то появляться. Их может быть ограниченное количество, то есть 10 или 100,
       а может быть бесконечное множество. Слово “Подплывают” назовем генератором кораблей.

  3.Вид кораблей и их вместительность могут быть разными в зависимости от типа товаров, которые нужно загрузить на корабль.
       То есть для ТЗ я придумал 3 Типа кораблей (Хлеб, Банан и Одежда) и три вида вместительности 10, 50, 100 шт. товаров.
       3 типа кораблей * 3 вида вместительности = 9 разных видов кораблей.

  4.Далее есть 3 вида причалов для погрузки кораблей — Хлеб, Банан и Одежда. Каждый причал берет или подзывает к себе
       необходимый ему корабль и начинает его загружать. За одну секунду причал загружает на корабль 10 ед. товара.
       То есть если у корабля вместительность 50 шт., то причал загрузит его за 5 секунд своей работы.
*/
public class Runner {
    public static void main(String[] args) {
        System.out.println("Available number of cores: " + Runtime.getRuntime().availableProcessors());

        Tunnel tunnel = new Tunnel();
        ShipGenerator shipGenerator = new ShipGenerator(tunnel, 10);

        //потоки которые ответственны за загрузку своего типа кораблей
        PierLoader pierLoader1 = new PierLoader(tunnel, Type.BANANA_SHIP);
        PierLoader pierLoader2 = new PierLoader(tunnel, Type.BREAD_SHIP);
        PierLoader pierLoader3 = new PierLoader(tunnel, Type.CLOTHES_SHIP);

        //Thread pool
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.execute(shipGenerator);
        service.execute(pierLoader1);
        service.execute(pierLoader2);
        service.execute(pierLoader3);
        service.shutdown();
    }
}
