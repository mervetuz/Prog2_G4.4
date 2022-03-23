package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class AppController {


    private List<Article> articles = new ArrayList();




    public AppController(){
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;

    }

    public int getArticleCount(){return 0;}

    public List<Article> getTopHeadlinesAustria(){
        return null;
    }

    protected List<Article> filterList(String query,List<Article> articles){
        return null;
    }

    public List<Article> getAllNewsBitcoin(){
        return null;
    }

    private List<Article> generateMockList(){
      return null;
    }
}
