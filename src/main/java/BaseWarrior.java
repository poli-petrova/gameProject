import weapons.Weapon;

public abstract class BaseWarrior implements IWarrior {

    private IWarrior iWarrior;

    public BaseWarrior(IWarrior iWarrior) {
        this.iWarrior = iWarrior;
    }

    @Override
    public int getAttack() {
        return iWarrior.getAttack();
    }

    @Override
    public int getHealth() {
        return iWarrior.getHealth();
    }

    @Override
    public boolean isAlive() {
        return iWarrior.isAlive();
    }

    @Override
    public int getMaxHealth() {
        return iWarrior.getMaxHealth();
    }

    @Override
    public IWarrior getBackLineWarrior() {
        return iWarrior.getBackLineWarrior();
    }

    @Override
    public void setBackLineWarrior(IWarrior warrior) {
        iWarrior.setBackLineWarrior(warrior);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        iWarrior.equipWeapon(weapon);
    }

    @Override
    public void hitBy(Damage damage) {
        iWarrior.hitBy(damage);
    }

    @Override
    public void hits(IWarrior enemy) {
        iWarrior.hits(enemy);
    }

    @Override
    public void changeHealth(int health) {
        iWarrior.changeHealth(health);
    }

}
