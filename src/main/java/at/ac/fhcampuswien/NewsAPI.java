package at.ac.fhcampuswien;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import enums.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class NewsAPI {
    public SortBy sortBy;
    public Endpoint endpoint;
    public Category category;
    public Language language;
    public Country country;
    public String q;
    private static final String URL = "https://newsapi.org/v2/";
    private static final String API_KEY = "apiKey=1c3a1d04cc674ddaa897818225da2afe";


    public Endpoint getEndpoint() { return endpoint; }
    public SortBy getSortBy() { return sortBy; }
    public Category getCategory() { return category; }
    public Language getLanguage() { return language; }
    public String getQ() { return q; }
    public Country getCountry() { return country; }

    OkHttpClient client = new OkHttpClient();

    public NewsAPI(String q, Endpoint endpoint) {
        this.client = new OkHttpClient();
        this.q = q;
        this.endpoint = endpoint;

    }






   public NewsAPI (SortBy sortby,Endpoint endpoint, Category category, Language language, String q ) {
        this.sortBy  = sortby;
        this.endpoint = endpoint;
        this.category = category;
        this.language = language;
        this.q = q;
    }


    public String buildURL() {
        String urlbase = String.format(URL, getEndpoint().getValue(), getQ(), API_KEY);
        StringBuilder sb = new StringBuilder(urlbase);

        if (getLanguage() != null) {
            sb.append("&").append("language=").append(getLanguage());
        }
        if(getCategory() != null) {
            sb.append("&").append("category=").append(getCategory());
        }
        if (getCountry() != null) {
            sb.append("&").append("country=").append(getCountry());
        }
        if (getSortBy() != null) {
            sb.append("&").append("sortby=").append(getSortBy());
        }
        return sb.toString();
    }

    public NewsResponse requestData() {
        String url = buildURL();
        Request request = new Request.Builder()
                .url(url)
                .build();

        System.out.println(url);

        try (Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            NewsResponse apiResponse = gson.fromJson(response.body().string(), NewsResponse.class);

            if(apiResponse.getStatus().equals("ok")) {
                return apiResponse;
            } else {
                System.err.println(this.getClass() + "http status nicht ok");
                return null;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        return null;
        }
    }
}








/**

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
**/



