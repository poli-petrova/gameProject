import weapons.Weapon;

public class Vampire extends Warrior {
    private int ATTACK = 4;
    private  int VAMPIRISM = 50;
    private final int MAX_HEALTH = 40;

    public Vampire() {
        super(40, 4);
    }


    @Override
    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    public int getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public void hits(Warrior enemy) {
        int healthBefore = enemy.getHealth();
        super.hits(enemy);
        int damage = healthBefore - enemy.getHealth();
        int restoreHealth = damage * getVampirism() / 100;
        setHealth((Math.min(40, getHealth() + restoreHealth)));
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        int additionalVampirism = weapon.getVampirism();
        VAMPIRISM = getVampirism() + additionalVampirism;
        if (getVampirism() < 0) {
            VAMPIRISM = 0;
        }
    }
}
