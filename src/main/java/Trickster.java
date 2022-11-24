public class Trickster extends BaseWarrior {


    protected Trickster() {
        super(new LancerDecorator(new DefenderDecorator(new WarriorImpl(50, 3))));
    }

}
