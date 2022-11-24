import weapons.Weapon;

public class WarriorImpl implements IWarrior {

    private int health;
    private int attack;
    private IWarrior backLineWarrior;
    private int maxHealth;

    public WarriorImpl(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public IWarrior getBackLineWarrior() {
        return backLineWarrior;
    }

    @Override
    public void setBackLineWarrior(IWarrior warrior) {
        this.backLineWarrior = warrior;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        int additionalHealth = weapon.getHealth();
        int additionalAttack = weapon.getAttack();
        this.health += additionalHealth;
        this.attack += additionalAttack;
        maxHealth = getHealth();
    }

    @Override
    public void hitBy(Damage damage) {
        int attackerDamage = damage.getDamage();
        changeHealth(getHealth() - attackerDamage);
    }

    @Override
    public void hits(IWarrior enemy) {
        SimpleDamage enemyDamage = new SimpleDamage(this.getAttack());
        enemy.hitBy(enemyDamage);
    }

    @Override
    public void changeHealth(int health) {
        this.health = health;
    }


}
