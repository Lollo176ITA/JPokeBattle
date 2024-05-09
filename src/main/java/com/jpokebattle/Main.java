package main.java.com.jpokebattle;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Root layout
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // Player and opponent info
        VBox playerInfo = new VBox(10);
        playerInfo.setAlignment(Pos.CENTER_LEFT);
        Label playerName = new Label("Lollo176ITA");
        playerName.setFont(new Font("Arial", 20));
        playerInfo.getChildren().add(playerName);

        VBox opponentInfo = new VBox(10);
        opponentInfo.setAlignment(Pos.CENTER_RIGHT);
        Label opponentName = new Label("B3EaNN");
        opponentName.setFont(new Font("Arial", 20));
        opponentInfo.getChildren().add(opponentName);

        root.setLeft(playerInfo);
        root.setRight(opponentInfo);

        // Main battle area
        GridPane battleArea = new GridPane();
        battleArea.setAlignment(Pos.CENTER);
        battleArea.setHgap(50);

        // Solgaleo Image
        Image solgaleoImage = new Image("file:src/main/resources/images/pokemon2.png"); // Adjust the file path as needed
        ImageView solgaleoView = new ImageView(solgaleoImage);
        solgaleoView.setFitHeight(200);
        solgaleoView.setFitWidth(200);
        Label solgaleoLabel = new Label("Solgaleo L74\nHP: 325/325", solgaleoView);
        solgaleoLabel.setContentDisplay(ContentDisplay.TOP);

        // Typhlosion Image
        Image typhlosionImage = new Image("file:src/main/resources/images/pokemon1.png"); // Adjust the file path as needed
        ImageView typhlosionView = new ImageView(typhlosionImage);
        typhlosionView.setFitHeight(200);
        typhlosionView.setFitWidth(200);
        Label typhlosionLabel = new Label("Typhlosion L84\nHP: 100%", typhlosionView);
        typhlosionLabel.setContentDisplay(ContentDisplay.TOP);

        battleArea.add(solgaleoLabel, 0, 0);
        battleArea.add(typhlosionLabel, 1, 0);

        root.setCenter(battleArea);

        // Action buttons
        HBox actionButtons = new HBox(10);
        actionButtons.setAlignment(Pos.CENTER);
        Button attackButton = new Button("Attack");
        Button switchButton = new Button("Switch");

        actionButtons.getChildren().addAll(attackButton, switchButton);

        root.setBottom(actionButtons);

        // Scene setup
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Pokémon Battle UI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


