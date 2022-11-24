public class Warlord extends BaseWarrior {

    public Warlord() {
        super(new DefenderDecorator(new WarriorImpl(100, 4)));
    }

    @Override
    public int getMaxHealth() {
        return 100;
    }
}
