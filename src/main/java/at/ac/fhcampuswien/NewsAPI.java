package at.ac.fhcampuswien;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class NewsAPI {


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


    }


}

