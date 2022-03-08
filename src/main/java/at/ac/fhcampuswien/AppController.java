package at.ac.fhcampuswien;

import java.util.List;

public class AppController {


    private List<Article> articles;
    public int count;

    public AppController(){
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
        count++;
    }

    public int getArticleCount(int count){

        if (count == 0){
            throw new IllegalArgumentException("Article count cannot be 0");
        }
        return getArticleCount(count);
    }

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
