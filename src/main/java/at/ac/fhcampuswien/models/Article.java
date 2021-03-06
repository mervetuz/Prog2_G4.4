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

    /** BUILDER PATTERN **/

    private Article(Builder builder){
        this.author = builder.author;
        this.title = builder.title;
        this.description = builder.description;
        this.url = builder.url;
        this.urlToImage = builder.urlToImage;
        this.publishedAt = builder.publishedAt;
        this.content = builder.content;
        this.source = builder.source;

    }

    public static class Builder {

        private final String author; //Fixed
        private final String title; //Fixed

        public String description;
        public String url;
        public String urlToImage;
        public String publishedAt;
        public String content;
        public Source source;

        //Mandatory
        public Builder(String author, String title) {
            this.author = author;
            this.title = title;
        }

        //Optional parameters
        public Builder description (String description) {
            this.description = description;
            return this;
        }

        public Builder url (String url) {
            this.url = url;
            return this;
        }

        public Builder urlToImage (String urlToImage) {
            this.urlToImage = urlToImage;
            return this;
        }

        public Builder publishedAt (String publishedAt) {
            this.publishedAt = publishedAt;
            return this;
        }

        public Builder content (String content) {
            this.content = content;
            return this;
        }

        public Builder source (Source source) {
            this.source = source;
            return this;
        }

        public Article build() {
            return new Article(this);
        }
    }


    public String getAuthor() { return this.author; }

    public String getTitle() { return this.title; }

    public Source getSource() {
        return source;
    }

    public String getUrl() { return this.url; }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
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


}
