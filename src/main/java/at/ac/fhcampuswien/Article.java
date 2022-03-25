package at.ac.fhcampuswien;

public class Article {
    private String author = "";
    private String title = "";
    private static int count = 0;

    public Article(String author, String title){
        this.author = author;
        this.title = title;
        count++;

    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() { //automatically created
        return "Article{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
