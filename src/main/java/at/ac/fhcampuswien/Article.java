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
        return "\nArticle\n" +
                "Author: " + author + "\n" +
                "Title: " + title + "\n" +
                "Description: " + description + "\n" +
                "Url: " + url + "\n" +
                "Image Url: " + urlToImage + "\n" +
                "Published at: " + publishedAt + "\n" +
                "Content: " + content + "\n" ;
    }
}
