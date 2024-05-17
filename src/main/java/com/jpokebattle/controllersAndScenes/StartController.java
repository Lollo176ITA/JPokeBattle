package main.java.com.jpokebattle.controllersAndScenes;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;


public class StartController {
    private int rickRollCounter = 0;

    @FXML
    private ImageView background;
    @FXML
    private Label createdBy;
    @FXML
    private Button startButton;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label progressLabel;

    private double progress = 0.0;
    private Timeline progressBarTimeline;
    private static final Random random = new Random();

    @FXML
    private void initialize() throws FileNotFoundException {

        progressBar.setVisible(false);
        progressLabel.setVisible(false);

        background.setImage(new Image(new FileInputStream("src/main/resources/images/background.jpg")));
        background.setFitWidth(640);
        background.setFitHeight(480);
        startButton.setStyle("-fx-background-color: #313131; -fx-text-fill: white;");

    }


    // The following methods are used to handle the start button

    @FXML
    private void handleStartMouseEntered() {
        startButton.setStyle("-fx-background-radius: 50; -fx-border-radius: 50;");
    }
    @FXML
    private void handleStartMouseExited() {
        startButton.setStyle("-fx-background-color: #313131; -fx-text-fill: white;");

    }

    @FXML
    private void handleStart(){
        Timeline buttonTimeline = new Timeline();
        KeyValue keyValueOpacity = new KeyValue(startButton.opacityProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.4), keyValueOpacity);
        buttonTimeline.getKeyFrames().add(keyFrame);

        buttonTimeline.setOnFinished(event -> {
            startButton.setVisible(false);
            progressBar.setVisible(true);
            progressBar.setVisible(true);
            startProgressBar();
        });

        buttonTimeline.play();

    /*
        timeline.setOnFinished(event -> {
            System.out.println("Animation finished, changing scene");
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Selection.fxml"));
                Scene scene = startButton.getScene();
                scene.setRoot(root);
                System.out.println("Scene changed successfully");
            } catch (IOException e) {
                System.err.println("Error loading FXML file");
                e.printStackTrace();
            }
        });
        timeline.play(); */
    }
    // The following methods are used to handle the progress bar
    private void startProgressBar() {
        progressBarTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.005), e -> updateProgress())
        );
        progressBarTimeline.setCycleCount(Timeline.INDEFINITE);
        progressBarTimeline.play();
    }

    private void updateProgress() {
        progress += random.nextDouble() * 0.003;
        if (progress >= 1) {
            progressBarTimeline.stop();
            progress = 1;
            changeScene();
        }
        progressBar.setProgress(progress);
        progressLabel.setText(String.format("%.0f%%", progress * 100));
    }

    private void changeScene() {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("Selection.fxml"));
            Stage stage = (Stage) progressBar.getScene().getWindow();
            stage.setScene(new Scene(newRoot));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // The following methods are used to rickroll the user

    @FXML
    private void handleCreatedByMouseEntered() {
        DropShadow shadow = new DropShadow(15,Color.WHITE);

        createdBy.setEffect(shadow);
    }
    @FXML
    private void handleCreatedByMouseExited() {
        createdBy.setEffect(null);
    }

    @FXML
    private void handleCreatedBy() throws IOException, URISyntaxException {
        getRickRolled();
        createdBy.setText("Lmao, you got rickrolled " + rickRollCounter + " time" + (rickRollCounter == 1 ? "" : "s"));
        createdBy.setAlignment(Pos.CENTER_RIGHT);
    }


    private void getRickRolled() throws URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
        rickRollCounter++;
    }

}
