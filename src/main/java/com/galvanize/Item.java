package com.galvanize;

public class Item {
    private String name;
    private double price;

    public Item(String name) {
        this.name = name;
        this.price = 1.00;
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
