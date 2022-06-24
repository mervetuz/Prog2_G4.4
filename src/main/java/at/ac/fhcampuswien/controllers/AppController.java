package at.ac.fhcampuswien.controllers;

import at.ac.fhcampuswien.models.Article;
import at.ac.fhcampuswien.api.NewsApi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppController {
    private List<Article> articles;

    public AppController() {
        articles = new ArrayList<Article>();
    }

    //Setter for the Articles list
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }
    //Returns the number of items in the list. If the list is null, 0 should be returned

    public int getArticleCount() throws NewsAPIExceptions {
        if (articles.size() != 0) {
            return articles.size();
        } else {
            throw new NewsAPIExceptions("\nBitte wählen sie eine Kategorie aus, welche Artikel haben!\n");
        }
    }

    //Should only return the list of Articles. If the list is null, an empty list should be returned
    public List<Article> getTopHeadlinesAustria() {
        NewsAPI getTopHeadlines = new NewsAPI();

        try { //Need to handle gson because of the IOException in NewsAPI
            articles = getTopHeadlines.gson(endpoints.TOP_HEADLINES.value_endpoint + country.AUSTRIA.value_country).getArticles();
        } catch (IOException e) {}

        if (articles == null) {
            return new ArrayList<Article>();
        } else
            return articles;
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

        NewsAPI response_bitcoin = new NewsAPI();

        try {

            articles = response_bitcoin.gson(endpoints.EVERYTHING.value_endpoint + "&q=New York").getArticles();

        } catch (IOException e) {
        }
        return articles; //= filterList("Bitcoin", articles);
    }


    public String mostArticles(){
        //in.stream()
          // return null;

        if (!articles.isEmpty()) {
            return articles.stream()
                    //Quelle:https://stackoverflow.com/questions/22989806/find-the-most-common-string-in-arraylist User:ChandraBhan Singh
                    .collect(Collectors.groupingBy(article -> article.getSource().getName(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .get()
                    .getKey();
        } else {
            return "No Articles in the List!";
        }

    }

    public String longestNameAuthor() { //delete every article with author = "null"
        if (!articles.isEmpty()) {      //then return author with longest name
            return articles.stream()
                    .filter(article -> article.getAuthor() != null)
                    .max(Comparator.comparing(article -> article.getAuthor().length()))
                    .get().getAuthor();
        } else {
            return "No Articles in the List!";
        }
    }
    public List<Article> NewYorkTimes (List<Article> in) {
        articles = in.stream()
                .filter(source->source.getSource().getName().equals("New York Times")) //For Testing
                .toList();

        try {

        if (articles.isEmpty()) {
            throw new  NewsAPIExceptions("\nNo Articles found!\n");

        } else {
            return  articles;
        }
        } catch (NewsAPIExceptions e) {
            System.out.println(e.getMessage());
        }
       return articles;

    }

    public List<Article> lessthan15chars (List<Article> in){
        articles = in.stream()
                .filter(title->title.getTitle().length()<15)
                .toList();

        try {
            if (articles.isEmpty()) {
                throw new NewsAPIExceptions("\nNo Articles found!\n");

            } else {
                return articles;
            }
        } catch (NewsAPIExceptions e) {
            System.out.println(e.getMessage());
        }
        return articles;
    }
    public  List<Article> sortByDescription(List<Article> in){
        for (int i = 0; i < articles.size(); i++) { //Runs through all articles in list
            if (articles.get(i).getDescription() == null) { //Articles who have no description -> ""
                articles.get(i).setDescription("");
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

    /**
     * Usable for Endpoint Top-Headlines
     */
    enum category {

        BUSINESS("&category=business"),
        ENTERTAINMENT("&category=entertainment"),
        GENERAL("&category=general"),
        HEALTH("&category=general"),
        SCIENCE("&category=science"),
        SPORTS("&category=science"),
        TECHNOLOGY("&category=science");

        private final String value_category;

        category(String value_category) {
            this.value_category = value_category;
        }

    }

    /**
     * Usable for Endpoint Top-Headlines
     */
    enum country {
        AUSTRIA("&country=at"),
        GERMANY("&country=de"),
        ENGLAND("&country=gb");


        private final String value_country;

        country(String value_country) {
            this.value_country = value_country;
        }


    }

    /**
     * Usable for Endpoint Everything
     */
    enum language {
        GERMAN("&language=de"),
        ENGLISH("&language=en");

        private final String value_language;

        language(String value_language) {
            this.value_language = value_language;
        }

    }

    /**
     * Usable for Endpoint Everything
     */
    enum sortby {
        RELEVANCY ("&sortBy=relevancy"),
        POPULARITY ("&sortBy=popularity"),
        PUBLISHED_AT ("&sortBy=publishedAt");
        private final String value_sortby;

        sortby(String value_sortby) {
            this.value_sortby = value_sortby;
        }
    }

    enum endpoints {
        EVERYTHING("https://newsapi.org/v2/everything?apiKey=1c3a1d04cc674ddaa897818225da2afe"),
        TOP_HEADLINES("https://newsapi.org/v2/top-headlines?apiKey=1c3a1d04cc674ddaa897818225da2afe");
        private final String value_endpoint;

        endpoints(String value_endpoint) {
            this.value_endpoint = value_endpoint;
        }
    }

  /*  private static List<Article> generateMockList(){

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