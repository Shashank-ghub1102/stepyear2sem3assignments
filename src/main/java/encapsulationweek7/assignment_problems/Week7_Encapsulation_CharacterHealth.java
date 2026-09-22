package encapsulationweek7.assignment_problems;

class Character {
    private int health;
    private final int maximumHealth;

    Character(int maximumHealth) {
        this.maximumHealth = Math.max(0, maximumHealth);
        health = this.maximumHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        if (amount > 0) health = Math.min(maximumHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }
}

public class Week7_Encapsulation_CharacterHealth {
    public static void main(String[] args) {
        Character character = new Character(100);
        character.takeDamage(30);
        character.heal(10);
        System.out.println("Health: " + character.getHealth());
    }
}
