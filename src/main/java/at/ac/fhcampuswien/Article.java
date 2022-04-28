package at.ac.fhcampuswien;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Article {
    private String author = "";
    private String title = "";
    private String description = "";
    private String content= "";
    //private SimpleDateFormat date = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    //private String publishedAt = date.format(new Date());


    public Article(String author, String title, String description, String content){
        this.author = author;
        this.title = title;
        this.description = description;
        this.content = content;
        //this.publishedAt = publishedAt;

    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() { return this.description; }



    @Override
    public String toString() { //automatically created
        return "Article{" +
                "author='" + author + '\'' + "\n" +
                ", title='" + title + '\'' + "\n" +
                "description='" + description + '\'' + "\n" +
                "content='" + content + '\'' + "\n" +
               // "publishedAt='" + publishedAt + '\'' + "\n" +
                '}'+"\n";
    }
}
