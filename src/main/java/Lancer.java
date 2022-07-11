public class Lancer extends Warrior {

    private static final int LANCER_ATTACK = 6;
    static final int PIERCE_POWER = 50;
    static final int PERCENTAGE = 100;
    private final int MAX_HEALTH = 50;

    public Lancer() {
        super(50, 6);
    }

    @Override
    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    @Override
    public void hits(Warrior enemy) {
        int healthBefore = enemy.getHealth();
        super.hits(enemy);
        int healthAfter = enemy.getHealth();
        int damageDealtToFirstEnemy = healthAfter - healthBefore;
        var damageForSecondEnemy = damageDealtToFirstEnemy * PIERCE_POWER / PERCENTAGE;

        Warrior theSecondEnemy = enemy.getBackLineWarrior();
        if (theSecondEnemy != null) {
            theSecondEnemy.setHealth(theSecondEnemy.getHealth() + (damageForSecondEnemy));
        }
    }
}
