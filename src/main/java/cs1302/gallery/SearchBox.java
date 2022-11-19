package cs1302.gallery;

import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;


public class SearchBox extends HBox {
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

} // SearchBox
