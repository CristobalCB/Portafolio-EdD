package controler;

import program.Animal;
import java.util.ArrayList;

public class ControlerAnimal {

    private ArrayList<Animal> list;

    /**
     * Crea el arrayList con los animales definidos (Se puede mejorar para que lo haga de una base de datos).
     */
    public ControlerAnimal(){
        list = new ArrayList<Animal>();
        list.add(new Animal("Perro","Guau Guau"));
        list.add(new Animal("Gato","Miau Miau"));
        //Here u can add more animals
    }

    /**
     * despliega una lista númerada por consola.
     */
    public void enlist(){
        for (Animal animal: list) {
            System.out.println((list.indexOf(animal)+1) + ". Soy un " + animal.getName() +".");
        }
    }


    public ArrayList<Animal> getList() {
        return list;
    }
}
