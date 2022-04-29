package at.ac.fhcampuswien;
import org.junit.jupiter.api.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


public class UnitTest {
    private AppController ctrl;
    private List<Article> articles;
    private List<Article> acceptedList;
    private Article first;
    private Article second;
    private Article third;

    @BeforeAll
    public static void init() {
       System.out.println("Testing News-App");}

    @BeforeEach
    public void setup() {
        ctrl = new AppController();
        articles = new ArrayList<>();
        first = new Article("Peter", "Ich bin ein Article!", "jdksskdjskd", "kjshdajkhsd", "ksjhd", "ksfds","ksjhdjsh");
        second = new Article("Lukas", "Das ist ein Article!", "aksjhdajk", "kashdakjsdh", "ksjhd", "ksfds","ksjhdjsh");
        third = new Article("Robert", "Nein, das ist ein bitcoin", "jdksskdjskd", "kjshdajkhsd", "ksjhd", "ksfds","ksjhdjsh");
    }

    @AfterAll
    public static void finish(){
        System.out.println("Finished Testing the News-App");
    }

    /**
     * Tests if the given List of Articles is assigned to the Classvariable articles in AppController.
     */
    @Test
    @DisplayName("Testing setArticles Method")
    public void test_setArticles(){
        articles.add(first);
        articles.add(second);
        articles.add(third);
        ctrl.setArticles(articles);
        assertEquals(articles,ctrl.getArticles());
    }

    /**
     * Test if list count equals number of articles. If null then it should be 0.
     */

    @Test
    @DisplayName("No articles")
    public void test_getArticleCount_Scenario_0(){
        ctrl.setArticles(articles);

        int actual = ctrl.getArticleCount();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Number of articles")
    public void test_getArticleCount_Scenario_1(){
        articles.add(first);
        articles.add(second);
        articles.add(third);

        ctrl.setArticles(articles);

        int actual = ctrl.getArticleCount();
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Empty List")
    public void test_getTopHeadLinesAustria_Scenario_2(){
        articles.add(first);
        articles.add(second);
        ctrl.setArticles(articles);

        List<Article> expected = articles;

        assertEquals(expected, ctrl.getTopHeadlinesAustria());
    }

    @Test
    //Getting all news with "bitcoin" in the title
    @DisplayName("Has bitcoin in the title, regardless of whether case sensitive or not")
    public void test_getAllNewsBitcoin_Scenario_1(){
        acceptedList = new ArrayList<>();

        articles.add(first);
        articles.add(second);
        articles.add(third);

        ctrl.setArticles(articles);
        acceptedList.add(third);
        assertEquals(acceptedList, ctrl.getAllNewsBitcoin());
    }


    @Test
    @DisplayName("Query in title, not important if case sensitive or not")
    public void test_filterList_Scenario_1(){

        String searchWord = "Ich";
        acceptedList = new ArrayList<>();

        articles.add(first);
        articles.add(second);
        articles.add(third);
        acceptedList.add(first);
        assertEquals(acceptedList,AppController.filterList(searchWord,articles));
    }

    @Test
    @DisplayName("Testing if case sensitive")
    public void test_filterList_scenario_2(){
        String searchWord = "ich";
        acceptedList = new ArrayList<>();

        articles.add(first);
        articles.add(second);
        articles.add(third);
        acceptedList.add(first);
        assertEquals(acceptedList,AppController.filterList(searchWord,articles));
    }

}