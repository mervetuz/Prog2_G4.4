package at.ac.fhcampuswien.streams;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import at.ac.fhcampuswien.Article;


public class ArticleStreams {
    /*
    * https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
    */

    //Get provider with most articles

    //Get longest author name

    // Count articles from NY Times

    // Get articles with short title

    // Sort articles by content length
    public List<Article> sortArticle() {
        return articles.stream()
                .sorted(Comparator.comparingInt((Article a) -> a.getContent().length())
                        .thenComparing(Article::getContent))
                .collect(Collectors.toList());
    }
}


