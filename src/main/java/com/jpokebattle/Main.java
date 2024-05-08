package main.java.com.jpokebattle;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JPokeBattle");

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        // Immagini dei Pokémon
        Image pokemonImage1 = new Image("file:src/main/resources/images/pokemon1.png");
        ImageView pokemonView1 = new ImageView(pokemonImage1);
        pokemonView1.setFitHeight(100);
        pokemonView1.setFitWidth(100);

        Image pokemonImage2 = new Image("file:src/main/resources/images/pokemon2.png");
        ImageView pokemonView2 = new ImageView(pokemonImage2);
        pokemonView2.setFitHeight(100);
        pokemonView2.setFitWidth(100);

        // Barre della vita
        ProgressBar healthBar1 = new ProgressBar(0.75);
        healthBar1.setPrefWidth(200);
        ProgressBar healthBar2 = new ProgressBar(0.50);
        healthBar2.setPrefWidth(200);

        // Layout per i Pokémon e le loro barre della vita
        HBox pokemonBox1 = new HBox(10, pokemonView1, healthBar1);
        pokemonBox1.setAlignment(Pos.CENTER);
        HBox pokemonBox2 = new HBox(10, pokemonView2, healthBar2);
        pokemonBox2.setAlignment(Pos.CENTER);

        // Pulsanti per le mosse (placeholders)
        Button move1 = new Button("Mossa 1");
        Button move2 = new Button("Mossa 2");
        Button move3 = new Button("Mossa 3");
        Button move4 = new Button("Mossa 4");

        VBox movesBox = new VBox(10, move1, move2, move3, move4);
        movesBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(pokemonBox1, pokemonBox2, movesBox);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
