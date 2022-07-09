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
    protected void hitBy(Warrior attacker) {
        setHealth(getHealth() - (Math.max(0, attacker.getAttack() - getDefense())));
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        int additionalDefense = weapon.getDefense();
        DEFENSE = getDefense() + additionalDefense;
    }

}
