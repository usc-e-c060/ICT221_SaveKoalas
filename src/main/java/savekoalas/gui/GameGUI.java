package savekoalas.gui;

import javafx.scene.control.Cell;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
//import savekoalas.engine.GameEngine;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * GUI for the Maze Runner Game.
 *
 * NOTE: Do NOT run this class directly in IntelliJ - run 'RunGame' instead.
 */
public class GameGUI extends Application {
    // TODO: move this to Controller class if you use FXML...
    //private GameEngine engine = new GameEngine(10);
    //private Cell[][] CellMatrix =  new Cell[10][10];


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("game_gui.fxml"));
        //Button root = new Button("Amazing Miner Game coming soon...");
        //root.setFont(new Font(24));

        //create map
        GridPane map = new GridPane();
        map.setPrefSize(100, 100);








        FlowPane pane = new FlowPane();
        pane.getChildren().addAll(map);

        Scene scene = new Scene(pane, 900 , 600 );
        primaryStage.setTitle( "Save Koalas" ); // Set the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /** In IntelliJ, do NOT run this method.  Run 'RunGame.main()' instead. */
    public static void main(String[] args) {
        launch(args);
    }
}
