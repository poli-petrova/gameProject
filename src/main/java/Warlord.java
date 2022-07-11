import weapons.Weapon;

public class Warlord extends Warrior {

    private int WARLORD_ATTACK = 4;
    private int DEFENSE = 2;

    public Warlord() {
        super(100, 4);
    }


    public int getDefense() {
        return DEFENSE;
    }

    @Override
    public void hitBy(Damage damage) {
        int attackerDamage = damage.getDamage();
        setHealth(getHealth() - (Math.max(0, attackerDamage - getDefense())));
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        int additionalDefense = weapon.getDefense();
        DEFENSE = getDefense() + additionalDefense;
    }

}
