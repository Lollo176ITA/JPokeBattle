package main.java.com.jpokebattle.logic;
public class Bot {
    private ConfiguredPokemon pokemon;

    public Bot(ConfiguredPokemon pokemon) {
        this.pokemon = pokemon;
    }

    public ConfiguredPokemon getPokemon() {
        return pokemon;
    }
}
