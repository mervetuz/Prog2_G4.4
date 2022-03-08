package at.ac.fhcampuswien;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class UnitTest {

    @BeforeAll
    public static void init() {
        System.out.println("Testing News-App");
    }

    @AfterAll
    public static void finish(){
        System.out.println("Finished Testing the News-App");
    }



    @Test
    public void test_setArticles(){

    }

    @Test
    @DisplayName("There are no articles")
    public void test_getArticleCount_Scenario_1(){


        AppController articles = new AppController();
        assertThrows(IllegalArgumentException.class, () -> articles.getArticleCount(0) );

    }

    @Test
    @DisplayName("There exist articles")
    public void test_getArticleCount_Scenario_2(){



    }

    @Test
    @DisplayName("Headlines are in Capslock ")
    public void test_getTopHeadlinesAustria_Scenario_1(){

    }

    @Test
    @DisplayName("Empty List")
    public void test_getTopHeadLinesAustria_Scenario_2(){


    }

    @Test
    @DisplayName("Has bitcoin in the title") //Getting all news with "bitcoin" in the title
    public void test_getAllNewsBitcoin_Scenario_1(){

    }

    @Test
    @DisplayName("Query in title, not important if case sensitive or not")
    public void test_filterList_Scenario_1(){

    }

}