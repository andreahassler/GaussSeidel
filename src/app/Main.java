package app;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.impl.MathParser;
import logic.impl.SimplePlate2D;
import persist.ConsoleInputReader;
import persist.TextFileReader;
import java.util.Arrays;

    /**
    *  In the main class, the core data structures are created, then the application is launched
    */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        TextFileReader textFileReader = new TextFileReader();
        ConsoleInputReader inputReader = new ConsoleInputReader();
        MathParser mathParser = new MathParser(inputReader.getString());

        SimplePlate2D simplePlate = new SimplePlate2D(textFileReader.writeContent(), textFileReader, mathParser);

        System.out.println(Arrays.deepToString(simplePlate.getCoordinates()));
        simplePlate.gaussSeidelAlgorithm(0);
        System.out.println(Arrays.deepToString(simplePlate.getCoordinates()));

    }
    public static void main(String[] args) {
        launch(args);
    }
    }

