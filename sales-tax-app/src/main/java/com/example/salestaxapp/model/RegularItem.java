package com.example.salestaxapp.model;

public class RegularItem extends Item {
    public RegularItem(String name, double price, boolean imported) {
        super(name, price, imported);
    }

    @Override
    public boolean isExempt() {
        return isBookFoodOrMedical(getName());
    }

    private boolean isBookFoodOrMedical(String itemName) {
        String lowerName = itemName.toLowerCase();
        return lowerName.contains("book") ||
                lowerName.contains("food") ||
                lowerName.contains("chocolate") ||
                lowerName.contains("pills");
    }
}
