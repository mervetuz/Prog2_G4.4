package at.ac.fhcampuswien.streams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import at.ac.fhcampuswien.Article;
import at.ac.fhcampuswien.NewsAPI;


public class ArticleStreams {
    /*
     * https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
     */

    //Get provider with most articles
    public List<Article> mostArticles(List<Article> in) {
        //in.stream()
        return null;

    }
    //Get longest author name
    public List<Article> longestNameAuthor(List<Article> in) {
        try {
            String maxLength = in.stream()
                    .max((aAuthor, bAuthor) -> aAuthor.getAuthor().length() - bAuthor.getAuthor().length())
                    .toString();
            return in.stream()
                    .filter(x -> x.getAuthor().equals(maxLength))
                    .toList();
        } catch (NullPointerException e) {
            System.out.println("welp");
        }
        return null;
    }

    // Count articles from NY Times

    public List<Article> NewYorkTimes(List<Article> in) {
        return null;
    }

    // Get articles with short title

    public List<Article> lessthan15chars(List<Article> in) {
        return null;
    }

    // Sort articles by content length

    public List<Article> sortByDescription(List<Article> in) {
        return null;
    }

}



