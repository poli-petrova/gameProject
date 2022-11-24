public class LancerDecorator extends BaseWarrior {

    public LancerDecorator(IWarrior iWarrior) {
        super(iWarrior);
    }

    @Override
    public void hits(IWarrior enemy) {
        int healthBefore = enemy.getHealth();
        super.hits(enemy);
        int healthAfter = enemy.getHealth();
        int damageDealtToFirstEnemy = healthAfter - healthBefore;
        var damageForSecondEnemy = damageDealtToFirstEnemy * 50 / 100;

        IWarrior theSecondEnemy = enemy.getBackLineWarrior();
        if (theSecondEnemy != null) {
            theSecondEnemy.changeHealth(theSecondEnemy.getHealth() + (damageForSecondEnemy));
        }
    }
}
