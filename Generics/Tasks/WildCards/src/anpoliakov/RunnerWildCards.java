package anpoliakov;

import java.util.ArrayList;
import java.util.List;

public class RunnerWildCards {
    public static void main(String[] args) {
        List <Animal> listOfAnimal = new ArrayList<>();
        listOfAnimal.add(new Animal(1));
        listOfAnimal.add(new Animal(2));

        List <Dog> listOfDogs = new ArrayList<>();
        listOfDogs.add(new Dog());
        listOfDogs.add(new Dog());

        test(listOfAnimal);
        test(listOfDogs);
    }

    // При применении generics - полиморфизм не работает, не могу в метод передать обьект
    // который наследуется от Animal: List <Dog> list (к примеру)
    public static void test(List <? extends Animal> list){
        for(Animal animal : list){
            System.out.println(animal);
        }
    }
}
