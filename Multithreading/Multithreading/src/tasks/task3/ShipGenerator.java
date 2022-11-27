package tasks.task3;

import java.util.Random;

//занимается созданием кораблей и добавлением их в тонель
public class ShipGenerator implements Runnable{
    private Tunnel tunnel;
    private int shipCount;

    //всего будет создано shipCount кол-во кораблей
    public ShipGenerator(Tunnel tunnel, int shipCount) {
        this.tunnel = tunnel;
        this.shipCount = shipCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < shipCount){
            Thread.currentThread().setName("Generator ship");
            count++;
            tunnel.add(new Ship(getRandomSize(), getRandomType()));
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }

    private Type getRandomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }
}
