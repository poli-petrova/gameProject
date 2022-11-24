import weapons.Weapon;

public class Vampire extends BaseWarrior {

    private  int VAMPIRISM = 50;

    public Vampire() {
        super(new WarriorImpl(40, 4));
    }


    @Override
    public int getMaxHealth() {
        return 40;
    }

    public int getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public void hits(IWarrior enemy) {
        int healthBefore = enemy.getHealth();
        super.hits(enemy);
        int damage = healthBefore - enemy.getHealth();
        int restoreHealth = damage * getVampirism() / 100;
        changeHealth((Math.min(40, getHealth() + restoreHealth)));
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
