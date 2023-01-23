package cs1302.gallery;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStream;
import javafx.scene.control.Label;
import java.lang.Thread;
import java.lang.Runnable;
import javafx.application.Platform;
import javafx.scene.control.Button;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Represents an iTunes Gallery App.
 */
public class GalleryApp extends Application {

    /** HTTP client. */
    public static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)           // uses HTTP protocol version 2 where possible
        .followRedirects(HttpClient.Redirect.NORMAL)  // always redirects, except from HTTPS to HTTP
        .build();                                     // builds and returns a HttpClient object

    /** Google {@code Gson} object for parsing JSON-formatted strings. */
    public static Gson GSON = new GsonBuilder()
        .setPrettyPrinting()                          // enable nice output when printing
        .create();                                    // builds and returns a Gson object

    private Stage stage;
    private Scene scene;
    private HBox root;

    private VBox layout;
    private SearchBox search;
    private TheGrid grid;
    private LoadingBox loading;
    private Label message;
    private Alert alert;

    /**
     * Constructs a {@code GalleryApp} object}.
     */
    public GalleryApp() {
        this.stage = null;
        this.scene = null;
        this.root = new HBox();
        this.layout = new VBox();
        this.search = new SearchBox();
        this.grid = new TheGrid();
        this.loading = new LoadingBox();
        this.alert = new Alert(Alert.AlertType.ERROR);
        this.message = new Label("Type in a term, select a media type, then click Get Images");
        this.message.setLineSpacing(1.5);
        this.message.setMinWidth(25);
        this.message.setMinHeight(25);
    } // GalleryApp

    /** {@inheritDoc} */
    @Override
    public void init() {
        layout.getChildren().addAll(search,message,grid,loading);
        System.out.println("init() called");
        Runnable r = () -> loadImage();
        search.getUpdate().setOnAction(e -> runNow(r));
        Runnable q = () -> setPlay();
        search.getPlay().setOnAction(e -> runNow(q));
        search.getPlay().setDisable(true);
    } // init

    /**
     * Sets the action of the Play/pause button.
     */
    public void setPlay() {
        if (search.getPlay().getText().equals("Play")) {
            Platform.runLater(() -> search.getPlay().setText("Pause"));
            grid.setIsPushed(true);
            grid.showRandomImg();
        } else {
            System.out.println("runs here woooooo");
            Platform.runLater(() -> search.getPlay().setText("Play"));
            grid.setIsPushed(false);
        } //
    } // setPlay

    /**
     * Loads the images into the buttons.
     */
    public void loadImage() {
        search.getUpdate().setDisable(true);
        search.getPlay().setDisable(true);
        if (grid.getIsPushed()) {
            grid.setIsPushed(false);
            Platform.runLater(() -> search.getPlay().setText("Play"));
        } // if
        try {
            search.request();
            Platform.runLater(() -> message.setText("Getting images..."));
            grid.downloadImage(search.getPictureURL());
            grid.showImg();
            Platform.runLater(() -> message.setText(search.getQuery()));
        } catch (IllegalArgumentException e) {
            alert.setContentText(e.getMessage());
            Platform.runLater(() -> alert.showAndWait());
        } // catch
        search.getPlay().setDisable(false);
        search.getUpdate().setDisable(false);
    } // loadImage

    /**
     * Creates a new Thread.
     * @param target of type Runnable.
     */
    public void runNow(Runnable target) {
        Thread t = new Thread(target);
        t.setDaemon(true);
        t.start();
    } // runNow

    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.scene = new Scene(this.layout);
        this.stage.setOnCloseRequest(event -> Platform.exit());
        this.stage.setTitle("GalleryApp!");
        this.stage.setScene(this.scene);
        this.stage.sizeToScene();
        this.stage.show();
        Platform.runLater(() -> this.stage.setResizable(false));
    } // start

    /** {@inheritDoc} */
    @Override
    public void stop() {
        // feel free to modify this method
        System.out.println("stop() called");
    } // stop


} // GalleryApp
