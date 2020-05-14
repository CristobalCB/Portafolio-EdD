package uInterface;

import controler.ControlerAnimal;
import program.Animal;

import java.util.Scanner;

public class ConsoleInterface {

    public ConsoleInterface(){
        ControlerAnimal ca = new ControlerAnimal();
        while (true){
            showPrincipalOptions();
            actionPrincipal(chooseOption(3), ca);
        }
    }

    private void showPrincipalOptions(){
        System.out.println("\n"+"Bienvenido a \"Animales\" \n(navegar escribiendo los indices)");
        System.out.println("1. Ver animales.");
        System.out.println("2. Salir.");
    }

    private void actionPrincipal(int choose, ControlerAnimal ca){
        switch (choose){
            case 1:
                System.out.println("");
                ca.enlist();
                System.out.println(ca.getList().size()+1 + ". Retroceder.");
                int aux = chooseOption(ca.getList().size()+1);
                if(aux == ca.getList().size()+1){
                    break;
                }
                actionAnimalList(aux, ca);
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    private void showAnimaloptions(){
        System.out.println("\n1. Hacer sonido.");
        System.out.println("2. Comer");
        System.out.println("3. Retroceder.");
    }

    private void  actionAnimalList(int choose, ControlerAnimal ca){
        Animal animal = ca.getList().get(choose-1);
        showAnimaloptions();
        switch (chooseOption(3)){
            case 1:
                System.out.println(animal.makeSound());
                actionAnimalList(choose,ca);
                break;
            case 2:
                System.out.println(animal.eat());
                actionAnimalList(choose,ca);
                break;
            case 3:
                ca.enlist();
                System.out.println(ca.getList().size()+1 + ". Retroceder.");
                int aux = chooseOption(ca.getList().size()+1);
                if(aux == ca.getList().size()+1){
                    break;
                }
                actionAnimalList(aux, ca);
                break;
        }

    }

    private int chooseOption(int option){
        Scanner in = new Scanner(System.in);
        try{
            int choose = in.nextInt();
            if(choose <= 0 || choose > option){
                System.err.println("no es una opción.");
                return chooseOption(option);
            }
            return choose;
        } catch (Exception e){
            System.err.println(e.getMessage());
            return chooseOption(option);
        }
    }
}
