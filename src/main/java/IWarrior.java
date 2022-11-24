import weapons.Weapon;

public interface IWarrior {

    int getAttack();
    int getHealth();
    boolean isAlive();
    int getMaxHealth();
    IWarrior getBackLineWarrior();
    void setBackLineWarrior(IWarrior warrior);
    void equipWeapon (Weapon weapon);
    void hitBy(Damage damage);
    void hits(IWarrior enemy);
    void changeHealth(int health);


}
