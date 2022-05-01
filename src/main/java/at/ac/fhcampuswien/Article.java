package at.ac.fhcampuswien;

import java.util.Date;

public class Article {
    private String author = "";
    private String title = "";
    private String id = "";
    private String name = "";
    private String description = "";
    private String url = "";
    private String urlToImage = "";
    private Date publishedAt = null;
    private String content = "";


    public Article(String author, String title){
        this.author = author;
        this.title = title;

    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }


    @Override
    public String toString() { //automatically created
        return "Article{" +
                "author='" + author + '\'' + "\n" +
                ", title='" + title + '\'' + "\n" +
                '}'+"\n";
    }
}
