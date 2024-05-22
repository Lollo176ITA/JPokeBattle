package main.java.com.jpokebattle.logic;

public class Move {
    private String name;
    private PokemonType type;
    private int power;
    private int accuracy;
    private int maxPP;
    private boolean isDamaging;

    public Move(String name, PokemonType type, int power, int accuracy, int maxPP, boolean isDamaging) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.maxPP = maxPP;
        this.isDamaging = isDamaging;
    }

    public void execute(ConfiguredPokemon attacker, ConfiguredPokemon target) {
        if (isDamaging) {
            double effectiveness = type.getEffectivenessAgainst(target.getType());
            int damage = (int) (power * effectiveness);
            target.receiveDamage(damage);
        } else {
            //TODO: implementa gli effetti delle mosse non dannose
        }
    }

    // Getters e setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getMaxPP() {
        return maxPP;
    }

    public void setMaxPP(int maxPP) {
        this.maxPP = maxPP;
    }

    public boolean isDamaging() {
        return isDamaging;
    }

    public void setDamaging(boolean damaging) {
        isDamaging = damaging;
    }

}
