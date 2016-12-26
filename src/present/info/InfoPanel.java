package present.info;

import app.ApplicationContext;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**************************************
 * Created by Andrea on 18.12.2016.
 **************************************/
public class InfoPanel extends StackPane{
    private ApplicationContext applicationContext;
    private Label nameLabel;
    private Label coordinates;

    public InfoPanel(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;

        nameLabel = new Label();
        coordinates = new Label();


        HBox hbox = new HBox();
        hbox.getChildren().add(new Label("Colums:  "));
        hbox.getChildren().add(new TextField());

        hbox.getChildren().add(new Label("Rows:  "));
        hbox.getChildren().add(new TextField());

        //vBox.setPadding(new Insets(10));
        hbox.setPadding(new Insets(100,20,20,20));
        //getChildren().add(vBox);
        getChildren().add(hbox);

    }

    }


