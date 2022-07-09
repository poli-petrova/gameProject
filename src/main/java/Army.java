import weapons.Sword;
import weapons.Weapon;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Army {

    List<Warrior> troops = new ArrayList<>();

    public Army() {
    }

    public void addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Warrior warrior = factory.get();
            if (!troops.isEmpty()) {
                troops.get(troops.size() - 1).setBackLineWarrior(warrior);
            }
            if (isWarlord(warrior)) {
                if (!checkIfWarlordIsPresent(troops)) {
                    troops.add(warrior);
                }
            } else {
                troops.add(warrior);
            }
        }
    }

    public boolean isWarlord(Warrior warrior) {
        return warrior.getClass().equals(Warlord.class);
    }

    public List<Warrior> getTroops() {
        return troops;
    }

    boolean armyHasAliveUnits() {
        return !troops.isEmpty();
    }

    public Iterator<Warrior> firstAliveIterator() {
        return new FirstAliveIterator();
    }

    public void equipWarriorAtPosition(int position, Weapon weapon) {
        Warrior toBeEquipped = troops.get(position);
        if (toBeEquipped != null) {
            toBeEquipped.equipWeapon(weapon);
        }
    }


    public  class FirstAliveIterator implements Iterator<Warrior> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            while (cursor < troops.size() && !troops.get(cursor).isAlive()) {
                cursor++;
            }
            return cursor < troops.size();
        }

        @Override
        public Warrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return troops.get(cursor);
        }
    }


    static void rearrangeArmiesForStraightFight(Army army1, Army army2) {
        int newSize = 0;

        int oldSizeArmy1 = army1.getTroops().size();
        int oldSizeArmy2 = army2.getTroops().size();

        newSize = Math.max(oldSizeArmy1, oldSizeArmy2);

        if (army1.getTroops().size() != newSize) {
            army1.addUnits(Healer::new, newSize - army1.getTroops().size());
            for (int i = oldSizeArmy1; i < newSize; i++) {
                army1.getTroops().get(i).setHealth(1);
            }
        } else {
            army2.addUnits(Healer::new, newSize - army2.getTroops().size());
            for (int i = oldSizeArmy2; i < newSize; i++) {
                army2.getTroops().get(i).setHealth(1);
            }
        }
        army1.getTroops().forEach(warrior -> warrior.setBackLineWarrior(null));
        army2.getTroops().forEach(warrior -> warrior.setBackLineWarrior(null));
    }


    static void removeDeadWarriors(Army army) {
        army.getTroops().removeIf(w -> !w.isAlive());
    }


    public boolean checkIfWarlordIsPresent(List<Warrior> troops) {
        Optional<Warrior> warlord = troops
                .stream()
                .filter(warrior -> warrior.getClass().equals(Warlord.class))
                .findAny();
        return warlord.isPresent();
    }

    public void placeLancersInFront(List<Warrior> troops) {
        List<Integer> lancerIndexes = findLancers(troops);
        if (lancerIndexes != null) {
            for (int i = 0; i < lancerIndexes.size(); i++) {
                troops.add(i, null);
            }
            for (int i = 0; i < lancerIndexes.size(); i++) {
                Collections.swap(troops, lancerIndexes.get(i) + lancerIndexes.size(), i);
            }
            troops.removeIf(Objects::isNull);
        }
    }

    public List<Integer> findLancers(List<Warrior> troops) {
        List<Integer> lancerIndexes = new ArrayList<>();
        for (Warrior w : getTroops()) {
            if (w.getClass().equals(Lancer.class)) {
                lancerIndexes.add(troops.indexOf(w));
            }
        }
        if (lancerIndexes.isEmpty()) {
            return null;
        }
        return lancerIndexes;
    }

    public boolean aliveSoldiers(List<Warrior> troops) {
        return troops.stream().anyMatch(warrior -> warrior.getHealth() > 0 && !warrior.getClass().equals(Healer.class));
    }

    public  void placeAliveSoldiersInFront(List<Warrior> troops) {
        ArrayList<Integer> aliveSoldiers = new ArrayList<>();
        if (findLancers(troops) == null) {
            for (Warrior w : getTroops()) {
                if (!w.getClass().equals(Healer.class) && w.isAlive()) {
                    aliveSoldiers.add(troops.indexOf(w));
                }
            }
            for (int i = 0; i < aliveSoldiers.size(); i++) {
                troops.add(i, null);
            }
            for (int i = 0; i < aliveSoldiers.size(); i++) {
                Collections.swap(troops, aliveSoldiers.get(i) + aliveSoldiers.size(), i);
            }
            troops.removeIf(Objects::isNull);
        }
    }

    public void placeHealersBehindFirstWarrior(List<Warrior> troops) {
        if (troops.get(0).isAlive() && !troops.get(0).getClass().equals(Healer.class)) {
            List<Integer> lancerIndexes = new ArrayList<>();
            for (Warrior w : getTroops()) {
                if (w.getClass().equals(Healer.class)) {
                    lancerIndexes.add(troops.indexOf(w));
                }
            }

            if (!lancerIndexes.isEmpty()) {
                for (int i = 1; i < lancerIndexes.size() + 1; i++) {
                    troops.add(i, null);
                }
                for (int i = 0; i < lancerIndexes.size(); i++) {
                    Collections.swap(troops, lancerIndexes.get(i) + lancerIndexes.size(), i + 1);
                }
                troops.removeIf(Objects::isNull);
            }
        }
    }

    public void moveUnits() {
        if (checkIfWarlordIsPresent(getTroops())) {
            placeWarlordInLastPosition(getTroops());
            placeLancersInFront(getTroops());
            placeHealersBehindFirstWarrior(getTroops());
            placeAliveSoldiersInFront(getTroops());
            placeHealersBehindFirstWarrior(getTroops());
            rearrangeBackLineWarriors(getTroops());
        } else {
            System.out.println("Not possible to move units if there is no Warlord present in the Army!");
        }
    }

    public void placeWarlordInLastPosition(List<Warrior> troops) {
        Warrior current = troops.stream().filter(warrior -> warrior.getClass().equals(Warlord.class))
                .findFirst().get();
        int warlordIndex = troops.indexOf(current);
        troops.add(null);
        int lastIndex = troops.size() - 1;
        Collections.swap(troops, lastIndex, warlordIndex);
        troops.remove(warlordIndex);
    }

    public void rearrangeBackLineWarriors(List<Warrior> troops) {
        for (int i = 0; i < troops.size() - 1; i++) {
            if (i == troops.size() - 1) {
                troops.get(i).setBackLineWarrior(null);
            } else {
                troops.get(i).setBackLineWarrior(troops.get(i + 1));
            }
        }
    }



}


