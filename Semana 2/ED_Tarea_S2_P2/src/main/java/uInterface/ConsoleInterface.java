package uInterface;

import controler.ControlerAnimal;
import program.Animal;

import java.util.Scanner;

public class ConsoleInterface {

    /**
     * Crea una nueva interfaz y la ejecuta.
     */
    public ConsoleInterface(){
        while (true){
            showPrincipalOptions();
            actionPrincipal(chooseOption(3));
        }
    }

    /**
     * Muestra las opciones del menú principal.
     */
    private void showPrincipalOptions(){
        System.out.println("\n"+"Bienvenido a \"Animales\" \n(navegar escribiendo los indices)");
        System.out.println("1. Ver animales.");
        System.out.println("2. Salir.");
    }

    /**
     * segun lo que haya eliegido el usuarios, despliega la lsita de animales o termina el programa
     * @param choose - decision tomada por el usuario
     */
    private void actionPrincipal(int choose){

        switch (choose){
            case 1:
                ControlerAnimal ca = new ControlerAnimal();
                showAnimalList(ca);
                int aux = chooseOption(ca.getList().size()+1);
                if(aux == ca.getList().size()+1){ break; }
                actionAnimalList(aux,ca);
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    /**
     * Enlista los animales seleccionables y un opcion de retroceder.
     * @param ca - lista de animales.
     */
    private void showAnimalList(ControlerAnimal ca){
        System.out.println("");
        ca.enlist();
        System.out.println(ca.getList().size()+1 + ". Retroceder.");
    }

    /**
     * Muestra las aciones realizables por los animales y la opción de volver.
     */
    private void showAnimaloptions(){
        System.out.println("1. Hacer sonido.");
        System.out.println("2. Comer");
        System.out.println("3. Retroceder.");
    }

    /**
     * Secuencia de acciones al elegir una opcion de un animal
     * @param choose - eleccion tomada por el usuario.
     * @param ca - lista de animales.
     */
    private void  actionAnimalList(int choose, ControlerAnimal ca){
        System.out.println("\n"+ca.getList().get(choose-1).getName());
        showAnimaloptions();
        switch (chooseOption(3)){
            case 1:
                System.out.println("\n"+ca.getList().get(choose-1).makeSound());
                actionAnimalList(choose,ca);
                break;
            case 2:
                System.out.println("\n"+Animal.eat());
                actionAnimalList(choose,ca);
                break;
            case 3:
                actionPrincipal(1);
        }

    }

    /**
     * Pregunta por consola la opción que quiere el usuario y valida que sea una lógica.
     * @param option - Cantidad e opciones validas
     * @return - opcion seleccionada
     */
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
