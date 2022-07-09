import weapons.Weapon;

public class Defender extends Warrior {

    private int DEFENSE = 2;
    private final int MAX_HEALTH = 60;

    public Defender() {
        super(60, 3);
    }

    @Override
    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    public int getDefense() {
        return DEFENSE;
    }

    public void setDEFENSE(int defense) {
        this.DEFENSE = defense;
    }

    @Override
    protected void hitBy(Warrior attacker) {
        setHealth(getHealth() - (Math.max(0, attacker.getAttack() - getDefense())));
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        int additionalDefense = weapon.getDefense();
        setDEFENSE(getDefense() + additionalDefense);
    }
}