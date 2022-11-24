import weapons.Weapon;

public class Knight extends BaseWarrior {

    public Knight() {
        super(new WarriorImpl(50, 7));
    }

    @Override
    public int getMaxHealth() {
        return 50;
    }
}
