package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class AppController {


    private List<Article> articles = new ArrayList();




    public AppController(){
    }
    //Setter for the Articles list
    public void setArticles(List<Article> articles) {
        this.articles = articles;
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

    protected List<Article> filterList(String query,List<Article> articles){
        return null;
    }

    public List<Article> getAllNewsBitcoin(){
        return filterList("bitcoin",articles);
    }

    private List<Article> generateMockList(){

        List<Article> liste = new ArrayList<Article>();
        for (int i = 0; i < 20; i++) {
            liste.add(new Article("Author "+i,"Title "+i));
        }

        return liste;
    }
}
