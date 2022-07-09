

public class Battle {

    static boolean fight(Warrior firstWarrior, Warrior secondWarrior) {
        while (firstWarrior.isAlive() && secondWarrior.isAlive()) {
            if (firstWarrior instanceof Healer && secondWarrior instanceof Healer) {
                firstWarrior.setHealth(0);
                secondWarrior.setHealth(0);
            } else {
                firstWarrior.hits(secondWarrior);
                if (firstWarrior.getBackLineWarrior() instanceof Healer) {
                    Healer healer = (Healer) firstWarrior.getBackLineWarrior();
                    healer.heal(firstWarrior);
                }
                if (secondWarrior.isAlive()) {
                    secondWarrior.hits(firstWarrior);

                    if (secondWarrior.getBackLineWarrior() instanceof Healer) {
                        Healer healer = (Healer) secondWarrior.getBackLineWarrior();
                        healer.heal(secondWarrior);
                    }

                }
            }
        }
        return firstWarrior.isAlive();
    }

    public static boolean fight(Army army1, Army army2) {
        while (army1.armyHasAliveUnits() && army2.armyHasAliveUnits()) {
            Warrior warriorArmy1 = army1.troops.get(0);
            Warrior warriorArmy2 = army2.troops.get(0);
            fight(warriorArmy1, warriorArmy2);
            if (warriorArmy1.isAlive()) {
                army2.troops.remove(warriorArmy2);

            } else {
                army1.troops.remove(warriorArmy1);
            }
        }
        return army1.armyHasAliveUnits();
    }


    public static boolean straightFight(Army army1, Army army2) {

        while (army1.armyHasAliveUnits() && army2.armyHasAliveUnits()) {
            Army.rearrangeArmiesForStraightFight(army1, army2);
            round(army1, army2);
            Army.removeDeadWarriors(army1);
            Army.removeDeadWarriors(army2);
    }
        return army1.armyHasAliveUnits();
    }

    public static boolean round(Army army1, Army army2) {
        var iterArmy1 = army1.getTroops().iterator();
        var iterArmy2 = army2.getTroops().iterator();
        while (iterArmy1.hasNext() && iterArmy2.hasNext()) {
            var warriorArmy1 = iterArmy1.next();
            var warriorArmy2 = iterArmy2.next();
            fight(warriorArmy1, warriorArmy2);
        }
        return army1.armyHasAliveUnits();
    }


}
