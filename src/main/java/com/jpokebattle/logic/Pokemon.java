package main.java.com.jpokebattle.logic;

import java.util.List;
import java.util.Map;

public abstract class Pokemon {
    protected String name;
    protected PokemonType type;
    protected int baseHealth;
    protected int baseAttack;
    protected int baseDefense;
    protected int baseSpeed;
    protected List<Move> moves;
    protected int level;
    protected int currentHealth;
    protected int experiencePoints;

    public Pokemon(String name, PokemonType type, int baseHealth, int baseAttack, int baseDefense, int baseSpeed, List<Move> moves, int level) {
        this.name = name;
        this.type = type;
        this.baseHealth = baseHealth;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.baseSpeed = baseSpeed;
        this.moves = moves;
        this.level = level;
        this.currentHealth = calculateMaxHealth();
    }

    protected int calculateMaxHealth() {
        return baseHealth + (level * 5);  // Formula semplificata
    }

    public void levelUp() {
        level++;
        currentHealth = calculateMaxHealth();
    }

    public void attack(Pokemon target, Move move) {
        move.execute((ConfiguredPokemon) this, (ConfiguredPokemon) target);
    }

    public void receiveDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0) currentHealth = 0;
    }

    public PokemonType getType() {
        return type;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public void gainExperience(int i) {
        experiencePoints += i;
    }


    public abstract boolean canEvolve();
    //public abstract PokemonSpecies getEvolution();

    public abstract void evolve();
}

