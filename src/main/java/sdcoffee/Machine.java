package sdcoffee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Machine {

    boolean sugarIsAdded = false;

    int coinsInside = 0;

    RuntimeException notEnoughException = new RuntimeException("Not enough coins");


    List<Integer> possibleCoins = new ArrayList<Integer>();
    HashMap<String, CoffeeType> coffeeMenu = new HashMap<String, CoffeeType>();

    public Machine() {

        possibleCoins.add(1);
        possibleCoins.add(2);
        possibleCoins.add(3);
        possibleCoins.add(5);

        coffeeMenu.put("cappuccino", new CoffeeType("Cappuccino", 4));
        coffeeMenu.put("latte", new CoffeeType("Latte", 6));

    }

    public void insert(Integer i) {

        if (!possibleCoins.contains(i)) {
            throw new RuntimeException("Can't recognise coin");
        }
        coinsInside += i;
    }

    public void select(String type) {

        CoffeeType coffeeType = coffeeMenu.get(type.toLowerCase());
        if (coffeeType == null) {
            throw new RuntimeException("Unknown coffee type");
        }
        if (coffeeType.Cost > coinsInside) {
            throw notEnoughException;
        }

        coinsInside -= coffeeType.Cost;
        String res = coffeeType.Name + " for you";
        if (sugarIsAdded) {
            res += " with sugar.";
        }
        System.out.println(res);

        resetSugar();

    }

    int sugarAddedTimes = 0;

    public void addSugar() {
        if (coinsInside < 1) {
            throw notEnoughException;
        }
        coinsInside--;
        sugarAddedTimes++;
        sugarIsAdded = true;

    }

    void rollbackSugar() {
        coinsInside += sugarAddedTimes;
        resetSugar();
    }

    void resetSugar() {
        sugarIsAdded = false;
        sugarAddedTimes = 0;
    }

    public void cancel() {
        if (coinsInside < 1)
            throw notEnoughException;
        System.out.println("Returning " + coinsInside + " coins");
        coinsInside = 0;
        resetSugar();
    }

    class CoffeeType {

        public String Name;
        public int Cost;

        public CoffeeType(String name, int cost) {
            this.Name = name;
            this.Cost = cost;
        }

    }

}
