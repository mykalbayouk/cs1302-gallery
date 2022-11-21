package cs1302.gallery;

import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class SearchBox extends HBox {
    /** HTTP client. */
    public static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)           // uses HTTP protocol version 2 where possible
        .followRedirects(HttpClient.Redirect.NORMAL)  // always redirects, except from HTTPS to HTTP
        .build();                                     // builds and returns a HttpClient object

    /** Google {@code Gson} object for parsing JSON-formatted strings. */
    public static Gson GSON = new GsonBuilder()
        .setPrettyPrinting()                          // enable nice output when printing
        .create();                                    // builds and returns a Gson object

    private static final String ITUNES_API = "https://itunes.apple.com/search";


    TextField textBox;
    Button play;
    Button get;
    ComboBox drop;
    String[] dropItems = {"music",
            "podcast",
            "movie",
            "musicVideo",
            "audiobook",
            "shortFilm",
            "tvShow",
            "software",
            "ebook",
            "all"};
    String[] pictureURL;


    public SearchBox() {
        super();
        textBox = new TextField("Kid Cudi");
        play = new Button("Play");
        get = new Button("Update Images");
        drop = new ComboBox();
        drop.getItems().addAll(dropItems);
        drop.getSelectionModel().selectFirst();

        this.getChildren().addAll(play,textBox,drop,get);
    } // constructor


    public void request() {
        try {
            String term = URLEncoder.encode(textBox.getText(), StandardCharsets.UTF_8);
            String media = URLEncoder.encode(drop.getValue().toString(),
                                      StandardCharsets.UTF_8);
            String limit = URLEncoder.encode("200", StandardCharsets.UTF_8);

            String query = String.format("?term=%s&media=%s&limit=%s", term, media, limit);
            String url = ITUNES_API + query;

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
            HttpResponse<String> response = HTTP_CLIENT
                .send(request, BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new IOException(response.toString());
            } // if

            String jsonString = response.body();
            ItunesResponse itunes = GSON
                .fromJson(jsonString, ItunesResponse.class);

            pictureURL = new String[itunes.results.length];
            for(int i = 0; i < itunes.results.length; i++) {
                ItunesResult result = itunes.results[i];
                pictureURL[i] = result.artworkUrl100;
            }
        } catch (IOException | InterruptedException e) {
            System.err.println(e);
            e.printStackTrace();
        } // catch
    } // request
    public Button getUpdate() {
        return get;
    } //getUpdate

    public String[] getPictureURL() {
        return pictureURL;
    } //getPictureURL
} // SearchBox
