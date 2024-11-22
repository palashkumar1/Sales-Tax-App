package com.example.salestaxapp;

import com.example.salestaxapp.model.Item;
import com.example.salestaxapp.model.RegularItem;
import com.example.salestaxapp.service.TaxService;
import com.example.salestaxapp.utils.ReceiptPrinter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SalesTaxAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesTaxAppApplication.class, args);
		// Input 1
		System.out.println("Input 1:");
		List<Item> basket1 = new ArrayList<>();
		basket1.add(new RegularItem("book", 12.49, false));
		basket1.add(new RegularItem("music CD", 14.99, false));
		basket1.add(new RegularItem("chocolate bar", 0.85, false));

		TaxService taxService = new TaxService();
		ReceiptPrinter receiptGenerator = new ReceiptPrinter(taxService);
		receiptGenerator.printReceipt(basket1);

		// Input 2
		System.out.println("\nInput 2:");
		List<Item> basket2 = new ArrayList<>();
		basket2.add(new RegularItem("imported box of chocolates", 10.00, true));
		basket2.add(new RegularItem("imported bottle of perfume", 47.50, true));

		receiptGenerator.printReceipt(basket2);

		// Input 3
		System.out.println("\nInput 3:");
		List<Item> basket3 = new ArrayList<>();
		basket3.add(new RegularItem("imported bottle of perfume", 27.99, true));
		basket3.add(new RegularItem("bottle of perfume", 18.99, false));
		basket3.add(new RegularItem("packet of headache pills", 9.75, false));
		basket3.add(new RegularItem("imported box of chocolates", 11.25, true));

		receiptGenerator.printReceipt(basket3);
	}


}
