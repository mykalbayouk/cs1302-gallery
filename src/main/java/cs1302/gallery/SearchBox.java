package cs1302.gallery;

import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
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
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.geometry.Orientation;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class that deals with the top part of the GUI, play/pause button,
 * Search box, drop down box, get images button.
 */
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

    /** Itunes URL. */
    private static final String ITUNES_API = "https://itunes.apple.com/search";


    /** Instance variables. */
    TextField textBox;
    Button play;
    Button get;
    ComboBox<String> drop;
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
    String formatUrl;

    /** Creates a SearchBox Object. */
    public SearchBox() {
        super();
        textBox = new TextField("Kid Cudi");
        play = new Button("Play");
        get = new Button("Get Images");
        drop = new ComboBox<String>();
        Label search = new Label("Search:");
        Separator sep = new Separator(Orientation.VERTICAL);
        Separator sep2 = new Separator(Orientation.VERTICAL);
        Separator sep3 = new Separator(Orientation.VERTICAL);

        drop.getItems().addAll(dropItems);
        drop.getSelectionModel().selectFirst();
        search.setAlignment(Pos.BOTTOM_CENTER);
        this.getChildren().addAll(play,sep,search,textBox,sep2,drop,sep3,get);
    } // constructor

    /** Request the image URLs from the Itunes API. */
    public void request() {
        try {
            pictureURL = null;
            String term = URLEncoder.encode(textBox.getText(), StandardCharsets.UTF_8);

            String media = URLEncoder.encode(drop.getValue(), StandardCharsets.UTF_8);
            System.out.println(drop.getValue().toString());
            String limit = URLEncoder.encode("200", StandardCharsets.UTF_8);
            String  query = String.format("?term=%s&media=%s&limit=%s", term, media, limit);
            formatUrl = ITUNES_API + query;

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(formatUrl))
                .build();
            HttpResponse<String> response = HTTP_CLIENT
                .send(request, BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new IOException(response.toString());
            } // if

            String jsonString = response.body();

            ItunesResponse itunes = GSON
                .fromJson(jsonString, ItunesResponse.class);
            if (itunes.results.length < 22) {
                throw new IllegalArgumentException("Not enough results found");
            } // if
            // sends the itunes response to a clean method
            pictureURL = cleanArray(itunes);
            for (int i = 0; i < pictureURL.length; i++) {
                System.out.println(pictureURL[i]);
            } // for
        } catch (IOException | InterruptedException e) {
            throw new IllegalArgumentException ("Request error");
        } // try
    } // request

    /**
     * Method that removes duplicates from response.
     *
     * @param itunes of type ItunesResponse
     * @return String Array
     */
    public String[] cleanArray(ItunesResponse itunes) {

        String[] dupe  = new String[itunes.results.length];
        ItunesResult result = itunes.results[0];
        int count = 0;
        // puts the first result into a new duplicate array
        dupe[0] = result.artworkUrl100;
        for (int i = 1; i < itunes.results.length; i++) {
            result = itunes.results[i];
            String url = result.artworkUrl100;
            // checks if url is present in array
            if (!this.contains(dupe, url)) {
                dupe[i] = url;
            } else {
                count++;
            } // if
        } // for
        String[] clean = new String[dupe.length - count];
        int j = 0;
        // removes dupes into a new array
        for (int i = 0; i < dupe.length; i ++) {
            if (!(dupe[i] == null)) {
                clean[j] = dupe[i];
                j++;
            } // if
        } // for
        return clean;
    } //cleanArray

    /**
     * Checks if a string url is present in inputted array.
     *
     * @param list of array String
     * @param url of type String
     * @return true if present, false if not
     */
    public boolean contains(String[] list, String url) {
        for (int i = 0;i < list.length; i++) {
            if (list[i] == null) {
                i = i;
            } else if (list[i].equals(url)) {
                return true;
            } // if
        } // for
        return false;
    } // contains

    /**
     * Returns the query url.
     *
     * @return String of query
     */
    public String getQuery() {
        return formatUrl;
    } // getQuery

    /**
     * Returns get images button.
     *
     * @return getImages of type Button
     */
    public Button getUpdate() {
        return get;
    } //getUpdate

    /**
     * Returns pictureURL String array.
     *
     * @return pictureURL String.
     */
    public String[] getPictureURL() {
        return pictureURL;
    } //getPictureURL

    /**
     * Returns pause/play button.
     *
     * @return play/pause button
     */
    public Button getPlay() {
        return play;
    } // getPlay
} // SearchBox
