package main.java.com.jpokebattle.logic;

import java.util.Random;

public class PokemonBattle {
    private Player player;
    private ConfiguredPokemon opponent; //Affrontando singoli avversari sarà più facile invertarmi una botness adeguata
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
        executeTurn(activePokemon, opponent, selectedMove,true);
    }

    private void botTurn() {
        Move selectedMove = opponent.getMoves().get(random.nextInt(opponent.getMoves().size()));
        executeTurn(opponent, player.getActivePokemon(), selectedMove, false);
    }
    //TODO: invece di executeTurn devo usare attack della classe ConfiguredPokemon.java inoltre così non riconosco bene quale sia il mio pokemon
    //Così entrambi usano la stessa mossa, ops... Possibile soluzione: usando una variabile boolean tengo traccia se sta attaccando il bot o il player
    private void executeTurn(ConfiguredPokemon attacker, ConfiguredPokemon defender, Move move, Boolean player) {
        System.out.println((player == true ? "Il tuo " : "Avversario ") + attacker.getName() + " usa " + move.getName() + "!");

        if (attacker == null || defender == null) return; //Per evitare errori in esecuzione (spero)

        //TODO: sleep lollo and then "smettila di scrivere in inglese"

        //Gotta redo the all fucking logic
        /*
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

         */

    }

    private int calculateDamage(ConfiguredPokemon attacker, ConfiguredPokemon defender, Move move) {
        double effectiveness = move.getType().getEffectivenessAgainst(defender.getType()); //In realtà sapere il tipo dell'attaccante non mi da alcuna informazione sul tipo di mossa
        return (int) (move.getPower() * effectiveness);
    }
}


