package at.ac.fhcampuswien.controllers;

import at.ac.fhcampuswien.App;
import at.ac.fhcampuswien.downloader.Downloader;
import at.ac.fhcampuswien.downloader.ParallelDownloader;
import at.ac.fhcampuswien.downloader.SequentialDownloader;
import at.ac.fhcampuswien.enums.Country;
import at.ac.fhcampuswien.enums.Endpoint;
import at.ac.fhcampuswien.models.Article;
import at.ac.fhcampuswien.api.NewsApi;
import at.ac.fhcampuswien.models.NewsResponse;

import java.applet.AppletStub;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AppController {

    /**
     *
     * SINGLETON PATTERN
     *
     * Menu.start singleton call & in MenuController
     * **/

    private List<Article> articles;

    private static AppController instance = null;
    private AppController(){} //empty Constructor

    //public wy to get to private AppController instance (Singleton)
    public static AppController getInstance() {

        if (instance == null) {
            instance = new AppController();  //Allows global access to all other classes
        }
        return instance;
    }

    /** END **/

    //Setter for the Articles list
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }
    //Returns the number of items in the list. If the list is null, 0 should be returned

    public int getArticleCount() throws NewsAPIException {
        if (articles.size() != 0) {
            return articles.size();
        } else {
            throw new NewsAPIException("\nBitte wählen sie eine Kategorie aus, welche Artikel haben!\n");
        }
    }

    //Should only return the list of Articles. If the list is null, an empty list should be returned
    public List<Article> getTopHeadlinesAustria() {

        NewsApi api = new NewsApi("corona", Country.at, Endpoint.TOP_HEADLINES);
        articles = new ArrayList<>();

        try { //Need to handle gson because of the IOException in NewsAPI
            NewsResponse response = api.requestData();
            articles = response.getArticles();
        } catch (NewsAPIException e) {
            System.out.println("An error occurred while fetching articles: " + e.getMessage());
        }

        return Objects.requireNonNullElseGet(articles, ArrayList::new);
    }

    /***
     * the function returned a search string (query) and a list.
     * A list of articles in which the query in the title is returned.
     * Upper and lower case should not be considered.
     * @param query
     * @param articles
     * @return
     */
    protected static List<Article> filterList(String query, List<Article> articles) {

        List<Article> newList = new ArrayList<Article>();
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getTitle().toLowerCase().contains(query.toLowerCase())) {
                newList.add(articles.get(i));
            }
        }
        return newList;
    }

    public List<Article> getAllNewsBitcoin() {
        NewsApi api = new NewsApi("bitcoin", Endpoint.EVERYTHING);
        articles = new ArrayList<>();
        try {
            NewsResponse response = api.requestData();
            articles = response.getArticles();
        } catch (NewsAPIException e) {
            System.out.println("An error occurred while fetching articles: " + e.getMessage());
        }
        return articles; //= filterList("Bitcoin", articles);
    }

    //Quelle:https://stackoverflow.com/questions/22989806/find-the-most-common-string-in-arraylist User:ChandraBhan Singh
    public String mostArticles() throws NewsAPIException{
        if (!articles.isEmpty()) {

            return articles.stream()
                    .collect(Collectors.groupingBy(article -> article.getSource().getName(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .get()
                    .getKey();
        } else {
            throw new NewsAPIException("No Articles in the list!");
        }

    }

    public String longestNameAuthor() throws NewsAPIException {
        if (!articles.isEmpty()) {      //then return author with longest name
            return articles.stream()
                    .filter(article -> article.getAuthor() != null)
                    .max(Comparator.comparing(article -> article.getAuthor().length()))
                    .get().getAuthor();
        } else {
            throw new NewsAPIException("No Articles in the list!");
        }
    }


    public long NewYorkTimes() throws NewsAPIException{
        if(articles.isEmpty()) {
            throw new NewsAPIException("Load data first");
        } else {
            return articles.stream()
                    .filter(e -> e.getSource().getName().equals("New York Times"))
                    .count();
        }
    }



    public List<Article> lessthan15chars (int in) throws NewsAPIException{
        if (articles.isEmpty()) {
            throw new NewsAPIException("\nNo Articles found!\n");
        } return articles.stream()
                .filter(article -> article.getTitle().length() <= in)
                .collect(Collectors.toList());
    }

    public  List<Article> sortByDescription(){

        for (Article value : articles) { //Runs through all articles in list
            if (value.getDescription() == null) { //Articles who have no description -> ""
                value.setDescription("");
            }
        }
        if (!articles.isEmpty()) { //sorts length of description, if there are articles
            setArticles(articles.stream()
                    .sorted(Comparator.comparingInt((Article article) -> article.getDescription().length())
                            .thenComparing(Article::getDescription))
                    .collect(Collectors.toList()));
            return articles;

        } else {
            return new ArrayList<>();
        }

    }

    public int downloadURLs(Downloader downloader) throws NewsAPIException { //return number of downloaded article urls
    //Jeder Downloader kann übergeben werden
        if (articles.isEmpty()) {
            throw new NewsAPIException("No Articles found!");
        }

        List<String> urls = articles.stream()
                .map(Article::getUrl)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return downloader.process(urls);
    }



/*
   private static List<Article> generateMockList(){

        List<Article> liste = new ArrayList<Article>();
        for (int i = 0; i < 10; i++) {
            liste.add(new Article("Author "+i,"Title "+i));
        }

        liste.add(new Article("El Salvador", "Tech this week: El Salvador rejects IMF call to drop Bitcoin use"));
        liste.add(new Article("Ian Smith", "Bitcoin price crash: Crypto extends losses as market fails to rally"));

        return liste;
    }
*/

}