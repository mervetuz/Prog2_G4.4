package at.ac.fhcampuswien;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

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
