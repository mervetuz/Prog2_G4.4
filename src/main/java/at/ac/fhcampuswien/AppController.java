package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AppController {

    private List<Article> articles;

    public AppController(){
        this.articles=generateMockList();
    }


    //Setter for the Articles list
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    public List<Article> getArticles(){
        return articles;
    }
    //Returns the number of items in the list. If the list is null, 0 should be returned
    public int getArticleCount(){
        return 0;

    }

    //Should only return the list of Articles. If the list is null, an empty list should be returned
    public List<Article> getTopHeadlinesAustria(){
        if (articles == null) {
            return new ArrayList<Article>();
        }else
            return articles;
        }

    protected static List<Article> filterList(String query,List<Article> articles){
        List<Article> newList = new ArrayList<Article>();
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getTitle().toLowerCase().contains(query.toLowerCase())){
                newList.add(articles.get(i));
            }
        }

        return newList;
    }

    public List<Article> getAllNewsBitcoin(){
        return filterList("bitcoin",articles);
    }

    private static List<Article> generateMockList(){

        List<Article> liste = new ArrayList<Article>();
        for (int i = 0; i < 20; i++) {
            liste.add(new Article("Author "+i,"Title "+i));
        }

        liste.add(new Article("El Salvador", "Tech this week: El Salvador rejects IMF call to drop Bitcoin use"));
        liste.add(new Article("Ian Smith", "Bitcoin price crash: Crypto extends losses as market fails to rally"));

        return liste;
    }
}
