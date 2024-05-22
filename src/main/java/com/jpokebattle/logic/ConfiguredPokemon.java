package main.java.com.jpokebattle.logic;


//Questa classe gestisce i pokemon separatamente
public class ConfiguredPokemon extends Pokemon {
    private PokemonSpecies species;

    public ConfiguredPokemon(PokemonSpecies species, int level) {
        super(species.getName(), species.getType(), species.getBaseHealth(), species.getBaseAttack(), species.getBaseDefense(), species.getBaseSpeed(), species.getMoves(), level);
        this.species = species;
    }
    //Per ora questo metodo lo metto da parte
    @Override
    public void attack(Pokemon target, Move move) {
        move.execute(this, (ConfiguredPokemon) target);
    }

    @Override
    public boolean canEvolve() { //TODO: alcuni pokemon si evolvono lollo...
        return false;
    }

    @Override
    public void evolve() { //TODO: implementare la logica evolutiva

    }

}


