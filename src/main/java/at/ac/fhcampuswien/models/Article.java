package at.ac.fhcampuswien.models;


public class Article {
    private final Source source;
    private final String author;
    private final String title;
    private String description;
    private final String url;
    private final String urlToImage;
    private final String publishedAt;
    private final String content;


    public Article(String author, String title, String description, String url, String urlToImage, String publishedAt, String content, Source source){
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.source = source;

    }

    public String getAuthor() { return this.author; }

    public String getTitle() { return this.title; }

    public Source getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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

    public String getUrl() {

        return this.url;
    }
}
