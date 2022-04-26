package at.ac.fhcampuswien;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class NewsAPI {

    /* Erstellt eine NewsApi Klasse, welche die Logik zum Senden/Empfangen von Requests/Responses, sowie die Erstellung der geeigneten URL (bspw. Endpoint und notwendige Queryparameter) implementiert. In weiterer Folge soll eure NewsApi Klasse von eurer AppController Klasse, mit den korrekten Queryparametern und Endpoints aufgerufen werden können. Achtung: der Parameter „q“ muss immer befüllt werden! (bei der Funktion getTopHeadlinesAustria() könnt ihr das Query frei wählen)
Bspw.:
- AppController.getTopHeadlinesAustria() -> sendet mithilfe der NewsApi folgenden Request: https://newsapi.org/v2/top-headlines?q=corona&apiKey=<YOUR_API_KEY>&country=at
- AppController.getAllNewsBitcoin() -> sendet mithilfe der NewsApi folgenden Request: https://newsapi.org/v2/everything?q=bitcoin&apiKey=<YOUR_API_KEY>
Achtet darauf, dass die Methoden der NewsApi Klasse so flexibel wie möglich sind. Es soll in Zukunft leicht möglich sein, neue Funktionen im AppController hinzuzufügen, die unterschiedliche Requestparameter senden.*/

    final OkHttpClient client = new OkHttpClient();

    public String getInformation(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public NewsResponse gson() throws IOException {

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        NewsResponse response = gson.fromJson(getInformation("https://newsapi.org/v2/top-headlines?country=at&apiKey=1c3a1d04cc674ddaa897818225da2afe"), NewsResponse.class);
        return response;
    }

    public NewsResponse gson1() throws IOException {

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        NewsResponse response_bitcoin = gson.fromJson(getInformation("https://newsapi.org/v2/everything?q=bitcoin&apiKey=1c3a1d04cc674ddaa897818225da2afe&language=de"), NewsResponse.class);
        return response_bitcoin;
    }



    public static void main(String[] args) throws IOException {

        NewsAPI gettopheadlines = new NewsAPI();
        NewsAPI response_bitcoin = new NewsAPI();

        response_bitcoin.gson1();

        gettopheadlines.gson();


        /*String response = topheadlines_at.getInformation("https://newsapi.org/v2/top-headlines?country=at&apiKey=1c3a1d04cc674ddaa897818225da2afe");
        System.out.println(response); */


    }



}

