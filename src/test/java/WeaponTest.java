import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import weapons.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeaponTest {

    @Test
    @DisplayName("Weapon test01")
    void test01() {
        var unit1 = new Warrior();
        var unit2 = new Vampire();
        var weapon1 = new Weapon(-10, 5, 0, 40, 0);
        var weapon2 = new Sword();
        unit1.equipWeapon(weapon1);
        unit2.equipWeapon(weapon2);
        var result = Battle.fight(unit1, unit2);

        assertTrue(result);
    }

    @Test
    @DisplayName("Weapon test02")
    void test02() {
        var unit1 = new Defender();
        var unit2 = new Lancer();
        var weapon1 = new Shield();
        var weapon2 = new GreatAxe();
        unit1.equipWeapon(weapon1);
        unit2.equipWeapon(weapon2);
        var result = Battle.fight(unit1, unit2);
        assertFalse(result);
    }

    @Test
    @DisplayName("Weapon test03")
    void test03() {
        var unit1 = new Healer();
        var unit2 = new Knight();
        var weapon1 = new MagicWand();
        var weapon2 = new Katana();
        unit1.equipWeapon(weapon1);
        unit2.equipWeapon(weapon2);
        var result = Battle.fight(unit1, unit2);
        assertFalse(result);
    }

    @Test
    @DisplayName("Weapon test04")
    void test04() {
        var unit1 = new Defender();
        var unit2 = new Vampire();
        var weapon1 = new Shield();
        var weapon2 = new MagicWand();
        var weapon3 = new Shield();
        var weapon4 = new Katana();
        unit1.equipWeapon(weapon1);
        unit1.equipWeapon(weapon2);
        unit2.equipWeapon(weapon3);
        unit2.equipWeapon(weapon4);
        var result = Battle.fight(unit1, unit2);
        assertFalse(result);
    }

    @Test
    @DisplayName("Weapon test05")
    void test05() {
        Weapon weapon1 = new MagicWand();
        Weapon weapon2 = new GreatAxe();
        Army myArmy = new Army();
        myArmy.addUnits(Knight::new, 1);
        myArmy.addUnits(Lancer::new, 1);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Vampire::new, 1);
        enemyArmy.addUnits(Healer::new, 1);
        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon2);
        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon2);
        var res = Battle.fight(myArmy, enemyArmy);
        assertTrue(res);
    }

    @Test
    @DisplayName("Weapon test06")
    void test06() {
        Weapon weapon1 = new Sword();
        Weapon weapon2 = new GreatAxe();
        Army myArmy = new Army();
        myArmy.addUnits(Defender::new, 1);
        myArmy.addUnits(Warrior::new, 1);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Knight::new, 1);
        enemyArmy.addUnits(Healer::new, 1);
        myArmy.equipWarriorAtPosition(0, weapon2);
        myArmy.equipWarriorAtPosition(1, weapon2);
        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon1);
        var res = Battle.fight(myArmy, enemyArmy);
        assertTrue(res);
    }

    @Test
    @DisplayName("Weapon test07")
    void test07() {
        Weapon weapon1 = new Katana();
        Weapon weapon2 = new Shield();
        Army myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Knight::new, 1);
        enemyArmy.addUnits(Vampire::new, 1);
        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon1);
        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon1);
        var res = Battle.fight(myArmy, enemyArmy);
        assertFalse(res);
    }

    @Test
    @DisplayName("Weapon test08")
    void test08() {
        Weapon weapon1 = new Weapon(-20, 6, 1, 40, -2);
        Weapon weapon2 = new Weapon(20, -2, 2, -55, 3);
        Army myArmy = new Army();
        myArmy.addUnits(Knight::new, 3);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 1);
        enemyArmy.addUnits(Defender::new, 2);
        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon1);
        myArmy.equipWarriorAtPosition(2, weapon2);
        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon2);
        enemyArmy.equipWarriorAtPosition(2, weapon2);
        var res = Battle.fight(myArmy, enemyArmy);
        assertTrue(res);
    }

    @Test
    @DisplayName("Weapon test09")
    void test09() {
        Weapon weapon1 = new Weapon(-20, 1, 1, 40, -2);
        Weapon weapon2 = new Weapon(20, 2, 2, -55, 3);
        Army myArmy = new Army();
        myArmy.addUnits(Vampire::new, 3);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 1);
        enemyArmy.addUnits(Defender::new, 2);
        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon1);
        myArmy.equipWarriorAtPosition(2, weapon2);
        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon2);
        enemyArmy.equipWarriorAtPosition(2, weapon2);
        var res = Battle.straightFight(myArmy, enemyArmy);
        assertFalse(res);
    }

    @Test
    @DisplayName("Weapon test10")
    void test10() {
        Weapon weapon1 = new Katana();
        Weapon weapon2 = new Shield();
        Army myArmy = new Army();
        myArmy.addUnits(Vampire::new, 2);
        myArmy.addUnits(Rookie::new, 2);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 1);
        enemyArmy.addUnits(Defender::new, 2);
        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon1);
        myArmy.equipWarriorAtPosition(2, weapon2);
        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon2);
        enemyArmy.equipWarriorAtPosition(2, weapon2);
        var res = Battle.straightFight(myArmy, enemyArmy);
        assertTrue(res);
    }

    @Test
    @DisplayName("Weapon test11")
    void test11() {
        Weapon weapon1 = new Sword();
        Weapon weapon2 = new GreatAxe();
        Army myArmy = new Army();
        myArmy.addUnits(Vampire::new, 3);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 1);
        enemyArmy.addUnits(Defender::new, 1);
        myArmy.equipWarriorAtPosition(0, weapon2);
        myArmy.equipWarriorAtPosition(1, weapon2);
        myArmy.equipWarriorAtPosition(2, weapon2);
        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon1);
        var res = Battle.straightFight(myArmy, enemyArmy);
        assertTrue(res);
    }

    @Test
    @DisplayName("Weapon test12")
    void test12() {
        Weapon weapon1 = new Katana();
        Weapon weapon2 = new MagicWand();
        Army myArmy = new Army();
        myArmy.addUnits(Rookie::new, 3);
        Army enemyArmy = new Army();
        enemyArmy.addUnits(Defender::new, 1);
        enemyArmy.addUnits(Healer::new, 1);
        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon1);
        myArmy.equipWarriorAtPosition(2, weapon1);
        enemyArmy.equipWarriorAtPosition(0, weapon2);
        enemyArmy.equipWarriorAtPosition(1, weapon2);
        var res = Battle.straightFight(myArmy, enemyArmy);
        assertFalse(res);
    }
}
