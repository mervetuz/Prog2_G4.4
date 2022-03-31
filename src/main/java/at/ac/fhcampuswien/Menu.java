package at.ac.fhcampuswien;

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
    /***
     *  getArticleCount(): returns the number of articles in the list.
     * If the list is null, then 0 be returned
     */
    private void getArticleCount(AppController ctrl){
        System.out.println(ctrl.getArticleCount());
    }

    /***
     * getTopHeadlinesAustria(): return the list of articles
     * If the list is null, an empty list should be returned
     * @param ctrl
     */
    private void getTopHeadlinesAustria(AppController ctrl){
        System.out.println(ctrl.getTopHeadlinesAustria());

    }

    /***
     * getAllNewsBitcoin(): the function calls the filterList() function with the query "bitcoin" on
     * @param ctrl
     */
    private void getAllNewsBitcoin(AppController ctrl){
        System.out.println(ctrl.getAllNewsBitcoin());

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


}
