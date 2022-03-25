package at.ac.fhcampuswien;
import org.junit.jupiter.api.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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



    /**
     * Tests if the given List of Articles is assigned to the Classvariable articles in AppController.
     */
    @Test
    public void test_setArticles(){
        System.out.println("Testing setArticles Method");
        List<Article> testList = new ArrayList<Article>();
        Article first = new Article("Peter","Das ist ein Article");
        Article second = new Article("Hans","Das ist ein Article");
        Article third = new Article("Gustav","Das ist ein Article");
        testList.add(first);
        testList.add(second);
        testList.add(third);
        AppController ctrl = new AppController();
        ctrl.setArticles(testList);
        assertEquals(testList,ctrl.getArticles());
    }

    /**
     * Test if list count equals number of articles. If null then it should be 0.
     */
    @Test
    @DisplayName("There are no articles")
    public void test_getArticleCount_Scenario_1(){



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
        System.out.println("Testing Bitcoin News");
        //List<Article> articles = new ArrayList<Article>();
        AppController ctrl = new AppController();

    try {
        assertTrue(ctrl.getAllNewsBitcoin().contains("bitcoin"));

            } //catch (NoSuchMethodException name){
              //  fail("There should be a public method called getAllNewsBitcoin.");
//
            //}
            catch (Exception e) {
                e.printStackTrace();
                fail("Some other problems have occured.");
        }
        //return articles.stream().filter(articles.contains("bitcoin")).collect(Collectors.toList());
        /*String test = "Bitcoin";
        String result;

        try {
            Method method = AppController.class.getMethod("getAllNewsBitcoin", String.class);
            result = (String)method.invoke(null, "")
        }
        */

    }

    @Test
    @DisplayName("Query in title, not important if case sensitive or not")
    public void test_filterList_Scenario_1(){

        String searchWord = "Ich";
        List<Article> testList = new ArrayList<Article>();
        List<Article> acceptedList = new ArrayList<Article>();
        Article first = new Article("Peter","Das ist ein Article");
        Article second = new Article("Hans","Ich bin ein Article");
        Article third = new Article("Gustav","Das ist ein Article");
        testList.add(first);
        testList.add(second);
        testList.add(third);
        acceptedList.add(second);
        assertEquals(acceptedList,AppController.filterList(searchWord,testList));

    }

    @Test
    @DisplayName("Testing if case sensitive")
    public void test_filterList_scenario_1(){
        String searchWord = "ich";
        List<Article> testList = new ArrayList<Article>();
        List<Article> acceptedList = new ArrayList<Article>();
        Article first = new Article("Peter","Das ist ein Article");
        Article second = new Article("Hans","Ich bin ein Article");
        Article third = new Article("Gustav","Das ist ein Article");
        testList.add(first);
        testList.add(second);
        testList.add(third);
        acceptedList.add(second);
        assertEquals(acceptedList,AppController.filterList(searchWord,testList));
    }

}