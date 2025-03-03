package com.lab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        Text timerText = new Text("Time: 0");
        MinesweeperGame game = new MinesweeperGame(grid, timerText);

        VBox root = new VBox(10, timerText, grid);
        Scene scene = new Scene(root, 500, 550);
        

        primaryStage.setTitle("Minesweeper Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
