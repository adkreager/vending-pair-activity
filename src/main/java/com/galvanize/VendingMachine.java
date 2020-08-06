package com.galvanize;

import java.util.ArrayList;



public class VendingMachine {
    private ArrayList<Item> items = new ArrayList<Item>();
    private String[] codes = {"123","321","000"};
    public double profit = 0.0;
    private double depositedFunds = 0.0;

    public ArrayList<com.galvanize.Item> getItems() {

        return this.items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public double getProfit() {
        return this.profit;
    }

    public void depositMoney(double money){
        this.depositedFunds += money;
    }

    public double getDepositedFunds() {
        return this.depositedFunds;
    }

    public String enterCode(String code) {
        for(int i = 0; i < this.codes.length; i++){
            if(this.codes[i] == code){
                return "OK";
            }
        }
        return "Try Again!";
    }
}
