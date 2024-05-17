package main.java.com.jpokebattle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.Stage;

import java.io.FileInputStream;


/**
 * The type Main.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {

        try {

            // Set the icon of the stage
            stage.getIcons().add(new Image(new FileInputStream("src/main/resources/images/icon.jpg")));


            Parent root = FXMLLoader.load(getClass().getResource("controllersAndScenes/Start.fxml"));
            Scene scene = new Scene(root, 640, 480); //4:3 ratio


            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            stage.setTitle("PokeBattle");


            stage.setOnCloseRequest(event -> {
                event.consume();
                logout(stage);
            });

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void logout(Stage stage){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Uscita dal gioco");
        alert.setHeaderText("Sei sicuro di voler uscire?");
        alert.setContentText("Potresti pentirtene amaramente");

        if (alert.showAndWait().get() == ButtonType.OK){ //Se l'utente preme OK
            //System.out.println("Sei uscito dal gioco."); //DEBUG
            stage.close(); //Chiude la finestra
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


