import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FightTest {

    @Test
    @DisplayName("Battle test01: Smoke Test")
    void test01() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();

        var result1 = Battle.fight(chuck, bruce);
        var result2 = Battle.fight(dave, carl);
        var result3 = chuck.isAlive();
        var result4 = bruce.isAlive();
        var result5 = carl.isAlive();
        var result6 = dave.isAlive();

        assertTrue(result1);
        assertFalse(result2);
        assertTrue(result3);
        assertFalse(result4);
        assertTrue(result5);
        assertFalse(result6);
    }


    @Test
    @DisplayName("Battle test02: Warrior vs Knight Fight")
    void test02() {
        var carl = new Warrior();
        var jim = new Knight();
        var battleResult = Battle.fight(carl, jim);

        assertFalse(battleResult);
    }

    @Test
    @DisplayName("Battle test03: Knight vs Warrior Fight")
    void test03() {
        var ramon = new Knight();
        var slevin = new Warrior();
        var battleResult = Battle.fight(ramon, slevin);

        assertTrue(battleResult);
    }

    @Test
    @DisplayName("Battle test04: Check if attacker is alive in Warrior vs Warrior fight")
    void test04() {
        var bob = new Warrior();
        var mars = new Warrior();
        Battle.fight(bob, mars);
        var bobIsAlive = bob.isAlive();

        assertTrue(bobIsAlive);
    }

    @Test
    @DisplayName("Battle test05: Check if attacker is alive in Knight vs Warrior fight")
    void test05() {
        var zeus = new Knight();
        var godKiller = new Warrior();
        Battle.fight(zeus, godKiller);
        var zeusIsAlive = zeus.isAlive();

        assertTrue(zeusIsAlive);
    }

    @Test
    @DisplayName("Battle test06: Check if defender is alive in Warrior vs Warrior fight")
    void test06() {
        var husband = new Warrior();
        var wife = new Warrior();
        Battle.fight(husband, wife);
        var wifeIsAlive = wife.isAlive();

        assertFalse(wifeIsAlive);
    }

    @Test
    @DisplayName("Battle test07: Check if defender is alive in Warrior vs Knight fight")
    void test07() {
        var dragon = new Warrior();
        var knight = new Knight();
        Battle.fight(dragon, knight);
        var knightIsAlive = knight.isAlive();

        assertTrue(knightIsAlive);
    }


    @Test
    @DisplayName("Battle test08: Check if Knight is alive after two battles with a Warrior")
    void test08() {
        var unit1 = new Warrior();
        var unit2 = new Knight();
        var unit3 = new Warrior();
        Battle.fight(unit1, unit2);
        var battleResult = Battle.fight(unit2, unit3);

        assertFalse(battleResult);
    }

    @ParameterizedTest
    @DisplayName("1. Fight")
    @MethodSource("warriorPairProvider")
    void name02(Warrior warrior1, Warrior warrior2, boolean expectedFightResult) {
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

    @Test
    @DisplayName("Battle test09: Check if Defender health is correct after a fight with Rookie")
    void test09() {
        var unit1 = new Defender();
        var unit2 = new Rookie();
        Battle.fight(unit1, unit2);
        var unit1Health = unit1.getHealth();
        var expectedHealth = 60;
        assertEquals(unit1Health, expectedHealth);
    }


    @Test
    @DisplayName("Fight test10")
    void test10() {
        var unit1 = new Defender();
        var unit2 = new Rookie();
        var unit3 = new Warrior();
        Battle.fight(unit1, unit2);
        var battleUnit1VsUnit3 = Battle.fight(unit1, unit3);
        assertTrue(battleUnit1VsUnit3);
    }

    @Test
    @DisplayName("Fight test11")
    void test11() {
        var eric = new Vampire();
        var adam = new Vampire();
        var richard = new Defender();
        var ogre = new Warrior();
        var mike = new Knight();

        var resultVampireVsDefender = Battle.fight(eric, richard);
        var resultWarriorvsVampire = Battle.fight(ogre, adam);

        assertFalse(resultVampireVsDefender);

    }
}