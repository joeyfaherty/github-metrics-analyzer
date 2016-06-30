package com.home.github.domain;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.Properties;

public class GithubReader {

    private Gson gson = new Gson();
    private JsonParser parser = new JsonParser();

    public User readParseToUserObject() throws IOException {
        // Connect to the URL using java's native library
        URL url = new URL(loadPropertiesFromClasspath().getProperty("github.url"));
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to a JSON object to print data
        JsonElement root = parser.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
        User user = gson.fromJson(rootobj, User.class);
        return user;
    }

    private Properties loadPropertiesFromClasspath() {
        try (final InputStream inputStream = GithubReader.class.getClassLoader().getResourceAsStream("config.properties")){
            final Properties p = new Properties();
            p.load(inputStream);
            return p;
        } catch (IOException e) {
            throw new MissingResourceException("cant find resource", "config.properties", "src/main/resources/");
        }
    }

}
