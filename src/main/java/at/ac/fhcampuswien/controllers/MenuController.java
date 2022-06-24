package at.ac.fhcampuswien.controllers;

import at.ac.fhcampuswien.controllers.AppController;
import at.ac.fhcampuswien.controllers.NewsAPIException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

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

    public void click_Headlines() {
        txt_Display.setText(ctrl.getTopHeadlinesAustria().toString());
    }

    public void click_Bitcoin() {
        txt_Display.setText(ctrl.getAllNewsBitcoin().toString());
    }

    public void click_NumberOfArticles() throws NewsAPIException {
        txt_Display.setText(String.valueOf(ctrl.getArticleCount()));
    }

    public void click_Exit() {
        System.exit(0);
    }

}
