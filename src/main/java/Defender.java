
public class Defender extends BaseWarrior  {

    public Defender() {
        super(new DefenderDecorator(new WarriorImpl(60, 3)));
    }

    @Override
    public int getMaxHealth() {
        return 60;
    }

}
