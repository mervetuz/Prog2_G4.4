package at.ac.fhcampuswien;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MenuController {
    AppController ctrl = new AppController();

    @FXML
    private Button btn_ArticlesNr;

    @FXML
    private Button btn_Bitcoin;

    @FXML
    private Button btn_Exit;

    @FXML
    private Button btn_Headlines;


    @FXML
    private TextArea txt_Display;
    private PrintStream ps;

    public void initialize() {
        ps = new PrintStream(new Console(txt_Display));
        System.setOut(ps);
        System.setErr(ps);
        System.out.println("Welcome!");
    }

    public class Console extends OutputStream {
        private TextArea txt_Display;

        public Console(TextArea txt_Display) {
            this.txt_Display = txt_Display;
        }

        public void appendText(String valueOf) {
            Platform.runLater(() -> txt_Display.appendText(valueOf));
        }

        public void write(int b) {
            appendText(String.valueOf((char)b));
        }
    }
    @FXML
    private Button btn_Category, btn_Business, btn_Entertainment,btn_General,btn_Health,btn_Science,btn_Sports,btn_Technology;
    private Parent root;
    private Button btn;

    public void click_Category() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/at.ac.fhcampuswien/Category.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Category");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage thisStage = (Stage) btn_Category.getScene().getWindow();
        thisStage.close();
    }
    public void click_Business() {
        Stage thisStage = (Stage) btn_Business.getScene().getWindow();
    }
    public void click_Entertainment() {
        Stage thisStage = (Stage) btn_Entertainment.getScene().getWindow();
    }
    public void click_General() {
        Stage thisStage = (Stage) btn_General.getScene().getWindow();
    }
    public void click_Health() {
        Stage thisStage = (Stage) btn_Health.getScene().getWindow();
    }
    public void click_Science() {
        Stage thisStage = (Stage) btn_Science.getScene().getWindow();
    }
    public void click_Technology() {
        Stage thisStage = (Stage) btn_Technology.getScene().getWindow();
    }
    public void click_Sports() {
        Stage thisStage = (Stage) btn_Sports.getScene().getWindow();
    }



    public void click_Headlines() {
        txt_Display.setText(ctrl.getTopHeadlinesAustria().toString());
    }

    public void click_Bitcoin() {
        txt_Display.setText(ctrl.getAllNewsBitcoin().toString());
    }

    public void click_NumberOfArticles() {
        txt_Display.setText(String.valueOf(ctrl.getArticleCount()));
    }

    public void click_Exit() {
        System.exit(0);
    }

}
