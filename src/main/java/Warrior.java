import weapons.Sword;
import weapons.Weapon;

public class Warrior  {

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

    protected void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return MAX_HEALTH;
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

    protected void hitBy(Warrior attacker) {
        setHealth(getHealth() - attacker.getAttack());
    }

    public void hits(Warrior enemy) {
        enemy.hitBy(this);
    }

    protected Warrior getBackLineWarrior() {
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
}
