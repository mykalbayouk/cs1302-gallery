package cs1302.gallery;

import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class TheGrid extends GridPane {
    private final Image DEFAULT_IMAGE = new Image("file:resources/default.png");

    ImageView[] arrayBox = new ImageView[20];
    Image[] imageAll;

    public TheGrid() {
        super();
        for (int i = 0; i < 20; i++) {
            arrayBox[i] = new ImageView(DEFAULT_IMAGE);
        } // for
        int c = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++){
                this.add(arrayBox[c], j, i);
                c++;
            } // for
        } //for

    } // constructor
    public void downloadImage(String[] url) {
        imageAll = new Image[url.length];
        for (int i = 0; i < url.length; i++) {
            imageAll[i] = new Image(url[i]);
            LoadingBox.updateBar((i + 0.0)/(url.length - 1));
        } // for
        System.out.println("all 200 saved");
    } // downloadImage

    public void showImg() {
        if (imageAll.length < 20) {
            System.out.println("less than 20");
            //throw error message not enough found
        } // if
        for (int i = 0; i < 20; i++) {
            arrayBox[i].setImage(imageAll[i]);
        } // for
        System.out.println("finished upload");
    } // setImg

} // TheGrid
