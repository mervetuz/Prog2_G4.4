package at.ac.fhcampuswien;

import java.util.Scanner;

public class Menu {
    private AppController controller = new AppController();
    private static final String INVALID_INPUT_MESSAGE = "Not a valid Input!";
    private static final String EXIT_MESSAGE = "Bye, see you soon!";


    public void start() {
       while (true) {

           printMenu();
           handleInput(new Scanner(System.in).next());

       }
    }

    private void handleInput(String input){
        switch (input) {
            case "a" -> getTopHeadlinesAustria(controller);
            case "b" -> getAllNewsBitcoin(controller);
            case "y" -> getArticleCount(controller);
            case "q" -> {
                printExitMessage();
                System.exit(0);
            }
            default -> {printInvalidInputMessage(); start();
            }
        }

    }

    private void getArticleCount(AppController ctrl){
        System.out.println(ctrl.getArticleCount());
    }

    private void getTopHeadlinesAustria(AppController ctrl){
        System.out.println(ctrl.getTopHeadlinesAustria());

    }

    private void getAllNewsBitcoin(AppController ctrl){
        System.out.println(ctrl.getAllNewsBitcoin());

    }

    private static void printExitMessage(){
        System.out.println(EXIT_MESSAGE);
    }

    private static void printInvalidInputMessage(){
        System.out.println(INVALID_INPUT_MESSAGE);

    }

    private static void printMenu(){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("        ***       Welcome to our NewsApp      ***             ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter what you wanna do by pressing the appropriate letter key:");
        System.out.println("a --> Get the Top Headlines from Austria");
        System.out.println("b --> Get all news concerning Bitcoin");
        System.out.println("y --> Count of all Articles");
        System.out.println("q --> Quit the Program");



    }


}
