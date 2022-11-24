import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import weapons.Katana;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class TricksterTest {

    @Test
    @DisplayName("Smoke test")
    void test01() {
        var trickster = new Trickster();
        assertEquals(trickster.getHealth(), 50);
        assertEquals(trickster.getAttack(), 3);
    }

    @ParameterizedTest
    @DisplayName("1.Fighting with Trickster")
    @MethodSource("warriorPairProvider")
    void test2To12(IWarrior warrior1, IWarrior warrior2, boolean expectedFightResult) {
        var test = Battle.fight(warrior1, warrior2);
        assertEquals(expectedFightResult, test);
    }

    static Stream<Arguments> warriorPairProvider() {
        return Stream.of(
                Arguments.arguments(new Warrior(), new Trickster(), true),
                Arguments.arguments(new Trickster(), new Warrior(), true),
                Arguments.arguments(new Knight(), new Trickster(), true),
                Arguments.arguments(new Trickster(), new Knight(), false),
                Arguments.arguments(new Rookie(), new Trickster(), false),
                Arguments.arguments(new Defender(), new Trickster(), true),
                Arguments.arguments(new Trickster(), new Defender(), false),
                Arguments.arguments(new Trickster(), new Lancer(), false),
                Arguments.arguments(new Lancer(), new Trickster(), true),
                Arguments.arguments(new Vampire(), new Trickster(), false),
                Arguments.arguments(new Warlord(), new Trickster(), true),
                Arguments.arguments(new Trickster(), new Defender(), false),
                Arguments.arguments(new Trickster(), new Lancer(), false)
        );
    }

    @Test
    @DisplayName("Trickster with Katana")
    void test13() {
        var trickster = new Trickster();
        trickster.equipWeapon(Katana.katanaBuilder().build());

        assertEquals(30, trickster.getHealth());
        assertEquals(9, trickster.getAttack());
    }

    @Test
    @DisplayName("Trickster vs Warrior")
    void test14() {
        var trickster = new Trickster();
        var warrior = new Warrior();
        Battle.fight(warrior, trickster);
        assertEquals(-1, trickster.getHealth());
        assertEquals(3, trickster.getAttack());

    }

    @Test
    @DisplayName("Trickster with Katana vs Warrior")
    void test15() {
        var trickster = new Trickster();
        trickster.equipWeapon(Katana.katanaBuilder().build());
        var warrior = new Warrior();
        Battle.fight(trickster, warrior);
        assertEquals(30, trickster.getHealth());
        assertEquals(9, trickster.getAttack());

    }

    @Test
    @DisplayName("Trickster vs Warrior: See defense")
        // Warrior has 5 attack and Trickster has 50 health and 2 defense -> health should be 47 instead of 45.
    void test16() {
        var trickster = new Trickster();
        var warrior = new Warrior();
        warrior.hits(trickster);
        var res = trickster.getHealth();
        var expectedHealth = 47;
        assertEquals(expectedHealth, res);
    }

    @Test
    @DisplayName("Trickster vs Warrior: See defense")
        // Warrior has 5 attack and Trickster has 50 health and 2 defense -> health should be 47 instead of 45.
    void test17() {
        var def = new DefenderDecorator(new LancerDecorator(new WarriorImpl(50, 3)));
        var warrior = new Warrior();
        warrior.hits(def);
        var res = def.getHealth();
        var expectedHealth = 47;
        assertEquals(expectedHealth, res);
    }

    @Test
    @DisplayName("Army with Tricksters against Warrior : See Trickster hitting as Lancer")
    void test18() {

        // Trickster hits Warrior with Warrior behind:
        // Warrior1 heath = 50 - 3 = 47 and Warrior2 health = -1;

        Army army1 = new Army();
        army1.addUnits(Warrior::new, 2);
        Army army2 = new Army();
        army2.addUnits(Trickster::new, 2);

        IWarrior firstWarriorArmy1 = army1.getTroops().get(0);
        IWarrior trickster = army2.getTroops().get(0);

        int healthBefore = firstWarriorArmy1.getHealth();
        trickster.hits(firstWarriorArmy1);
        int healthAfter = firstWarriorArmy1.getHealth();

        int damageDealtToFirstEnemy = healthAfter - healthBefore;
        var damageForSecondEnemy = damageDealtToFirstEnemy * 50 / 100;

        assertEquals(damageForSecondEnemy, -1);

    }

    @Test
    @DisplayName("Army with Tricksters against Warrior : See Trickster hitting as Lancer")
    void test19() {

        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior::new, 1);
        army1.addUnits(Trickster::new, 1);
        army1.addUnits(Lancer::new, 3);
        army1.addUnits(Defender::new, 1);
        army1.addUnits(Warlord::new, 4);

        army2.addUnits(Warrior::new, 2);
        army2.addUnits(Lancer::new, 3);
        army2.addUnits(Defender::new, 1);
        army2.addUnits(Warlord::new, 4);

        army1.moveUnits();
        army2.moveUnits();

        assertTrue(Battle.fight(army1, army2));


    }
}




