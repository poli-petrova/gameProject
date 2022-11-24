import weapons.Weapon;

public class Healer extends BaseWarrior {

    private int HEAL_POINTS = 2;

    public Healer() {
        super(new WarriorImpl(60, 0));
    }


    @Override
    public int getMaxHealth() {
        return 60;
    }


    public void heal(IWarrior toBeHealed) {
        int healthBefore = toBeHealed.getHealth();
        int healthAfter = healthBefore + HEAL_POINTS;
        if (healthAfter > toBeHealed.getMaxHealth()) {
            healthAfter = toBeHealed.getMaxHealth();
        }
        toBeHealed.changeHealth(healthAfter);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        int additionalHealPoints = weapon.getHealPower();
        HEAL_POINTS += additionalHealPoints;
    }
}
