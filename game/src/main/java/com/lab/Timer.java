package com.lab;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Timer{
    private int seconds = 0;
    private boolean running = false;
    private Timeline timeline;
    private final Text timerText;

    public Timer(Text timerText) {
        this.timerText = timerText;
        this.timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> updateTimer()));
        this.timeline.setCycleCount(Timeline.INDEFINITE);
        updateDisplay();
    }

    private void updateTimer() {
        seconds++;
        updateDisplay();
    }

    private void updateDisplay() {
        timerText.setText("Time: " + seconds);
    }

    public void start() {
        if (!running) {
            running = true;
            timeline.play();
        }
    }

    public void stop() {
        running = false;
        timeline.stop();
    }

    public void reset() {
        stop();
        seconds = 0;
        updateDisplay();
    }
}
