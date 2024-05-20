package main.java.com.jpokebattle.logic;

import java.util.List;
import java.util.Scanner;

public class Player {
    private List<ConfiguredPokemon> team;
    private Scanner scanner = new Scanner(System.in);

    public Player(List<ConfiguredPokemon> team) {
        this.team = team;
    }

    public boolean hasActivePokemon() {
        return team.stream().anyMatch(p -> p.getCurrentHealth() > 0);
    }

    public ConfiguredPokemon getActivePokemon() {
        return team.stream().filter(p -> p.getCurrentHealth() > 0).findFirst().orElse(null);
    }

    public Move chooseMove() {
        ConfiguredPokemon activePokemon = getActivePokemon();
        System.out.println("Scegli una mossa:");
        for (int i = 0; i < activePokemon.getMoves().size(); i++) {
            System.out.println((i + 1) + ": " + activePokemon.getMoves().get(i).getName());
        }
        int choice = scanner.nextInt() - 1;
        return activePokemon.getMoves().get(choice);
    }
}


