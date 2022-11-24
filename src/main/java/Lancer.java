public class Lancer extends BaseWarrior {

    public Lancer() {
        super(new LancerDecorator(new WarriorImpl(50, 6)));
    }

    @Override
    public int getMaxHealth() {
        return 50;
    }

}
