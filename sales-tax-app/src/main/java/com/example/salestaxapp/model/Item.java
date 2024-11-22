package com.example.salestaxapp.model;

public abstract class Item {
    private String name;
    private double price;
    private boolean imported;

    public Item(String name, double price, boolean imported) {
        this.name = name;
        this.price = price;
        this.imported = imported;
    }

    public abstract boolean isExempt();

    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isImported() { return imported; }
}
