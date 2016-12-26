package present;

import app.ApplicationContext;
import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import present.info.InfoPanel;

/**************************************
 * Created by Andrea on 18.12.2016.
 **************************************/
public class MainPanel extends BorderPane {

        public MainPanel(ApplicationContext applicationContext, int windowWidth, int windowHeight) {
            final int INFO_AREA_WIDTH = 200;
            final int HISTO_AREA_HEIGHT = 300;

            // Left side
            //-----------

            StackPane leftPane = new StackPane(new InfoPanel(applicationContext));

            // Right side
            //------------

            // Top
            StackPane topPane = new StackPane();

            // Bottom
            //StackPane bottomPane = new StackPane(new HistogramPanel(applicationContext));

            final SplitPane horizontalSplitPane = new SplitPane();
            horizontalSplitPane.setOrientation(Orientation.VERTICAL);
            horizontalSplitPane.setDividerPosition(0, (double)(windowHeight - HISTO_AREA_HEIGHT) / (double)windowHeight);
            horizontalSplitPane.getItems().addAll(topPane);

            StackPane rightPane = new StackPane(horizontalSplitPane);

            // Put things together
            //---------------------

            final SplitPane verticalSplitPane = new SplitPane();
            verticalSplitPane.setOrientation(Orientation.HORIZONTAL);
            verticalSplitPane.setDividerPosition(0, 0.45);

            verticalSplitPane.getItems().addAll(leftPane, rightPane);


            setCenter(verticalSplitPane);
        }


    }

