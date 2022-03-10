package at.ac.fhcampuswien;

public class Menu {
    private AppController controller = new AppController();
    private static final String INVALID_INPUT_MESSAGE = "";
    private static final String EXIT_MESSAGE = "";


    public void start(){
        printMenu();

    }

    private void handleInput(String input){

    }

    private void getArticleCount(AppController ctrl){

    }

    private void getTopHeadlinesAustria(AppController ctrl){

    }

    private void getAllNewsBitcoin(AppController ctrl){

    }

    private static void printExitMessage(){

    }

    private static void printInvalidInputMessage(){

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
