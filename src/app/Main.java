package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Plate;
import persist.ReadTextFile;
import present.MainPanel;

import java.util.Arrays;

/**************************************
 * Created by Andrea on 06.11.2016.
 **************************************/
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        final String VERSION = "1.0";
        final String NAME = "SliceView FX";
        final int WINDOW_WIDTH = 1000;
        final int WINDOW_HEIGHT = 800;


        // Create the core data structures

        ApplicationContext applicationContext = new ApplicationContext(VERSION, NAME);

        // Create the main user interface panel and provide it with the application context

        Pane mainPane = new MainPanel(applicationContext, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Create and show the window

        Scene scene = new Scene(mainPane, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setTitle(applicationContext.getName() + " - v" + applicationContext.getVersion());
        primaryStage.setScene(scene);
        primaryStage.show();

        /*Plate plate = new Plate(4,4);
        plate.fillArray();
        String s = plate.toString();
        System.out.println(s);
        plate.gaussSeidelAlgorithm(0);
        System.out.println(plate.getTemperature());
        String a = plate.toString();
        System.out.println(a);*/
        ReadTextFile readTextFile = new ReadTextFile();
        Plate plate = new Plate(readTextFile.writeContent());
        System.out.println(Arrays.deepToString(plate.getCoordinates()));




    }
    public static void main(String[] args) {
        launch(args);
    }
    }

