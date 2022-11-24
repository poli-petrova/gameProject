import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import weapons.Shield;
import weapons.Sword;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BattleTest {

    @Test
    @DisplayName("Battle test01: Smoke Test")
    void test01() {

        var myArmy = new Army();
        myArmy.addUnits(Knight::new, 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 3);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 20);
        army3.addUnits(Knight::new, 5);

        var army4 = new Army();
        army4.addUnits(Warrior::new, 30);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @ParameterizedTest
    @DisplayName("1. Fight")
    @MethodSource("warriorPairProvider")
    void name02(IWarrior warrior1, IWarrior warrior2, boolean expectedFightResult) {
        var test = Battle.fight(warrior1, warrior2);
        assertEquals(expectedFightResult, test);

    }

    static Stream<Arguments> warriorPairProvider() {
        return Stream.of(
                Arguments.arguments(new Warrior(), new Warrior(), true),
                Arguments.arguments(new Warrior(), new Knight(), false),
                Arguments.arguments(new Knight(), new Warrior(), true),
                Arguments.arguments(new Knight(), new Knight(), true)
        );
    }

    @ParameterizedTest
    @DisplayName("Battle test03: Armies fighting against each other")
    @MethodSource("fightingArmies")
    void test03(
            Army army1,
            IWarrior warrior1,
            int numOfUnitsArmy1,
            Army army2,
            IWarrior warrior2,
            int numOfUnitsArmy2,
            boolean expectedResult
    ) {
        army1.addUnits(Warrior::new, numOfUnitsArmy1);
        army2.addUnits(Warrior::new, numOfUnitsArmy2);
        var test = Battle.fight(army1, army2);
        assertEquals(expectedResult, test);
    }

    public static Stream<Arguments> fightingArmies() {
        return Stream.of(
                Arguments.arguments(new Army(), new Warrior(), 1, new Army(), new Warrior(), 2, false),
                Arguments.arguments(new Army(), new Warrior(), 2, new Army(), new Warrior(), 3, false),
                Arguments.arguments(new Army(), new Warrior(), 5, new Army(), new Warrior(), 7, false),
                Arguments.arguments(new Army(), new Warrior(), 20, new Army(), new Warrior(), 21, true),
                Arguments.arguments(new Army(), new Warrior(), 10, new Army(), new Warrior(), 11, true),
                Arguments.arguments(new Army(), new Warrior(), 11, new Army(), new Warrior(), 7, true),
                Arguments.arguments(new Army(), new Defender(), 1, new Army(), new Warrior(), 2, false),
                Arguments.arguments(new Army(), new Defender(), 1, new Army(), new Knight(), 1, true)
        );
    }

    @Test
    @DisplayName("Battle test04: 5 Warriors and 9 Defenders Vs 4 Warriors")
    void test04() {

        var myArmy = new Army();
        myArmy.addUnits(Warrior::new, 5);
        myArmy.addUnits(Defender::new, 4);
        myArmy.addUnits(Defender::new, 5);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 4);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Battle test05: 9 Defenders and 20 Warriors Vs 21 Warriors")
    void test05() {

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 5);
        myArmy.addUnits(Warrior::new, 20);
        myArmy.addUnits(Defender::new, 4);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 21);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Battle test06: 15 Defenders and 10 Warriors Vs 5 Warriors")
    void test06() {

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 5);
        myArmy.addUnits(Warrior::new, 10);
        myArmy.addUnits(Defender::new, 10);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 5);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Battle test07: 3 Defenders and 1 Warriors Vs 5 Warriors")
    void test07() {

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);
        myArmy.addUnits(Warrior::new, 1);
        myArmy.addUnits(Defender::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 5);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Battle test08: 5 Defenders, 6 Vampires and 7 Warriors vs 6 Warriors, 6 Defenders and 6 Vampires")
    void test08() {

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 5);
        myArmy.addUnits(Vampire::new, 6);
        myArmy.addUnits(Warrior::new, 7);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 6);
        enemyArmy.addUnits(Defender::new, 6);
        enemyArmy.addUnits(Vampire::new, 6);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Battle test09: 2 Defenders, 3 Vampires and 4 Warriors vs 4 Warriors, 4 Defenders and 3 Vampires")
    void test09() {

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);
        myArmy.addUnits(Warrior::new, 4);
        myArmy.addUnits(Vampire::new, 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 4);
        enemyArmy.addUnits(Defender::new, 4);
        enemyArmy.addUnits(Vampire::new, 3);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Battle test10: 2 Defenders, 3 Vampires and 3 Warriors vs 4 Warriors, 4 Defenders and 3 Vampires")
    void test10() {

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);
        myArmy.addUnits(Warrior::new, 4);
        myArmy.addUnits(Vampire::new, 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 4);
        enemyArmy.addUnits(Defender::new, 4);
        enemyArmy.addUnits(Vampire::new, 3);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Battle test11: 2 Defenders, 3 Vampires and 4 Warriors vs 4 Warriors, 4 Defenders and 3 Vampires")
    void test11() {

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);
        myArmy.addUnits(Warrior::new, 4);
        myArmy.addUnits(Vampire::new, 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 4);
        enemyArmy.addUnits(Defender::new, 4);
        enemyArmy.addUnits(Vampire::new, 3);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Battle test12: 2 Defenders, 3 Vampires, 4 Warriors and 5 Lancers vs 4 Warriors, 4 Defenders, 5 Lancers and 6 Vampires")
    void test12() {

        var myArmy = new Army();
        myArmy.addUnits(Lancer::new, 5);
        myArmy.addUnits(Vampire::new, 3);
        myArmy.addUnits(Warrior::new, 4);
        myArmy.addUnits(Defender::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 4);
        enemyArmy.addUnits(Defender::new, 4);
        enemyArmy.addUnits(Vampire::new, 6);
        enemyArmy.addUnits(Lancer::new, 5);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Battle test13: 2 Defenders, 3 Vampires, 4 Warriors, 7 Lancers and 2 Healers vs 4 Warriors, 4 Defenders, 6 Vampires, 4 Lancers and 1 Healer")
    void test13() {

        var myArmy = new Army();
        myArmy.addUnits(Lancer::new, 7);
        myArmy.addUnits(Vampire::new, 3);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Warrior::new, 4);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Defender::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 4);
        enemyArmy.addUnits(Defender::new, 4);
        enemyArmy.addUnits(Healer::new, 1);
        enemyArmy.addUnits(Vampire::new, 6);
        enemyArmy.addUnits(Lancer::new, 4);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Battle test13: 1 Lancer, 3 Warriors, 1 Healer, 4 Warriors, 1 Healer and 2 Knights vs 4 Warriors, 4 Defenders,1 Healer, 6 Vampires and 4 Lancers")
    void test14() {

        var myArmy = new Army();
        myArmy.addUnits(Lancer::new, 1);
        myArmy.addUnits(Warrior::new, 3);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Warrior::new, 4);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Knight::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 4);
        enemyArmy.addUnits(Defender::new, 4);
        enemyArmy.addUnits(Healer::new, 1);
        enemyArmy.addUnits(Vampire::new, 6);
        enemyArmy.addUnits(Lancer::new, 4);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }

    // TODO
    @Test
    @DisplayName("Battle test15: ")
    void test15() {

        var myArmy = new Army();
        myArmy.addUnits(Lancer::new, 5);
        myArmy.addUnits(Vampire::new, 3);
        myArmy.addUnits(Warrior::new, 4);
        myArmy.addUnits(Defender::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 4);
        enemyArmy.addUnits(Defender::new, 4);
        enemyArmy.addUnits(Vampire::new, 6);
        enemyArmy.addUnits(Lancer::new, 5);

        assertFalse(Battle.straightFight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Battle test16: ")
    void test16() {

        var myArmy = new Army();
        myArmy.addUnits(Lancer::new, 7);
        myArmy.addUnits(Vampire::new, 3);
        myArmy.addUnits(Warrior::new, 4);
        myArmy.addUnits(Defender::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 4);
        enemyArmy.addUnits(Defender::new, 4);
        enemyArmy.addUnits(Vampire::new, 6);
        enemyArmy.addUnits(Lancer::new, 4);

        assertTrue(Battle.straightFight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Battle test17: ")
    void test17() {

        var myArmy = new Army();
        myArmy.addUnits(Lancer::new, 7);
        myArmy.addUnits(Vampire::new, 3);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Warrior::new, 4);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Defender::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 4);
        enemyArmy.addUnits(Defender::new, 4);
        enemyArmy.addUnits(Healer::new, 1);
        enemyArmy.addUnits(Vampire::new, 6);
        enemyArmy.addUnits(Lancer::new, 4);

        assertTrue(Battle.straightFight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Battle test18: ")
    void test18() {

        var myArmy = new Army();
        myArmy.addUnits(Lancer::new, 4);
        myArmy.addUnits(Warrior::new, 3);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Warrior::new, 4);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Knight::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 4);
        enemyArmy.addUnits(Defender::new, 4);
        enemyArmy.addUnits(Healer::new, 1);
        enemyArmy.addUnits(Vampire::new, 2);
        enemyArmy.addUnits(Lancer::new, 4);

        assertTrue(Battle.straightFight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Battle test19: Battle with moveUnits method")
    void test19() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warlord::new, 1);
        army1.addUnits(Warrior::new, 2);
        army1.addUnits(Lancer::new, 2);
        army1.addUnits(Healer::new, 2);

        army2.addUnits(Warlord::new, 1);
        army2.addUnits(Vampire::new, 1);
        army2.addUnits(Healer::new, 2);
        army2.addUnits(Knight::new, 2);

        army1.moveUnits();
        army2.moveUnits();

        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Battle test20: Battle with moveUnits method")
    void test20() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior::new, 2);
        army1.addUnits(Lancer::new, 2);
        army1.addUnits(Defender::new, 1);
        army1.addUnits(Warlord::new, 3);

        army2.addUnits(Warlord::new, 2);
        army2.addUnits(Vampire::new, 1);
        army2.addUnits(Healer::new, 5);
        army2.addUnits(Knight::new, 2);

        army1.moveUnits();
        army2.moveUnits();

        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Battle test21: Battle with moveUnits method")
    void test21() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior::new, 2);
        army1.addUnits(Lancer::new, 3);
        army1.addUnits(Defender::new, 1);
        army1.addUnits(Warlord::new, 4);

        army2.addUnits(Warlord::new, 1);
        army2.addUnits(Vampire::new, 1);
        army2.addUnits(Vampire::new, 1);
        army2.addUnits(Knight::new, 1);

        army1.equipWarriorAtPosition(0, new Sword());
        army2.equipWarriorAtPosition(0, new Shield());

        army1.moveUnits();
        army2.moveUnits();

        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Battle test22: Battle with moveUnits method")
    void test22() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior::new, 2);
        army1.addUnits(Lancer::new, 3);
        army1.addUnits(Defender::new, 1);
        army1.addUnits(Warlord::new, 1);

        army2.addUnits(Warlord::new, 5);
        army2.addUnits(Vampire::new, 1);
        army2.addUnits(Vampire::new, 1);
        army2.addUnits(Knight::new, 1);

        army1.equipWarriorAtPosition(0, new Sword());
        army2.equipWarriorAtPosition(0, new Shield());

        army1.moveUnits();
        army2.moveUnits();

        assertFalse(Battle.straightFight(army1, army2));
    }



}


