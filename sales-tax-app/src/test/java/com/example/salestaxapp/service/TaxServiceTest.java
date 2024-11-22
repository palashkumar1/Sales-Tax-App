package com.example.salestaxapp.service;

import com.example.salestaxapp.model.RegularItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxServiceTest {
    private TaxService taxCalculator;

    @BeforeEach
    void setUp() {
        taxCalculator = new TaxService();
    }

    @Test
    void testBasicSalesTaxForNonExemptItem() {
        RegularItem musicCD = new RegularItem("music CD", 14.99, false);
        assertEquals(1.50, taxCalculator.calculateSalesTax(musicCD), 0.01);
    }

    @Test
    void testNoSalesTaxForExemptItem() {
        RegularItem book = new RegularItem("book", 12.49, false);
        assertEquals(0.0, taxCalculator.calculateSalesTax(book), 0.01);
    }

    @Test
    void testImportDutyForImportedItem() {
        RegularItem importedChocolates = new RegularItem("imported box of chocolates", 10.00, true);
        assertEquals(0.50, taxCalculator.calculateSalesTax(importedChocolates), 0.01);
    }

    @Test
    void testCombinedTaxForImportedNonExemptItem() {
        RegularItem importedPerfume = new RegularItem("imported bottle of perfume", 47.50, true);
        assertEquals(7.15, taxCalculator.calculateSalesTax(importedPerfume), 0.01);
    }

    @Test
    void testTotalPriceCalculation() {
        RegularItem perfume = new RegularItem("bottle of perfume", 18.99, false);
        assertEquals(20.89, taxCalculator.calculateTotalPrice(perfume), 0.01);
    }

    @Test
    void testExemptItemIdentification() {
        assertTrue(new RegularItem("book", 12.49, false).isExempt());
        assertTrue(new RegularItem("chocolate bar", 0.85, false).isExempt());
        assertTrue(new RegularItem("packet of headache pills", 9.75, false).isExempt());

        assertFalse(new RegularItem("music CD", 14.99, false).isExempt());
        assertFalse(new RegularItem("bottle of perfume", 18.99, false).isExempt());
    }
}