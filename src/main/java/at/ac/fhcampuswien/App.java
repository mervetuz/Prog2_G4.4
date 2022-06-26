package at.ac.fhcampuswien;

import at.ac.fhcampuswien.models.Article;
import at.ac.fhcampuswien.models.Source;
import at.ac.fhcampuswien.ui.Menu;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App  {
    public static void main(String[] args){
        //launch(args);
        Menu menu = new Menu();
        menu.start();

        /*
Article article = new Article.Builder("Alex", "Kingg")
        .description("Ich bin die Beschreibung")
        .publishedAt("2020-12-12")
        .url("www.alex.com")
        .build();

        System.out.println(article.toString());
        */

    }


    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/at.ac.fhcampuswien/Menu.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();

    }

}