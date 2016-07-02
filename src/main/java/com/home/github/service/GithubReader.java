package com.home.github.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.home.github.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.home.github.Utility.FileLoader.load;

public class GithubReader {

    private static final String FILE_NAME = "config.properties";

    private Gson gson = new Gson();
    private JsonParser parser = new JsonParser();

    public User readParseToUserObject() throws IOException {
        // Connect to the URL using java's native library
        URL url = new URL(load(FILE_NAME).getProperty("github.url"));
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to a JSON object to print data
        JsonElement root = parser.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
        User user = gson.fromJson(rootobj, User.class);
        return user;
    }

}
