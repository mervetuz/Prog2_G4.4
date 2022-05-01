package at.ac.fhcampuswien;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public int getArticleCount() {
        if (articles.size() != 0) {
            return articles.size();
        } else {
            return 0;
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

            articles = response_bitcoin.gson(endpoints.EVERYTHING.value_endpoint + "&q=bitcoin").getArticles();

        } catch (IOException e) {
        }
        return articles = filterList("Bitcoin", articles);
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