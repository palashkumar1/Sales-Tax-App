package com.example.salestaxapp.utils;

import com.example.salestaxapp.model.Item;
import com.example.salestaxapp.service.TaxService;

import java.util.List;

public class ReceiptPrinter {

    private TaxService taxService;

    public ReceiptPrinter(TaxService taxService) {
        this.taxService = taxService;
    }

    public void printReceipt(List<Item> items) {
        double totalSalesTax = 0.0;
        double totalPrice = 0.0;

        for (Item item : items) {
            double itemTax = taxService.calculateSalesTax(item);
            double itemTotalPrice = taxService.calculateTotalPrice(item);

            System.out.printf("1 %s: %.2f%n", item.getName(), itemTotalPrice);

            totalSalesTax += itemTax;
            totalPrice += itemTotalPrice;
        }

        System.out.printf("Sales Taxes: %.2f%n", totalSalesTax);
        System.out.printf("Total: %.2f%n", totalPrice);
    }
}
