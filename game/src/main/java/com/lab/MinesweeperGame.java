package com.lab;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Random;

public class MinesweeperGame {
    public static final int SIZE = 10;
    private static final int NUM_MINES = 15;
    private final Button[][] buttons = new Button[SIZE][SIZE];
    private final boolean[][] mines = new boolean[SIZE][SIZE];
    private boolean gameOver = false;
    private boolean firstClick = true;
    private final Timer timer;

    public MinesweeperGame(GridPane grid, Text timerText) {
        this.timer = new Timer(timerText);
        initializeButtons(grid);
        placeMines();
    }

    private void initializeButtons(GridPane grid) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                final int r = row, c = col;
                buttons[row][col] = new Button();
                buttons[row][col].setMinSize(40, 40);
                buttons[row][col].setOnAction(e -> handleButtonClick(r, c));
                grid.add(buttons[row][col], col, row);
            }
        }
    }

    private void placeMines() {
        Random random = new Random();
        int placedMines = 0;
        while (placedMines < NUM_MINES) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            if (!mines[row][col]) {
                mines[row][col] = true;
                placedMines++;
            }
        }
    }

    private void handleButtonClick(int row, int col) {
        if (gameOver) return;
        if (firstClick) {
            timer.start(); // เริ่มจับเวลาหลังจากคลิกแรก
            firstClick = false;
        }

        if (mines[row][col]) {
            buttons[row][col].setStyle("-fx-background-color: red;");
            showEndGameDialog("Game Over! You hit a mine.");
            gameOver = true;
            timer.stop();
        } else {
            int nearbyMines = countNearbyMines(row, col);
            buttons[row][col].setText(nearbyMines > 0 ? String.valueOf(nearbyMines) : "");
            buttons[row][col].setDisable(true);
            checkWin();
        }
    }

    private int countNearbyMines(int row, int col) {
        int count = 0;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int r = row + dr, c = col + dc;
                if (r >= 0 && r < SIZE && c >= 0 && c < SIZE && mines[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void checkWin() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (!mines[row][col] && !buttons[row][col].isDisabled()) {
                    return;
                }
            }
        }
        showEndGameDialog("You Won! Congratulations!");
        gameOver = true;
        timer.stop();
    }

    private void showEndGameDialog(String message) {
        Platform.runLater(() -> {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setTitle("Game Over");

            Text messageText = new Text(message);
            Button restartButton = new Button("Restart");
            restartButton.setOnAction(e -> {
                dialogStage.close();
                resetGame();
            });

            VBox vbox = new VBox(15);
            vbox.setStyle("-fx-background-color: white; -fx-padding: 20; -fx-alignment: center;");
            vbox.getChildren().addAll(messageText, restartButton);

            Scene scene = new Scene(vbox, 250, 150);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
        });
    }

    private void resetGame() {
        gameOver = false;
        firstClick = true;
        timer.reset();
        
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                mines[row][col] = false;
                buttons[row][col].setText("");
                buttons[row][col].setStyle("");
                buttons[row][col].setDisable(false);
            }
        }
        placeMines();
    }
}
