package main.java.com.jpokebattle.logic;

public class ConfiguredPokemon extends Pokemon {
    private PokemonSpecies species;

    public ConfiguredPokemon(PokemonSpecies species, int level) {
        super(species.getName(), species.getType(), species.getBaseHealth(), species.getBaseAttack(), species.getBaseDefense(), species.getBaseSpeed(), species.getMoves(), level);
        this.species = species;
    }

    @Override
    public void attack(Pokemon target, Move move) {
        move.execute(this, (ConfiguredPokemon) target);
    }

    @Override
    public boolean canEvolve() {
        return false;
    }

    @Override
    public void evolve() {

    }

}


