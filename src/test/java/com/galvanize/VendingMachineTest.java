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

        Item item1 = new Item();
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


}
