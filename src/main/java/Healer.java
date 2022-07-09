import weapons.Weapon;

public class Healer extends Warrior {

    private final int HEALER_ATTACK = 0;
    private int HEAL_POINTS = 2;
    private final int MAX_HEALTH = 60;

    public Healer() {
        super(60, 0);
    }


    @Override
    public int getMaxHealth() {
        return MAX_HEALTH;
    }


    public void heal(Warrior toBeHealed) {
        int healthBefore = toBeHealed.getHealth();
        int healthAfter = healthBefore + HEAL_POINTS;
        if (healthAfter > toBeHealed.getMaxHealth()) {
            healthAfter = toBeHealed.getMaxHealth();
        }
        toBeHealed.setHealth(healthAfter);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        int additionalHealPoints = weapon.getHealPower();
        HEAL_POINTS += additionalHealPoints;
    }
}
