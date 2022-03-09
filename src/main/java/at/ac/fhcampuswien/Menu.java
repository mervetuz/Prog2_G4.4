package at.ac.fhcampuswien;

import java.util.Scanner;

public class Menu {
    private AppController controller = new AppController();
    private static final String INVALID_INPUT_MESSAGE = "Not a valid Input!";
    private static final String EXIT_MESSAGE = "Bye bye!";


    public void start(){
        printMenu();
        handleInput(new Scanner(System.in).next());

    }

    private void handleInput(String input){
        switch (input) {
            case "a" -> getTopHeadlinesAustria(controller);
            case "b" -> getAllNewsBitcoin(controller);
            case "y" -> getArticleCount(controller);
            case "q" -> printExitMessage();
            default -> printInvalidInputMessage();
        }

    }

    private void getArticleCount(AppController ctrl){

    }

    private void getTopHeadlinesAustria(AppController ctrl){

    }

    private void getAllNewsBitcoin(AppController ctrl){

    }

    private static void printExitMessage(){
        System.out.println(EXIT_MESSAGE);

    }

    private static void printInvalidInputMessage(){
        System.out.println(INVALID_INPUT_MESSAGE);
    }

    private static void printMenu(){
        System.out.println("What do you want to do?");

    }


}
