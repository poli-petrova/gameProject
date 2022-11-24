package weapons;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class Weapon {

    private int health = 0;
    private int attack = 0;
    private int defense = 0;
    private int vampirism = 0;
    private int healPower = 0;


    public Weapon(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    public Weapon(int health, int attack, int defense, int vampirism, int healPower) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.vampirism = vampirism;
        this.healPower = healPower;
    }

}

