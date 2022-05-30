package at.ac.fhcampuswien;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class MenuController {
    AppController ctrl = new AppController();

    @FXML
    private Button  btn_ArticlesNr,
                    btn_Bitcoin,
                    btn_Exit,
                    btn_Headlines,
                    btn_NYTimes,
                    btn_LongestAuthorName,
                    btn_ShortTitle,
                    btn_MostArticles,
                    btn_SortDescription;
    @FXML
    private TextArea txt_Display;
    @FXML
    private ComboBox cbx_Language, cbx_Country;


    public void click_Headlines() {
        txt_Display.setText(ctrl.getTopHeadlinesAustria().toString());
    }

    public void click_Bitcoin() {
        txt_Display.setText(ctrl.getAllNewsBitcoin().toString());
    }

    public void click_NYTimes() throws NewsAPIExceptions{
        //txt_Display.setText(String.valueOf(ctrl.NewYorkTimes()));
    }

    public void click_MostArticles(){
        txt_Display.setText(ctrl.mostArticles());
    }

    public void click_LongestAuthorName(){
        txt_Display.setText(ctrl.longestNameAuthor());
    }

    public void click_ShortTitle() {
        //txt_Display.setText(ctrl.lessthan15chars());
    }

    public void click_SortDescription() {
        //txt_Display.setText(ctrl.sortByDescription());
    }


    public void click_NumberOfArticles() throws NewsAPIExceptions {
        txt_Display.setText(String.valueOf(ctrl.getArticleCount()));
    }

    public void click_Exit() {
        System.exit(0);
    }

}