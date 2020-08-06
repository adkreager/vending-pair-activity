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

    public String getItem(Item item) {
        if (this.items.contains(item)) {
            return "vending item";
        } else {
            return "please select another item";
        }
    }

    public String buyItem(Item item) {
        double price = item.getPrice();
        if (this.depositedFunds < price) {
            return "Please add more money";
        } else {
            this.depositedFunds -= price;
            this.profit += price;
            return "vending item";
        }
    }

    public double returnChange() {
        double change = this.depositedFunds;
        this.depositedFunds = 0;
        return change;
    }

    public double cancelOrder() {
        return returnChange();
    }

    public String checkChange(Item item) {
        double price = item.getPrice();
        if (this.profit >= price) {
            return "enough change";
        } else {
            return "not enough change";
        }
    }
}
