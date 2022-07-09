import weapons.*;

public class GameStart {
    public static void main(String[] args) {


//        var chuck = new Warrior();
//        var bruce = new Warrior();
//        var carl = new Knight();
//        var dave = new Warrior();
//        var mark = new Warrior();
//        var bob = new Defender();
//        var mike = new Knight();
//        var rog = new Warrior();
//        var lancelot = new Defender();
//        var eric = new Vampire();
//        var adam = new Vampire();
//        var richard = new Defender();
//        var ogre = new Warrior();
//        var freelancer = new Lancer();
//        var vampire = new Vampire();
//        var priest = new Healer();
//
//        System.out.println(Battle.fight(chuck, bruce)); //true
//        System.out.println(Battle.fight(dave, carl)); //false
//        System.out.println(chuck.isAlive()); //true
//        System.out.println(bruce.isAlive()); //false
//        System.out.println(carl.isAlive()); //true
//        System.out.println(dave.isAlive()); //false
//        System.out.println(Battle.fight(carl, mark)); //false
//        System.out.println(carl.isAlive()); //false
//        System.out.println(Battle.fight(bob, mike)); //false
//        System.out.println(Battle.fight(lancelot, rog)); //true
//        System.out.println(Battle.fight(eric, richard)); //false
//        System.out.println(Battle.fight(ogre, adam)); //true
//        System.out.println(Battle.fight(freelancer, vampire)); //true
//        System.out.println(freelancer.isAlive()); //true
//        System.out.println(freelancer.getHealth()); //14
//        priest.heal(freelancer);
//        System.out.println(freelancer.getHealth()); //16

//
//        var my_army = new Army();
//        my_army.addUnits(Defender::new, 2);
//        my_army.addUnits(Healer::new, 1);
//        my_army.addUnits(Vampire::new, 2);
//        my_army.addUnits(Lancer::new, 2);
//        my_army.addUnits(Healer::new, 1);
//        my_army.addUnits(Warrior::new, 1);
//
//        var enemy_army = new Army();
//        enemy_army.addUnits(Warrior::new, 2);
//        enemy_army.addUnits(Lancer::new, 4);
//        enemy_army.addUnits(Healer::new, 1);
//        enemy_army.addUnits(Defender::new, 2);
//        enemy_army.addUnits(Vampire::new, 3);
//        enemy_army.addUnits(Healer::new, 1);
//
//        var army_3 = new Army();
//        army_3.addUnits(Warrior::new, 1);
//        army_3.addUnits(Lancer::new, 1);
//        army_3.addUnits(Healer::new, 1);
//        army_3.addUnits(Defender::new, 2);
//
//        var army_4 = new Army();
//        army_4.addUnits(Vampire::new, 3);
//        army_4.addUnits(Warrior::new, 1);
//        army_4.addUnits(Healer::new, 1);
//        army_4.addUnits(Lancer::new, 2);


//        System.out.println(Battle.fight(my_army, enemy_army)); //false
 //       System.out.println(Battle.fight(army_3, army_4)); //true
//
//        assert Battle.fight(my_army, enemy_army) == false;
//        assert Battle.fight(army_3, army_4) == true;

//        var army1 = new Army();
//        var army2 = new Army();
//        army1.addUnits(Warrior::new, 1);
//        army2.addUnits(Warrior::new, 2);
//        System.out.println(Battle.fight(army1, army2));

//        Arguments.arguments(new Army(), new Warrior(), 2, new Army(), new Warrior(), 3, false),
//                Arguments.arguments(new Army(), new Warrior(), 5, new Army(), new Warrior(), 7, false),
//
//        var army3 = new Army();
//        var army4 = new Army();
//        army3.addUnits(Warrior::new, 2);
//        army4.addUnits(Warrior::new, 3);
//        System.out.println(Battle.fight(army3, army4));
//
//        System.out.println(Battle.fight(new Defender(), new Knight()));
//
//        var army5 = new Army();
//        army5.addUnits(Warrior::new, 10);
//
//        var army6 = new Army();
//        army6.addUnits(Warrior::new, 6);
//        army6.addUnits(Lancer::new, 5);
//
//        System.out.println(Battle.straightFight(army5, army6));

//        var myArmy = new Army();
//        myArmy.addUnits(Lancer::new, 7);
//        myArmy.addUnits(Vampire::new, 3);
//        myArmy.addUnits(Healer::new, 1);
//        myArmy.addUnits(Warrior::new, 4);
//        myArmy.addUnits(Healer::new, 1);
//        myArmy.addUnits(Defender::new, 2);
//
//        var enemyArmy = new Army();
//        enemyArmy.addUnits(Warrior::new, 4);
//        enemyArmy.addUnits(Defender::new, 4);
//        enemyArmy.addUnits(Healer::new, 1);
//        enemyArmy.addUnits(Vampire::new, 6);
//        enemyArmy.addUnits(Lancer::new, 4);
//
//        System.out.println(Battle.straightFight(myArmy, enemyArmy)); //expected: false

//        var myArmy = new Army();
//        myArmy.addUnits(Warrior::new, 2);
//        myArmy.addUnits(Knight::new, 1);
//
//        var enemyArmy = new Army();
//        enemyArmy.addUnits(Knight::new, 1);
//        enemyArmy.addUnits(Healer::new, 1);
//        enemyArmy.addUnits(Knight::new, 1);


       // System.out.println(Battle.straightFight(myArmy, enemyArmy)); //expected True
     //   System.out.println(Battle.straightFight(army5, army6)); //expected false

//        var myArmy = new Army();
//        myArmy.addUnits(Lancer::new, 7);
//        myArmy.addUnits(Vampire::new, 3);
//        myArmy.addUnits(Healer::new, 1);
//        myArmy.addUnits(Warrior::new, 4);
//        myArmy.addUnits(Healer::new, 1);
//        myArmy.addUnits(Defender::new, 2);
//
//        var enemyArmy = new Army();
//        enemyArmy.addUnits(Warrior::new, 4);
//        enemyArmy.addUnits(Defender::new, 4);
//        enemyArmy.addUnits(Healer::new, 1);
//        enemyArmy.addUnits(Vampire::new, 6);
//        enemyArmy.addUnits(Lancer::new, 4);
//
//        System.out.println(Battle.straightFight(myArmy, enemyArmy)); // expected false
//
//        var ogre = new Warrior();
//        var lancelot = new Knight();
//        var richard = new Defender();
//        var eric = new Vampire();
//        var freelancer = new Lancer();
//        var priest = new Healer();
//
//        var katana = new Katana();
//        freelancer.equipWeapon(katana);

//        var ronald = new Warlord();
//        var heimdall = new Knight();
//
//        System.out.println(Battle.fight(heimdall, ronald)); // false;
//
//        var myArmy = new Army();
//        myArmy.addUnits(Warlord::new, 1);
//        myArmy.addUnits(Warrior::new, 2);
//        myArmy.addUnits(Lancer::new, 2);
//        myArmy.addUnits(Healer::new, 2);
//
//        var enemyArmy = new Army();
//        enemyArmy.addUnits(Warlord::new, 3);
//        enemyArmy.addUnits(Vampire::new, 1);
//        enemyArmy.addUnits(Healer::new, 2);
//        enemyArmy.addUnits(Knight::new, 2);
//
//        myArmy.moveUnits();
//        enemyArmy.moveUnits();
//
//        System.out.println(myArmy.troops.size());
//        System.out.println(myArmy);
//        System.out.println(enemyArmy.getTroops().size()); // 6
//
//        for (Warrior w : enemyArmy.getTroops()) {
//            System.out.println(w.getClass());
//        }

//        var army1 = new Army();
//        var army2 = new Army();
//        army1.addUnits(Warrior::new, 2);
//        army1.addUnits(Lancer::new, 2);
//        army1.addUnits(Defender::new, 1);
//        army1.addUnits(Warlord::new, 3);
//
//        army2.addUnits(Warlord::new, 2);
//        army2.addUnits(Vampire::new, 1);
//        army2.addUnits(Healer::new, 5);
//        army2.addUnits(Knight::new, 2);
//
//        army1.moveUnits();
//        army2.moveUnits();
//
//        System.out.println(Battle.fight(army1, army2));
//
//        for (Warrior w : army1.getTroops()) {
//            System.out.println(w.getClass());
//        }
//
//        for (Warrior w : army2.getTroops()) {
//            System.out.println(w.getClass());
//        }

        var ogre = new Warrior();
        var lancelot = new Knight();
        var richard = new Defender();
        var eric = new Vampire();
        var freelancer = new Lancer();
        var priest = new Healer();

// you may consider using another interfaces for the predefined weapon
// e.g. you could use enum or some factory
//        var sword = new Sword();
//        var shield = new Shield();
//        var axe = new GreatAxe();
//        var katana = new Katana();
//        var wand = new MagicWand();
//// consider using a builder instead
//        var superWeapon = new Weapon(50, 10, 5, 150, 8);
//
//        ogre.equipWeapon(sword);
//        ogre.equipWeapon(shield);
//        ogre.equipWeapon(superWeapon);
//        lancelot.equipWeapon(superWeapon);
//        richard.equipWeapon(shield);
//        eric.equipWeapon(superWeapon);
//        freelancer.equipWeapon(axe);
//        freelancer.equipWeapon(katana);
//        priest.equipWeapon(wand);
//        priest.equipWeapon(shield);
//
//        System.out.println(ogre.getHealth() == 125);
//        System.out.println(lancelot.getAttack() == 17);
//        System.out.println(richard.getDefense() == 4);
//        System.out.println(eric.getVampirism() == 200);
//        System.out.println(freelancer.getHealth() == 15);
//        System.out.println(priest.getHealPower() == 5);
//
//        System.out.println(Battle.fight(ogre, eric));//false;
//        System.out.println(Battle.fight(priest, richard)); //false;
//        System.out.println(Battle.fight(lancelot, freelancer));//true;

//        var myArmy = new Army();
//        myArmy.addUnits(Knight::new, 1);
//        myArmy.addUnits(Lancer::new, 1);
//
//        var enemyArmy = new Army();
//        enemyArmy.addUnits(Vampire::new, 1);
//        enemyArmy.addUnits(Healer::new, 1);
//
//        myArmy.equipWarriorAtPosition(0, axe);
//        myArmy.equipWarriorAtPosition(1, superWeapon);
//
//        enemyArmy.equipWarriorAtPosition(0, katana);
//        enemyArmy.equipWarriorAtPosition(1, wand);
//
//        assert Battle.fight(myArmy, enemyArmy) == true;


//        Weapon weapon1 = new Katana();
//        Weapon weapon2 = new Shield();
//        Army myArmy = new Army();
//        myArmy.addUnits(Defender::new, 2);
//        Army enemyArmy = new Army();
//        enemyArmy.addUnits(Knight::new, 1);
//        enemyArmy.addUnits(Vampire::new, 1);
//        myArmy.equipWarriorAtPosition(0, weapon1);
//        myArmy.equipWarriorAtPosition(1, weapon1);
//        enemyArmy.equipWarriorAtPosition(0, weapon1);
//        enemyArmy.equipWarriorAtPosition(1, weapon1);
//        var res = Battle.fight(myArmy, enemyArmy);
//
//        System.out.println(res);
//
//        var myArmy = new Army();
//        myArmy.addUnits(Lancer::new, 7);
//        myArmy.addUnits(Vampire::new, 3);
//        myArmy.addUnits(Healer::new, 1);
//        myArmy.addUnits(Warrior::new, 4);
//        myArmy.addUnits(Healer::new, 1);
//        myArmy.addUnits(Defender::new, 2);
//
//        var enemyArmy = new Army();
//        enemyArmy.addUnits(Warrior::new, 4);
//        enemyArmy.addUnits(Defender::new, 4);
//        enemyArmy.addUnits(Healer::new, 1);
//        enemyArmy.addUnits(Vampire::new, 6);
//        enemyArmy.addUnits(Lancer::new, 4);
//
//        System.out.println(Battle.straightFight(myArmy, enemyArmy));

        var army1 = new Army();
        var amry2 = new Army();

        army1.addUnits(Warrior::new, 2);
        army1.addUnits(Knight::new, 1);

        amry2.addUnits(Knight::new, 1);
        amry2.addUnits(Healer::new, 1);
        amry2.addUnits(Knight::new, 1);

        System.out.println(Battle.straightFight(army1, amry2));





    }
}
