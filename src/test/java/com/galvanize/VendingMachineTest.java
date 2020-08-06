package com.galvanize;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTest {

    @Test
    public void canSeeWhatIsInVendingMachine(){
        VendingMachine vend = new VendingMachine();

        ArrayList<Item> list = new ArrayList<Item>();

        assertEquals(list,vend.getItems());
    }

    @Test
    public void addItemsToVendingMachine(){
        VendingMachine vend = new VendingMachine();
        ArrayList<Item> list = new ArrayList<Item>();

        Item item1 = new Item("item");
        list.add(item1);
        vend.addItem(item1);

        assertEquals(list,vend.getItems());
    }

    @Test
    public void seeTotalSalesFromVendingMachine(){
        VendingMachine vend = new VendingMachine();
        assertEquals(0.0,vend.getProfit());

    }

    @Test
    public void howMuchMoneyHaveIDeposited(){
        VendingMachine vend = new VendingMachine();
        vend.depositMoney(2.00);
        assertEquals(2.00,vend.getDepositedFunds());
    }

    @Test
    public void addMoreMoney(){
        VendingMachine vend = new VendingMachine();
        vend.depositMoney(2.00);
        assertEquals(2.00,vend.getDepositedFunds());

        vend.depositMoney(0.25);
        assertEquals(2.25,vend.getDepositedFunds());

        vend.depositMoney(0.50);
        assertEquals(2.75,vend.getDepositedFunds());
    }

    @Test
    public void errorCode(){
        VendingMachine vend = new VendingMachine();
        assertEquals("OK",vend.enterCode("123"));
        assertEquals("Try Again!",vend.enterCode("12345"));

    }

    @Test
    public void checkItemIsUnavailable() {
        VendingMachine vend = new VendingMachine();
        Item item1 = new Item("oreos");
        Item item2 = new Item("Coca cola");

        vend.addItem(item1);

        assertEquals("vending item", vend.getItem(item1));
        assertEquals("please select another item", vend.getItem(item2));
    }

    @Test
    public void checkIfHaveEnoughMoney() {
        VendingMachine vend = new VendingMachine();

        Item item1 = new Item("oreos", 2.00);
        assertEquals("Please add more money", vend.buyItem(item1));

        vend.depositMoney(0.50);
        assertEquals("Please add more money", vend.buyItem(item1));

        vend.depositMoney(1.50);
        assertEquals("vending item", vend.buyItem(item1));
    }

    @Test
    public void custReceiveChange() {
        VendingMachine vend = new VendingMachine();
        Item item1 = new Item("oreos", 2.00);
        assertEquals("Please add more money", vend.buyItem(item1));
        vend.depositMoney(0.50);
        assertEquals("Please add more money", vend.buyItem(item1));
        vend.depositMoney(2.00);
        assertEquals("vending item", vend.buyItem(item1));

        assertEquals(0.50, vend.returnChange());
        assertEquals(0.0, vend.getDepositedFunds());
    }

    @Test
    public void getRefundOnCancelledOrder() {
        VendingMachine vend = new VendingMachine();
        vend.depositMoney(0.50);
        vend.depositMoney(2.00);

        assertEquals(2.50, vend.cancelOrder());
    }

    @Test
    public void checkIfVendingMachineCanMakeChange() {
        VendingMachine vend = new VendingMachine();
        vend.depositMoney(3.00);
        Item item1 = new Item("cookies", 1.00);
        Item item2 = new Item("gum", 3.00);

        vend.buyItem(item1);

        assertEquals("enough change", vend.checkChange(item1));
        assertEquals("not enough change", vend.checkChange(item2));
    }
}
