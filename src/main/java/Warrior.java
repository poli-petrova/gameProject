public class Warrior extends BaseWarrior {

    protected Warrior() {
        super(new WarriorImpl(50, 5));
    }

    @Override
    public int getMaxHealth() {
        return 50;
    }
}
