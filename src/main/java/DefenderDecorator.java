import weapons.Weapon;

public class DefenderDecorator extends BaseWarrior {

    private static int DEFENSE = 2;

    public DefenderDecorator(IWarrior iWarrior) {
        super(iWarrior);
    }


    public static int getDefense() {
        return DEFENSE;
    }

    public static void setDEFENSE(int DEFENSE) {
        DefenderDecorator.DEFENSE = DEFENSE;
    }

    @Override
    public void hitBy(Damage damage) {
        int attackerDamage = damage.getDamage();
        changeHealth(getHealth() - (Math.max(0, attackerDamage - getDefense())));
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        int additionalDefense = weapon.getDefense();
        setDEFENSE(getDefense() + additionalDefense);
    }


}
