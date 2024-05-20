package main.java.com.jpokebattle.logic;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PokemonGame {
    private Map<String, PokemonSpecies> speciesMap;
    private Player player;
    private Scanner scanner;

    public PokemonGame() throws IOException {
        this.speciesMap = PokemonLoader.loadPokemonSpecies();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        createPlayerTeam();
        battleLoop();
    }

    private void createPlayerTeam() {
        List<ConfiguredPokemon> team = new ArrayList<>();
        System.out.println("Crea la tua squadra di Pokémon. Seleziona fino a 6 Pokémon.");
        for (int i = 0; i < 6; i++) {
            System.out.print("Inserisci il nome del Pokémon (lascia vuoto per terminare): ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            if (speciesMap.containsKey(name)) {
                team.add(new ConfiguredPokemon(speciesMap.get(name), 1));
            } else {
                System.out.println("Nome del Pokémon non valido. Riprova.");
                i--;
            }
        }
        this.player = new Player(team);
    }

    private void battleLoop() {
        int level = 1;
        while (player.hasActivePokemon()) {
            ConfiguredPokemon opponent = createRandomOpponent(level);
            System.out.println("Affronti un " + opponent.getName() + " di livello " + level + "!");
            System.out.println("Vita attuale del tuo Pokémon: " + player.getActivePokemon().getCurrentHealth());
            PokemonBattle battle = new PokemonBattle(player, opponent);
            battle.startBattle();

            if (player.hasActivePokemon()) {
                System.out.println("Hai vinto la battaglia!");
                level++;
            } else {
                System.out.println("Hai perso la battaglia.");
            }
        }
        System.out.println("Tutti i tuoi Pokémon sono esausti. Fine del gioco.");
    }

    private ConfiguredPokemon createRandomOpponent(int level) {
        List<String> speciesNames = new ArrayList<>(speciesMap.keySet());
        String randomSpeciesName = speciesNames.get((int) (Math.random() * speciesNames.size()));
        return new ConfiguredPokemon(speciesMap.get(randomSpeciesName), level);
    }

    public static void main(String[] args) {
        try {
            PokemonGame game = new PokemonGame();
            game.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



