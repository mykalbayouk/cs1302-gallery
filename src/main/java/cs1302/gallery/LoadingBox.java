package cs1302.gallery;

import javafx.scene.layout.HBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;

/**
 * A class used to setup the bottom of the GUI, progress bar and label.
 */
public class LoadingBox extends HBox {
    /** Instance variables. */

    static ProgressBar bar;
    Label text;

    /** Creates new LoadingBox Object. */
    public LoadingBox() {
        super(10);
        bar = new ProgressBar(0);
        text = new Label("images are provided by the iTunes Search API");

        this.getChildren().addAll(bar,text);
    } // constructor

    /**
     * Static method to update the progress bar.
     *
     * @param amount of type double.
     */
    public static void updateBar(double amount) {
        bar.setProgress(amount);
    } //updateBar
} // LoadingBox
