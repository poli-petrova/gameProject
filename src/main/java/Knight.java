import weapons.Weapon;

public class Knight extends Warrior {

    private static final int KNIGHT_ATTACK = 7;

    public Knight() {
        super(50, 7);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
    }
}
