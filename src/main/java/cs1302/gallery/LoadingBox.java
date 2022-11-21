package cs1302.gallery;

import javafx.scene.layout.HBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;

public class LoadingBox extends HBox {
    static ProgressBar bar;
    Label text;

    public LoadingBox() {
        super(10);
        bar = new ProgressBar(0);
        text = new Label("images are provided by the iTunes Search API");

        this.getChildren().addAll(bar,text);
    } // constructor

    public static void updateBar(double amount) {
        bar.setProgress(amount);
    } //updateBar
} // LoadingBox
