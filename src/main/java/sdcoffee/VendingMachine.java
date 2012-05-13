package sdcoffee;

import java.util.HashSet;

public class VendingMachine extends Machine{
    
    HashSet<String> nonSugarItems = new HashSet<String>();
    
    public VendingMachine(){
        
        this.coffeeMenu.put("bonaqua", new CoffeeType("BonAqua", 10));
        this.coffeeMenu.put("perrier", new CoffeeType("Perrier", 30));
        nonSugarItems.add("bonaqua");
        nonSugarItems.add("perrier");
        
        this.possibleCoins.add(10);
        this.possibleCoins.add(50);
        
    }

    @Override
    public void select(String type) {
        if(nonSugarItems.contains(type.toLowerCase())){
            rollbackSugar();
        }
        super.select(type);
    }
}
