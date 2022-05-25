package at.ac.fhcampuswien;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Objects;

public class NewsAPI {


    final OkHttpClient client = new OkHttpClient();

    public String getInformation(String url) {


        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return (Objects.requireNonNull(response.body()).string()); //must not be null

        } catch (UnknownHostException e){
            System.out.println("Internet is not connected");
            return "Internet is not connected";

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



}

