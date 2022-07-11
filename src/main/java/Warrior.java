
import weapons.Weapon;

public class Warrior  implements IWarrior {

    private int health;
    private  int attack;
    private Warrior backLineWarrior;
    private int MAX_HEALTH = 50;

    public Warrior() {
        this(50, 5);

    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    public void hits(Warrior enemy) {
        SimpleDamage enemyDamage = new SimpleDamage(this.getAttack());
        enemy.hitBy(enemyDamage);
    }

    public void hitBy(Damage damage) {
        int attackerDamage = damage.getDamage();
        setHealth(getHealth() - attackerDamage);
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }


    public Warrior getBackLineWarrior() {
        return backLineWarrior;
    }

    void setBackLineWarrior(Warrior backLineWarrior) {
        this.backLineWarrior = backLineWarrior;
    }

    public void equipWeapon(Weapon weapon) {
        int additionalHealth = weapon.getHealth();
        int additionalAttack = weapon.getAttack();
        this.health += additionalHealth;
        this.attack += additionalAttack;
        MAX_HEALTH = getHealth();
    }

    @Override
    public Warrior decorate() {
        return null;
    }

    @Override
    public int getDefense() {
        return 0;
    }


}
