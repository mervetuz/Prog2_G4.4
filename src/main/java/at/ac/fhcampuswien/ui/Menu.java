package at.ac.fhcampuswien.ui;

import at.ac.fhcampuswien.downloader.ParallelDownloader;
import at.ac.fhcampuswien.downloader.SequentialDownloader;
import at.ac.fhcampuswien.models.Article;
import at.ac.fhcampuswien.controllers.AppController;
import at.ac.fhcampuswien.controllers.NewsAPIException;
import at.ac.fhcampuswien.models.NewsResponse;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;


public class Menu {
    private static Menu instance = null;
    private AppController controller;
    private static final String INVALID_INPUT_MESSAGE = "Not a valid Input! Try again";
    private static final String EXIT_MESSAGE = "Bye, see you soon!";

    /***************************************** SINGLETON *********************************************/
    private Menu() {}
    public static Menu getInstance() {
        if(instance == null){
            instance = new Menu();
        }
        return instance;
    }

    public void start() {
        /** SINGLETON CALL **/
        controller = AppController.getInstance();


        while (true) {
            printMenu();
            handleInput(new Scanner(System.in).next());
        }
    }


    private void downloadURLs() {

        try {
            SequentialDownloader sdow = SequentialDownloader.getInstance();
            ParallelDownloader pdow = ParallelDownloader.getInstance();

            long start = System.currentTimeMillis();
            int resultSequential = controller.downloadURLs(sdow);
            long end = System.currentTimeMillis();
            System.out.println("Download successful!" + "\n" +
                    "Sequential downloaded " + resultSequential + " files in " + (end - start) + "ms!");


            start = System.currentTimeMillis();
            int resultParallel = controller.downloadURLs(pdow);
            end = System.currentTimeMillis();
            System.out.println("Download successful!" + "\n" +
                    "Parallel downloaded " + resultParallel + " files in " + (end - start) + "ms!");


        } catch (NewsAPIException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleInput(String input){
        switch (input) {
            case "a" -> getTopHeadlinesAustria(controller);
            case "b" -> getAllNewsBitcoin(controller);
            case "c" -> getArticleCount(controller);
            case "d" -> mostArticles();
            case "e" -> longestNameAuthor();
            case "f" -> NewYorkTimes();
            case "g" -> lessthan15chars();
            case "h" -> sortByDescription();
            case "i" -> downloadURLs();
            case "q" -> {
                printExitMessage();
                System.exit(0); }
            default -> {printInvalidInputMessage(); start();
            }
        }
    }

    private void mostArticles() {
        try {
            System.out.println(controller.mostArticles());
        } catch (NewsAPIException e) {
            System.out.println(e.getMessage());
        }
    }
    private void longestNameAuthor() {
        try {
            System.out.println(controller.longestNameAuthor());
        } catch (NewsAPIException e) {
            System.out.println(e.getMessage());
        }
    }
    private void NewYorkTimes() {
        try {
            System.out.println(controller.NewYorkTimes());
        } catch (NewsAPIException e) {
            System.out.println(e.getMessage());
        }
    }

    private void lessthan15chars() {
        try {
            List<Article> articles = controller.lessthan15chars(15);
            if (articles.size() > 0) {
                articles.forEach(System.out::println);
            } else {
                System.out.println("No articles.");
            }
        } catch (NewsAPIException e) {
            System.out.println(e.getMessage());

        }
    }
    private void sortByDescription () {
        System.out.println(controller.sortByDescription());
    }

    private void getArticleCount(AppController ctrl){
    try {
        System.out.println(ctrl.getArticleCount());

    } catch (NewsAPIException e) {
        System.out.println(e.getMessage());}
    }

    private void getTopHeadlinesAustria(AppController ctrl){
        List<Article> articleList = controller.getTopHeadlinesAustria();
      try {
          if (ctrl.getTopHeadlinesAustria().isEmpty()) {
              throw new UnknownHostException();

            } else {
                for ( Article article : articleList) {
                    System.out.println(article);
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("\nCheck your internet connectivity!\n");
        }
    }

    private void getAllNewsBitcoin(AppController ctrl){
      try {
            if (ctrl.getAllNewsBitcoin().isEmpty()) {
                throw new UnknownHostException();
            } else {
                System.out.println(ctrl.getAllNewsBitcoin());
            }
        } catch (UnknownHostException exception) {
            System.out.println("\nCheck your internet connectivity!\n");
        }
    }


    private static void printExitMessage(){
        System.out.println(EXIT_MESSAGE);
    }

    private static void printInvalidInputMessage(){ System.out.println(INVALID_INPUT_MESSAGE); }

    private static void printMenu(){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("        ***       Welcome to our NewsApp      ***             ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter what you wanna do by pressing the appropriate letter key:");
        System.out.println("a --> Get the Top Headlines from Austria");
        System.out.println("b --> Get all news concerning Bitcoin");
        System.out.println("c --> Count of all Articles");
        System.out.println("d --> Get provider with most articles");
        System.out.println("e --> Get author with longest name ");
        System.out.println("f --> Count Articles from New York Times");
        System.out.println("g --> Get articles with short title");
        System.out.println("h --> Sort articles by content lenght");
        System.out.println("i --> Downloads URLs");
        System.out.println("q --> Quit the Program");

    }

}
