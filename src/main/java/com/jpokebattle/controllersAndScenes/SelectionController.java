package main.java.com.jpokebattle.controllersAndScenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectionController {

    @FXML
    private TextField nameField;

    @FXML
    private ImageView maleTrainer;

    @FXML
    private ImageView femaleTrainer;

    @FXML
    private ImageView pokeball1;

    @FXML
    private ImageView pokeball2;

    @FXML
    private ImageView pokeball3;

    @FXML
    private ImageView pokeball4;

    @FXML
    private ImageView pokeball5;

    @FXML
    private ImageView pokeball6;

    private ImageView selectedTrainer;
    private ImageView selectedPokeball;

    @FXML
    private void initialize() {
        selectedTrainer = null;
        selectedPokeball = null;

    }

    @FXML
    private void handleTrainerSelection(MouseEvent event) {
        if (selectedTrainer != null) {
            selectedTrainer.setStyle("");
        }
        selectedTrainer = (ImageView) event.getSource();
        selectedTrainer.setStyle("-fx-effect: dropshadow(gaussian, blue, 10, 0, 0, 0);");
    }

    @FXML
    private void handlePokeballSelection(MouseEvent event) {
        if (selectedPokeball != null) {
            selectedPokeball.setStyle("");
        }
        selectedPokeball = (ImageView) event.getSource();
        selectedPokeball.setStyle("-fx-effect: dropshadow(gaussian, red, 10, 0, 0, 0);");
    }

    @FXML
    //
    private void handleButtonClick(ActionEvent event) {
        String name = nameField.getText();

        if (name.isEmpty() || selectedTrainer == null || selectedPokeball == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter your name, select a trainer, and choose a Pokéball.");
            alert.showAndWait();
            return;
        }

        String trainer = selectedTrainer == maleTrainer ? "Male Trainer" : "Female Trainer";
        String pokeball = getPokeballName(selectedPokeball);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("page2.fxml"));
            Parent root = loader.load();

            Page2Controller controller = loader.getController();
            controller.setNameAndPokeball(name, trainer, pokeball);

            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(root, 640, 480));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private String getPokeballName(ImageView pokeball) {
        if (pokeball == pokeball1) {
            return "Pokéball 1";
        } else if (pokeball == pokeball2) {
            return "Pokéball 2";
        } else if (pokeball == pokeball3) {
            return "Pokéball 3";
        } else if (pokeball == pokeball4) {
            return "Pokéball 4";
        } else if (pokeball == pokeball5) {
            return "Pokéball 5";
        } else if (pokeball == pokeball6) {
            return "Pokéball 6";
        }
        return "";
    }
}
