package main.java.com.jpokebattle.controllersAndScenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class SchermataSelezioneController {

    @FXML
    private TextField nameField;

    @FXML
    private ImageView maleTrainer;

    @FXML
    private ImageView femaleTrainer;

    @FXML
    private ToggleGroup pokeballGroup;

    @FXML
    private void initialize() {

    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        String name = nameField.getText();
        //RadioButton selectedRadioButton = (RadioButton) pokeballGroup.getSelectedToggle();
        //String pokeball = selectedRadioButton != null ? selectedRadioButton.getText() : "";

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("page2.fxml"));
            Parent root = loader.load();

            // Passaggio dei dati al controller della seconda pagina
            Page2Controller controller = loader.getController();
            String pokeball = "pokeball";
            controller.setNameAndPokeball(name, pokeball);

            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(root, 640, 480));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

