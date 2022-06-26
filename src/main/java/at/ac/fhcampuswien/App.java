package at.ac.fhcampuswien;

import at.ac.fhcampuswien.ui.Menu;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App  {
    public static void main(String[] args){
        //launch(args);
        Menu menu = Menu.getInstance();
        menu.start();

    }
}


/*
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/at.ac.fhcampuswien/Menu.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();

    }
*/
