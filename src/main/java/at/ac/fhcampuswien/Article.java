package at.ac.fhcampuswien;


public class Article {
    private String author;
    private String title;
    private String description;
    private String content;


    public Article(String author, String title, String description, String content){
        this.author = author;
        this.title = title;
        this.description = description;
        this.content = content;

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
        return "Article: " + title  + "\n" +
                "Author: " + author + "\n" +
                "Description: " + description + "\n" +
                 content + "\n" +
                "\n";
    }
}
