public class Rookie extends BaseWarrior {

    public Rookie() {
        super(new WarriorImpl(50, 1));
    }

    @Override
    public int getMaxHealth() {
        return 50;
    }
}
