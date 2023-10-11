package ui;


import model.Controller;

import java.util.Scanner;

public class Main {

    private Scanner sc;
    private Controller cll;
    private Init init;

    public Main(){
        sc = new Scanner(System.in);
        cll = new Controller();
        init = new Init();
        cll = init.testKeys();
    }

    public static void main(String[] args) {

        Main ppal = new Main();
        System.out.println("");

        int option=0;

        do{
            option= ppal.showMenu(); //Muestra el menu por medio del metodo ShowMenu()
            ppal.executeOperation(option); //Permite al usuario escoger entre las opciones del menu.

        }while (option!=0);

    }

    public int showMenu() {
        int option=0;

        System.out.println(
                "Main menu, please pick an option\n" +
                        "(1) Operations with reminders main list\n" +
                        "(2) Operations with reminders (Priority) \n" +
                        "(3) Operations with reminders (No priority) \n" +
                        "(0) Leave\n"
        );
        option= sc.nextInt();
        sc.nextLine();
        return option;
    }

    public void executeOperation(int operation) {

        switch (operation) {
            case 0 -> System.out.println("Bye!");
            case 1 -> System.out.println(1);
            case 2 -> System.out.println(2);
            case 3 -> System.out.println(3);
            default -> System.out.println("Error, wrong option");
        }
    }

}