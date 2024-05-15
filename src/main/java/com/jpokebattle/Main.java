package main.java.com.jpokebattle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;


/**
 * The type Main.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {

        try {

            // Carica l'icona dell'applicazione
            InputStream stream = new FileInputStream("src/main/resources/images/icon.jpg"); // Carica l'icona dell'applicazione
            Image icon = new Image(stream);

            // Verifica se l'icona è caricata correttamente
            if (icon.isError()) {
                System.out.println("Errore nel caricamento dell'icona.");
            } else {
                stage.getIcons().add(icon);
            }

            Parent root = FXMLLoader.load(getClass().getResource("controllersAndScenes/SchermataSelezione.fxml"));
            Scene scene = new Scene(root);

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
        alert.setContentText("I tuoi progressi non verranno salvati.");

        if (alert.showAndWait().get() == ButtonType.OK){ //Se l'utente preme OK
            //System.out.println("Sei uscito dal gioco."); //DEBUG
            stage.close(); //Chiude la finestra
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


