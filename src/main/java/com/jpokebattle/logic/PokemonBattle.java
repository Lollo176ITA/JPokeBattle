package main.java.com.jpokebattle.logic;

import java.util.Random;

public class PokemonBattle {
    private Player player;
    private ConfiguredPokemon opponent;
    private Random random = new Random();

    public PokemonBattle(Player player, ConfiguredPokemon opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    public void startBattle() {
        while (player.hasActivePokemon() && opponent.getCurrentHealth() > 0) {
            playerTurn();
            if (opponent.getCurrentHealth() > 0) {
                botTurn();
            }
        }

        if (player.hasActivePokemon()) {
            System.out.println("Hai vinto la battaglia!");
            player.getActivePokemon().gainExperience(100); // Esempio di guadagno esperienza
            if (player.getActivePokemon().canEvolve()) {
                player.getActivePokemon().evolve();
            }
        } else {
            System.out.println("Hai perso la battaglia.");
        }
    }

    private void playerTurn() {
        ConfiguredPokemon activePokemon = player.getActivePokemon();
        Move selectedMove = player.chooseMove();
        executeTurn(activePokemon, opponent, selectedMove);
    }

    private void botTurn() {
        Move selectedMove = opponent.getMoves().get(random.nextInt(opponent.getMoves().size()));
        executeTurn(opponent, player.getActivePokemon(), selectedMove);
    }

    private void executeTurn(ConfiguredPokemon attacker, ConfiguredPokemon defender, Move move) {
        System.out.println(attacker.getName() + " usa " + move.getName() + "!");

        if (attacker.getBaseSpeed() > defender.getBaseSpeed()) {
            int damage = calculateDamage(attacker, defender, move);
            defender.receiveDamage(damage);
            System.out.println(defender.getName() + " ha subito " + damage + " danni. Vita rimanente: " + defender.getCurrentHealth());

            if (defender.getCurrentHealth() > 0) {
                damage = calculateDamage(defender, attacker, move);
                attacker.receiveDamage(damage);
                System.out.println(attacker.getName() + " ha subito " + damage + " danni. Vita rimanente: " + attacker.getCurrentHealth());
            }
        } else {
            int damage = calculateDamage(defender, attacker, move);
            attacker.receiveDamage(damage);
            System.out.println(attacker.getName() + " ha subito " + damage + " danni. Vita rimanente: " + attacker.getCurrentHealth());

            if (attacker.getCurrentHealth() > 0) {
                damage = calculateDamage(attacker, defender, move);
                defender.receiveDamage(damage);
                System.out.println(defender.getName() + " ha subito " + damage + " danni. Vita rimanente: " + defender.getCurrentHealth());
            }
        }
    }

    private int calculateDamage(ConfiguredPokemon attacker, ConfiguredPokemon defender, Move move) {
        double effectiveness = move.getType().getEffectivenessAgainst(defender.getType());
        return (int) (move.getPower() * effectiveness);
    }
}


