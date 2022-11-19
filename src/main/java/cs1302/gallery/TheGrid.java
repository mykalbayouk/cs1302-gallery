package cs1302.gallery;

import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class TheGrid extends GridPane {
    private final Image DEFAULT_IMAGE = new Image("file:resources/default.png");

    ImageView imageBox1;
    ImageView imageBox2;
    ImageView imageBox3;
    ImageView imageBox4;
    ImageView imageBox5;
    ImageView imageBox6;
    ImageView imageBox7;
    ImageView imageBox8;
    ImageView imageBox9;
    ImageView imageBox10;
    ImageView imageBox11;
    ImageView imageBox12;
    ImageView imageBox13;
    ImageView imageBox14;
    ImageView imageBox15;
    ImageView imageBox16;
    ImageView imageBox17;
    ImageView imageBox18;
    ImageView imageBox19;
    ImageView imageBox20;




    public TheGrid() {
        super();
        imageBox1 = new ImageView(DEFAULT_IMAGE);
        imageBox2 = new ImageView(DEFAULT_IMAGE);
        imageBox3 = new ImageView(DEFAULT_IMAGE);
        imageBox4 = new ImageView(DEFAULT_IMAGE);
        imageBox5 = new ImageView(DEFAULT_IMAGE);
        imageBox6 = new ImageView(DEFAULT_IMAGE);
        imageBox7 = new ImageView(DEFAULT_IMAGE);
        imageBox8 = new ImageView(DEFAULT_IMAGE);
        imageBox9 = new ImageView(DEFAULT_IMAGE);
        imageBox10 = new ImageView(DEFAULT_IMAGE);
        imageBox11 = new ImageView(DEFAULT_IMAGE);
        imageBox12 = new ImageView(DEFAULT_IMAGE);
        imageBox13 = new ImageView(DEFAULT_IMAGE);
        imageBox14 = new ImageView(DEFAULT_IMAGE);
        imageBox15 = new ImageView(DEFAULT_IMAGE);
        imageBox16 = new ImageView(DEFAULT_IMAGE);
        imageBox17 = new ImageView(DEFAULT_IMAGE);
        imageBox18 = new ImageView(DEFAULT_IMAGE);
        imageBox19 = new ImageView(DEFAULT_IMAGE);
        imageBox20 = new ImageView(DEFAULT_IMAGE);

        this.add(imageBox1, 0, 0);
        this.add(imageBox2, 1, 0);
        this.add(imageBox3, 2, 0);
        this.add(imageBox4, 3, 0);
        this.add(imageBox5, 4, 0);
        this.add(imageBox6, 0, 1);
        this.add(imageBox7, 1, 1);
        this.add(imageBox8, 2, 1);
        this.add(imageBox9, 3, 1);
        this.add(imageBox10, 4, 1);
        this.add(imageBox11, 0, 2);
        this.add(imageBox12, 1, 2);
        this.add(imageBox13, 2, 2);
        this.add(imageBox14, 3, 2);
        this.add(imageBox15, 4, 2);
        this.add(imageBox16, 0, 3);
        this.add(imageBox17, 1, 3);
        this.add(imageBox18, 2, 3);
        this.add(imageBox19, 3, 3);
        this.add(imageBox20, 4, 3);

    } // constructor

} // TheGrid
