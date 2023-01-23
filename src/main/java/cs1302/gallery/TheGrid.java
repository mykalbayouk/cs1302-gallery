package cs1302.gallery;

import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.lang.Math;
import javafx.util.Duration;
import java.lang.Thread;
import java.lang.InterruptedException;

/** Class that handles the images of the GUI. */
public class TheGrid extends GridPane {

    /** Sets a value for the default image given.  */
    private final String defaultLink = "file:resources/default.png";

    /** instance variables. */
    ImageView[] arrayBox = new ImageView[20];
    Image[] imageAll;
    boolean isPushed;

    /** Constructs a TheGrid Object. */
    public TheGrid() {
        super();
        Image DEFAULT_IMAGE = new Image(defaultLink);
        isPushed = false;
        for (int i = 0; i < 20; i++) {
            arrayBox[i] = new ImageView(DEFAULT_IMAGE);
        } // for
        int c = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                this.add(arrayBox[c], j, i);
                c++;
            } // for
        } //for
    } // constructor

    /**
     * Downloads the images from the parameter into each image object in the imageAll array.
     *
     * @param url of type String Array
     */
    public void downloadImage(String[] url) {
        imageAll = new Image[url.length];
        for (int i = 0; i < url.length; i++) {
            imageAll[i] = new Image(url[i]);
            LoadingBox.updateBar((i + 0.0) / (url.length - 1));
        } // for
    } // downloadImage

    /**
     * Updates each imageView object with each imageArray object.
     */
    public void showImg() {
        for (int i = 0; i < 20; i++) {
            arrayBox[i].setImage(imageAll[i]);
            arrayBox[i].setFitHeight(100);
            arrayBox[i].setFitWidth(100);
        } // for
    } // setImg

    /**
     * Randomly switches between the 20 images to a new image in the ImageAll array.
     */
    public void showRandomImg() {
        int max = 20;
        int min = 1;
        int range = max - min + 1;
        int index;
        int indexImg;
        int maxImg = imageAll.length;

        while (isPushed) {
            try {
                index = (int)(Math.random() * range);
                indexImg = (int)(Math.random() * (maxImg - min + 1));
                arrayBox[index].setImage(imageAll[indexImg]);

                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            } //catch
        } // while

    } // showRandomImg

    /**
     * Changes the value of isPushed to the parameter.
     *
     * @param push of type boolean.
     */
    public void setIsPushed(boolean push) {
        isPushed = push;
    } // isPushed

    /**
     * Returns the value of isPushed.
     *
     * @return the value of isPushed
     */
    public boolean getIsPushed() {
        return isPushed;
    } // getIsPushed
} // TheGrid
