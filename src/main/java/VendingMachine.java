public class VendingMachine extends Machine{
    
    public VendingMachine(){
        
        this.coffeeMenu.put("bonaqua", new CoffeeType("BonAqua", 10));
        this.coffeeMenu.put("perrier", new CoffeeType("Perrier", 30));
        this.possibleCoins.add(10);
        this.possibleCoins.add(50);
         
    }
    
}
