package at.ac.fhcampuswien.ui;

import at.ac.fhcampuswien.models.Article;
import at.ac.fhcampuswien.controllers.AppController;
import at.ac.fhcampuswien.controllers.NewsAPIExceptions;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;
/***
 * the Menu class is for outputting the console menu and for the responsible for user input.
 * If the user input has been validated, AppController is called.
 * The class has a member variable of AppController.
 * two static variables for invalid user input and the closing text
 */

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
    /**
     * Menu:
     * When entering "a", a statically generated list of items should be output.
     * When entering "b", all articles in which the keyword "bitcoin" appears in the title.
     * Entering "y" gives the number of items in the static list.
     * Entering "q" outputs a closing text and ends the program
    **/
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

    private Object handleStream(String in, List<Article> list){
        switch (in){
            case "a" : return controller.mostArticles();

            case "b" : return controller.longestNameAuthor();
            case "c" : return controller.NewYorkTimes(list);
            case "e" : return controller.lessthan15chars(list);
            case "d" : return controller.sortByDescription(list);
            case "q" : return list;
            default : {printInvalidInputMessage();start();}
        }
        return null;
    }

    /***
     *  getArticleCount(): returns the number of articles in the list.
     * If the list is null, then 0 be returned
     */
    private void getArticleCount(AppController ctrl){

    try {

        System.out.println(ctrl.getArticleCount());

    } catch (NewsAPIExceptions e) {
        System.out.println(e.getMessage());
    }
    }

    /***
     * getTopHeadlinesAustria(): return the list of articles
     * If the list is null, an empty list should be returned
     * @param ctrl
     */
    private void getTopHeadlinesAustria(AppController ctrl){
    //    printStreamSelector();
    //    System.out.println(handleStream(new Scanner(System.in).next(),ctrl.getTopHeadlinesAustria()));

        try {

            if (ctrl.getTopHeadlinesAustria().isEmpty()) {

                throw new UnknownHostException();
            } else {
                //System.out.println(ctrl.getTopHeadlinesAustria());
                printStreamSelector();
                System.out.println(handleStream(new Scanner(System.in).next(),ctrl.getTopHeadlinesAustria()));
            }

        } catch (UnknownHostException e) {
            System.out.println("\nCheck your internet connectivity!\n");
        }
    }

    /***
     * getAllNewsBitcoin(): the function calls the filterList() function with the query "bitcoin" on
     * @param ctrl
     */
    private void getAllNewsBitcoin(AppController ctrl){
     //   printStreamSelector();
     //   System.out.println(handleStream(new Scanner(System.in).next(),ctrl.getAllNewsBitcoin()));

        try {

            if (ctrl.getAllNewsBitcoin().isEmpty()) {
                throw new UnknownHostException();
            } else {
              //  System.out.println(ctrl.getAllNewsBitcoin());
                printStreamSelector();
                System.out.println(handleStream(new Scanner(System.in).next(),ctrl.getAllNewsBitcoin()));
            }
        } catch (UnknownHostException exception) {
            System.out.println("\nCheck your internet connectivity!\n");
        }
    }

    /***
     * return "Bye, see you soon!"
     */
    private static void printExitMessage(){
        System.out.println(EXIT_MESSAGE);
    }

    /***
     * return "Not a valid Input!";
     */
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
    private static void printStreamSelector(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("        ***       Welcome to our NewsApp      ***             ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter what you wanna do by pressing the appropriate letter key:");
        System.out.println("a --> Filter (Provider with the most Articles)");
        System.out.println("b --> Filter (Author with the longest Name)");
        System.out.println("c --> Filter (New York Times)");
        System.out.println("d --> Filter (Description length)");
        System.out.println("e --> Filter (Less than 15 characters in Title)");
        System.out.println("q --> No Filter");
    }


}
