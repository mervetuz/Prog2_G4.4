package at.ac.fhcampuswien;

public class Article {
    private String author = "";
    private String title = "";

    public Article(String author, String title){

    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() { //automatically created
        return "Article{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
