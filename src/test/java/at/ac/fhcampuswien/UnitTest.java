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

    @BeforeAll
    public static void init() {
       System.out.println("Testing News-App");}

    @BeforeEach
    public void setup() {
        ctrl = new AppController();
        articles = new ArrayList<>();
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
        Article first = new Article("Peter","Das ist ein Article");
        Article second = new Article("Hans","Das ist ein Article");
        Article third = new Article("Gustav","Das ist ein Article");

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
        Article first = new Article("Marco Polo", "Welcome to Venice!");
        articles.add(first);
        Article second = new Article("Christopher Columbus", "Hello America!");
        articles.add(second);
        Article third = new Article("Charles Darwin", "Ever heard of Theory of evolution?");
        articles.add(third);

        ctrl.setArticles(articles);

        int actual = ctrl.getArticleCount();
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Empty List")
    public void test_getTopHeadLinesAustria_Scenario_2(){
        Article first = new Article("El Salvador", "Tech this week: El Salvador rejects IMF call to drop Bitcoin use");
        articles.add(first);
        Article second = new Article("Ian Smith", "Bitcoin price crash: Crypto extends losses as market fails to rally");
        articles.add(second);
        ctrl.setArticles(articles);

        List<Article> expected = articles;

        assertEquals(expected, ctrl.getTopHeadlinesAustria());

    }

    @Test
    //Getting all news with "bitcoin" in the title
    @DisplayName("Has bitcoin in the title, regardless of whether case sensitive or not")
    public void test_getAllNewsBitcoin_Scenario_1(){
        acceptedList = new ArrayList<Article>();

        Article first = new Article("Ian Smith", "Cryptos sind cool");
        Article second = new Article("Peter Smith", "Bitcoin ist cool");
        Article third = new Article("Franz Smith", "Cryptos sind königlich");
        articles.add(first);
        articles.add(second);
        articles.add(third);
        ctrl.setArticles(articles);
        acceptedList.add(second);
        assertEquals(acceptedList, ctrl.getAllNewsBitcoin());


    }


    @Test
    @DisplayName("Query in title, not important if case sensitive or not")
    public void test_filterList_Scenario_1(){

        String searchWord = "Ich";
        acceptedList = new ArrayList<Article>();

        Article first = new Article("Peter","Das ist ein Article");
        Article second = new Article("Hans","Ich bin ein Article");
        Article third = new Article("Gustav","Das ist ein Article");
        articles.add(first);
        articles.add(second);
        articles.add(third);
        acceptedList.add(second);
        assertEquals(acceptedList,AppController.filterList(searchWord,articles));

    }

    @Test
    @DisplayName("Testing if case sensitive")
    public void test_filterList_scenario_2(){
        String searchWord = "ich";
        acceptedList = new ArrayList<Article>();

        Article first = new Article("Peter","Das ist ein Article");
        Article second = new Article("Hans","Ich bin ein Article");
        Article third = new Article("Gustav","Das ist ein Article");
        articles.add(first);
        articles.add(second);
        articles.add(third);
        acceptedList.add(second);
        assertEquals(acceptedList,AppController.filterList(searchWord,articles));
    }

}