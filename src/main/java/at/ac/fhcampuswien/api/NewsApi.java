package at.ac.fhcampuswien.api;

import at.ac.fhcampuswien.controllers.NewsAPIException;
import at.ac.fhcampuswien.enums.*;
import at.ac.fhcampuswien.models.NewsResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class NewsApi {


    final OkHttpClient client = new OkHttpClient();

    public String getInformation(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
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

