package main.java.com.jpokebattle.logic;

import java.util.EnumMap;
import java.util.Map;

public enum PokemonType {
    NORMAL,
    FIRE,
    WATER,
    ELECTRIC,
    GRASS,
    ICE,
    FIGHTING,
    POISON,
    GROUND,
    FLYING,
    PSYCHIC,
    BUG,
    ROCK,
    GHOST,
    DRAGON;

    private static final Map<PokemonType, Map<PokemonType, Double>> effectivenessMap = new EnumMap<>(PokemonType.class);

    static {
        for (PokemonType type : PokemonType.values()) {
            effectivenessMap.put(type, new EnumMap<>(PokemonType.class));
        }

        // Normale
        effectivenessMap.get(NORMAL).put(ROCK, 0.5);
        effectivenessMap.get(NORMAL).put(GHOST, 0.0);

        // Fuoco
        effectivenessMap.get(FIRE).put(FIRE, 0.5);
        effectivenessMap.get(FIRE).put(WATER, 0.5);
        effectivenessMap.get(FIRE).put(GRASS, 2.0);
        effectivenessMap.get(FIRE).put(ICE, 2.0);
        effectivenessMap.get(FIRE).put(BUG, 2.0);
        effectivenessMap.get(FIRE).put(ROCK, 0.5);
        effectivenessMap.get(FIRE).put(DRAGON, 0.5);

        // Acqua
        effectivenessMap.get(WATER).put(FIRE, 2.0);
        effectivenessMap.get(WATER).put(WATER, 0.5);
        effectivenessMap.get(WATER).put(GRASS, 0.5);
        effectivenessMap.get(WATER).put(GROUND, 2.0);
        effectivenessMap.get(WATER).put(ROCK, 2.0);
        effectivenessMap.get(WATER).put(DRAGON, 0.5);

        // Elettro
        effectivenessMap.get(ELECTRIC).put(WATER, 2.0);
        effectivenessMap.get(ELECTRIC).put(ELECTRIC, 0.5);
        effectivenessMap.get(ELECTRIC).put(GRASS, 0.5);
        effectivenessMap.get(ELECTRIC).put(GROUND, 0.0);
        effectivenessMap.get(ELECTRIC).put(FLYING, 2.0);
        effectivenessMap.get(ELECTRIC).put(DRAGON, 0.5);

        // Erba
        effectivenessMap.get(GRASS).put(FIRE, 0.5);
        effectivenessMap.get(GRASS).put(WATER, 2.0);
        effectivenessMap.get(GRASS).put(GRASS, 0.5);
        effectivenessMap.get(GRASS).put(POISON, 0.5);
        effectivenessMap.get(GRASS).put(GROUND, 2.0);
        effectivenessMap.get(GRASS).put(FLYING, 0.5);
        effectivenessMap.get(GRASS).put(BUG, 0.5);
        effectivenessMap.get(GRASS).put(ROCK, 2.0);
        effectivenessMap.get(GRASS).put(DRAGON, 0.5);

        // Ghiaccio
        effectivenessMap.get(ICE).put(FIRE, 0.5);
        effectivenessMap.get(ICE).put(WATER, 0.5);
        effectivenessMap.get(ICE).put(GRASS, 2.0);
        effectivenessMap.get(ICE).put(ICE, 0.5);
        effectivenessMap.get(ICE).put(GROUND, 2.0);
        effectivenessMap.get(ICE).put(FLYING, 2.0);
        effectivenessMap.get(ICE).put(DRAGON, 2.0);

        // Lotta
        effectivenessMap.get(FIGHTING).put(NORMAL, 2.0);
        effectivenessMap.get(FIGHTING).put(ICE, 2.0);
        effectivenessMap.get(FIGHTING).put(POISON, 0.5);
        effectivenessMap.get(FIGHTING).put(FLYING, 0.5);
        effectivenessMap.get(FIGHTING).put(PSYCHIC, 0.5);
        effectivenessMap.get(FIGHTING).put(BUG, 0.5);
        effectivenessMap.get(FIGHTING).put(ROCK, 2.0);
        effectivenessMap.get(FIGHTING).put(GHOST, 0.0);

        // Veleno
        effectivenessMap.get(POISON).put(GRASS, 2.0);
        effectivenessMap.get(POISON).put(POISON, 0.5);
        effectivenessMap.get(POISON).put(GROUND, 0.5);
        effectivenessMap.get(POISON).put(ROCK, 0.5);
        effectivenessMap.get(POISON).put(GHOST, 0.5);

        // Terra
        effectivenessMap.get(GROUND).put(FIRE, 2.0);
        effectivenessMap.get(GROUND).put(ELECTRIC, 2.0);
        effectivenessMap.get(GROUND).put(GRASS, 0.5);
        effectivenessMap.get(GROUND).put(POISON, 2.0);
        effectivenessMap.get(GROUND).put(FLYING, 0.0);
        effectivenessMap.get(GROUND).put(BUG, 0.5);
        effectivenessMap.get(GROUND).put(ROCK, 2.0);

        // Volante
        effectivenessMap.get(FLYING).put(ELECTRIC, 0.5);
        effectivenessMap.get(FLYING).put(GRASS, 2.0);
        effectivenessMap.get(FLYING).put(FIGHTING, 2.0);
        effectivenessMap.get(FLYING).put(BUG, 2.0);
        effectivenessMap.get(FLYING).put(ROCK, 0.5);

        // Psichico
        effectivenessMap.get(PSYCHIC).put(FIGHTING, 2.0);
        effectivenessMap.get(PSYCHIC).put(POISON, 2.0);
        effectivenessMap.get(PSYCHIC).put(PSYCHIC, 0.5);

        // Coleottero
        effectivenessMap.get(BUG).put(FIRE, 0.5);
        effectivenessMap.get(BUG).put(GRASS, 2.0);
        effectivenessMap.get(BUG).put(FIGHTING, 0.5);
        effectivenessMap.get(BUG).put(POISON, 2.0);
        effectivenessMap.get(BUG).put(FLYING, 0.5);
        effectivenessMap.get(BUG).put(PSYCHIC, 2.0);
        effectivenessMap.get(BUG).put(GHOST, 0.5);

        // Roccia (Rock)
        effectivenessMap.get(ROCK).put(FIRE, 2.0);
        effectivenessMap.get(ROCK).put(ICE, 2.0);
        effectivenessMap.get(ROCK).put(FIGHTING, 0.5);
        effectivenessMap.get(ROCK).put(GROUND, 0.5);
        effectivenessMap.get(ROCK).put(FLYING, 2.0);
        effectivenessMap.get(ROCK).put(BUG, 2.0);

        // Spettro
        effectivenessMap.get(GHOST).put(NORMAL, 0.0);
        effectivenessMap.get(GHOST).put(PSYCHIC, 0.0);
        effectivenessMap.get(GHOST).put(GHOST, 2.0);

        // Drago
        effectivenessMap.get(DRAGON).put(DRAGON, 2.0);
    }
    // Metodo per ottenere l'efficacia di un tipo di Pokemon contro un altro tipo di Pokemon (es. tipo Fuoco contro tipo Acqua)
    public double getEffectivenessAgainst(PokemonType other) {
        return effectivenessMap.get(this).getOrDefault(other, 1.0);
    }
    /*
    // Metodo main per testare il codice
    public static void main(String[] args) {
        PokemonType type = PokemonType.FIRE;
        System.out.println(type.getEffectivenessAgainst(PokemonType.WATER));
    }
    */
}
