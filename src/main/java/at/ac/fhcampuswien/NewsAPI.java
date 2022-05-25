package at.ac.fhcampuswien;

import at.ac.fhcampuswien.enums.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Objects;

public class NewsAPI {
    public static final String DELIMITER = "&";
    private static final String URL = "https://newsapi.org/v2/%s?q=%s&apiKey=%s";
    private static final String API_KEY = "1c3a1d04cc674ddaa897818225da2afe";
    private final OkHttpClient client;

    private Endpoint endpoint;
    private String q;
    private Country country;
    private Category category;
    private Language language;
    private SortBy sortBy;


    public String getQ() {return q;}
    public Country getCountry() {return country;}
    public Category getCategory() {return category;}
    public Language getLanguage() {return language;}
    public SortBy getSortBy() {return sortBy;}
    public Endpoint getEndpoint() {return endpoint;}


    public NewsAPI (String q, Endpoint endpoint){
        this.client = new OkHttpClient();
        this.q = q;
        this.endpoint = endpoint;
    }

    public NewsAPI(String q, Country country, Endpoint endpoint){
        this.client = new OkHttpClient();
        this.q = q;
        this.country = country;
        this.endpoint = endpoint;
    }

    private String buildUrl(){
        String baseurl = String.format(URL, getEndpoint().getValue(), getQ(), API_KEY);

        StringBuilder sb = new StringBuilder(baseurl);

        if(getLanguage() != null){
            sb.append(DELIMITER).append("language=").append(getLanguage());
        }
        if(getCountry() != null){
            sb.append(DELIMITER).append("country=").append(getCountry());
        }
        if(getCategory() != null){
            sb.append(DELIMITER).append("category=").append(getCategory());
        }
        if(getSortBy() != null){
            sb.append(DELIMITER).append("sortBy=").append(getSortBy());
        }
        return sb.toString();
    }

    public NewsResponse requestData() {
        String url = buildUrl();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            NewsResponse apiResponse = gson.fromJson(Objects.requireNonNull(response.body()).string(), NewsResponse.class);
            if(apiResponse.getStatus().equals("ok")){
                return apiResponse;
            } else {
                System.err.println(this.getClass() + ": http status not ok");
                return null;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }





/**
    public String getInformation(String url) {


        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return (Objects.requireNonNull(response.body()).string()); //must not be null

        } catch (UnknownHostException e){
            System.out.println("Internet is not connected");
            throw new RuntimeException(e);

        } catch (IOException e) {
            System.out.println("Ups! Something went wrong.");
            throw new RuntimeException(e);
        }
    }

    public NewsResponse gson(String url) throws IOException {

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String country;
        return gson.fromJson(getInformation(url), NewsResponse.class);
    }

**/

}

