package sdcoffee;

import org.junit.*;

public class Tests {

    Machine machine = null;

    @Test
    public void testCancelCoins() {
        machine = new Machine();
        machine.insert(1);
        machine.insert(5);
        machine.cancel();
        Assert.assertTrue(machine.coinsInside == 0);
    }

    @Test
    public void testInsertBadCoinAndContinue() {
        machine = new Machine();
        machine.insert(1);
        
        boolean wasException = false;
        try {
            // bad coin
            machine.insert(89123);
        } catch (Exception e) {
            wasException = true;
        }
        Assert.assertTrue(wasException);
        machine.insert(3);
        // 1 + 3 = 4 ?
        Assert.assertTrue(machine.coinsInside == 4);
    }

    @Test
    public void testUnderpaidOrder() {
        machine = new Machine();
        machine.insert(1);
        machine.insert(3);
        boolean wasException = false;
        try {
            // expensive order 
            machine.select("latte");
        } catch (Exception e) {
            wasException = true;
        }
        Assert.assertTrue(wasException);
        
        // check that machine is ok
        machine.insert(3);
        machine.select("latte");
        
    }

}
