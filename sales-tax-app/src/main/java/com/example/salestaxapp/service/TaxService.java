package com.example.salestaxapp.service;

import com.example.salestaxapp.model.Item;
import org.springframework.stereotype.Service;

@Service
public class TaxService {
    private static final double BASIC_SALES_TAX_RATE = 0.10;
    private static final double IMPORT_DUTY_RATE = 0.05;

    public double calculateSalesTax(Item item) {
        double salesTax = 0.0;

        // Apply basic sales tax only if the item is not exempt
        if (!item.isExempt()) {
            salesTax += roundUp(item.getPrice() * BASIC_SALES_TAX_RATE);
        }

        // Apply import duty if the item is imported
        if (item.isImported()) {
            salesTax += roundUp(item.getPrice() * IMPORT_DUTY_RATE);
        }

        return salesTax;
    }

    public double calculateTotalPrice(Item item) {
        return item.getPrice() + calculateSalesTax(item);
    }

    /**
     * Method to round up tax to the nearest 0.05
     *
     * @param amount amount to round
     * @return rounded amount
     */
    private double roundUp(double amount) {
        return Math.ceil(amount * 20) / 20.0;
    }
}
