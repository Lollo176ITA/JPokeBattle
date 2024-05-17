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
            stage.setResizable(false); //Non permette di ridimensionare la finestra per ora (potrebbe essere utile in futuro)
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
        alert.setTitle("Exit PokeBattle");
        alert.setHeaderText("Are you sure to exit?"); //Chiede all'utente se è sicuro di voler uscire dal gioco (per evitare chiusure accidentali)
        alert.setContentText("Potresti pentirtene amaramente"); //Easter egg per chi ha giocato a Pokemon Rosso/Blu su GameBoy Advance (2003) e ha scelto di non salvare il gioco prima di sfidare il Team Rocket al Monte Argento (e poi ha perso) :D (per chi non lo sapesse, il gioco si bloccava e non era possibile proseguire)

        if (alert.showAndWait().get() == ButtonType.OK){
            //System.out.println("Sei uscito dal gioco."); //DEBUG
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


