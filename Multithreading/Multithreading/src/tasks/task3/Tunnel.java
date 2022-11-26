package tasks.task3;

import java.util.ArrayList;
import java.util.List;

public class Tunnel {
    private List<Ship> store;
    private static final int maxShipsInTunel = 5;
    private static final int minShipsInTunel = 0;
    private int shipsCounter = 0;

    public Tunnel() {
        this.store = new ArrayList<>();
    }

    public synchronized boolean add (Ship element){
        try {
            if (shipsCounter < maxShipsInTunel) {
                notifyAll();

                store.add(element);
                String info = String.format("%s + The ship arrived in the tunnel: %s %s %s",
                        store.size(), element.getType(), element.getSize(), Thread.currentThread().getName());
                System.out.println(info);
                shipsCounter++;
            } else {
                System.out.println();
                wait(); //Если тонель заполнен - ждём
                return false;
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return true;
    }

    public synchronized Ship get(Type shipType){
        try{
            if(shipsCounter > minShipsInTunel){
                notifyAll(); //после вызова другой поток (который был в состоянии WAITING не начинает сразу работу, ждёт завершения работы данного метода)

                for(Ship ship:store){
                    if(ship.getType() == shipType){
                        shipsCounter--;
                        System.out.println(store.size() + "- The ship is taken from the tunnel: " + Thread.currentThread().getName());
                        store.remove(ship);
                        return ship;
                    }
                }
            }

            System.out.println("0 < There are no ships in the tunnel");
            wait();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //WARNING!
        return null;
    }
}
