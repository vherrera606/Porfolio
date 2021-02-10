package vend;

import org.junit.Assert;

import static org.junit.Assert.*;

public class VendingMachineTest {

    @org.junit.Test
    public void dispenseItem_coke_change() {
        VendingMachine vendingMachine = new VendingMachine();

        String actual = vendingMachine.dispenseItem(65, "coke");

        Assert.assertEquals("Item dispensed and change of 40 returned", actual);
    }

    @org.junit.Test
    public void dispenseItem_candy_change() {
        VendingMachine vendingMachine = new VendingMachine();

        String actual = vendingMachine.dispenseItem(65, "candy");

        Assert.assertEquals("Item dispensed and change of 45 returned", actual);
    }

    @org.junit.Test
    public void dispenseItem_coffee_change() {
        VendingMachine vendingMachine = new VendingMachine();

        String actual = vendingMachine.dispenseItem(65, "coffee");

        Assert.assertEquals("Item dispensed and change of 20 returned", actual);
    }

    @org.junit.Test
    public void dispenseItem_coke_0() {
        VendingMachine vendingMachine = new VendingMachine();

        String actual = vendingMachine.dispenseItem(25, "coke");

        Assert.assertEquals("Item dispensed.", actual);
    }

    @org.junit.Test
    public void dispenseItem_candy_0() {
        VendingMachine vendingMachine = new VendingMachine();

        String actual = vendingMachine.dispenseItem(20, "candy");

        Assert.assertEquals("Item dispensed.", actual);
    }

    @org.junit.Test
    public void dispenseItem_coffee_0() {
        VendingMachine vendingMachine = new VendingMachine();

        String actual = vendingMachine.dispenseItem(45, "coffee");

        Assert.assertEquals("Item dispensed.", actual);
    }

    @org.junit.Test
    public void dispenseItem_coke_less() {
        VendingMachine vendingMachine = new VendingMachine();

        String actual = vendingMachine.dispenseItem(20, "coke");

        Assert.assertEquals("Item not dispensed, missing 5 cents. Can purchase candy.", actual);
    }

    @org.junit.Test
    public void dispenseItem_candy_less() {
        VendingMachine vendingMachine = new VendingMachine();

        String actual = vendingMachine.dispenseItem(15, "candy");

        Assert.assertEquals("Item not dispensed, missing 5 cents. Cannot purchase item.", actual);
    }

    @org.junit.Test
    public void dispenseItem_coffee_less() {
        VendingMachine vendingMachine = new VendingMachine();

        String actual = vendingMachine.dispenseItem(40, "coffee");

        Assert.assertEquals("Item not dispensed, missing 5 cents. Can purchase candy or coke.", actual);
    }

}