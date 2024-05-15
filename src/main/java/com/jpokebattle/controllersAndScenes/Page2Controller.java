package main.java.com.jpokebattle.controllersAndScenes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Page2Controller {

    @FXML
    private Label nameLabel;

    @FXML
    private Label trainerLabel;

    @FXML
    private Label pokeballLabel;

    public void setNameAndPokeball(String name, String trainer, String pokeball) {
        nameLabel.setText("Nome: " + name);
        trainerLabel.setText("Genere: " + trainer);
        pokeballLabel.setText("Pokéball Preferita: " + pokeball);
    }
}
