package ui;


import model.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    //--------------------------------------------------------------------------------------\\


    public int showHashMenu() {
        int optionHash=0;

        System.out.println(
                "Game menu, please pick an option\n" +
                        "(1) Create a reminder \n" +
                        "(2) Modify reminder \n" +
                        "(3) Delete reminder \n"+
                        "(4) List by priority \n"+
                        "(5) List by deadline \n"+
                        "(0) Leave\n"
        );
        optionHash= sc.nextInt();
        sc.nextLine();
        return optionHash;
    }

    public void hashOperation(){

        int optionHash=0;

        do{
            optionHash= showHashMenu();
            executeOperationHash(optionHash);

        }while (optionHash!=0);

    }

    public void executeOperationHash(int operation) {

        switch(operation) {
            case 0:
                System.out.println("Returning to the tittle!");
                break;
            case 1:
                registerTaskAndReminders();
                break;
            case 2:
                modifyTaskAndReminders();
                break;
            case 3:
                deleteTaskAndReminders();
                break;
            case 4:
                cll.priorityInOrder();
                break;
            case 5:
                System.out.println();
                break;

            default:
                System.out.println("Error, wrong option");

        }
    }


    public void registerTaskAndReminders(){

        DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");

        String actualDate = dateFormat.format(new Date());

        System.out.println(actualDate);

        System.out.println("Type the title of the reminder");
        String title = sc.nextLine();
        System.out.println("Type a description for the reminder");
        String description = sc.nextLine();
        System.out.println("Type the deadline of the reminder");
        String deadline = sc.nextLine();


        int key = 0;
        boolean flag = true;
        System.out.println("To save a reminder it is necessary to create a key for it");
        while (flag){
            key = sc.nextInt();
            flag = cll.keyVerification(key);
            if(flag){
                System.out.println("The key already exist, type another one");
            }
        }

        System.out.println("Does the reminder has a priority?");
        String answer = sc.next();


        int priority = 0;
        if(answer.equals("yes")){
            System.out.println("Type the priority of the reminder");
            System.out.println(
                    "How important the task or reminder is? " +
                            "(1) Very important  \n" +
                            "(2) Important  \n"+
                            "(3) Considerable  \n"+
                            "(4) Less important  \n"+
                            "(5) Not very important \n"
            );
            priority = sc.nextInt();
            cll.registerReminders(title,description,deadline,priority,key);
        }else{
            cll.registerReminders(title,description,deadline,priority,key);
        }
    }


    public void modifyTaskAndReminders(){
        System.out.println("To modify the reminder it is necessary to type the respective key");
        int key = sc.nextInt();
        int answer = -1;
        String title;
        String description;
        String deadline;
        int priority;


        while(answer!=0) {
            System.out.println(
                    "What do you want to modify? \n" +
                            "(1) Title  \n" +
                            "(2) Description  \n" +
                            "(3) Deadline  \n" +
                            "(4) Priority  \n"
            );
            answer = sc.nextInt();

            switch (answer) {
                case 1:
                    System.out.println("Type the new title for the reminder");
                    sc.nextLine();
                    title = sc.nextLine();
                    cll.modifyReminders(title, null, null, 0, key);
                    break;
                case 2:
                    System.out.println("Type the new description for the reminder");
                    sc.nextLine();
                    description = sc.next();
                    cll.modifyReminders(null, description, null, 0, key);
                    break;
                case 3:
                    System.out.println("Type the new deadline for the reminder");
                    sc.nextLine();
                    deadline = sc.next();
                    cll.modifyReminders(null, null, deadline, 0, key);
                    break;
                case 4:
                    System.out.println("Type the new priority for the reminder");
                    priority = sc.nextInt();
                    cll.modifyReminders(null, null, null, priority, key);
                    break;

                default:
                    System.out.println("Error, wrong option");


            }
        }
    }

    public void deleteTaskAndReminders(){
        System.out.println("To modify the reminder it is necessary to type the respective key");
        int key = sc.nextInt();
        cll.deleteReminders(key);
    }


}